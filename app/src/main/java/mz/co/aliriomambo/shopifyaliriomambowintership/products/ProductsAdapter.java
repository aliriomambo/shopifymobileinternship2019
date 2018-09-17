package mz.co.aliriomambo.shopifyaliriomambowintership.products;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import mz.co.aliriomambo.shopifyaliriomambowintership.R;
import mz.co.aliriomambo.shopifyaliriomambowintership.data.model.Product;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsHolder> {


    private List<Product> productList;
    private Context context;

    public ProductsAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.item_recycler_view_products, parent, false);
        return new ProductsAdapter.ProductsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsHolder holder, int position) {
        Product product = productList.get(position);
        holder.productTitle.setText(product.getTitle());
        holder.productQuantity.setText(String.valueOf(product.getTotalInventory()) + " Products Available");
        Glide.with(context)
                .load(product.getImagePath())
                .into(holder.productImage);

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductsHolder extends RecyclerView.ViewHolder {
        private TextView productTitle;
        private TextView productQuantity;
        private ImageView productImage;

        public ProductsHolder(View itemView) {
            super(itemView);
            productTitle = itemView.findViewById(R.id.product_title_item_products);
            productQuantity = itemView.findViewById(R.id.product_quantity_item_products);
            productImage = itemView.findViewById(R.id.product_img_item_product);
        }
    }
}
