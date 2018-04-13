package com.example.aya.login;

import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;

/**
 * Created by Aya on 4/11/2018.
 */

public interface LoginView {


    public String getEmail();
    public String getPassword();
    public void setEmailError(String EmailError);
    public void setPasswordError(String PasswordError);
    public void navigateToHome();
    public void loginFailed();


}
