package tech.filatov.bestrest.web.dish;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.filatov.bestrest.model.Dish;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/admin/restaurants/{restaurantId}")
public class DishAdminController extends AbstractDishController {

    @GetMapping("/dishes/{dishId}")
    public Dish get(@PathVariable int dishId) {
        return super.get(dishId);
    }

    @PostMapping(value = "/dishes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> createWithLocation(@PathVariable int restaurantId, @Valid @RequestBody Dish dish) {
        Dish created = super.create(dish, restaurantId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/dishes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Dish dish, @PathVariable int id, @PathVariable int restaurantId) {
        super.update(dish, id, restaurantId);
    }

    @PatchMapping("/dishes/{dishId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void enable(@PathVariable int dishId, @RequestParam boolean enable) {
        super.enable(dishId, enable);
    }

    @DeleteMapping("/dishes/{dishId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int restaurantId, @PathVariable int dishId) {
        super.delete(dishId);
    }
}
