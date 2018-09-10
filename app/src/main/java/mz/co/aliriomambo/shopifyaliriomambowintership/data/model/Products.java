package mz.co.aliriomambo.shopifyaliriomambowintership.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Products {

    @SerializedName("products")
    @Expose
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

}
