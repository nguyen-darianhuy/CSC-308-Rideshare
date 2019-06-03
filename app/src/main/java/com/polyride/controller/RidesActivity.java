package com.polyride.controller;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.firebase.ui.firestore.SnapshotParser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.polyride.R;
import com.polyride.entity.TripListing;
import com.polyride.adapter.ListingAdapter;

public class RidesActivity extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference listingRef = db.collection("TripListing");

    private ListingAdapter adapter;

    SnapshotParser<TripListing> parser = new SnapshotParser<TripListing>() {
        @NonNull
        public TripListing parseSnapshot(@NonNull DocumentSnapshot snapshot) {
            TripListing listing = new TripListing(
                    snapshot.getString("driverID"),
                    snapshot.get("maxPassengers", Integer.class),
                    snapshot.get("numPassengers", Integer.class),
                    snapshot.getString("destination"),
                    snapshot.getString("departure"),
                    snapshot.getString("departureDate"));
            return listing;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rides);

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        Query query  = listingRef.orderBy("departure");

        FirestoreRecyclerOptions<TripListing> options = new FirestoreRecyclerOptions.Builder<TripListing>()
                .setQuery(query, parser)
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
    }
}
