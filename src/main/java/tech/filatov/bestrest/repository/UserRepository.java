package tech.filatov.bestrest.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import tech.filatov.bestrest.model.User;

import java.util.List;

import static tech.filatov.bestrest.util.ValidationUtil.checkNotFoundWithId;

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

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id) != 0, id);
    }

    public User get(int id) {
        return checkNotFoundWithId(repository.findById(id).orElse(null), id);
    }

    public User getRef(int id) {
        return repository.getById(id);
    }

    public User getByEmail(String email) {
        return repository.findByEmailIgnoreCase(email).orElse(null);
    }

    public List<User> getAll() {
        return repository.findAll(SORT_EMAIL);
    }
}
