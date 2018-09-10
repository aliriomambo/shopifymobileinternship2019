package mz.co.aliriomambo.shopifyaliriomambowintership.products;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import mz.co.aliriomambo.shopifyaliriomambowintership.data.Repository;
import mz.co.aliriomambo.shopifyaliriomambowintership.data.model.Product;

public class ProductViewModel extends AndroidViewModel {
    private Repository repository;

    public ProductViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public LiveData<List<Product>> getProductsLiveData() {
        return repository.getAllProductsLiveData();
    }

}
