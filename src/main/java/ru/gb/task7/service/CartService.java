package ru.gb.task7.service;

import ru.gb.task7.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {

    void save(Cart cart);

    void delete(Cart cart);

    List<Cart> findAllCarts();

    Optional<Cart> findById(Long id);

    void addProducts(Cart cart, Long[] productIds);

    void removeProducts(Cart cart, Long[] productIds);

}
