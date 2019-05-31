package com.polyride.controller;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.support.design.widget.TextInputLayout;

import android.support.annotation.NonNull;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;


import com.polyride.R;

public class Create extends AppCompatActivity{
    private static final String TAG = "EmailPassword";

    private TextView mTextMessage;

    private TextInputLayout firstName;
    private TextInputLayout lastName;
    private TextInputLayout email;
    private TextInputLayout password;

    private Button signUpButton;
    private Button existingAccountButton;

    private FirebaseAuth mAuth;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        button = (Button)findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity3();
            }
        });
    }

    public void openActivity3(){
        Intent intent = new Intent (this, Main2Activity.class);

        Log.d("CLICK", "Register Activity Page");

        // text fields
        firstName = findViewById(R.id.textInputLayout);
        lastName = findViewById(R.id.textInputLayout2);
        email = findViewById(R.id.textInputLayout3);
        password = findViewById(R.id.textInputLayout4);

        // buttons
        signUpButton = findViewById(R.id.button5);
        existingAccountButton = findViewById(R.id.button7);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputEmail = email.getEditText().getText().toString().trim();
                String inputPass = password.getEditText().getText().toString().trim();
                createAccount(inputEmail, inputPass);
            }
        });
        mAuth = FirebaseAuth.getInstance();
    }

    void createAccount(String email, String pass){
        if(email == null || password == null){
            Toast.makeText(getApplicationContext(), "Email or Password cannot be left empty",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "Account Made.",
                                    Toast.LENGTH_SHORT).show();
                            openMain2Activity();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
        // [END create_user_with_email]
        });
    }

    void openMain2Activity(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
