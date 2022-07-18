package tech.filatov.bestrest.web.restaurant;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tech.filatov.bestrest.model.Restaurant;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@AllArgsConstructor
public class RestaurantController extends AbstractRestaurantController {

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant get(@PathVariable int id) {
        return super.getWithDishes(id);
    }

    @GetMapping
    public List<Restaurant> getAll() {
        return super.getAll();
    }


}