package tech.filatov.bestrest.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tech.filatov.bestrest.model.Dish;

import java.util.List;

import static tech.filatov.bestrest.util.ValidationUtil.checkNotFoundWithId;

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
        return checkNotFoundWithId(repository.findById(id).orElse(null), id);
    }

    public Dish getEnabled(int id) {
        return checkNotFoundWithId(repository.getEnabled(id), id);
    }

    public List<Dish> getAllByRestaurant(int restaurantId) {
        return repository.getAllByRestaurant(restaurantJpaRepository.getById(restaurantId), SORT_ENABLED_NAME);
    }

    public List<Dish> getAllEnabledByRestaurant(int id) {
        return repository.getAllEnabledByRestaurantId(id);
    }

    public Dish save(Dish dish, int restaurantId) {
        dish.setRestaurant(restaurantJpaRepository.getById(restaurantId));
        return repository.save(dish);
    }

    public void update(Dish dish,int restaurantId) {
        dish.setRestaurant(restaurantJpaRepository.getById(restaurantId));
        repository.save(dish);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id) != 0, id);
    }

    @Transactional
    public void enable(int id, boolean enable) {
        Dish dish = repository.getById(id);
        dish.setEnabled(enable);
        repository.save(dish);
    }
}
