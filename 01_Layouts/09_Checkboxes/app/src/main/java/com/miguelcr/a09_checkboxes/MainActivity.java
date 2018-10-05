package com.miguelcr.a09_checkboxes;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox cb1, cb2;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = findViewById(R.id.checkBox1);
        cb2 = findViewById(R.id.checkBox2);
        layout = findViewById(R.id.layout);
    }

    public void showChecked(View view) {
        if(cb1.isChecked() && cb2.isChecked()) {
            Toast.makeText(this, "CB1 and 2 checked", Toast.LENGTH_SHORT).show();
        } else if(cb1.isChecked()) {
            Toast.makeText(this, "CB1 checked", Toast.LENGTH_SHORT).show();
        } else if(cb2.isChecked()) {
            Toast.makeText(this, "CB2 checked", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Nothing checked", Toast.LENGTH_SHORT).show();
        }
    }
}
