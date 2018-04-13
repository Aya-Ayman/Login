package com.example.aya.login.retrofit;

import retrofit2.*;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Aya on 4/8/2018.
 */

public interface Service {

    String BASE_URL = "https://private-d3105-tamini.apiary-mock.com/Tamini/";

    @POST("login")
    Call<response> login(@Query("email") String email, @Query("password") String password);
}
