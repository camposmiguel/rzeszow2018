package com.miguelcr.a04_fragmentlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RestaurantInteractionListener {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment f = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    f = new RestaurantFragment();
                    break;
                case R.id.navigation_dashboard:

                    break;
                case R.id.navigation_notifications:

                    break;
            }

            if(f!=null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, f)
                        .commit();
                return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // By default we're going to load the RestaurantFragment list
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentContainer, new RestaurantFragment())
                .commit();
    }

    @Override
    public void showRestaurantDetail(Restaurant restaurant) {
        Intent i = new Intent(MainActivity.this, RestaurantDetailActivity.class);
        i.putExtra("name", restaurant.getName());
        i.putExtra("photo", restaurant.getPhotoUrl());
        startActivity(i);
    }

    @Override
    public void updateRestauntRate(Restaurant restaurant, float newRate) {

    }
}
