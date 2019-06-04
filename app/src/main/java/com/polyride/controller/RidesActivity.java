package com.polyride.controller;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.firebase.ui.firestore.SnapshotParser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.polyride.R;
import com.polyride.entity.TripListing;
import com.polyride.adapter.ListingAdapter;
import com.polyride.entity.User;

import java.util.HashMap;
import java.util.Map;

public class RidesActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference listingRef = db.collection("TripListing");

    private final Map<String, User> idToDriver = new HashMap<>();
    private ListingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rides);

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_profile:
                        openProfile();
                        break;

                    case R.id.navigation_notifications:
                        openNotifications();
                        break;
                }
                return true;
            }
        });

        CollectionReference colRef = db.collection("Users");
        colRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    idToDriver.put(document.getId(), new User(document));
                }
                setUpRecyclerView();
            }
        });
    }

    private void setUpRecyclerView() {
        SnapshotParser<TripListing> parser = new SnapshotParser<TripListing>() {
            @NonNull
            public TripListing parseSnapshot(@NonNull DocumentSnapshot snapshot) {
                TripListing listing = new TripListing(
                        idToDriver.get(snapshot.getString("driverID")),
                        snapshot.get("maxPassengers", Integer.class),
                        snapshot.get("numPassengers", Integer.class),
                        snapshot.getString("destination"),
                        snapshot.getString("departure"),
                        snapshot.getString("departureDate"));
                return listing;
            }
        };

        Query query  = listingRef.orderBy("departure");
        FirestoreRecyclerOptions<TripListing> options = new FirestoreRecyclerOptions.Builder<TripListing>()
                .setQuery(query, parser)
                .build();

        adapter = new ListingAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.startListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    public void openProfile(){
        Intent intent = new Intent(this, Profile2.class);
        startActivity(intent);
    }


    public void openNotifications(){
        Intent intent = new Intent(this, Notify.class);
        startActivity(intent);
    }
}
