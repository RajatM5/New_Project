package com.example.myapplication.veggies.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.veggies.Model.BannerModel;
import com.example.myapplication.veggies.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;


public class SliderAdapterBanner extends SliderViewAdapter<SliderAdapterBanner.SliderAdapterVH>{
    private final Context context;
    ArrayList<BannerModel.BannerData> mSliderItems;
    String image_path;
    public SliderAdapterBanner(Context context, ArrayList<BannerModel.BannerData> bannerList, String image_path) {
        this.context = context;
        this.mSliderItems = bannerList;
        this.image_path=image_path;
    }
    public void renewItems(ArrayList<BannerModel.BannerData> sliderItems) {
        this.mSliderItems = sliderItems;
        notifyDataSetChanged();
    }
    public void deleteItem(int position) {
        this.mSliderItems.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(BannerModel.BannerData sliderItem) {
        this.mSliderItems.add(sliderItem);
        notifyDataSetChanged();
    }
    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_adapter_slider, null);
        return new SliderAdapterVH(inflate);
    }


    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder,final int position) {
        BannerModel.BannerData sliderItem = mSliderItems.get(position);
        Log.w("RATAG",image_path);
        Log.w("RATAG",sliderItem.getImage());

        Glide.with(context)
                .load(image_path+sliderItem.getImage())
                .centerCrop()
                .error(R.drawable.grapes)
                .into(viewHolder.iv_banner);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
            }

            });
        }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mSliderItems.size();
    }
    public static class SliderAdapterVH extends SliderViewAdapter.ViewHolder {
        View itemView;
        ImageView iv_banner;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            iv_banner = itemView.findViewById(R.id.iv_banner);
            this.itemView = itemView;
        }
    }
}