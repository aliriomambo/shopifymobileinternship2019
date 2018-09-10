package mz.co.aliriomambo.shopifyaliriomambowintership.products;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mz.co.aliriomambo.shopifyaliriomambowintership.R;
import mz.co.aliriomambo.shopifyaliriomambowintership.data.model.Product;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        String tag = getIntent().getStringExtra("TAG");
        RecyclerView recyclerView = findViewById(R.id.recycler_view_products_activity);

        ProductViewModel productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);

        final List<Product> productList = new ArrayList<Product>();
        final ProductsAdapter productsAdapter = new ProductsAdapter(this, productList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(productsAdapter);

        productViewModel.getProductsByTagLiveData(tag).observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> products) {
                productList.clear();
                productList.addAll(products);
                productsAdapter.notifyDataSetChanged();
            }
        });

    }
}
