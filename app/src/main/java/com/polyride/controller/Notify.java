package com.polyride.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.polyride.R;

public class Notify extends AppCompatActivity {

    private ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);

        button = (ImageButton) findViewById(R.id.person_action);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openRequestActivity();
            }
        });
    }

    void openRequestActivity() {
        Intent intent = new Intent(this, RecyclerRequest.class);
        startActivity(intent);
    }
}

