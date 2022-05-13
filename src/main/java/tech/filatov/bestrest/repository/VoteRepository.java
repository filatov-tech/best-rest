package tech.filatov.bestrest.repository;

import org.springframework.stereotype.Repository;
import tech.filatov.bestrest.model.Restaurant;
import tech.filatov.bestrest.model.Vote;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public class VoteRepository {
    private final VoteJpaRepository repository;

    public VoteRepository(VoteJpaRepository repository) {
        this.repository = repository;
    }

    public Vote save(Vote vote) {
        return repository.save(vote);
    }

    public Vote get(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Vote> getRestaurantVotes(Restaurant restaurant) {
        return repository.getAllByRestaurantAndDateTimeIsAfter(restaurant, LocalDateTime.of(LocalDate.now(), LocalTime.MIN));
    }

}
