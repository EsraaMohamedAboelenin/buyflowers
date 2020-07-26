package com.esraa.buyflowres.View.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.esraa.buyflowres.Data.Model.adv_model;
import com.esraa.buyflowres.Data.Model.main_cat_model;
import com.esraa.buyflowres.Data.Model.product_model;
import com.esraa.buyflowres.Data.Retrofit.ApiClient;
import com.esraa.buyflowres.Data.Retrofit.ApiInterfaces;
import com.esraa.buyflowres.R;
import com.esraa.buyflowres.Utils.SpaceItemDecoration;
import com.esraa.buyflowres.View.Adapter.adv_adapter;
import com.esraa.buyflowres.View.Adapter.cat_adapter;
import com.esraa.buyflowres.View.Adapter.main_cat_adapter;
import com.esraa.buyflowres.ViewModel.HomeVM;
import com.esraa.buyflowres.databinding.HomeBinding;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HomeFragment  extends Fragment {
    private HomeBinding homeBinding;
    private HomeVM homeVM;
    private Handler handler;
    private Runnable runnable;
    private int pages,current_page=0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        homeBinding= DataBindingUtil.inflate(inflater, R.layout.home,container,false);

        View view=homeBinding.getRoot();
        homeVM= ViewModelProviders.of(this).get(HomeVM.class);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        set_adv();
        set_main_cat();
        set_cat_product();


    }



   private void set_adv() {


        homeVM.get_adv().observe(this, new Observer<List<adv_model.Data>>() {
            @Override
            public void onChanged(List<adv_model.Data> data) {

                ArrayList<adv_model.Data>contents=(ArrayList<adv_model.Data>) data;

                adv_adapter adv_adapter=new adv_adapter(getContext(),contents);
                homeBinding.advViewPager.setAdapter(adv_adapter);
                pages=contents.size();
                automatic_scroll();


            }
        });






   }

private void automatic_scroll(){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                if(current_page>=pages){

                    current_page=0;
                }
                homeBinding.advViewPager.setCurrentItem(current_page++,true);
                handler.postDelayed(runnable,3000);
            }
        };
handler.postDelayed(runnable,3000);
}







private void set_main_cat(){

       homeVM.get_main_cat().observe(this, new Observer<List<main_cat_model.Data>>() {
           @Override
           public void onChanged(List<main_cat_model.Data> data) {
               ArrayList<main_cat_model.Data>contents=(ArrayList<main_cat_model.Data>) data;
               homeBinding.mainCat.setAdapter(new main_cat_adapter(getContext(),contents));
               GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),2);

               gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
               gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                   @Override
                   public int getSpanSize(int position) {
                       if(position==0)
                       return 2;
                       else return 1;
                   }
               });
               homeBinding.mainCat.setLayoutManager(gridLayoutManager);
               homeBinding.mainCat.addItemDecoration(new SpaceItemDecoration(5));

           }
       });








}







private void set_cat_product(){

        homeVM.get_cat_product().observe(this, new Observer<product_model>() {
            @Override
            public void onChanged(product_model product_model) {
                ArrayList<product_model.Data>content=product_model.getContents();

                homeBinding.productCatList.setAdapter(new cat_adapter(getContext(),content));
                RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
                ((LinearLayoutManager) layoutManager).setOrientation(RecyclerView.VERTICAL);
                homeBinding.productCatList.setLayoutManager(layoutManager);
                homeBinding.productCatList.addItemDecoration(new SpaceItemDecoration(10));
            }
        });




}







}
