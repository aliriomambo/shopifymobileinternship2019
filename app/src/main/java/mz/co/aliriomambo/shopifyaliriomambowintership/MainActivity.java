package mz.co.aliriomambo.shopifyaliriomambowintership;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import mz.co.aliriomambo.shopifyaliriomambowintership.data.Repository;
import mz.co.aliriomambo.shopifyaliriomambowintership.data.model.Product;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Repository repository = new Repository(this);
        repository.synchronize();

        repository.getAllProductsLiveData().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> products) {
                Log.d("ProductAct", products.toString());
            }
        });
    }
}
