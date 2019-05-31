package com.polyride.controller;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.polyride.R;
import com.polyride.entity.User;

public class Profile extends AppCompatActivity { //NOSONAR
    FirebaseFirestore db;
    FirebaseAuth auth;
    FirebaseUser user;

    EditText name;
    EditText email;
    EditText bio;
    EditText vehicle;
    EditText homeCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        name = findViewById(R.id.editText2);
        email = findViewById(R.id.editText);
        bio = findViewById(R.id.editText4);
        vehicle = findViewById(R.id.editText6);
        homeCity = findViewById(R.id.editText7);

        auth.signInWithEmailAndPassword("dnguy235@calpoly.edu", "asdfasdf");
        user = auth.getCurrentUser();


        if (user != null) {
            final DocumentReference docRef = db.collection("Users").document(user.getUid());

            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        name.setText(document.get("name", String.class));
                        email.setText(document.get("email", String.class));
                        bio.setText(document.get("bio", String.class));
                        vehicle.setText(document.get("vehicle", String.class));
                        homeCity.setText(document.get("homeCity", String.class));
                    } else {
                        User user = new User();
                        docRef.set(user);
                    }
                }
            });
        }

    }

    public void save(View view) {
        final DocumentReference docRef = db.collection("Users").document(user.getUid());
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    User user = new User(name.getText().toString(), email.getText().toString(),
                                          vehicle.getText().toString(), bio.getText().toString(),
                                          homeCity.getText().toString());
                    docRef.set(user);
                }
            }
        });
    }
}
