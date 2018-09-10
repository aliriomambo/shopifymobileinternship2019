package mz.co.aliriomambo.shopifyaliriomambowintership.tags;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import mz.co.aliriomambo.shopifyaliriomambowintership.R;
import mz.co.aliriomambo.shopifyaliriomambowintership.data.model.Tag;

public class TagsAdapter extends RecyclerView.Adapter<TagsAdapter.TagsHolder> {
    private List<Tag> tagList;
    private Context context;
    private TagItemClick tagItemClick;


    public TagsAdapter(Context context, List<Tag> tagList, TagItemClick tagItemClick) {
        this.context = context;
        this.tagList = tagList;
        this.tagItemClick = tagItemClick;
    }

    @NonNull
    @Override
    public TagsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.item_recycler_view_tags, parent, false);
        return new TagsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TagsHolder holder, int position) {
        Tag tag = tagList.get(position);

        holder.txtTagTitle.setText(tag.getTitle());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //TODO Product Number
    }

    @Override
    public int getItemCount() {
        return tagList.size();
    }

    public class TagsHolder extends RecyclerView.ViewHolder {
        private TextView txtTagTitle;
        private LinearLayout linearLayout;
        private TextView txtProductCount;


        public TagsHolder(View itemView) {
            super(itemView);
            txtTagTitle = itemView.findViewById(R.id.title_item_tag);
            txtProductCount = itemView.findViewById(R.id.num_products_item_tag);
            linearLayout = itemView.findViewById(R.id.linear_layout_item_tags);
        }
    }
}
