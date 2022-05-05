package tech.filatov.bestrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.filatov.bestrest.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
