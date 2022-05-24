package tech.filatov.bestrest.web.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import tech.filatov.bestrest.model.Restaurant;
import tech.filatov.bestrest.service.RestaurantService;

import java.util.List;

import static tech.filatov.bestrest.util.ValidationUtil.*;

public abstract class AbstractRestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    public Restaurant get(int id) {
        return restaurantService.get(id);
    }

    public List<Restaurant> getAll() {
        return restaurantService.getAll();
    }

    public Restaurant getWithDishes(int id) {
        return restaurantService.getWithDishes(id);
    }

    public void delete(int id) {
        restaurantService.delete(id);
    }

    public void update(Restaurant restaurant, int id) {
        assureIdConsistent(restaurant, id);
        restaurantService.update(restaurant);
    }

    public Restaurant create(Restaurant restaurant) {
        checkNew(restaurant);
        return restaurantService.create(restaurant);
    }
}