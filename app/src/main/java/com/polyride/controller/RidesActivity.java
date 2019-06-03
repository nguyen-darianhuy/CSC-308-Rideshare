package com.polyride.controller;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
//<<<<<<< HEAD
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
/*=======
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.polyride.ExampleAdapter;
import com.polyride.ExampleItem;
>>>>>>> origin/frontend*/
import com.polyride.R;
import com.polyride.entity.TripListing;
import com.polyride.adapter.ListingAdapter;

public class RidesActivity extends AppCompatActivity {  //NOSONAR
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference listingRef = db.collection("TripListing");

//<<<<<<< HEAD
    private ListingAdapter adapter;
/*=======
import java.util.ArrayList;

public class RidesActivity extends AppCompatActivity {
>>>>>>> origin/frontend*/

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    //private ExampleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rides);

//<<<<<<< HEAD
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        Query query  = listingRef.orderBy("departure");

        FirestoreRecyclerOptions<TripListing> options = new FirestoreRecyclerOptions.Builder<TripListing>()
                .setQuery(query, TripListing.class)
                .build();

        adapter = new ListingAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
/*=======

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.navigation_notifications:
                        openNotifications();
                        break;

                    case R.id.navigation_profile:
                        openProfile();
                        break;



                }
                return true;
            }
        });

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.mipmap.ic_raters, "Sarah Hyland", "2/3 Spots Remaining", "San Luis Obispo -> San Jose"));
        exampleList.add(new ExampleItem(R.mipmap.ic_raters, "Sam Jennings", "1/2 Spots Remaining", "San Luis Obispo -> LAX"));
        exampleList.add(new ExampleItem(R.mipmap.ic_raters, "Travis Greene", "3/4 Spots Remaining", "San Francisco -> San Luis Obispo"));

        //this line is different than the video, with the recycler view
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.search_bar, menu);

            MenuItem searchItem = menu.findItem(R.id.action_search);
            SearchView searchView = (SearchView) searchItem.getActionView();

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    adapter.getFilter().filter(newText);
                    return false;
                }
            });
            return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.navigation_profile:
                Intent intent = new Intent(this, Profile2.class);
                startActivity(intent);
                break;
            case R.id.navigation_notifications:
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
>>>>>>> origin/frontend*/
    }

    public void openProfile(){
        Intent intent = new Intent(this, Profile2.class);
        startActivity(intent);
    }


    public void openNotifications(){
        Intent intent = new Intent(this, Notify.class);
        startActivity(intent);
    }





}
