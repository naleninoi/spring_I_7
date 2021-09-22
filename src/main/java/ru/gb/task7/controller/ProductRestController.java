package ru.gb.task7.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.task7.model.Product;
import ru.gb.task7.service.ProductService;

import java.util.List;

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
        Product product = productService.findById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}/delete")
    public ResponseEntity<List<Product>> deleteProduct(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            productService.delete(product);
            List<Product> products = productService.findAllProducts();
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping()
    public ResponseEntity<List<Product>> addProduct(@RequestBody Product product) {
        try {
            productService.save(product);
            List<Product> products = productService.findAllProducts();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }



}
