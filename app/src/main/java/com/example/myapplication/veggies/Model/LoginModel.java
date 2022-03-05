package com.example.myapplication.veggies.Model;

import com.google.gson.annotations.SerializedName;

public class LoginModel {
    @SerializedName("success")
    private int success;
    @SerializedName("message")
    private String message;
    @SerializedName("otp")
    private String otp;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}


