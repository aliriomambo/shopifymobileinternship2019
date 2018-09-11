package mz.co.aliriomambo.shopifyaliriomambowintership.data;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mz.co.aliriomambo.shopifyaliriomambowintership.config.ProductService;
import mz.co.aliriomambo.shopifyaliriomambowintership.config.ShopifyApi;
import mz.co.aliriomambo.shopifyaliriomambowintership.data.local.AppDatabase;
import mz.co.aliriomambo.shopifyaliriomambowintership.data.model.Product;
import mz.co.aliriomambo.shopifyaliriomambowintership.data.model.Products;
import mz.co.aliriomambo.shopifyaliriomambowintership.data.model.Tag;
import mz.co.aliriomambo.shopifyaliriomambowintership.data.model.Variant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private AppDatabase appDatabase;


    public Repository(Context context) {
        appDatabase = AppDatabase.getInstance(context);
        synchronize();
    }


    private void synchronize() {
        Log.d("Repository", "Synchronize");
        final ProductService productService = ShopifyApi.getProductService();
        Call<Products> getProducts = productService.loadProducts();

        getProducts.enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {
                for (Product product : response.body().getProducts()) {
                    product.setImagePath(product.getImage().getSrc());
                    product.setTotalInventory(getTotalAvailableInventoryByProduct(product));
                    ArrayList<Tag> tagsList = getTagsByProduct(product);
                    appDatabase.getProductDao().insert(product);
                    appDatabase.getTagDao().insertAll(tagsList);
                }
            }

            @Override
            public void onFailure(Call<Products> call, Throwable t) {
                Log.d("Failed Call", t.getMessage());
            }
        });


    }

    private Long getTotalAvailableInventoryByProduct(Product product) {
        Long totalAvailableInventory = 0L;
        for (Variant variant : product.getVariants()) {
            totalAvailableInventory = totalAvailableInventory + variant.getInventoryQuantity();
        }
        return totalAvailableInventory;
    }

    private ArrayList<Tag> getTagsByProduct(Product product) {
        ArrayList<String> stringTag = new ArrayList<String>(Arrays.asList(product.getTags().split(",")));
        ArrayList<Tag> tagList = new ArrayList<Tag>();
        for (String string : stringTag) {
            tagList.add(new Tag(string.trim().replaceAll("\\s+", "")));
        }
        return tagList;
    }

    public LiveData<List<Product>> getAllProductsLiveData() {
        return appDatabase.getProductDao().getAllProductsLiveData();
    }

    public LiveData<List<Tag>> getAllTagsLiveData() {
        return appDatabase.getTagDao().getAllTagsLiveData();
    }

    public LiveData<List<Product>> getAllProductsByTag(String tag) {
        return appDatabase.getProductDao().getAllProductsByTag(tag);
    }


}
