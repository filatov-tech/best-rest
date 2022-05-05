package tech.filatov.bestrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.filatov.bestrest.model.Dish;

public interface DishRepository extends JpaRepository<Dish, Integer> {
}
