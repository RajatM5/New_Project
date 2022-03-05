package com.example.myapplication.veggies.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ShopSubModel {

    @SerializedName("success")
    private int success;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private ArrayList<ShopSubDataModel> data = new ArrayList<>();

    @SerializedName("image_path")
    private String image_path;


    public static class ShopSubDataModel{
        @SerializedName("product_name")
        private String product_name;
        @SerializedName("quantity")
        private String quantity;
        @SerializedName("unit_type")
        private String unit_type;
        @SerializedName("price")
        private String price;
        @SerializedName("image")
        private String image;

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getUnit_type() {
            return unit_type;
        }

        public void setUnit_type(String unit_type) {
            this.unit_type = unit_type;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

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

    public ArrayList<ShopSubDataModel> getData() {
        return data;
    }

    public void setData(ArrayList<ShopSubDataModel> data) {
        this.data = data;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
}