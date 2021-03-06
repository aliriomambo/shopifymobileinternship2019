package mz.co.aliriomambo.shopifyaliriomambowintership.data.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import mz.co.aliriomambo.shopifyaliriomambowintership.data.model.Tag;

@Dao
public interface TagDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Tag> tags);

    @Query("SELECT * FROM tag")
    LiveData<List<Tag>> getAllTagsLiveData();
}
