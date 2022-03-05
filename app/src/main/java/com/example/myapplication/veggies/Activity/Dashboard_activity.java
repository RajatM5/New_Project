package com.example.myapplication.veggies.Activity;

import static com.example.myapplication.veggies.Controllers.SessionManagement.KEY_USERID;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.veggies.Adapter.Offers_Adp;
import com.example.myapplication.veggies.Adapter.ReviewAdapter;
import com.example.myapplication.veggies.Adapter.ShopCat_Adp;
import com.example.myapplication.veggies.Adapter.SliderAdapterBanner;
import com.example.myapplication.veggies.Controllers.ApiClient;
import com.example.myapplication.veggies.Controllers.SessionManagement;
import com.example.myapplication.veggies.Model.BannerModel;
import com.example.myapplication.veggies.Model.Customer_reviewsModel;
import com.example.myapplication.veggies.Model.OfferModel;
import com.example.myapplication.veggies.Model.ShopModel;
import com.example.myapplication.veggies.R;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.JsonObject;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderView;

import retrofit2.Call;
import retrofit2.Callback;

public class Dashboard_activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ProgressDialog pd;
    SessionManagement sessionManagement;
    Toolbar toolbar;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView nav_view;
    ImageView fruits,iv_banner,cart;
    TextView ad;
    LinearLayout supp,acc,scroll1;
    RecyclerView review_rv,rv,rv_offer;
    SliderView imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);

            Log.w("DTAG", "create");
            toolbar = (Toolbar) findViewById(R.id.toolbar_veggies);
//        toolbar_name = (TextView) findViewById(R.id.toolbar_name);
            toolbar.setTitle("");
            setSupportActionBar(toolbar);
//        toolbar_name.setText("Find Doctor");
            drawerLayout = findViewById(R.id.my_drawer_layout);
            nav_view = findViewById(R.id.nav_view);
            nav_view.setNavigationItemSelectedListener(this);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(Dashboard_activity.this, drawerLayout, toolbar,
                    R.string.nav_open, R.string.nav_close);
            drawerLayout.addDrawerListener(toggle);
//        drawer.openDrawer(Gravity.RIGHT);
            toggle.syncState();
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
        acc = findViewById(R.id.my_account);
        fruits = findViewById(R.id.fruits);
        supp = findViewById(R.id.my_support);
        review_rv = findViewById(R.id.review_rv);
        scroll1 = findViewById(R.id.scroll1);
        iv_banner =findViewById(R.id.iv_banner);
        imageSlider =findViewById(R.id.imageSlider);
        cart = findViewById(R.id.cart);
        rv =findViewById(R.id.rv);
        rv_offer =findViewById(R.id.rv_offer);
