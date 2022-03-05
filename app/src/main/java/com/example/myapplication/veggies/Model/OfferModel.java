package com.example.myapplication.veggies.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OfferModel {
    @SerializedName("success")
    private int success;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private ArrayList<OfferModel.OfferDataModel> data = new ArrayList<>();

    @SerializedName("image_path")
    private String image_path;

    public static class OfferDataModel{
        @SerializedName("product_name")
        private String product_name;
        @SerializedName("image")
        private String image;
        @SerializedName("price")
        private String price;
        @SerializedName("offer_price")
        private String offer_price;

        public String getProduct_name() { return product_name; }

        public void setProduct_name(String product_name) { this.product_name = product_name; }

        public String getImage() { return image; }

        public void setImage(String image) { this.image = image; }

        public String getPrice() { return price; }

        public void setPrice(String price) { this.price = price; }

        public String getOffer_price() { return offer_price; }

        public String getOffer_Price() { return offer_price; }

        public void setOffer_price(String offer_price) { this.offer_price = offer_price; }


    }

    public int getSuccess() { return success; }

    public void setSuccess(int success) { this.success = success; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public ArrayList<OfferDataModel> getData() { return data; }

    public void setData(ArrayList<OfferDataModel> data) { this.data = data; }

    public String getImage_path() { return image_path; }

    public void setImage_path(String image_path) { this.image_path = image_path; }
}
