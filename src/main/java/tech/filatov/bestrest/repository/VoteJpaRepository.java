package tech.filatov.bestrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import tech.filatov.bestrest.model.Restaurant;
import tech.filatov.bestrest.model.Vote;
import tech.filatov.bestrest.to.VoteResultTo;
import tech.filatov.bestrest.to.VoteTo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface VoteJpaRepository extends JpaRepository<Vote, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Vote v WHERE v.id=:id")
    int delete(int id);

    @Query("" +
            "SELECT new tech.filatov.bestrest.to.VoteTo(v.id, v.dateTime, v.user.id, v.restaurant.id) " +
            "FROM Vote v " +
            "WHERE v.user.id = :userId")
    List<VoteTo> getUserVote(@Param("userId") int userId);

    @Query("" +
            "SELECT new tech.filatov.bestrest.to.VoteResultTo(r.id, COUNT(r.id)) " +
            "FROM Restaurant r LEFT OUTER JOIN Vote v ON r.id = v.restaurant.id " +
            "WHERE v.dateTime > :currentDate " +
            "GROUP BY r.id " +
            "ORDER BY COUNT(r.id) DESC")
    List<VoteResultTo> getVotingResult(LocalDateTime currentDate);

    List<Vote> getVotesByRestaurantAndDateTimeIsAfter(Restaurant restaurant, LocalDateTime date);
}
