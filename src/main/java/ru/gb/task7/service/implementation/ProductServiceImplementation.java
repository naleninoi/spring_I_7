package ru.gb.task7.service.implementation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.gb.task7.model.Product;
import ru.gb.task7.repository.ProductRepository;
import ru.gb.task7.service.ProductService;


import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findByIdAndIsDeletedIsFalse(id);
    }

    @Override
    public Optional<Product> findByTitle(String title) {
        return productRepository.findByTitleAndIsDeletedIsFalse(title);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findByIsDeletedFalse();
    }

    @Override
    public Page<Product> getAllProductsByPages(Pageable pageable) {
        return productRepository.findAllByIsDeletedFalse(pageable);
    }

    @Override
    public List<Product> findProductsByMaxPrice(float maxPrice) {
        return productRepository.findByPriceLessThan(maxPrice);
    }

    @Override
    public List<Product> findProductsByMinPrice(float minPrice) {
        return productRepository.findByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> findProductsByPriceInterval(float minPrice, float maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        product.setDeleted(true);
        productRepository.save(product);
    }
}
