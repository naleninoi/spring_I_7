package ru.gb.task7.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.task7.model.Product;
import ru.gb.task7.service.ProductService;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "products")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(required = false, defaultValue = "0") Float min,
            @RequestParam(required = false) Float max ) {
        List<Product> products;
        if (min != null & max != null) {
            products = productService.findProductsByPriceInterval(min, max);
        } else if (min != null) {
            products = productService.findProductsByMinPrice(min);
        } else if (max != null) {
            products = productService.findProductsByMaxPrice(max);
        } else {
            products = productService.findAllProducts();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            productService.delete(product.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping()
    public ResponseEntity<Product> createOrUpdateProduct(@RequestBody Product productDto) {
        Optional <Product> product = productService.findByTitle(productDto.getTitle());
        if (product.isPresent()) {
            product.get().setPrice(productDto.getPrice());
            productService.save(product.get());
            return ResponseEntity.ok(product.get());
        } else {
            productService.save(productDto);
            return ResponseEntity.created( URI.create( "products/" + productDto.getId() ) ).body(productDto);
        }
    }

}
