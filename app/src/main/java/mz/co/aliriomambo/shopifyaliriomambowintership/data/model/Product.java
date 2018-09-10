package mz.co.aliriomambo.shopifyaliriomambowintership.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity
public class Product {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("product_type")
    @Expose
    private String productType;

    @SerializedName("tags")
    @Expose
    private String tags;

    @Ignore
    @SerializedName("variants")
    @Expose
    private List<Variant> variants;

    @Ignore
    @SerializedName("image")
    @Expose
    private Image image;

    private String imagePath;

    private Long totalInventory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Long getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(Long totalInventory) {
        this.totalInventory = totalInventory;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", productType='" + productType + '\'' +
                ", tags='" + tags + '\'' +
                ", variants=" + variants +
                ", image=" + image +
                ", imagePath='" + imagePath + '\'' +
                ", totalInventory=" + totalInventory +
                '}';
    }
}
