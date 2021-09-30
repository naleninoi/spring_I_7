package ru.gb.task7.render;

import ru.gb.task7.model.CartPosition;

public class CartPositionDto {

    private ProductDto productDto;
    private int quantity;

    public CartPositionDto(CartPosition cartPosition) {
        this.productDto = new ProductDto(cartPosition.getProduct());
        this.quantity = cartPosition.getQuantity();
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public int getQuantity() {
        return quantity;
    }
}
