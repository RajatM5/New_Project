package com.example.myapplication.veggies.Model;

public class My_fruit_list_data1 {
    private String description;
    private int imgId;
    private String quantity;
    public My_fruit_list_data1(String description, int imgId,String quantity) {
        this.description = description;
        this.quantity = quantity;
        this.imgId = imgId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() { return quantity; }

    public void setQuantity(String quantity) { this.quantity = quantity; }


    public int getImgId() {
         return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}

