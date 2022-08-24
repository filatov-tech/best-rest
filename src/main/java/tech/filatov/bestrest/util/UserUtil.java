package tech.filatov.bestrest.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import tech.filatov.bestrest.model.Role;
import tech.filatov.bestrest.model.User;
import tech.filatov.bestrest.to.UserTo;

public class UserUtil {

    public static User createNewFromTo(UserTo userTo) {
        return new User(null, userTo.getEmail().toLowerCase(), userTo.getPassword(), Role.USER);
    }

    public static User prepareToSave(User user, PasswordEncoder passwordEncoder) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }
}
