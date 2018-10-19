package com.miguelcr.a02_duckhunt;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiDuckService {

    @POST("auth/login")
    Call<LoginResponse> doLogin(@Body LoginRequest user);
}
