package com.polyride.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.polyride.entity.TripListing;
import com.polyride.*;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;

public class ListingAdapter extends FirestoreRecyclerAdapter<TripListing, ListingAdapter.ListingHolder> {

    public ListingAdapter(@NonNull FirestoreRecyclerOptions<TripListing> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ListingHolder holder, int position, @NonNull TripListing model) {
        holder.textViewProfileName.setText(model.getDriverID());
        holder.textViewDepartureDestination.setText(model.getDeparture());
        holder.textViewSpotsRemaining.setText(String.valueOf(model.getMaxPassengers()));
        holder.textViewDepartureDate.setText(model.getDepartureDate().toString());
        holder.textViewRating.setText(model.getDriverID());
    }

    @NonNull
    @Override
    public ListingHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items, viewGroup, false);
        return new ListingHolder(v);
    }

    class ListingHolder extends RecyclerView.ViewHolder {
        TextView textViewProfileName;
        TextView textViewDepartureDestination;
        TextView textViewSpotsRemaining;
        TextView textViewDepartureDate;
        TextView textViewRating;

        public ListingHolder(View itemView) {
            super(itemView);
            textViewProfileName =itemView.findViewById(R.id.textViewProfileName);
            textViewDepartureDestination = itemView.findViewById(R.id.textViewDepartureDestination);
            textViewSpotsRemaining = itemView.findViewById(R.id.textViewSpotsRemaining);
            textViewDepartureDate = itemView.findViewById(R.id.textViewDepartureDate);
            textViewRating = itemView.findViewById(R.id.textViewRating);
        }
    }
}
