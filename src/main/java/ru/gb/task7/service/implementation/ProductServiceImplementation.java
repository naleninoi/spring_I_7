package ru.gb.task7.service.implementation;

import org.springframework.stereotype.Service;
import ru.gb.task7.model.Product;
import ru.gb.task7.repository.ProductRepository;
import ru.gb.task7.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findByIsDeletedFalse();
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
