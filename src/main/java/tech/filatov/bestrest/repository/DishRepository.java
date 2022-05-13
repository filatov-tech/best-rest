package tech.filatov.bestrest.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import tech.filatov.bestrest.model.Dish;
import tech.filatov.bestrest.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DishRepository {
    public static final Sort SORT_DATE_NAME = Sort.by(Sort.Direction.DESC, "date", "name");
    public static final Sort SORT_NAME = Sort.by(Sort.Direction.DESC,  "name");

    public final DishJpaRepository repository;
    public final RestaurantJpaRepository restaurantJpaRepository;

    public DishRepository(DishJpaRepository repository, RestaurantJpaRepository restaurantJpaRepository) {
        this.repository = repository;
        this.restaurantJpaRepository = restaurantJpaRepository;
    }

    public Dish get(int id) {
        return repository.findById(id).orElse(null);
    }

    public Dish save(Dish dish, int restaurantId) {
        if (dish.isNew()) {
            dish.setRestaurant(restaurantJpaRepository.getById(restaurantId));
        }
        return repository.save(dish);
    }

    public List<Dish> getAll() {
        return repository.findAll(SORT_DATE_NAME);
    }

    public List<Dish> getAllByDateAndRestaurant(LocalDate date, Restaurant restaurant) {
        return repository.getAllByDateAndRestaurant(date, restaurant, SORT_NAME);
    }

    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

}
