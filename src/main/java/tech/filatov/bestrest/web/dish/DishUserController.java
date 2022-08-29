package tech.filatov.bestrest.web.dish;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.filatov.bestrest.model.Dish;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class DishUserController extends AbstractDishController {

    @GetMapping("/restaurants/{id}/dishes")
    public List<Dish> getAllEnabledByRestaurant(@PathVariable int id) {
        return super.getAllEnabledByRestaurant(id);
    }

    @GetMapping("/dishes/{id}")
    public Dish getEnabled(@PathVariable int id) {
        return super.getEnabled(id);
    }
}