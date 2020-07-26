package com.esraa.buyflowres.Data.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class product_model {
    @SerializedName("data")
    private ArrayList<Data>contents;

    public ArrayList<Data> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Data> contents) {
        this.contents = contents;
    }

    public   class Data{
        @SerializedName("category_id")
        private String cat_id;
        @SerializedName("category_name")
        private String cat_name;
        @SerializedName("product_data")
        private ArrayList<product_data>product_array;


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

        public ArrayList<product_data> getProduct_array() {
            return product_array;
        }

        public void setProduct_array(ArrayList<product_data> product_array) {
            this.product_array = product_array;
        }

        public class product_data implements Parcelable {



            public  product_data(Parcel in){
                pro_id=in.readString();
            }



            public final Creator<product_data> CREATOR = new Creator<product_data>() {
                @Override
                public product_data createFromParcel(Parcel in) {
                    return new product_data(in);
                }

                @Override
                public product_data[] newArray(int size) {
                    return new product_data[size];
                }
            };



            @SerializedName("prod_id")
            private String pro_id;
            @SerializedName("product_name")
            private String pro_name;
            @SerializedName("product_price")
            private String pro_price;
            @SerializedName("product_img")
            private String pro_img;

            public String getPro_id() {
                return pro_id;
            }

            public void setPro_id(String pro_id) {
                this.pro_id = pro_id;
            }

            public String getPro_name() {
                return pro_name;
            }

            public void setPro_name(String pro_name) {
                this.pro_name = pro_name;
            }

            public String getPro_price() {
                return pro_price;
            }

            public void setPro_price(String pro_price) {
                this.pro_price = pro_price;
            }

            public String getPro_img() {
                return pro_img;
            }

            public void setPro_img(String pro_img) {
                this.pro_img = pro_img;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(pro_id);


            }
        }
    }
}
