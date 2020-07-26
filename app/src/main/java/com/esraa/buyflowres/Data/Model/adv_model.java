package com.esraa.buyflowres.Data.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class adv_model {


    @SerializedName("product_data")
    private ArrayList<Data> adv_array;

    public ArrayList<Data> getAdv_array() {
        return adv_array;
    }

    public void setAdv_array(ArrayList<Data> adv_array) {
        this.adv_array = adv_array;
    }

    public class Data{

        @SerializedName("img")
        private String imag_url;
        @SerializedName("id_cat")
        private String id;

        public String getImag_url() {
            return imag_url;
        }

        public void setImag_url(String imag_url) {
            this.imag_url = imag_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }





}
