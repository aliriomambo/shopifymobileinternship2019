package mz.co.aliriomambo.shopifyaliriomambowintership.data.local.dao;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import mz.co.aliriomambo.shopifyaliriomambowintership.data.model.Product;

@Dao
public interface ProductDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Product... products);


    @Query("SELECT * FROM product")
    LiveData<List<Product>> getAllProductsLiveData();

    @Query("SELECT * FROM product WHERE tags LIKE '%' || :tag || '%'")
    LiveData<List<Product>> getAllProductsByTag(String tag);


}
