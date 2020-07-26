package com.esraa.buyflowres.Data.Retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    private static String base_url="https://www.oxygenislands.com/";
    public static ApiInterfaces get_client(){

        Retrofit retrofit=new Retrofit.Builder()
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(base_url)
                .build();
        ApiInterfaces apiInterfaces=retrofit.create(ApiInterfaces.class);
        return apiInterfaces;





    }
}
