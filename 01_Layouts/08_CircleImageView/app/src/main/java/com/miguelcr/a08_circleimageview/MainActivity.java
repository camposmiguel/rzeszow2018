package com.miguelcr.a08_circleimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    CircleImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photo = findViewById(R.id.profile_image);

        Picasso.get()
                .load("https://i1.wp.com/www.ligablatt.de/wp-content/uploads/2017/12/img_0306.jpg")
                .into(photo);
    }
}
