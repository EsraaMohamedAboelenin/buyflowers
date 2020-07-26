package com.esraa.buyflowres.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.esraa.buyflowres.Data.Model.product_model;
import com.esraa.buyflowres.R;
import com.esraa.buyflowres.Utils.SpaceItemDecoration;
import com.esraa.buyflowres.databinding.AdvLayoutBinding;
import com.esraa.buyflowres.databinding.ProductListBinding;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class cat_adapter  extends RecyclerView.Adapter<cat_adapter.ViewHolder>{
private Context context;
private ArrayList<product_model.Data>contents;

public cat_adapter(Context context,ArrayList<product_model.Data>contents){

    this.contents = contents;
    this.context=context;

}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        ProductListBinding productListBinding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.product_list,parent,false);



        return new ViewHolder(productListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.layoutBinding.catName.setText(contents.get(position).getCat_name());

    holder.layoutBinding.productList.setAdapter(new product_adapter(context,contents.get(position).getProduct_array()));
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context);
        ((LinearLayoutManager) layoutManager).setOrientation(RecyclerView.HORIZONTAL);
        holder.layoutBinding.productList.setLayoutManager(layoutManager);
        holder.layoutBinding.productList.addItemDecoration(new SpaceItemDecoration(5));


    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
      ProductListBinding layoutBinding;

        public ViewHolder(@NonNull ProductListBinding itemView) {
            super(itemView.getRoot());
           layoutBinding =itemView;
        }
    }

}
