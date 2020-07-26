package com.esraa.buyflowres.Data.Retrofit;

import com.esraa.buyflowres.Data.Model.adv_model;
import com.esraa.buyflowres.Data.Model.main_cat_model;
import com.esraa.buyflowres.Data.Model.product_model;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterfaces {
    @POST("API/adv_api.php")
    @FormUrlEncoded
    Observable<adv_model> get_adv(@Field("lang")String lang_id);
    @POST("API/get_cat_api.php")
    @FormUrlEncoded
    Observable<main_cat_model>get_cat_list(@Field("lang")String lang_id);
    @POST("API/get_cat_product.php")
    @FormUrlEncoded
    Observable<product_model>get_all_product(@Field("lang")String lang_id);
}
