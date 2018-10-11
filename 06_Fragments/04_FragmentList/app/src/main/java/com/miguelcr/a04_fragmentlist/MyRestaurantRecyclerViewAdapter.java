package com.miguelcr.a04_fragmentlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyRestaurantRecyclerViewAdapter extends RecyclerView.Adapter<MyRestaurantRecyclerViewAdapter.ViewHolder> {

    private final List<Restaurant> mValues;
    private final RestaurantInteractionListener mListener;

    public MyRestaurantRecyclerViewAdapter(List<Restaurant> items, RestaurantInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_restaurant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.currentItem = mValues.get(position);
        holder.textViewName.setText(holder.currentItem.getName());
        holder.textViewAddress.setText(holder.currentItem.getAddress());
        holder.ratingBar.setRating(holder.currentItem.getRate());

        Picasso.get()
                .load(holder.currentItem.getPhotoUrl())
                .resize(1080, 400)
                .centerCrop()
                .into(holder.imageViewPhoto);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.showRestaurantDetail(holder.currentItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewName;
        public final TextView textViewAddress;
        public final ImageView imageViewPhoto;
        public final RatingBar ratingBar;
        public Restaurant currentItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewName = view.findViewById(R.id.textViewName);
            textViewAddress = view.findViewById(R.id.textViewAddress);
            imageViewPhoto = view.findViewById(R.id.imageViewPhoto);
            ratingBar = view.findViewById(R.id.ratingBar);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewName.getText() + "'";
        }
    }
}
