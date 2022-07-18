package tech.filatov.bestrest.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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

    public Dish getEnabled(int id) {
        return repository.getEnabled(id);
    }

    public List<Dish> getAllByRestaurant(int restaurantId) {
        return repository.getAllByRestaurant(restaurantJpaRepository.getById(restaurantId), SORT_ENABLED_NAME);
    }

    public List<Dish> getAllEnabledDishByRestaurant(int id) {
        return repository.getAllEnabledDishByRestaurantId(id);
    }

    public Dish save(Dish dish, int restaurantId) {
        dish.setRestaurant(restaurantJpaRepository.getById(restaurantId));
        return repository.save(dish);
    }

    public void update(Dish dish) {
        repository.save(dish);
    }

    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Transactional
    public void enable(int id, boolean enable) {
        Dish dish = repository.getById(id);
        dish.setEnabled(enable);
        repository.save(dish);
    }
}
