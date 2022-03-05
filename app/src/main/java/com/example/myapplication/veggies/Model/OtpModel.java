package com.example.myapplication.veggies.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OtpModel {
    @SerializedName("success")
    private int success;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    public OtpDataModel otpDataModel;


    public static class OtpDataModel {
        @SerializedName("id")
        private String id;
        @SerializedName("name")
        private String name;
        @SerializedName("mobile")
        private String mobile;
        @SerializedName("email")
        private String email;
        @SerializedName("status")
        private String status;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

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

    public OtpDataModel getOtpDataModel() {
        return otpDataModel;
    }

    public void setOtpDataModel(OtpDataModel otpDataModel) {
        this.otpDataModel = otpDataModel;
    }
}