package mz.co.aliriomambo.shopifyaliriomambowintership.tags;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import mz.co.aliriomambo.shopifyaliriomambowintership.data.Repository;
import mz.co.aliriomambo.shopifyaliriomambowintership.data.model.Tag;

public class TagsViewModel extends AndroidViewModel {
    private Repository repository;

    public TagsViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public LiveData<List<Tag>> getTagsLiveData() {
        return repository.getAllTagsLiveData();
    }
}
