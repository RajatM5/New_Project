package com.example.myapplication.veggies.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.veggies.R;

public class Support extends AppCompatActivity {
    LinearLayout send;
    ImageView bac;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.support);
        bac = findViewById(R.id.support_back);

        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Support.this,Dashboard_activity.class);
                startActivity(intent);

            }
        });
}}

