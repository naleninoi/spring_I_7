package ru.gb.task7.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.task7.model.CartPosition;

@Repository
public interface CartPositionRepository extends CrudRepository<CartPosition, Long> {
}
