package info.jiangwenqi.e_commerce.dto.product;

import info.jiangwenqi.e_commerce.model.Product;

import javax.validation.constraints.NotNull;

/**
 * @author wenqi
 */
public class ProductDto {
    private Integer id;
    private @NotNull String name;
    private @NotNull String imageUrl;
    private @NotNull Double price;
    private @NotNull String description;
    private @NotNull Integer categoryId;

    public ProductDto(@NotNull String name, @NotNull String imageUrl, @NotNull Double price, @NotNull String description, @NotNull Integer categoryId) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
    }

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.imageUrl = product.getImageUrl();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.categoryId = product.getCategory().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
