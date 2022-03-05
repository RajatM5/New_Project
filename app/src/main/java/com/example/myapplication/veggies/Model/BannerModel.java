package com.example.myapplication.veggies.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BannerModel {
@SerializedName("success")
private int success;

@SerializedName("message")
private String message;

@SerializedName("data")
private ArrayList<BannerData> data= new ArrayList<>();

@SerializedName("image_path")
private String image_path;


public static class BannerData{
    @SerializedName("image")
    private String image;

    public String getImage() {
        return image;

    }

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

    public ArrayList<BannerData> getData() {
        return data;
    }

    public void setData(ArrayList<BannerData> data) {
        this.data = data;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }



}
