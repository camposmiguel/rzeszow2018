package com.miguelcr.a00_basicintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etFirstName, etPassword, etConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the View component reference by ID.
        etFirstName = findViewById(R.id.editTextFirstName);
        etPassword = findViewById(R.id.editTextPassword);
        etConfirmPassword = findViewById(R.id.editTextConfirmPassword);
    }

    public void doRegister(View view) {
        String fName = etFirstName.getText().toString();
        String pass = etPassword.getText().toString();
        String confirmPass = etConfirmPassword.getText().toString();

        if(pass.equals(confirmPass)) {
            Toast.makeText(this, "Signup ok", Toast.LENGTH_SHORT).show();

            // We define the navigation to the HomeActivity
            Intent i = new Intent(MainActivity.this, HomeActivity.class);

            // Open the new screen
            startActivity(i);
        } else {
            Toast.makeText(this, "Signup wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
