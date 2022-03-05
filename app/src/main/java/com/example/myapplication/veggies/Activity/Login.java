package com.example.myapplication.veggies.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.veggies.Controllers.ApiClient;
import com.example.myapplication.veggies.Controllers.SessionManagement;
import com.example.myapplication.veggies.Model.LoginModel;
import com.example.myapplication.veggies.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;

public class Login extends AppCompatActivity {
    ProgressDialog pd;
    SessionManagement sessionManagement;
    TextView textskip,regist;
    TextInputEditText signinMobileno;
    RelativeLayout btn_log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        sessionManagement = new SessionManagement(getApplicationContext());
        pd = new ProgressDialog(this);
        pd.setCancelable(false);
        pd.setMessage("Please wait...");
        signinMobileno = findViewById(R.id.signinMobileno);
        btn_log = findViewById(R.id.btn_log);
        regist = findViewById(R.id.regist);
        textskip = findViewById(R.id.login_skip);
//        btn_log.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Login_activity.this, Otp.class);
//                startActivity(intent);
//            }
//        });
//        btn_log.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Login_activity.this, Otp.class);
//                startActivity(intent);
//            }
//        });
        textskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Dashboard_activity.class);
                startActivity(intent);
            }
        });
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Registration.class);
                startActivity(intent);
            }
        });

        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (signinMobileno.getText().toString().trim().length() == 0) {
                    signinMobileno.setError("Please Enter Mobile Number");
                    signinMobileno.findFocus();
                } else if (signinMobileno.getText().toString().trim().length() < 10) {
                    signinMobileno.setError("Please Enter Valid Mobile Number");
                    signinMobileno.findFocus();
                } else {
                    getMeLogin();
                }
            }
        });


    }

      private void getMeLogin() {
        try {
            pd.show();
//                    String tempid = Settings.Secure.getString(Login_activity.this.getContentResolver(),
//                            Settings.Secure.ANDROID_ID);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("mobile",signinMobileno.getText().toString().trim());

            retrofit2.Call<LoginModel> call = ApiClient.getInstance().getApi().getLogMe(jsonObject);
            call.enqueue(new Callback<LoginModel>() {
                @Override
                public void onResponse(retrofit2.Call<LoginModel> call,
                                       retrofit2.Response<LoginModel> response) {
                            Log.w("PPMTAG", "Respinse " + response);
                    if (response.body().getSuccess() == 1) {
                        pd.dismiss();
                        Intent intent = new Intent(Login.this, Otp.class);
                        intent.putExtra("mob",signinMobileno.getText().toString().trim());
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
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
                public void onFailure(Call<LoginModel> call, Throwable t) {
                    //handle error or failure cases here
//                    ppm_pb3.setVisibility(View.GONE);
                    Log.w("ELTAG", "error" + t.getLocalizedMessage());
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {

        }
    }
}

