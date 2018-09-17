package mz.co.aliriomambo.shopifyaliriomambowintership.tags;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import mz.co.aliriomambo.shopifyaliriomambowintership.R;
import mz.co.aliriomambo.shopifyaliriomambowintership.data.model.Tag;
import mz.co.aliriomambo.shopifyaliriomambowintership.products.ProductActivity;

public class TagsActivity extends AppCompatActivity implements TagItemClick {
    private TagsAdapter tagsAdapter;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tags);
        Toolbar toolbar = findViewById(R.id.main_toolbar);

        toolbar.setTitle("Tags");

        setSupportActionBar(toolbar);


        RecyclerView recyclerView = findViewById(R.id.recycler_view_tags_activity);

        TagsViewModel tagsViewModel = ViewModelProviders.of(this).get(TagsViewModel.class);

        final List<Tag> tagList = new ArrayList<>();
        tagsAdapter = new TagsAdapter(tagList, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(tagsAdapter);

        tagsViewModel.getTagsLiveData().observe(this, new Observer<List<Tag>>() {
            @Override
            public void onChanged(@Nullable List<Tag> tagListLiveData) {
                if (tagListLiveData != null) {
                    tagList.clear();
                    tagList.addAll(tagListLiveData);
                    tagsAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public void onclick(String tagTitle) {
        Intent startProductActivity = new Intent(this, ProductActivity.class);
        startProductActivity.putExtra("TAG", tagTitle);
        startActivity(startProductActivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tag_activity_menu, menu);
        MenuItem menuItemSearch = menu.findItem(R.id.action_search);

        SearchView mSearchView = (SearchView) menuItemSearch.getActionView();

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override

            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                tagsAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
