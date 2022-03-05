package com.example.myapplication.veggies.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ShopModel {
    @SerializedName("success")
    private int success;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private ArrayList<ShopDataModel> data = new ArrayList<>();


    @SerializedName("image_path")
    private String image_path;


    public static class ShopDataModel{
        @SerializedName("id")
        private String id;

        @SerializedName("title")
        private String title;

        @SerializedName("image")
        private String image;

        public String getId() { return id; }

        public void setId(String id) { this.id = id; }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() { return image; }

        public void setImage(String image) {
            this.image = image;
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

    public ArrayList<ShopDataModel> getData() { return data; }

    public void setData(ArrayList<ShopDataModel> data) { this.data = data; }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
}