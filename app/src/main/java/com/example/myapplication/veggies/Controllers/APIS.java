package com.example.myapplication.veggies.Controllers;


import com.example.myapplication.veggies.Model.BannerModel;
import com.example.myapplication.veggies.Model.Customer_reviewsModel;
import com.example.myapplication.veggies.Model.LoginModel;
import com.example.myapplication.veggies.Model.OfferModel;
import com.example.myapplication.veggies.Model.OtpModel;
import com.example.myapplication.veggies.Model.RegistrationModel;
import com.example.myapplication.veggies.Model.ShopModel;
import com.example.myapplication.veggies.Model.ShopSubModel;
import com.google.gson.JsonObject;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIS {

//@FormUrlEncoded
@POST("Master/getLogin")
Call<LoginModel> getLogMe(@Body JsonObject getLogin);
@FormUrlEncoded
@POST("Master/verifyOtp")
Call<OtpModel> getOTP(@Body JsonObject otp);
@FormUrlEncoded
@POST("Master/userRegistration")
Call<RegistrationModel> getRegistration(@Body JsonObject registeration);
//@FormUrlEncoded
@POST("Master/getCustomer_reviews")
Call<Customer_reviewsModel> getCustomer_review();
//@FormUrlEncoded
@POST("Master/getBanners")
Call<BannerModel> getBanners(@Body JsonObject getBanners);
@POST("Master/getCategory")
Call<ShopModel> getcategory(@Body JsonObject getcategory);
@POST("Master/getProduct")
Call<ShopSubModel> getProduct(@Body JsonObject getProduct);
@POST("Master/getOffers")
//Call<OfferModel> getOffers(@Body JsonObject getOffers);
Call<OfferModel> getOffers();


//    Call<OtpModel> getOTP();
//    @POST("Master/userRegistration")
//    Call<RegistrationModel> getMeRegister(@Body JsonObject regObject);
//@FormUrlEncoded
//@POST("app_employee_login.php")
//Call<LoginModel> getLogMe(@Field("action") String action, @Field("email") String email, @Field("password") String password, @Field("device_token") String device_token);



}

