package com.miguelcr.a04_picassolibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.imageViewLogo);
        Picasso.get().load("https://ep01.epimg.net/internacional/imagenes/2018/01/25/actualidad/1516911435_016304_1516912079_noticia_normal.jpg").into(logo);
    }
}
