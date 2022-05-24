package tech.filatov.bestrest.web.user;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import tech.filatov.bestrest.AuthUser;
import tech.filatov.bestrest.model.User;
import tech.filatov.bestrest.service.UserService;

import static tech.filatov.bestrest.util.ValidationUtil.assureIdConsistent;


@RestController
@RequestMapping(value = "/api/profile", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ProfileController extends AbstractUserController {

    private final UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@AuthenticationPrincipal AuthUser authUser) {
        return authUser.getUser();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody User user, @AuthenticationPrincipal AuthUser authUser) {
        assureIdConsistent(user, authUser.id());
        userService.update(user);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@AuthenticationPrincipal AuthUser authUser) {
        userService.delete(authUser.id());
    }
}
