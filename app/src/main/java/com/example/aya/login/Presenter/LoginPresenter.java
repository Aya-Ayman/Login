package com.example.aya.login.Presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;

import com.example.aya.login.LoginView;
import com.example.aya.login.Model.LoginModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aya on 4/11/2018.
 */

public class LoginPresenter  {

    private LoginView loginView;
    private LoginModel loginModel;
    int result;

    public LoginPresenter(LoginView loginView) {

    this.loginView=loginView;

    }

    public void doLogin()
    {
        if(validate(loginView.getEmail(),loginView.getPassword()))
        {
            result=loginModel.login(loginView.getEmail(),loginView.getPassword());

          if(result==1)
          {
              loginView.navigateToHome();
          }
          else
          {
              loginView.loginFailed();
          }
        }
    }

    public boolean validate(String email,String password)
    {

        if (email.length()==0 ) {
            loginView.setEmailError("Email is required");
            Log.i("tag","required!!!!!!!!!!!");
            return false;
        } else if (!isEmailValid(email)) {

            loginView.setEmailError("Enter a valid email");
            Log.i("tag", "not valid!!!!!!!!!!!");
            return false;
        }
            else
            {
                loginView.setEmailError(null);

            }



        if (password.length()==0) {
            loginView.setPasswordError("Password is required");
            return false;
        } else if (!isPasswordValid(password)) {
            loginView.setPasswordError("Password must contain at least 6 characters");
            return false;
        }
        else
        {
            loginView.setPasswordError(null);

        }

        return true;
    }

    public boolean isEmailValid(String email){

        Pattern emailPattern=Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+");
       return emailPattern.matcher(email).matches();

    }


    public boolean isPasswordValid(String password)
    {
        return password.length() >= 6;
    }

    public boolean checkConnection(Context context)
    {
        boolean state;
        final ConnectivityManager connectivityManager= ((ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE));
        if(connectivityManager.getActiveNetworkInfo()!=null&&connectivityManager.getActiveNetworkInfo().isConnected())
        {
            state=true;

        }
        else
        {
            state=false;
        }
        return state;
    }

     }

