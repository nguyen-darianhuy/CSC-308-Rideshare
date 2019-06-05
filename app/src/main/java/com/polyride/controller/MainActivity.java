package com.polyride.controller;

import android.support.v7.app.AppCompatActivity;  //NOSONAR
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

import com.polyride.R;

public class MainActivity extends AppCompatActivity { //NOSONAR

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button button;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity2();
            }
        });

        button = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openLogin();
            }
        });
    }

    public void openActivity2(){
        Intent intent = new Intent(this, Create.class);
        startActivity(intent);
    }

    public void openLogin(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
