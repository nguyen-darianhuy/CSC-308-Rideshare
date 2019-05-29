package com.polyride.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.polyride.R;

public class Login extends AppCompatActivity { //NOSONAR

    private static final String TAG = "LOGINPASSWORD";

    private Button signInButton;
    private TextInputLayout userLogin;
    private TextInputLayout userPassword;

    private String login;
    private String password;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // replace with correct xml file name
        setContentView(R.layout.activity_login);

        // get the field
        userLogin = findViewById(R.id.textInputLayout3);
        userPassword = findViewById(R.id.textInputLayout4);
        login = userLogin.getEditText().getText().toString().trim();
        password = userPassword.getEditText().getText().toString().trim();
        signInButton = findViewById(R.id.button5);

        mAuth = FirebaseAuth.getInstance();

        signInButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                loginActivity();
            }
        });
    }

    public void onStart(){
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    void loginActivity(){
        mAuth.signInWithEmailAndPassword(login, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            Toast.makeText(Login.this, "Login Success!",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            nextActivity();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(Login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    void nextActivity(){
        Intent intent = new Intent(this, RidesActivity.class);
        startActivity(intent);
    }
}
