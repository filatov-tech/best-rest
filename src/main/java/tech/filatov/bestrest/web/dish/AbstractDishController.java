package tech.filatov.bestrest.web.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import tech.filatov.bestrest.model.Dish;
import tech.filatov.bestrest.model.Restaurant;
import tech.filatov.bestrest.repository.DishRepository;

import java.time.LocalDate;
import java.util.List;

import static tech.filatov.bestrest.util.ValidationUtil.checkNew;

public abstract class AbstractDishController {

    @Autowired
    private DishRepository dishRepository;

    public Dish create(Dish dish, int restaurantId) {
        Assert.notNull(dish, "dish must not be null");
        checkNew(dish);
        return dishRepository.save(dish, restaurantId);
    }

    public void update(Dish dish) {
        Assert.notNull(dish, "dish must not be null");
        dishRepository.save(dish, 0);
    }

    public List<Dish> getTodaysDishesByRestaurant(Restaurant restaurant) {
        return dishRepository.getAllByDateAndRestaurant(LocalDate.now(), restaurant);
    }

    public Dish get(int id) {
        return dishRepository.get(id);
    }

    public List<Dish> getAllByRestaurant(Restaurant restaurant) {
        return dishRepository.getAllByRestaurant(restaurant);
    }

    public void delete(int id) {
        dishRepository.delete(id);
    }
}
