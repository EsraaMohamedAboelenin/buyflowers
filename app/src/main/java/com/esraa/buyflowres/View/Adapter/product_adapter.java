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

import com.esraa.buyflowres.Data.Model.product_model;
import com.esraa.buyflowres.R;
import com.esraa.buyflowres.databinding.ProductContentBinding;
import com.esraa.buyflowres.databinding.ProductListBinding;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class product_adapter extends RecyclerView.Adapter<product_adapter.ViewHolder> {
    private Context context;
    private ArrayList<product_model.Data.product_data> contents;
    private Point screenSize;
    private int width,height;

    public product_adapter(Context context,ArrayList<product_model.Data.product_data>contents){

        this.contents = contents;
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
       ProductContentBinding productBinding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.product_content,parent,false);



        return new ViewHolder(productBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     holder.layoutBinding.productName.setText(contents.get(position).getPro_name());
     holder.layoutBinding.productPrice.setText(contents.get(position).getPro_price());
        ViewGroup.LayoutParams layoutParam=holder.layoutBinding.productImg.getLayoutParams();
        layoutParam.height = height/6;
        holder.layoutBinding.productImg.setLayoutParams(layoutParam);
        Picasso.with(context).load(contents.get(position).getPro_img()).into(holder.layoutBinding.productImg, new Callback() {
            @Override
            public void onSuccess() {
                holder.layoutBinding.loader.setVisibility(View.INVISIBLE);
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
     ProductContentBinding layoutBinding;

        public ViewHolder(@NonNull ProductContentBinding itemView) {
            super(itemView.getRoot());
            layoutBinding =itemView;
        }
    }


}
