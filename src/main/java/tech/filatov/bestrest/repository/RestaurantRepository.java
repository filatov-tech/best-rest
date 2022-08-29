package tech.filatov.bestrest.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tech.filatov.bestrest.model.Restaurant;

import java.util.List;

import static tech.filatov.bestrest.util.ValidationUtil.checkNotFoundWithId;

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
        return checkNotFoundWithId(repository.findById(id).orElse(null), id);
    }

    public Restaurant getRef(int id) {
        return repository.getById(id);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id) != 0, id);
    }

    public Restaurant getWithDishes(int id) {
        return checkNotFoundWithId(repository.getWithDishes(id), id);
    }

    public Restaurant getWithVotes(int id) {
        return checkNotFoundWithId(repository.getWithVotes(id), id);
    }

    @Transactional
    public List<Restaurant> getAll() {
        return repository.findAll(SORT_NAME);
    }

    @Transactional
    public List<Restaurant> getAllWithEnabledDishes() {
        return repository.getAllWithEnabledDishes();
    }
}
