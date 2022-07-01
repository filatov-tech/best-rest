package tech.filatov.bestrest.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import tech.filatov.bestrest.model.Dish;
import tech.filatov.bestrest.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DishRepository {
    public static final Sort SORT_ENABLED_NAME =
            Sort.by("enabled").descending().and(Sort.by("name"));

    public final DishJpaRepository repository;
    public final RestaurantJpaRepository restaurantJpaRepository;

    public DishRepository(DishJpaRepository repository, RestaurantJpaRepository restaurantJpaRepository) {
        this.repository = repository;
        this.restaurantJpaRepository = restaurantJpaRepository;
    }

    public Dish get(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Dish> getAllByRestaurant(int restaurantId) {
        return repository.getAllByRestaurant(restaurantJpaRepository.getById(restaurantId), SORT_ENABLED_NAME);
    }

    public List<Dish> getAllEnabledDishByRestaurant(Restaurant restaurant) {
        return repository.getAllEnabledDishByRestaurant(restaurant);
    }

    public Dish save(Dish dish, Integer restaurantId) {
        if (dish.isNew()) {
            dish.setRestaurant(restaurantJpaRepository.getById(restaurantId));
        }
        return repository.save(dish);
    }

    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

}
