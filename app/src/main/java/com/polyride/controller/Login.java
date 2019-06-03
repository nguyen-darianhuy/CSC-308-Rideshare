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
import com.polyride.R;

public class Login extends AppCompatActivity { //NOSONAR

    private static final String TAG = "LOGINPASSWORD";

    private TextInputLayout loginWrapper;
    private TextInputLayout passwordWrapper;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        loginWrapper = findViewById(R.id.textInputLayout3);
        passwordWrapper = findViewById(R.id.textInputLayout4);
        Button button = findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // get the field
                String login = loginWrapper.getEditText().getText().toString().trim();
                String password = passwordWrapper.getEditText().getText().toString().trim();
                loginActivity(login, password);
            }
        });

        button = findViewById(R.id.button19);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                createActivity();
            }
        });
    }

    void loginActivity(String login, String password){

        mAuth.signInWithEmailAndPassword(login, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            Toast.makeText(Login.this, "Login Success!",
                                    Toast.LENGTH_SHORT).show();
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
        Intent intent = new Intent(this, Profile2.class);
        startActivity(intent);
    }

    void createActivity(){
        Intent intent = new Intent(this, Create.class);
        startActivity(intent);
    }
}
