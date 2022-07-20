package tech.filatov.bestrest.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import tech.filatov.bestrest.model.User;
import tech.filatov.bestrest.repository.UserRepository;
import tech.filatov.bestrest.to.UserTo;
import tech.filatov.bestrest.util.UserUtil;

import java.util.List;

public abstract class AbstractUserController {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    protected User create(UserTo userTo) {
        return userRepository.save(UserUtil.createNewFromTo(userTo));
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.delete(id);
    }

    public User get(int id) {
        return userRepository.get(id);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }
}
