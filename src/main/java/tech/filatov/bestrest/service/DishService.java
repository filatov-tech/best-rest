package tech.filatov.bestrest.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tech.filatov.bestrest.model.Dish;
import tech.filatov.bestrest.model.Restaurant;
import tech.filatov.bestrest.repository.DishRepository;

import java.time.LocalDate;
import java.util.List;

import static tech.filatov.bestrest.util.ValidationUtil.checkNotFoundWithId;

@Service
public class DishService {
    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public Dish create(Dish dish, int restaurantId) {
        Assert.notNull(dish, "dish must not be null");
        return dishRepository.save(dish, restaurantId);
    }

    public void update(Dish dish) {
        Assert.notNull(dish, "dish must not be null");
        checkNotFoundWithId(dishRepository.save(dish, 0), dish.id());
    }

    public List<Dish> getTodaysDishesByRestaurant(Restaurant restaurant) {
        return dishRepository.getAllByDateAndRestaurant(LocalDate.now(), restaurant);
    }

    public Dish get(int id) {
        return checkNotFoundWithId(dishRepository.get(id), id);
    }

    public List<Dish> getAll() {
        return dishRepository.getAll();
    }

    public void delete(int id) {
        checkNotFoundWithId(dishRepository.delete(id), id);
    }

}
