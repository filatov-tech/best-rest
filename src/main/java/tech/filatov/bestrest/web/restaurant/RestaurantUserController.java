package tech.filatov.bestrest.web.restaurant;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tech.filatov.bestrest.model.Restaurant;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@AllArgsConstructor
public class RestaurantUserController extends AbstractRestaurantController {

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant getWithEnabledDishes(@PathVariable int id) {
        return super.getWithEnabledDishes(id);
    }

    @GetMapping
    public List<Restaurant> getAll() {
        return super.getAll();
    }
}