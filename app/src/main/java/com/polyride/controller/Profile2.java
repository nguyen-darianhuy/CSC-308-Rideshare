package com.polyride.controller;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TextInputLayout;
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

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
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

                    case R.id.navigation_profile:
                        openProfile();

                    default:
                        break;
                }
                return true;
            }
        });

        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        name = ((TextInputLayout)findViewById(R.id.textInputLayout)).getEditText();
        email = ((TextInputLayout)findViewById(R.id.textInputLayout3)).getEditText();
        bio = ((TextInputLayout)findViewById(R.id.textInputLayout2)).getEditText();
        number = ((TextInputLayout)findViewById(R.id.textInputLayout4)).getEditText();
        departureCity = ((TextInputLayout)findViewById(R.id.textInputLayout5)).getEditText();
        arrivalCity = ((TextInputLayout)findViewById(R.id.textInputLayout6)).getEditText();

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
                        departureCity.setText(document.get("departureCity", String.class));
                        arrivalCity.setText(document.get("arrivalCity", String.class));
                    } else {
                        User newUser = new User();
                        docRef.set(newUser);
                    }
                }
            });
        } else {
            openLogin();
        }
    }

    public void save(View view) { // NOSONAR
        final DocumentReference docRef = db.collection("Users").document(user.getUid());
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    User userData = new User(name.getText().toString(),
                                             email.getText().toString(),
                                             bio.getText().toString(),
                                             number.getText().toString(),
                                             departureCity.getText().toString(),
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

    public void openLogin(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void openProfile(){
        Intent intent = new Intent(this, Profile2.class);
        startActivity(intent);
    }

}
