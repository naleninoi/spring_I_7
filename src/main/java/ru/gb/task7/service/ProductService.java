package ru.gb.task7.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.gb.task7.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(Long id);

    Optional<Product> findByTitle(String title);

    List<Product> findAllProducts();

    Page<Product> getAllProductsByPages(Pageable pageable);

    List<Product> findProductsByMaxPrice(float maxPrice);

    List<Product> findProductsByMinPrice(float minPrice);

    List<Product> findProductsByPriceInterval(float minPrice, float maxPrice);

    void save (Product product);

    void delete(Product product);

}
