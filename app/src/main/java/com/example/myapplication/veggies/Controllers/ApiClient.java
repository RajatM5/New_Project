package com.example.myapplication.veggies.Controllers;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BaseUrl = Utilities.ServerUrl;
    private Retrofit retrofit;
    private static com.example.myapplication.veggies.Controllers.ApiClient client;
    private ApiClient() {

//        Log.w("ZTAG", "NST " + nstToken);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Chain chain) throws IOException {
                                Request original = chain.request();
                                Request.Builder requestBuilder = original.newBuilder()
//                                        .header("Authorization", "Basic dGJkVXNlcjp0YmQkMTIz")
//                                        .header("Password", "tbd$12")
//                                        .header("Username", "tbdUser")
                                        .method(original.method(), original.body());

                                Request request = requestBuilder.build();
                                return chain.proceed(request);
                            }
                        }
                ).connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS).build();


        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
                .build();



    }


    public static synchronized com.example.myapplication.veggies.Controllers.ApiClient getInstance() {
        if (client == null) {
            client = new com.example.myapplication.veggies.Controllers.ApiClient();
        }
        return client;
    }

    public APIS getApi() {
        return retrofit.create(APIS.class);
    }
}