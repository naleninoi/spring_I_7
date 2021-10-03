package ru.gb.task7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.task7.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
