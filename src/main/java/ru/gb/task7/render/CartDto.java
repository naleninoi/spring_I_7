package ru.gb.task7.render;

import ru.gb.task7.model.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartDto {

    private Long cartId;
    private List<CartPositionDto> cartPositions = new ArrayList<>();

    public CartDto(Cart cart) {
        this.cartId = cart.getId();
        this.cartPositions = cart.getCartPositions()
                .stream()
                .map(CartPositionDto::new)
                .collect(Collectors.toList());
    }

    public Long getCartId() {
        return cartId;
    }

    public List<CartPositionDto> getCartPositions() {
        return cartPositions;
    }
}
