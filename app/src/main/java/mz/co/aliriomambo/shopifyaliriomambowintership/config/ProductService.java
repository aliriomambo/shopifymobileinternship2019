package mz.co.aliriomambo.shopifyaliriomambowintership.config;

import mz.co.aliriomambo.shopifyaliriomambowintership.data.model.Products;
import retrofit2.Call;
import retrofit2.http.GET;

/*
Created by Alírio Mambo
*/

public interface ProductService {
    @GET("/admin/products.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    Call<Products> loadProducts();

}
