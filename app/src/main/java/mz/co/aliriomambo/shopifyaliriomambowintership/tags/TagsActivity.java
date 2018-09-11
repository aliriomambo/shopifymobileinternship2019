package mz.co.aliriomambo.shopifyaliriomambowintership.tags;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mz.co.aliriomambo.shopifyaliriomambowintership.R;
import mz.co.aliriomambo.shopifyaliriomambowintership.data.model.Tag;
import mz.co.aliriomambo.shopifyaliriomambowintership.products.ProductActivity;

public class TagsActivity extends AppCompatActivity implements TagItemClick {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tags);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_tags_activity);

        TagsViewModel tagsViewModel = ViewModelProviders.of(this).get(TagsViewModel.class);

        final List<Tag> tagList = new ArrayList<Tag>();
        final TagsAdapter tagsAdapter = new TagsAdapter(this, tagList, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(tagsAdapter);

        tagsViewModel.getTagsLiveData().observe(this, new Observer<List<Tag>>() {
            @Override
            public void onChanged(@Nullable List<Tag> tagListLiveData) {
                tagList.clear();
                tagList.addAll(tagListLiveData);
                tagsAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onclick(String tag) {
        Intent startProductActivity = new Intent(this, ProductActivity.class);
        startProductActivity.putExtra("TAG", tag);
        startActivity(startProductActivity);
    }
}
