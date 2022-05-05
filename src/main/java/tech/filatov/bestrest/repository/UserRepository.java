package tech.filatov.bestrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.filatov.bestrest.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getByEmail(String email);
}
