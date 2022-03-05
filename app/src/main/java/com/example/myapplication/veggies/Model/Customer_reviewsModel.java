package com.example.myapplication.veggies.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Customer_reviewsModel {
    @SerializedName("success")
    private int success;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private ArrayList<Customer_reviewsData> data = new ArrayList<>();

    @SerializedName("image_path")
    private String image_path;

    public static class Customer_reviewsData{
        @SerializedName("name")
        private String name;
        @SerializedName("image")
        private String image;
        @SerializedName("description")
        private String description;

        public String getName() { return name; }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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

    public ArrayList<Customer_reviewsData> getData() { return data; }

    public void setData(ArrayList<Customer_reviewsData> data) {
        this.data = data;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

}
