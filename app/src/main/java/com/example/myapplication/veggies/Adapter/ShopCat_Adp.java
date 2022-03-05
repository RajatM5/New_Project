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
import com.example.myapplication.veggies.Activity.Dashboard_activity;
import com.example.myapplication.veggies.Activity.ShopSubCat;
import com.example.myapplication.veggies.Model.ShopModel;
import com.example.myapplication.veggies.R;

import java.util.ArrayList;

public class ShopCat_Adp extends RecyclerView.Adapter<ShopCat_Adp.ViewHolder>{
    ArrayList<ShopModel.ShopDataModel> data;
    Context context;
    String image_path;
    public ShopCat_Adp(ArrayList<ShopModel.ShopDataModel> data, Dashboard_activity context, String image_path) {
        this.data = data;
        this.context = context;
        this.image_path = image_path;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View ListItem = layoutInflater.inflate(R.layout.category,parent,false);
        ViewHolder viewHolder = new ViewHolder(ListItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ShopModel.ShopDataModel myListDatan = data.get(position);
         holder.afl_tv.setText(myListDatan.getTitle());
        Glide.with(context).load(image_path+myListDatan.getImage()).into(holder.afl_iv);
        holder.milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShopSubCat.class);
                intent.putExtra("catgname",myListDatan.getTitle());
                intent.putExtra("id",myListDatan.getId());
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView afl_iv;
        public TextView afl_tv;
        public LinearLayout milk;

        public ViewHolder(View itemView) {
            super(itemView);
            this.afl_iv = (ImageView) itemView.findViewById(R.id.afl_iv);
            this.afl_tv = (TextView) itemView.findViewById(R.id.afl_tv);
            this.milk = (LinearLayout) itemView.findViewById(R.id.milk);

        }
    }
}
