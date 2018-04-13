package com.example.aya.login.Model;

import android.util.Log;

import com.example.aya.login.Presenter.LoginPresenter;
import com.example.aya.login.retrofit.Service;
import com.example.aya.login.retrofit.response;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Aya on 4/11/2018.
 */

public class LoginModel {


    LoginPresenter presenter;
    public static int loginResult;

    public static int login(String email, final String password) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Service.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service api = retrofit.create(Service.class);
        Call<response> call = api.login(email, password);
        call.enqueue(new Callback<response>() {
            @Override
            public void onResponse(Call<response> call, Response<response> response) {
                if (response.isSuccessful()) {
                    response resObj = response.body();
                    if (resObj.getMessage().equals("Login Success")) {
                        Log.i("tag","login successful !!!!!!!!!!");
                        loginResult = 1;

                    }


                } else {
                    Log.i("tag","login failed !!!!!!!!!!");
                    loginResult = 0;
                }
            }

            @Override
            public void onFailure(Call<response> call, Throwable t) {
                //  Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

      return loginResult;
    }
}

