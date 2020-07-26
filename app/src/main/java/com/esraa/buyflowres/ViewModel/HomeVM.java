package com.esraa.buyflowres.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.esraa.buyflowres.Data.Model.adv_model;
import com.esraa.buyflowres.Data.Model.main_cat_model;
import com.esraa.buyflowres.Data.Model.product_model;
import com.esraa.buyflowres.Data.Retrofit.ApiClient;
import com.esraa.buyflowres.Data.Retrofit.ApiInterfaces;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class HomeVM extends ViewModel {



   public LiveData<List<adv_model .Data>> get_adv(){

       final MutableLiveData<List<adv_model.Data>>mutableLiveData=new MutableLiveData<>();
       ApiInterfaces apiInterfaces= ApiClient.get_client();
       Observable<adv_model>observable=apiInterfaces.get_adv("en")
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread());
            observable.safeSubscribe(new Observer<adv_model>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onNext(@NonNull adv_model adv_model) {
                    mutableLiveData.setValue(adv_model.getAdv_array());

                }

                @Override
                public void onError(@NonNull Throwable e) {

                }

                @Override
                public void onComplete() {

                }
            });




return mutableLiveData;




   }



    public LiveData<List<main_cat_model.Data>>get_main_cat(){

        MutableLiveData<List<main_cat_model.Data>>mutableLiveData=new MutableLiveData<>();

        ApiInterfaces apiInterfaces= ApiClient.get_client();
        Observable<main_cat_model>observable=apiInterfaces.get_cat_list("en")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.safeSubscribe(new io.reactivex.rxjava3.core.Observer<main_cat_model>() {
            @Override
            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

            }

            @Override
            public void onNext(@io.reactivex.rxjava3.annotations.NonNull main_cat_model main_cat_model) {
                mutableLiveData.setValue(main_cat_model.getCat_array());
            }

            @Override
            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });



        return mutableLiveData;







    }

public LiveData<product_model>get_cat_product(){


       MutableLiveData<product_model>mutableLiveData=new MutableLiveData<>();
       ApiInterfaces apiInterfaces=ApiClient.get_client();
       Observable<product_model>observable=apiInterfaces.get_all_product("en")
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread());
       observable.safeSubscribe(new Observer<product_model>() {
           @Override
           public void onSubscribe(@NonNull Disposable d) {

           }

           @Override
           public void onNext(@NonNull product_model product_model) {
               mutableLiveData.setValue(product_model);

           }

           @Override
           public void onError(@NonNull Throwable e) {

           }

           @Override
           public void onComplete() {

           }
       });


       return mutableLiveData;

}
}
