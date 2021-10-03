package ru.gb.task7.render;

import ru.gb.task7.model.Product;

public class ProductDto {

    private Long productId;
    private String title;
    private float price;

    public ProductDto (Product product) {
        this.productId = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
    }

    public Long getProductId() {
        return productId;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }
}
