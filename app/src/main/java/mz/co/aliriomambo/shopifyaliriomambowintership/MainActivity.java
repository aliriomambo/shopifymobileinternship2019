package mz.co.aliriomambo.shopifyaliriomambowintership;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import mz.co.aliriomambo.shopifyaliriomambowintership.data.model.Tag;
import mz.co.aliriomambo.shopifyaliriomambowintership.tags.TagsViewModel;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
