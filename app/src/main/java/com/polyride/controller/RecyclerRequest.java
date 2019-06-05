package com.polyride.controller;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.polyride.RequestAdapter;
import com.polyride.ExampleItem;
import com.polyride.R;
import com.polyride.entity.TripListing;
import com.polyride.entity.User;

import java.util.ArrayList;


public class RecyclerRequest extends AppCompatActivity { //NOSONAR

    FirebaseFirestore db;
    FirebaseAuth auth;
    FirebaseUser user;

    private final ArrayList<TripListing> idToTrips = new ArrayList<>();
    private TripListing trip;
    private User userClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button button, button2;
        RequestAdapter adapter;
        RecyclerView mRecyclerView;
        RecyclerView.LayoutManager mLayoutManager;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_request);

        button = findViewById(R.id.button16);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openRequestActivity();
            }
        });

        button2 = findViewById(R.id.button5);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AcceptRequest();
            }
        });

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.mipmap.ic_raters, "Sarah Hyland", "Julianna was very nice overall. She did spill fries in my car however", "3.8/5"));
        exampleList.add(new ExampleItem(R.mipmap.ic_raters, "Sam Jennings", "Wonderful Passenger! Would love to have her again", "5/5"));
        exampleList.add(new ExampleItem(R.mipmap.ic_raters, "Travis Greene", "I loved her and her picture of her corgi! So cute!!!", "5/5"));

        //this line is different than the video, with the recycler view
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        adapter = new RequestAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(adapter);
    }

    void openRequestActivity() {
        Intent intent = new Intent(this, Notify.class);
        startActivity(intent);
    }

    void AcceptRequest() {
        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        if (user != null) {
            DocumentReference docRef = db.collection("Users").document(user.getUid());
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    DocumentSnapshot document = task.getResult();
                    userClass = new User(document);
                }
            });

            CollectionReference colRef = db.collection("TripListing");
            colRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    for (DocumentSnapshot doc : task.getResult()) {
                        if (user.getUid().equals(doc.get("driverId", String.class))) {
                            trip = new TripListing(doc, userClass);
                            trip.setNumPassengers(trip.getNumPassengers() + 1);
                            final DocumentReference dRef = db.collection("TripListing").document(doc.getId());
                            dRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                    dRef.set(trip);
                                }
                            });
                        }
                    }
                }
            });
        }



        Intent intent = new Intent(this, Notify.class);
        startActivity(intent);
    }
}
