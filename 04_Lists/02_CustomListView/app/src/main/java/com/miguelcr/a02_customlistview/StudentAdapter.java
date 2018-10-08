package com.miguelcr.a02_customlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

class StudentAdapter extends ArrayAdapter<StudentItem> {
    Context ctx;
    int layoutTemplate;
    List<StudentItem> values;

    public StudentAdapter(@NonNull Context context, int resource, @NonNull List<StudentItem> objects) {
        super(context, resource, objects);
        ctx = context;
        layoutTemplate = resource;
        values = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx)
                .inflate(layoutTemplate, parent, false);

        // 1. Get the current item information
        StudentItem current = values.get(position);
        String name = current.getName();
        String photo = current.getPhotoUrl();
        int age = current.getAge();

        // 2. Get the view components in the template
        TextView tvName = v.findViewById(R.id.textViewName);
        TextView tvAge = v.findViewById(R.id.textViewAge);
        ImageView ivPhoto = v.findViewById(R.id.imageViewPhoto);

        // 3. Set the current info >>> into view components
        tvName.setText(name);
        tvAge.setText(String.valueOf(age));

        Picasso.get().load(photo).into(ivPhoto);

        return v;
    }
}
