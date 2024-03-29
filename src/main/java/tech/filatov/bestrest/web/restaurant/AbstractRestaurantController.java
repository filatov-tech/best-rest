package tech.filatov.bestrest.web.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import tech.filatov.bestrest.model.Restaurant;
import tech.filatov.bestrest.repository.RestaurantRepository;

import java.util.List;

import static tech.filatov.bestrest.util.ValidationUtil.*;

public abstract class AbstractRestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant get(int id) {
        return restaurantRepository.get(id);
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.getAllWithEnabledDishes();
    }

    public Restaurant getWithDishes(int id) {
        return restaurantRepository.getWithDishes(id);
    }

    public Restaurant getWithEnabledDishes(int id) {
        return restaurantRepository.getWithEnabledDishes(id);
    }

    public Restaurant getWithVotes(int id) {
        return restaurantRepository.getWithVotes(id);
    }

    public void delete(int id) {
        restaurantRepository.delete(id);
    }

    public void update(Restaurant restaurant, int id) {
        assureIdConsistent(restaurant, id);
        restaurantRepository.save(restaurant);
    }

    public Restaurant create(Restaurant restaurant) {
        checkNew(restaurant);
        return restaurantRepository.save(restaurant);
    }
}