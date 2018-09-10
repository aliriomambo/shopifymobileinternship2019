package mz.co.aliriomambo.shopifyaliriomambowintership.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
Created by Alírio Mambo
*/


public class ShopifyApi {
    public static final String API_URL = "https://shopicruit.myshopify.com";

    private static final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();

    //Library that checks connections
    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    private static final ProductService PRODUCT_SERVICE = retrofit.create(ProductService.class);

    public static ProductService getProductService() {
        return PRODUCT_SERVICE;
    }
}
