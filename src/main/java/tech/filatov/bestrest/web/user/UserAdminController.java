package tech.filatov.bestrest.web.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.filatov.bestrest.model.User;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
public class UserAdminController extends AbstractUserController {

    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        return super.get(id);
    }

    @GetMapping
    public List<User> getAll() {
        return super.getAll();
    }
}
