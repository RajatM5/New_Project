package com.example.myapplication.veggies.Adapter;

import android.content.Context;
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
import com.example.myapplication.veggies.Model.OfferModel;
import com.example.myapplication.veggies.R;

import java.util.ArrayList;

public class Offers_Adp extends RecyclerView.Adapter<Offers_Adp.ViewHolder> {
private ArrayList<OfferModel.OfferDataModel> data ;
    Context context;
    String image_path;
    int count= 1;
    public Offers_Adp ( ArrayList<OfferModel.OfferDataModel> data ,Dashboard_activity context, String image_path ){
       this.data = data;
    this.context = context;
    this.image_path = image_path;
}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.offers,parent,false);
        Offers_Adp.ViewHolder viewHolder = new Offers_Adp.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OfferModel.OfferDataModel datan = data.get(position);
        holder.offers_name.setText(datan.getProduct_name());
        holder.offers_old_pr.setText(datan.getPrice());
        holder.new_pr.setText(datan.getOffer_price());
        Glide.with(context).load(image_path+datan.getImage()).into(holder.offers_img);
        holder.offers_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.offers_A.setVisibility(View.GONE);
                holder.offers_B.setVisibility(View.VISIBLE);
            }
        });
        holder.offers_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;
                holder.offers_int.setText(String.valueOf(count));
            }
        });
        holder.offers_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                holder.offers_int.setText(String.valueOf(count));
            }
        });

    }


    @Override
    public int getItemCount() { return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView offers_img;
        public TextView offers_name,offers_qty,offers_qty_,offers_qty_unit,new_pr,new_pr_unit,offers_old_pr,old_pr_unit,offers_int,offers_minus,offers_plus;
        public LinearLayout offers_A,offers_B;
        public int count = 1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.offers_img = (ImageView) itemView.findViewById(R.id.offers_img);
            this.offers_qty_ = (TextView) itemView.findViewById(R.id.offers_qty_);
            this.offers_name = (TextView) itemView.findViewById(R.id.offers_name);
            this.offers_old_pr = (TextView) itemView.findViewById(R.id.offers_old_pr);
            this.new_pr = (TextView) itemView.findViewById(R.id.new_pr);
            this.old_pr_unit = (TextView) itemView.findViewById(R.id.old_pr_unit);
//            this.milk_description = (TextView) itemView.findViewById(R.id.milk_description);
//            this.milk_unit = (TextView) itemView.findViewById(R.id.milk_unit);

            offers_A = (LinearLayout) itemView.findViewById(R.id.offers_A);
            offers_B = (LinearLayout) itemView.findViewById(R.id.offers_B);
            this.offers_int =(TextView) itemView.findViewById(R.id.offers_int);
            this.offers_plus = (TextView) itemView.findViewById(R.id.offers_plus);
            this.offers_minus = (TextView) itemView.findViewById(R.id.offers_minus);
        }
    }
}
