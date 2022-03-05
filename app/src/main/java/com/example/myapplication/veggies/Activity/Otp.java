package com.example.myapplication.veggies.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.veggies.Controllers.ApiClient;
import com.example.myapplication.veggies.Controllers.SessionManagement;
import com.example.myapplication.veggies.Model.OtpModel;
import com.example.myapplication.veggies.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.JsonObject;

import retrofit2.Callback;
import retrofit2.http.Body;

public class Otp extends AppCompatActivity {
    ProgressDialog pd;
    SessionManagement sessionManagement;
    TextView otp_gethelp,otp_changeno;
    RelativeLayout otp_continue;
    TextInputEditText otp_et;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp_activity);
        sessionManagement = new SessionManagement(getApplicationContext());
        pd = new ProgressDialog(this);
        pd.setCancelable(false);
        pd.setMessage("Please wait...");
        otp_gethelp = findViewById(R.id.otp_gethelp);
        otp_changeno = findViewById(R.id.otp_changeno);
        otp_continue = findViewById(R.id.otp_continue);
        otp_changeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {  Intent intent = new Intent(Otp.this, Login.class);
                startActivity(intent);
            }
        });
        otp_gethelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {  Intent intent = new Intent(Otp.this, Support.class);
                startActivity(intent);
            }
        });
        otp_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(otp_et.getText().toString().trim().length()==0){
                        otp_et.setError("Please Enter OTP");
                        otp_et.findFocus();
                    }else{
                        getVerifyMyOtp();
                    }
                }
            });
//
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Otp.this, ProfileActivity.class);
//                startActivity(intent);
//            }
//        });



        }


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private void getVerifyMyOtp() {
            try {
                pd.show();
                String tempid= Settings.Secure.getString(Otp.this.getContentResolver(),
                        Settings.Secure.ANDROID_ID);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("otp", otp_et.getText().toString());
                retrofit2.Call<OtpModel> call = ApiClient.getInstance().getApi().getOTP(jsonObject);
                call.enqueue(new Callback<OtpModel>() {
                    @Override
                    public void onResponse(retrofit2.Call<OtpModel> call,
                                           retrofit2.Response<OtpModel> response) {
                        Log.w("PPMTAG","Respinse "+response.body().getSuccess());
                        if(response.body().getSuccess()==1){
                            pd.dismiss();
                            Log.w("PPMTAG","response inside==>"+response);
                            Toast.makeText(Otp.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                        Toast.makeText(com.tbd.gtechitworld.activities.LoginActivity.this, response.body().getData().getWallet(), Toast.LENGTH_SHORT).show();
                            Log.w("GBATAG","generate getName===>"+response.body().getOtpDataModel());
                            sessionManagement.createLoginSession(response.body().getOtpDataModel().getId(),response.body().getOtpDataModel().getName(),response.body().getOtpDataModel().getEmail(),response.body().getOtpDataModel().getMobile(),response.body().getOtpDataModel().getStatus());


                                Intent intent = new Intent(Otp.this,Dashboard_activity.class);
                                startActivity(intent);
                                finish();


                        }else {
                            Toast.makeText(Otp.this,response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            pd.dismiss();
//                        ppm_pb3.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(retrofit2.Call<OtpModel> call, Throwable t) {
                        Log.w("ELTAG","error"+t.getLocalizedMessage());
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                });
            } catch (Exception e) {

            }
        }
        }