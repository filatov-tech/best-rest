package tech.filatov.bestrest.web.dish;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.filatov.bestrest.model.Dish;

import java.net.URI;

@RestController
@RequestMapping("/api/admin")
public class DishAdminController extends AbstractDishController {

    @GetMapping("/restaurants/{restaurantId}/dishes/{dishId}")
    public Dish get(@PathVariable int restaurantId, @PathVariable int dishId) {
        return super.get(dishId);
    }

    @PostMapping(value = "/restaurants/{restaurantId}/dishes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> createWithLocation(@PathVariable int restaurantId, @RequestBody Dish dish) {
        Dish created = super.create(dish, restaurantId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/dishes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Dish dish, @PathVariable int id) {
        super.update(dish, id);
    }

    @PatchMapping("/dishes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void enable(@PathVariable int id, @RequestParam boolean enable) {
        super.enable(id, enable);
    }

    @DeleteMapping("/restaurants/{restaurantId}/dishes/{dishId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int restaurantId, @PathVariable int dishId) {
        super.delete(dishId);
    }

    @DeleteMapping(value = {"/dishes/{dishId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int dishId) {
        super.delete(dishId);
    }
}
