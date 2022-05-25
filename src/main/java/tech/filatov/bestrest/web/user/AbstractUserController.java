package tech.filatov.bestrest.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import tech.filatov.bestrest.service.UserService;

public abstract class AbstractUserController {

    @Autowired
    private UserService userService;
}
