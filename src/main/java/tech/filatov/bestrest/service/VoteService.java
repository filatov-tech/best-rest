package tech.filatov.bestrest.service;

import org.springframework.stereotype.Service;
import tech.filatov.bestrest.model.Restaurant;
import tech.filatov.bestrest.model.User;
import tech.filatov.bestrest.model.Vote;
import tech.filatov.bestrest.to.VoteResultTo;
import tech.filatov.bestrest.to.VoteTo;
import tech.filatov.bestrest.repository.RestaurantRepository;
import tech.filatov.bestrest.repository.UserRepository;
import tech.filatov.bestrest.repository.VoteRepository;
import tech.filatov.bestrest.util.exception.AlreadyVotedException;

import java.time.LocalDateTime;
import java.util.List;

import static tech.filatov.bestrest.util.ValidationUtil.*;
import static tech.filatov.bestrest.util.TimeLimitUtil.*;

@Service
public class VoteService {
    private final VoteRepository voteRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;


    public VoteService(VoteRepository repository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.voteRepository = repository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Vote voteForRestaurant(int restaurantId, int userId) {
        Restaurant restaurant = restaurantRepository.getRef(restaurantId);
        User user = userRepository.get(userId);
        Vote vote = user.getVote();

        if (vote == null || userNotVotingToday(vote.getDateTime())) {
            vote = new Vote(user, restaurant, LocalDateTime.now());
        } else if (canChangeTodaysVote()) {
            vote.setRestaurant(restaurant);
            vote.setDateTime(LocalDateTime.now());
        } else {
           throw new AlreadyVotedException("User with id=" + userId + " is already voted. Vote can only be changed until 11:00 AM");
        }
        return voteRepository.save(vote);
    }

    public List<Vote> getTodaysVotesByRestaurant(int restaurantId) {
        return voteRepository.getTodaysVotesByRestaurant(restaurantRepository.get(restaurantId));
    }

    public List<VoteResultTo> getVotingResult() {
        return voteRepository.getVotingResult();
    }

    public List<VoteTo> getAll(int userId) {
        return voteRepository.getUserVotes(userId);
    }

    public int getNumberOfVotesForRestaurant(int restaurantId) {
        List<Vote> votes = voteRepository.getTodaysVotesByRestaurant(restaurantRepository.get(restaurantId));
        return votes.size();
    }

    public Vote get(int id) {
        return checkNotFoundWithId(voteRepository.get(id), id);
    }
}
