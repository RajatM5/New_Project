package com.example.myapplication.veggies.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.veggies.R;

public class Account extends AppCompatActivity {
    ImageView back;
    ImageView logout;
    LinearLayout profile;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_activity);
        back = findViewById(R.id.acc_back_iv);
        logout = findViewById(R.id.acc_logout_iv);
        profile = findViewById(R.id.account_lay2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Account.this,Dashboard_activity.class);
                startActivity(intent);

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Account.this, Login.class);
                startActivity(intent);

            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Account.this,Profile.class);
                startActivity(intent);

            }
        });
    }
}
