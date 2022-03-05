package com.example.myapplication.veggies.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.veggies.Adapter.My_fruit_list_adapter;
import com.example.myapplication.veggies.Model.My_fruit_list_data1;
import com.example.myapplication.veggies.R;

public class Fruits extends AppCompatActivity {
        RecyclerView list_rv;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fruit_list);

            list_rv = findViewById(R.id.list_rv);
            My_fruit_list_data1[] my_fruit_list_data1 = new My_fruit_list_data1[]{
                    new My_fruit_list_data1("Apple", R.drawable.apple,"1kg"),
                    new My_fruit_list_data1("Grapes",R.drawable.grapes,"1kg"),
                    new My_fruit_list_data1("Banana", R.drawable.banana,"1kg"),
                    new My_fruit_list_data1("Mango", R.drawable.mango,"1kg"),
                    new My_fruit_list_data1("Gavava",R.drawable.gavava,"1kg"),
                    new My_fruit_list_data1("Blueberry",R.drawable.blueberry,"1kg"),
                    new My_fruit_list_data1("Apple", R.drawable.apple,"1kg"),
                    new My_fruit_list_data1("Grapes",R.drawable.grapes,"1kg"),
                    new My_fruit_list_data1("Banana", R.drawable.banana,"1kg"),
                    new My_fruit_list_data1("Mango", R.drawable.mango,"1kg"),
                    new My_fruit_list_data1("Gavava",R.drawable.gavava,"1kg"),
                    new My_fruit_list_data1("Blueberry",R.drawable.blueberry,"1kg"),

            };

            My_fruit_list_adapter listAdapter = new My_fruit_list_adapter(my_fruit_list_data1,Fruits.this);
            list_rv.setAdapter(listAdapter);

        }
    }
