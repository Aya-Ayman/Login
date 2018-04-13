package com.example.aya.login.retrofit;

/**
 * Created by Aya on 4/11/2018.
 */

public class response {

    private boolean status;
    private int error;
    private String message;

    public response(boolean status, int error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
