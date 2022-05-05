package tech.filatov.bestrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.filatov.bestrest.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer> {
}
