package tech.filatov.bestrest.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import tech.filatov.bestrest.model.Restaurant;

import java.util.List;

@Repository
public class RestaurantRepository {
    public static final Sort SORT_NAME = Sort.by(Sort.Direction.ASC, "name");

    private final RestaurantJpaRepository repository;

    public RestaurantRepository(RestaurantJpaRepository repository) {
        this.repository = repository;
    }

    public Restaurant save(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    public Restaurant get(int id) {
        return repository.findById(id).orElse(null);
    }

    public Restaurant getRef(int id) {
        return repository.getById(id);
    }

    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    public Restaurant getWithDishes(int id) {
        return repository.getWithDishes(id);
    }

    public Restaurant getWithVotes(int id) {
        return repository.getWithVotes(id);
    }

    public List<Restaurant> getAll() {
        return repository.findAll(SORT_NAME);
    }
}
