package com.example.aya.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aya.login.Presenter.LoginPresenter;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {

    LoginPresenter presenter;


    @BindView(R.id.email)
    EditText Email;

    @BindView(R.id.email_error)
    TextView EmailError;

    @BindView(R.id.password)
    EditText Password;

    @BindView(R.id.password_error)
    TextView PasswordError;


    @Override
    public void setEmailError(String emailError) {
        EmailError.setText(emailError);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter= new LoginPresenter(this);
    }


    @OnClick(R.id.login_btn)
    public void onButtonClick(View view) {
        if(presenter.checkConnection(this)) {
            presenter.doLogin();
        }
        else
        {
            Toast.makeText(this,"No internet connection", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public String getEmail()
    {
        return Email.getText().toString();
    }
    @Override
    public String getPassword()
    {
        return Password.getText().toString();
    }

    @Override
    public void setPasswordError(String passwordError)
    {
        PasswordError.setText(passwordError);
    }

    public void navigateToHome()
    {
        Intent i = new Intent(this,Welcome.class);
        startActivity(i);

    }

    public  void loginFailed()

    {
        Toast.makeText(this,"login Failed", Toast.LENGTH_SHORT).show();
    }


}

