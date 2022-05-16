package tech.filatov.bestrest.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import tech.filatov.bestrest.model.User;
import tech.filatov.bestrest.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import static tech.filatov.bestrest.util.ValidationUtil.*;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        Assert.notNull(user, "user must be not null");
        return repository.save(user);
    }

    public void update(User user) {
        Assert.notNull(user, "user must be not null");
        checkNotFoundWithId(repository.save(user), user.id());
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Transactional
    public User get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<User> getAll() {
        return repository.getAll();
    }

    public User getByEmail(String email) {
        return repository.getByEmail(email);
    }
}
