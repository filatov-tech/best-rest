package tech.filatov.bestrest.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import tech.filatov.bestrest.model.User;

import java.util.List;

@Repository
public class UserRepository {
    public static final Sort SORT_EMAIL = Sort.by(Sort.Direction.ASC, "email");

    private final UserJpaRepository repository;

    public UserRepository(UserJpaRepository repository) {
        this.repository = repository;
    }

    public User save(User user) {
        return repository.save(user);
    }

    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    public User get(int id) {
        return repository.findById(id).orElse(null);
    }

    public User getRef(int id) {
        return repository.getById(id);
    }

    public User getByEmail(String email) {
        return repository.getByEmail(email);
    }

    public List<User> getAll() {
        return repository.findAll(SORT_EMAIL);
    }
}
