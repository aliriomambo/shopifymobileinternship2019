package mz.co.aliriomambo.shopifyaliriomambowintership.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import mz.co.aliriomambo.shopifyaliriomambowintership.data.local.dao.ProductDao;
import mz.co.aliriomambo.shopifyaliriomambowintership.data.local.dao.TagDao;
import mz.co.aliriomambo.shopifyaliriomambowintership.data.model.Product;
import mz.co.aliriomambo.shopifyaliriomambowintership.data.model.Tag;


/*
Created by Alírio Mambo
*/


@Database(entities = {Tag.class, Product.class}, version = 1, exportSchema = false)

public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabaseSingleton;

    public static AppDatabase getInstance(Context context) {
        if (appDatabaseSingleton == null) {
            appDatabaseSingleton = Room.databaseBuilder(context.
                            getApplicationContext(), AppDatabase.class,
                    "shopifydb")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return appDatabaseSingleton;
    }

    public abstract ProductDao getProductDao();

    public abstract TagDao getTagDao();


}

