package com.polyride.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.polyride.R;

public class Create extends AppCompatActivity {

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
        startActivity(intent);
    }
}
