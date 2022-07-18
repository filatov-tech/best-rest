package tech.filatov.bestrest.web.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import tech.filatov.bestrest.model.Dish;
import tech.filatov.bestrest.repository.DishRepository;

import java.util.List;

import static tech.filatov.bestrest.util.ValidationUtil.*;

public abstract class AbstractDishController {

    @Autowired
    private DishRepository dishRepository;

    public Dish create(Dish dish, int restaurantId) {
        Assert.notNull(dish, "dish must not be null");
        checkNew(dish);
        return dishRepository.save(dish, restaurantId);
    }

    public void update(Dish dish, int id) {
        assureIdConsistent(dish, id);
        dishRepository.update(dish);
    }

    public Dish get(int id) {
        return dishRepository.get(id);
    }

    public Dish getEnabled(int id) {
        return dishRepository.getEnabled(id);
    }

    public List<Dish> getAllByRestaurant(int id) {
        return dishRepository.getAllByRestaurant(id);
    }

    public List<Dish> getAllEnabledDishesByRestaurant(int id) {
        return dishRepository.getAllEnabledDishByRestaurant(id);
    }

    public void delete(int id) {
        dishRepository.delete(id);
    }

    protected void enable(int id, boolean enable) {
        dishRepository.enable(id, enable);
    }
}
