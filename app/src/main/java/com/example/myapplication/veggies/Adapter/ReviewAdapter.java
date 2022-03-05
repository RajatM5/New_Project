package com.example.myapplication.veggies.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.veggies.Activity.Dashboard_activity;
import com.example.myapplication.veggies.Model.Customer_reviewsModel;
import com.example.myapplication.veggies.R;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder>{
   ArrayList<Customer_reviewsModel.Customer_reviewsData> data;
    Context context;
    String image_path;
    int count = 0;
//    public ReviewAdapter(My_fruit_list_data1[] myListData, Fruits context) {
//        this.my_fruit_list_data1 = myListData;
//        this.context = context;
//    }

    public ReviewAdapter(ArrayList<Customer_reviewsModel.Customer_reviewsData> data, Dashboard_activity context, String image_path) {
    this.data = data;
    this.context = context;
    this.image_path = image_path;
    }

    @NonNull
    @Override
    public ReviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.review_adapter, parent, false);
        ReviewAdapter.ViewHolder viewHolder = new ReviewAdapter.ViewHolder(listItem);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ReviewAdapter.ViewHolder holder, int position) {
        Customer_reviewsModel.Customer_reviewsData myListDatan = data.get(position);
        holder.review_name_tv.setText(myListDatan.getName());
        holder.review_dis_tv.setText(myListDatan.getDescription());
        Glide.with(context).load(image_path+myListDatan.getImage()).into(holder.review_iv);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView review_iv;
        public TextView review_name_tv,review_dis_tv;


        public ViewHolder(View itemView) {
            super(itemView);
            review_iv = (ImageView) itemView.findViewById(R.id.review_iv);
            review_name_tv = (TextView) itemView.findViewById(R.id.review_name_tv);
            review_dis_tv = (TextView) itemView.findViewById(R.id.review_dis_tv);

        }
    }
}
