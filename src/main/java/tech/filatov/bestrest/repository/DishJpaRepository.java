package tech.filatov.bestrest.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import tech.filatov.bestrest.model.Dish;
import tech.filatov.bestrest.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

public interface DishJpaRepository extends JpaRepository<Dish, Integer> {
    List<Dish> getAllByRestaurant(Restaurant restaurant, Sort sort);

    List<Dish> getAllByDateAndRestaurant(LocalDate date, Restaurant restaurant, Sort sort);

    @Transactional
    @Modifying
    @Query("DELETE FROM Dish d WHERE d.id=:id")
    int delete(int id);
}
