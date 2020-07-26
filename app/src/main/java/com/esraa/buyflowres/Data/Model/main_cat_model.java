package com.esraa.buyflowres.Data.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class main_cat_model {
@SerializedName("data")
private ArrayList<Data>cat_array;

    public ArrayList<Data> getCat_array() {
        return cat_array;
    }

    public void setCat_array(ArrayList<Data> cat_array) {
        this.cat_array = cat_array;
    }

    public class Data{
       @SerializedName("category_id")
       private String cat_id;
       @SerializedName("category_name")
       private String cat_name;
       @SerializedName("category_img")
       private String cat_img;


       public String getCat_id() {
           return cat_id;
       }

       public void setCat_id(String cat_id) {
           this.cat_id = cat_id;
       }

       public String getCat_name() {
           return cat_name;
       }

       public void setCat_name(String cat_name) {
           this.cat_name = cat_name;
       }

       public String getCat_img() {
           return cat_img;
       }

       public void setCat_img(String cat_img) {
           this.cat_img = cat_img;
       }
   }

}
