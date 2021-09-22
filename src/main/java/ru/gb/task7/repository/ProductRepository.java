package ru.gb.task7.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.gb.task7.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>,
        PagingAndSortingRepository<Product, Long> {

    Page<Product> findAllByIsDeletedFalse (Pageable pageable);

    List<Product> findByIsDeletedFalse();

    List<Product> findByPriceGreaterThan(float price);

    List<Product> findByPriceLessThan(float price);

    List<Product> findByPriceBetween(float minPrice, float maxPrice);

}
