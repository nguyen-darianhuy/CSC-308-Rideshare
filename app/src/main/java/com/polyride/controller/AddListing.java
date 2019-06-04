package com.polyride.controller;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.polyride.R;
import com.polyride.entity.TripListing;
import com.polyride.entity.User;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class AddListing extends AppCompatActivity { //NOSONAR
    private FirebaseFirestore db;
    private FirebaseAuth auth;
    private FirebaseUser user;

    private static final String TAG = "AddListing";

    private TextView mDisplayDate;

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TextInputLayout departureLayout;
    private TextInputLayout destinationLayout;
    private TextInputLayout maxPassengersLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_listing);
        mDisplayDate = (TextView) findViewById(R.id.DatePicker);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddListing.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy:" + month + "/" + dayOfMonth + "/" + year);
                String date = month + "/" + dayOfMonth + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        departureLayout = findViewById(R.id.textInputLayout);
        destinationLayout = findViewById(R.id.textInputLayout2);
        maxPassengersLayout = findViewById(R.id.textInputLayout4);

        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        if (user != null) {

        }

    }

    public void submit(View view) { // NO SONAR
        final DocumentReference docRef = db.collection("Users").document(user.getUid());
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    User driver = new User();
                    driver.setUserAttributes(document);
                    createListing(driver);
                }
            }
        });
    }

    public void createListing(final User driver) {
        Map<String, Object> listingData = new HashMap<>();
        listingData.put("departure", departureLayout.getEditText().getText().toString());
        listingData.put("departureDate", mDisplayDate.getText().toString());
        listingData.put("destination", destinationLayout.getEditText().getText().toString());
        listingData.put("driverID", user.getUid());
        listingData.put("maxPassengers", Integer.parseInt(maxPassengersLayout.getEditText().getText().toString()));
        listingData.put("numPassengers", 0);

        final DocumentReference docRef = db.collection("TripListing").document();
        docRef.set(listingData).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                openRideListing();
            }
        });
    }

    public void openRideListing(){
        Intent intent = new Intent(this, RidesActivity.class);
        startActivity(intent);
    }

}
