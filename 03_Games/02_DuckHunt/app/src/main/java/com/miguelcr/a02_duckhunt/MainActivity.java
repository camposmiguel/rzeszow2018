package com.miguelcr.a02_duckhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.net.HttpURLConnection.HTTP_OK;

public class MainActivity extends AppCompatActivity {
    EditText editTextEmail, editTextPassword;
    Button btnStart;
    Retrofit retrofit;
    ApiDuckService apiDuckService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide the toolbar in this Activity
        getSupportActionBar().hide();

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnStart = findViewById(R.id.buttonStart);

        retrofitInit();
    }

    private void retrofitInit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.DUCK_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiDuckService = retrofit.create(ApiDuckService.class);
    }


    public void startGame(View view) {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        LoginRequest loginInfo = new LoginRequest(email, password);

        Call<LoginResponse> requestCall = apiDuckService.doLogin(loginInfo);

        requestCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.code() == HTTP_OK) {
                    LoginResponse loginResponse = response.body();
                    Toast.makeText(MainActivity.this, loginResponse.getToken(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login incorrect", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Login incorrect", Toast.LENGTH_SHORT).show();
            }
        });


        // Intent i = new Intent(MainActivity.this, GameActivity.class);
        // startActivity(i);
    }
}
