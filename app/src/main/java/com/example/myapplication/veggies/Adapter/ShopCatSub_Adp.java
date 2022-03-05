package com.example.myapplication.veggies.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.veggies.Activity.Description;
import com.example.myapplication.veggies.Activity.ShopSubCat;
import com.example.myapplication.veggies.Model.ShopSubModel;
import com.example.myapplication.veggies.R;


import java.util.ArrayList;

public class ShopCatSub_Adp extends RecyclerView.Adapter<ShopCatSub_Adp.ViewHolder>{
    private ArrayList<ShopSubModel.ShopSubDataModel> data ;
    Context context;
    String image_path;
    int count= 1;
    public ShopCatSub_Adp(ArrayList<ShopSubModel.ShopSubDataModel> data , ShopSubCat context, String image_path) {
        this.data = data;
        this.context = context;
        this.image_path = image_path;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.subcat, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
       
        return viewHolder;
    }

@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ShopSubModel.ShopSubDataModel datan = data.get(position); ;
        holder.milk_name.setText(datan.getProduct_name());
        holder.milk_qty.setText(datan.getQuantity());
        holder.milk_unit.setText(datan.getUnit_type());
        holder.milk_pr.setText(datan.getPrice());
        Glide.with(context).load(image_path+datan.getImage()).into(holder.milk_iv);
        holder.milk_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.milk_A.setVisibility(View.GONE);
                holder.milk_B.setVisibility(View.VISIBLE);
            }
        });
        holder.milk_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;
                holder.txtCount.setText(String.valueOf(count));
            }
        });
        holder.milk_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                holder.txtCount.setText(String.valueOf(count));
            }
        });
      holder.milk_iv.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(context, Description.class);
              context.startActivity(intent);
          }
      });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView milk_iv;
        public TextView milk_name,milk_description,milk_unit,milk_qty,milk_pr,milk_minus,milk_plus,txtCount;
        public LinearLayout milk_A,milk_B;
        public int count = 1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.milk_iv = (ImageView) itemView.findViewById(R.id.milk_iv);
            this.milk_qty = (TextView) itemView.findViewById(R.id.milk_qty);
            this.milk_name = (TextView) itemView.findViewById(R.id.milk_name);
            this.milk_pr = (TextView) itemView.findViewById(R.id.milk_pr);
//            this.milk_description = (TextView) itemView.findViewById(R.id.milk_description);
            this.milk_unit = (TextView) itemView.findViewById(R.id.milk_unit);

            milk_A = (LinearLayout) itemView.findViewById(R.id.milk_A);
            milk_B = (LinearLayout) itemView.findViewById(R.id.milk_B);
            this.txtCount =(TextView) itemView.findViewById(R.id.milk_int);
            this.milk_plus = (TextView) itemView.findViewById(R.id.milk_plus);
            this.milk_minus = (TextView) itemView.findViewById(R.id.milk_minus);
        }
    }
}


