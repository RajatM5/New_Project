package com.example.myapplication.veggies.Activity;

import static com.example.myapplication.veggies.Controllers.SessionManagement.KEY_USERID;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.veggies.Adapter.ShopCatSub_Adp;
import com.example.myapplication.veggies.Controllers.ApiClient;
import com.example.myapplication.veggies.Controllers.SessionManagement;
import com.example.myapplication.veggies.Model.ShopSubModel;
import com.example.myapplication.veggies.R;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopSubCat extends AppCompatActivity {
    RecyclerView list_ml;
    ProgressDialog pd;
    ImageView milk_iv;
    TextView heading;
    SessionManagement sessionManagement;
    String subcatid ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subcatlist);
        sessionManagement = new SessionManagement(ShopSubCat.this);
        pd = new ProgressDialog(this);
        pd.setCancelable(false);
        pd.setMessage("Please wait...");

        list_ml = findViewById(R.id.list_ml);
        getproduct();

        heading = findViewById(R.id.heading);

        String SubCatName = getIntent().getStringExtra("catgname");
        heading.setText(SubCatName);

        subcatid = getIntent().getStringExtra("id");





//        milk_iv = findViewById(R.id.milk_iv);
//        milk_iv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ShopSubCat.this, Description.class);
//            }
//        });
//        ShopSubModel[] My_milk_list_data1 = new ShopSubModel[]{
//        new ShopSubModel("Dinshwa's Red",R.drawable.milkimg,"500 Ml","₹ 50"),
//        new ShopSubModel("Dinshwa's Blue",R.drawable.milkimg2,"500 Ml","₹ 40"),
//        new ShopSubModel("Dinshwa's Green",R.drawable.milkimg3,"500 Ml","₹ 30"),
//        new ShopSubModel("Dinshwa's Red",R.drawable.milkimg,"500 Ml","₹ 50"),
//        new ShopSubModel("Dinshwa's Blue",R.drawable.milkimg2,"500 Ml","₹ 40"),
//        new ShopSubModel("Dinshwa's Green",R.drawable.milkimg3,"500 Ml","₹ 30"),
//        };
//
//        ShopCatSub_Adp listAdapter = new ShopCatSub_Adp(My_milk_list_data1,ShopSubCat.this);
//        list_ml.setAdapter(listAdapter);



    }

    private void getproduct() {
        try {
//            pd.show();
            String tempid = Settings.Secure.getString(ShopSubCat.this.getContentResolver(),
                    Settings.Secure.ANDROID_ID);
            JsonObject jsonObjectproduct = new JsonObject();
            jsonObjectproduct.addProperty("category_id",getIntent().getStringExtra("id"));
            jsonObjectproduct.addProperty("user_id",sessionManagement.getUserDetails().get(KEY_USERID));
            Log.w("PPMTAG", "Respinse " +getIntent().getStringExtra("id"));
            Call<ShopSubModel> call = ApiClient.getInstance().getApi().getProduct(jsonObjectproduct);
            call.enqueue(new Callback<ShopSubModel>() {
                @Override
                public void onResponse(Call<ShopSubModel> call, Response<ShopSubModel> response) {
                    {
                        Log.w("PPMTAG", "Respinse " + response.body().getSuccess());
                        if (response.body().getSuccess() == 1) {


                            ShopCatSub_Adp adapter_subcatg = new ShopCatSub_Adp(response.body().getData(), ShopSubCat.this, response.body().getImage_path());
                            list_ml.setAdapter(adapter_subcatg);


//                            pd.dismiss();
                        } else {
                            Toast.makeText(ShopSubCat.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            Handler mHandler = new Handler();
                            mHandler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    pd.dismiss();


                                }

                            }, 2000);
//                        ppm_pb3.setVisibility(View.GONE);
                        }
                    }}

                        @Override
                        public void onFailure (Call < ShopSubModel > call, Throwable t){
                        pd.dismiss();
                        Log.w("ELTAG", "error" + t.getLocalizedMessage());
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }


            });
        } catch (Exception e) {
            Log.w("ELTAG", "error" + e);


        }

    }}