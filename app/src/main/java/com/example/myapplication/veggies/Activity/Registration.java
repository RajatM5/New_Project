package com.example.myapplication.veggies.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.veggies.Controllers.ApiClient;
import com.example.myapplication.veggies.Model.RegistrationModel;
import com.example.myapplication.veggies.R;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;

public class Registration extends AppCompatActivity {
    ProgressDialog pd;
    EditText reg_email,reg_name,reg_refer,reg_mob ;
    RelativeLayout reg_complete;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);
        reg_name =  findViewById(R.id.reg_name);
        reg_email =  findViewById(R.id.reg_email);
        reg_mob =  findViewById(R.id.reg_mob);
        reg_complete = findViewById(R.id.reg_complete);

        reg_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reg_name.getText().toString().trim().length() == 0) {
                    reg_name.setError("Please Enter Full Name");
                    reg_name.findFocus();
                } else if (reg_name.getText().toString().trim().length() == 0) {
                    reg_name.setError("Please Enter Valid Mobile Number");
                    reg_name.findFocus();
                } else if (reg_email.getText().toString().trim().length() == 0) {
                    reg_email.setError("Please Enter Valid Email Id");
                    reg_email.findFocus();
                } else if (reg_mob.getText().toString().trim().length() == 0) {
                    reg_mob.setError("Please Enter Mobile Number");
                    reg_mob.findFocus();
                } else {
                    getRegistration();
                }
            }

            private void getRegistration() {
                try {
                     pd.show();
                     String tempid = Settings.Secure.getString(Registration.this.getContentResolver(),
                                     Settings.Secure.ANDROID_ID);
                     JsonObject jsonObject = new JsonObject();
                     jsonObject.addProperty("name", reg_name.getText().toString());
                     jsonObject.addProperty("mobile", reg_mob.getText().toString());
                     jsonObject.addProperty("email", reg_email.getText().toString());


                     Call<RegistrationModel> call = ApiClient.getInstance().getApi().getRegistration(jsonObject);
                     call.enqueue(new Callback<RegistrationModel>() {
                            @Override
                            public void onResponse(Call<RegistrationModel> call, retrofit2.Response<RegistrationModel> response) {
                                Log.w("PPMTAG", "signuppromocode " + call.request());
                                Log.w("PPMTAG", "Respinse " + response.body().getSuccess());
                                if (response.body().getSuccess() == 1) {
                                    pd.dismiss();
                                    Intent intent = new Intent(Registration.this, Login.class);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    Log.w("PPMTAG", "Respinse " + response.body().getSuccess());
                                    Toast.makeText(Registration.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                    Handler mHandler = new Handler();
                                    mHandler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {

                                            pd.dismiss();

                                        }

                                    }, 2000);
//                        ppm_pb3.setVisibility(View.GONE);
                                }

                            }

                            @Override
                            public void onFailure(Call<RegistrationModel> call, Throwable t) {
                                //handle error or failure cases here
//                    ppm_pb3.setVisibility(View.GONE);
                                Log.w("ELTAG", "error" + t.getLocalizedMessage());
                                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    } catch (Exception e) {
                }
            }
        });}}