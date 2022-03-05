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

import com.example.myapplication.veggies.Activity.Fruits;
import com.example.myapplication.veggies.Model.My_fruit_list_data1;
import com.example.myapplication.veggies.R;

public class My_fruit_list_adapter extends RecyclerView.Adapter<My_fruit_list_adapter.ViewHolder>{
    private final My_fruit_list_data1[] my_fruit_list_data1;
    Context context;
    int count = 0;
    public My_fruit_list_adapter(My_fruit_list_data1[] myListData, Fruits context) {
        this.my_fruit_list_data1 = myListData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.fruits, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        My_fruit_list_data1 myListDatan = my_fruit_list_data1[position];
        holder.afl_tv.setText(myListDatan.getDescription());
        holder.afl_iv.setImageResource(myListDatan.getImgId());
        holder.afl_qt.setText(myListDatan.getQuantity());
        holder.buttonA.setOnClickListener(new View.OnClickListener() {
//            bhbhbhbhbjbhbhbjhb
            @Override
            public void onClick(View v) {
                holder.buttonA.setVisibility(View.GONE);
                holder.buttonB.setVisibility(View.VISIBLE);
            }
        });
        holder.buttoninc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;
                holder.txtCount.setText(String.valueOf(count));
            }
        });

        holder.buttondec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                holder.txtCount.setText(String.valueOf(count));
            }
        });

    }

    @Override
    public int getItemCount() {
        return my_fruit_list_data1.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView afl_iv,buttoninc,buttondec;
        public TextView afl_tv;
        public LinearLayout afl_rl,buttonA,buttonB;
        public TextView afl_qt,txtCount;
        public int count = 0;

        public ViewHolder(View itemView) {
            super(itemView);
            this.afl_iv = (ImageView) itemView.findViewById(R.id.afl_iv);
            this.afl_tv = (TextView) itemView.findViewById(R.id.afl_tv);
            this.afl_qt = (TextView) itemView.findViewById(R.id.afl_qt);

            afl_rl = (LinearLayout)itemView.findViewById(R.id.afl_rl);
            buttonA = (LinearLayout) itemView.findViewById(R.id.ly_a1);
            buttonB = (LinearLayout) itemView.findViewById(R.id.ly_b2);
            this.txtCount =(TextView) itemView.findViewById(R.id.integer);
             this.buttoninc =(ImageView) itemView.findViewById(R.id.plus);
            this.buttondec =(ImageView) itemView.findViewById(R.id.minus);


        }
    }
}
