package tech.filatov.bestrest.util;

import tech.filatov.bestrest.model.Role;
import tech.filatov.bestrest.model.User;
import tech.filatov.bestrest.to.UserTo;

public class UserUtil {

    public static User createNewFromTo(UserTo userTo) {
        return new User(null, userTo.getEmail().toLowerCase(), userTo.getPassword(), Role.USER);
    }
}
