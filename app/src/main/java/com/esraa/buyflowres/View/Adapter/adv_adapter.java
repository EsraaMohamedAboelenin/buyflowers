package com.esraa.buyflowres.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.esraa.buyflowres.Data.Model.adv_model;
import com.esraa.buyflowres.R;
import com.esraa.buyflowres.databinding.AdvLayoutBinding;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adv_adapter extends RecyclerView.Adapter<adv_adapter.ViewHolder> {

private Context context;
private ArrayList<adv_model .Data>contents;




public adv_adapter(Context context,ArrayList<adv_model.Data>contents){

    this.contents=contents;
    this.context=context;


}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    AdvLayoutBinding advLayoutBinding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.adv_layout,parent,false);

        return new ViewHolder(advLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Picasso.with(context).load(contents.get(position).getImag_url()).into(holder.advLayoutBinding.img, new Callback() {
            @Override
            public void onSuccess() {
                holder.advLayoutBinding.loader.setVisibility(View.INVISIBLE);
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
AdvLayoutBinding advLayoutBinding;

        public ViewHolder(@NonNull AdvLayoutBinding itemView) {
            super(itemView.getRoot());
            advLayoutBinding=itemView;
        }
    }




}
