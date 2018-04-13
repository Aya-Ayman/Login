package com.example.aya.login.Presenter;

import android.content.Context;

/**
 * Created by Aya on 4/12/2018.
 */

public interface PresenterInt {
    public void validate(String email,String password);

    public boolean isEmailValid(String email);

    public boolean isPasswordValid();

    public void loginSuccess();

    public void loginFailed();

    public boolean checkConnection(Context context);
}
