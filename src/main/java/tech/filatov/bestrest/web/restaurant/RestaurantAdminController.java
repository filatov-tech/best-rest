package tech.filatov.bestrest.web.restaurant;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/admin/restaurants")
@AllArgsConstructor
public class RestaurantAdminController extends AbstractRestaurantController {
    //TODO get, getAll, update, delete, create,

}
