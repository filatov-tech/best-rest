package tech.filatov.bestrest.web.dish;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tech.filatov.bestrest.model.Dish;

import java.util.List;

@RestController
public class DishUserController extends AbstractDishController {

    @GetMapping("/restaurants/{restaurantId}/dishes")
    public List<Dish> getAllEnabledByRestaurant(@PathVariable int restaurantId) {
        return super.getAllEnabledByRestaurant(restaurantId);
    }

    @GetMapping("/dishes/{id}")
    public Dish getEnabled(@PathVariable int id) {
        return super.getEnabled(id);
    }
}