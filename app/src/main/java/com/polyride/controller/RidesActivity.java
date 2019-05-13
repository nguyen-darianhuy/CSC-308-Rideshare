package com.polyride.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.polyride.R;

public class RidesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rides);

        //TextView mTitleWindow = (TextView) findViewById(R.id.titleWindow);
        //TextView mMessageWindow = (TextView) findViewById(R.id.messageWindow);

        //mTitleWindow.setText( "This is some Title." );

        StringBuilder stringBuilder = new StringBuilder();

        String someMessage = " This is some message that I'm writing to append. ";

        for (int i = 0; i < 100; i++)
        {
            stringBuilder.append(someMessage);
        }
        //mMessageWindow.setText(stringBuilder.toString());
    }
}
