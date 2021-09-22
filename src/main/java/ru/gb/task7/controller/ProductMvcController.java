package ru.gb.task7.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.task7.model.Product;
import ru.gb.task7.service.ProductService;

import java.util.List;

@Controller
@RequestMapping(value = "mvc/products")
public class ProductMvcController {

    private final ProductService productService;

    public ProductMvcController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String getProducts(
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "10") Integer pageSize,
            Model model) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Product> productsPage = productService.getAllProductsByPages(pageable);
        List<Product> products = productsPage.getContent();
        model.addAttribute("products", products);
        model.addAttribute("totalPages", productsPage.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("prevPage", page - 1);
        model.addAttribute("nextPage", page + 1);
        return "products";
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            productService.delete(product);
        }
        return "redirect:/mvc/products";
    }



}
