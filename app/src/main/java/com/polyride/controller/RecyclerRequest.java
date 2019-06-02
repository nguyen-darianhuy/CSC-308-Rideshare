package com.polyride.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.polyride.RequestAdapter;
import com.polyride.ExampleItem;
import com.polyride.R;

import java.util.ArrayList;

public class RecyclerRequest extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private RequestAdapter adapter;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_request);

        button = (Button) findViewById(R.id.button16);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openRequestActivity();
            }
        });

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.mipmap.ic_raters, "Sarah Hyland", "Julianna was very nice overall. She did spill fries in my car however", "3.8/5"));
        exampleList.add(new ExampleItem(R.mipmap.ic_raters, "Sam Jennings", "Wonderful Passenger! Would love to have her again", "5/5"));
        exampleList.add(new ExampleItem(R.mipmap.ic_raters, "Travis Greene", "I loved her and her picture of her corgi! So cute!!!", "5/5"));

        //this line is different than the video, with the recycler view
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        adapter = new RequestAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(adapter);
    }
    void openRequestActivity() {
        Intent intent = new Intent(this, Notify.class);
        startActivity(intent);
    }


}
