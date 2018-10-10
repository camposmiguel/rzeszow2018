package com.miguelcr.a01_sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    Context context = HomeActivity.this;
    TextView textViewEmail;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textViewEmail = findViewById(R.id.textViewEmail);

        sharedPref = context.getSharedPreferences("LOGIN_PREFERENCES", Context.MODE_PRIVATE);
        String email = sharedPref.getString("email", "");

        textViewEmail.setText(email);
    }

    public void doLogout(View view) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.remove("email");
        editor.commit();

        finish();
        Intent i = new Intent(HomeActivity.this, LoginActivity.class);
        startActivity(i);
    }
}
