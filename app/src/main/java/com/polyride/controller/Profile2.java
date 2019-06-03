package com.polyride.controller;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.polyride.R;
import com.polyride.entity.User;

public class Profile2 extends AppCompatActivity { //NOSONAR
    FirebaseFirestore db;
    FirebaseAuth auth;
    FirebaseUser user;

    EditText name;
    EditText email;
    EditText bio;
    EditText number;
    EditText departureCity;
    EditText arrivalCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        openRideListing();
                        break;

                    case R.id.navigation_notifications:
                        openNotifications();
                        break;
                }
                return true;
            }
        });

        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        name = findViewById(R.id.textInputLayout);
        email = findViewById(R.id.textInputLayout3);
        bio = findViewById(R.id.textInputLayout2);
        number = findViewById(R.id.textInputLayout4);
        departureCity = findViewById(R.id.textInputLayout5);
        arrivalCity = findViewById(R.id.textInputLayout6);

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
                        number.setText(document.get("number", String.class));
                        arrivalCity.setText(document.get("homeCity", String.class));
                    } else {
                        User newUser = new User();
                        docRef.set(newUser);
                    }
                }
            });
        }

    }

    public void save(View view) { // NO SONAR
        final DocumentReference docRef = db.collection("Users").document(user.getUid());
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    User userData = new User(name.getText().toString(), email.getText().toString(),
                            number.getText().toString(), bio.getText().toString(),
                            arrivalCity.getText().toString());
                    docRef.set(userData);
                }
            }
        });
    }

    public void openRideListing(){
        Intent intent = new Intent(this, RidesActivity.class);
        startActivity(intent);
    }


    public void openNotifications(){
        Intent intent = new Intent(this, Notify.class);
        startActivity(intent);
    }

}