//        sessionManagement = new SessionManagement(getApplicationContext());
        pd = new ProgressDialog(this);
        pd.setCancelable(false);
        sessionManagement = new SessionManagement(getApplicationContext());
        scroll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard_activity.this, ArrayList.class);
            }
        });
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard_activity.this, Account.class);
                startActivity(intent);

            }
        });

        supp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard_activity.this,Support.class);
                startActivity(intent);

            }
        });

        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard_activity.this, Fruits.class);
                startActivity(intent);

            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard_activity.this, Cart.class);
                startActivity(intent);
            }
        });
    }

    private void getbanner() {
        try {
       pd.show();
            Log.w("PPMTAG","Respinse banner "+"HI");
            JsonObject jsonObjectbanner = new JsonObject();
            jsonObjectbanner.addProperty("status","Active");
            retrofit2.Call<BannerModel> call = ApiClient.getInstance().getApi().getBanners(jsonObjectbanner);
            call.enqueue(new Callback<BannerModel>() {
                @Override
                public void onResponse(@NonNull retrofit2.Call<BannerModel> call, retrofit2.Response<BannerModel> response) {
                    Log.w("PPMTAG","Respinse banner "+response.body().getSuccess());
//                    Toast.makeText(Dashboard_activity.this, response.body().getSuccess(), Toast.LENGTH_SHORT).show();
                    if(response.body().getSuccess()==1){

                        SliderAdapterBanner banner = new SliderAdapterBanner(Dashboard_activity.this,response.body().getData(),response.body().getImage_path());
                        imageSlider.setSliderAdapter(banner);
                        imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
                        imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
                        imageSlider.setIndicatorSelectedColor(Color.WHITE);
                        imageSlider.setIndicatorUnselectedColor(Color.GRAY);
                        imageSlider.setScrollTimeInSec(4); //set scroll delay in seconds :
                        imageSlider.startAutoCycle();
                        pd.dismiss();
                    }else {
                        Toast.makeText(Dashboard_activity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Handler mHandler = new Handler();
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
//
                            pd.dismiss();


                            }

                        }, 2000);
//                        ppm_pb3.setVisibility(View.GONE);
                    }

                }

                @Override
                public void onFailure(Call<BannerModel> call, Throwable t) {
                    //handle error or failure cases here
//                    ppm_pb3.setVisibility(View.GONE);
                pd.dismiss();
                    Log.w("ELTAG","error"+t.getLocalizedMessage());
                    Toast.makeText(Dashboard_activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            Log.w("ELTAG","error"+e);
        }
    }



//    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
private void getreview() {
    try {
       pd.show();
//        String tempid= Settings.Secure.getString(Dashboard_activity.this.getContentResolver(),
//                Settings.Secure.ANDROID_ID);

        JsonObject jsonObjectcoustmrreview = new JsonObject();
        jsonObjectcoustmrreview.addProperty("status","Active");

        retrofit2.Call<Customer_reviewsModel> call = ApiClient.getInstance().getApi().getCustomer_review();
        call.enqueue(new Callback<Customer_reviewsModel>() {
            @Override
            public void onResponse(retrofit2.Call<Customer_reviewsModel> call,
                                   retrofit2.Response<Customer_reviewsModel> response) {
                Log.w("PPMTAG","Respinse "+response.body().getSuccess());
                if(response.body().getSuccess()==1){

//                        Catg_Adapter cardAdapter = new Catg_Adapter(response.body().getRvdata(), getActivity(),response.body().getImage_path());
//                        list_rv.setAdapter(cardAdapter);
                    ReviewAdapter review_adapter = new ReviewAdapter(response.body().getData(),Dashboard_activity.this,response.body().getImage_path());
                    review_rv.setAdapter(review_adapter);

//                    pd.dismiss();
                }else {
                    Toast.makeText(Dashboard_activity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Handler mHandler = new Handler();
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
//
                            pd.dismiss();


                        }

                    }, 2000);
//                        ppm_pb3.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<Customer_reviewsModel> call, Throwable t) {
                //handle error or failure cases here
//                    ppm_pb3.setVisibility(View.GONE);
//                pd.dismiss();
                Log.w("ELTAG","error"+t.getLocalizedMessage());
                Toast.makeText(Dashboard_activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    } catch (Exception e) {
        Log.w("ELTAG","error"+e);
    }
}
//    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private void getCatogery() {
        try {
            pd.show();
            JsonObject jsonObjectcatg = new JsonObject();
            jsonObjectcatg.addProperty("status", "Active");
            retrofit2.Call<ShopModel> call = ApiClient.getInstance().getApi().getcategory(jsonObjectcatg);
            call.enqueue(new Callback<ShopModel>() {
                @Override
                public void onResponse(retrofit2.Call<ShopModel> call,
                                       retrofit2.Response<ShopModel> response) {
                    Log.w("PPMTAG","Respinse "+response.body().getSuccess());
                    if(response.body().getSuccess()==1){
//                        Log.w("RATAG",response.body().image_path);

                        ShopCat_Adp cardAdapter = new ShopCat_Adp(response.body().getData(),Dashboard_activity.this,response.body().getImage_path());
                        rv.setAdapter(cardAdapter);
//
                         pd.dismiss();
                    }else {
                        Toast.makeText(Dashboard_activity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
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
                public void onFailure(Call<ShopModel> call, Throwable t) {
                    pd.dismiss();
                    Log.w("ELTAG","error"+t.getLocalizedMessage());
                    Toast.makeText(Dashboard_activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();



                }
            });
        } catch (Exception e) {
            Log.w("ELTAG","error"+e);
        }

    }
//    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private void getOffers() {
        try {
//            pd.show();
            JsonObject jsonObjectcatg = new JsonObject();
            jsonObjectcatg.addProperty("product_id","1");

            retrofit2.Call<OfferModel> call = ApiClient.getInstance().getApi().getOffers();
            call.enqueue(new Callback<OfferModel>() {
                @Override
                public void onResponse(retrofit2.Call<OfferModel> call,
                                       retrofit2.Response<OfferModel> response) {
                    Log.w("PPMTAG","Respinse "+response.body().getSuccess());
                    if(response.body().getSuccess()==1){
//                        Log.w("RATAG",response.body().image_path);

                        Offers_Adp cardAdapter = new Offers_Adp(response.body().getData(),Dashboard_activity.this,response.body().getImage_path());
                        rv_offer.setAdapter(cardAdapter);
//
                        pd.dismiss();
                    }else {
                        Toast.makeText(Dashboard_activity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
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
                public void onFailure(Call<OfferModel> call, Throwable t) {
                    pd.dismiss();
                    Log.w("ELTAG","error"+t.getLocalizedMessage());
                    Toast.makeText(Dashboard_activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();



                }
            });
        } catch (Exception e) {
            Log.w("ELTAG","error"+e);
        }

    }

//    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        @Override
        protected void onStart () {
        super.onStart();
            Log.w("DTAG", "resume");
        }

        @Override
        protected void onResume () { super.onResume();
            Log.w("DTAG", "resume");
            getreview();
            getbanner();
            getCatogery();
            getOffers();

        }

    @Override
        public boolean onNavigationItemSelected (@NonNull MenuItem item){
            return false;
        }

    }



