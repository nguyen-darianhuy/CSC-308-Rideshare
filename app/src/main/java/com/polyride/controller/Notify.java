package com.polyride.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.polyride.R;

public class Notify extends AppCompatActivity {  //NOSONAR

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

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.navigation_home:
                        openRideListing();
                        break;

                    case R.id.navigation_profile:
                        openProfile();
                        break;



                }
                return true;
            }
        });
    }

    void openRequestActivity() {
        Intent intent = new Intent(this, RecyclerRequest.class);
        startActivity(intent);
    }

    public void openRideListing(){
        Intent intent = new Intent(this, RidesActivity.class);
        startActivity(intent);
    }


    public void openProfile(){
        Intent intent = new Intent(this, Profile2.class);
        startActivity(intent);
    }
}

