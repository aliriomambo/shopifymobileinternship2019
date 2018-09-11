package mz.co.aliriomambo.shopifyaliriomambowintership.tags;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mz.co.aliriomambo.shopifyaliriomambowintership.R;
import mz.co.aliriomambo.shopifyaliriomambowintership.data.model.Tag;

public class TagsAdapter extends RecyclerView.Adapter<TagsAdapter.TagsHolder> implements Filterable {
    private List<Tag> tagList;
    private List<Tag> tagListFiltered;
    private TagItemClick tagItemClick;


    public TagsAdapter(List<Tag> tagList, TagItemClick tagItemClick) {
        this.tagList = tagList;
        this.tagItemClick = tagItemClick;
        this.tagListFiltered = tagList;
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
        final Tag tag = tagListFiltered.get(position);

        holder.txtTagTitle.setText(tag.getTitle());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tagItemClick.onclick(tag.getTitle());
            }
        });

    }

    @Override
    public int getItemCount() {
        return tagListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();

                if (charString.isEmpty()) {
                    tagListFiltered = tagList;
                } else {

                    List<Tag> filteredList = new ArrayList<>();
                    for (Tag row : tagList) {
                        if (row.getTitle().toLowerCase().contains(charString.toLowerCase())) {

                            filteredList.add(row);
                        }
                    }

                    tagListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = tagListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                tagListFiltered = (ArrayList<Tag>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class TagsHolder extends RecyclerView.ViewHolder {
        private TextView txtTagTitle;
        private LinearLayout linearLayout;


        public TagsHolder(View itemView) {
            super(itemView);
            txtTagTitle = itemView.findViewById(R.id.title_item_tag);
            linearLayout = itemView.findViewById(R.id.linear_layout_item_tags);
        }
    }
}
