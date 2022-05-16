package tech.filatov.bestrest.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tech.filatov.bestrest.model.Restaurant;
import tech.filatov.bestrest.repository.DishRepository;
import tech.filatov.bestrest.repository.RestaurantRepository;

import java.util.List;

import static tech.filatov.bestrest.util.ValidationUtil.*;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final DishRepository dishRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, DishRepository dishRepository) {
        this.restaurantRepository = restaurantRepository;
        this.dishRepository = dishRepository;
    }

    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must be not null");
        return restaurantRepository.save(restaurant);
    }

    public void update(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must be not null");
        checkNotFoundWithId(restaurantRepository.save(restaurant), restaurant.id());
    }

    public Restaurant get(int id) {
        return checkNotFoundWithId(restaurantRepository.get(id), id);
    }

    public Restaurant getWithDishes(int id) {
        return checkNotFoundWithId(restaurantRepository.getWithDishes(id), id);
    }

    public Restaurant getWithVotes(int id) {
        return checkNotFoundWithId(restaurantRepository.getWithVotes(id), id);
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.getAll();
    }

    public void delete(int id) {
        checkNotFoundWithId(restaurantRepository.delete(id), id);
    }
}
