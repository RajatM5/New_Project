package com.example.myapplication.veggies.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.veggies.R;


public class Description extends AppCompatActivity {
    RelativeLayout disclamer_on,disclamer_off,prodif_on,prodif_off;
    TextView text1,text2,prodif_text1,prodif_text2,desc_minus,desc_plus,desc_int;
    LinearLayout desc_A,desc_B;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descriptions);
        disclamer_on = findViewById(R.id.disclamer_on);
        disclamer_off = findViewById(R.id.disclamer_off);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disclamer_on.setVisibility(View.GONE);
                disclamer_off.setVisibility(View.VISIBLE);
            }
        });
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disclamer_on.setVisibility(View.VISIBLE);
                disclamer_off.setVisibility(View.GONE);
            }
        });

        prodif_on = findViewById(R.id.prodif_on);
        prodif_off = findViewById(R.id.prodif_off);
        prodif_text1 = findViewById(R.id.prodif_text1);
        prodif_text2 = findViewById(R.id.prodif_text2);
        prodif_text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prodif_on.setVisibility(View.GONE);
                prodif_off.setVisibility(View.VISIBLE);
            }
        });
        prodif_text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prodif_on.setVisibility(View.VISIBLE);
                prodif_off.setVisibility(View.GONE);
            }
        });
    }
}