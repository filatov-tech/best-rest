package tech.filatov.bestrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import tech.filatov.bestrest.model.Restaurant;
import tech.filatov.bestrest.model.Vote;

import java.time.LocalDateTime;
import java.util.List;

public interface VoteJpaRepository extends JpaRepository<Vote, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Vote v WHERE v.id=:id")
    int delete(int id);

    List<Vote> getAllByRestaurantAndDateTimeIsAfter(Restaurant restaurant, LocalDateTime date);
}
