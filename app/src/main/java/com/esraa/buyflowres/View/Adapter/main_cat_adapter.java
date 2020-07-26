package com.esraa.buyflowres.View.Adapter;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.esraa.buyflowres.Data.Model.main_cat_model;
import com.esraa.buyflowres.R;
import com.esraa.buyflowres.databinding.AdvLayoutBinding;
import com.esraa.buyflowres.databinding.MainCatLayoutBinding;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class main_cat_adapter extends RecyclerView.Adapter<main_cat_adapter.ViewHolder> {
private Context context;
private ArrayList<main_cat_model.Data>contents;
    private Point screenSize;
    private int width,height;


public main_cat_adapter(Context context,ArrayList<main_cat_model.Data>contents){

    this.contents=contents;
    this.context=context;
    WindowManager windowManager = (WindowManager) context
            .getSystemService(Context.WINDOW_SERVICE);
    Display display = windowManager.getDefaultDisplay();
    screenSize = new Point();
    display.getSize(screenSize);
    width=screenSize.x;
    height=screenSize.y;


}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MainCatLayoutBinding mainCatLayoutBinding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.main_cat_layout,parent,false);
        return new ViewHolder(mainCatLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if(position==0){

            ViewGroup.LayoutParams layoutParams=holder.LayoutBinding.container.getLayoutParams();
            layoutParams.width=width/2;

            holder.LayoutBinding.container.setLayoutParams(layoutParams);




        }

        else{
            ViewGroup.LayoutParams layoutParams=holder.LayoutBinding.container.getLayoutParams();
            layoutParams.width=width/4;
            // layoutParams.height=height/6;
            holder.LayoutBinding.container.setLayoutParams(layoutParams);


        }









        holder.LayoutBinding.catName.setText(contents.get(position).getCat_name());
        Picasso.with(context).load(contents.get(position).getCat_img()).into(holder.LayoutBinding.img, new Callback() {
            @Override
            public void onSuccess() {
                holder.LayoutBinding.loader.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError() {

            }
        });

    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        MainCatLayoutBinding LayoutBinding;

        public ViewHolder(@NonNull MainCatLayoutBinding itemView) {
            super(itemView.getRoot());
            LayoutBinding=itemView;
        }
    }


}
