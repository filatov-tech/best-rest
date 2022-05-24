package tech.filatov.bestrest.web.restaurant;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.filatov.bestrest.model.Restaurant;
import tech.filatov.bestrest.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@AllArgsConstructor
public class RestaurantController extends AbstractRestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant get(@PathVariable int id) {
        Restaurant restaurant = super.getWithDishes(id);
        restaurant.setVotes(null);
        return restaurant;
    }

    @GetMapping
    public List<Restaurant> getAll() {
        return super.getAll();
    }
}
