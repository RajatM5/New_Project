package com.example.myapplication.veggies.Model;

import com.google.gson.annotations.SerializedName;

public class RegistrationModel {
    @SerializedName("success")
    private int success;
    @SerializedName("message")
    private int message;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }
}
