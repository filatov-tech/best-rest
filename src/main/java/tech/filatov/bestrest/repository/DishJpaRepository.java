package tech.filatov.bestrest.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import tech.filatov.bestrest.model.Dish;
import tech.filatov.bestrest.model.Restaurant;

import java.util.List;

public interface DishJpaRepository extends JpaRepository<Dish, Integer> {
    List<Dish> getAllByRestaurant(Restaurant restaurant, Sort sort);

    @Query("SELECT d FROM Dish d WHERE d.id = :id AND d.enabled = true")
    Dish getEnabled(int id);

    @Query("SELECT d FROM Dish d WHERE d.restaurant.id = :id AND d.enabled = true ORDER BY d.name")
    List<Dish> getAllEnabledDishByRestaurantId(int id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Dish d WHERE d.id=:id")
    int delete(int id);
}
