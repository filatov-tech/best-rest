package tech.filatov.bestrest.service;

import tech.filatov.bestrest.model.Restaurant;
import tech.filatov.bestrest.model.User;
import tech.filatov.bestrest.model.Vote;
import tech.filatov.bestrest.repository.RestaurantRepository;
import tech.filatov.bestrest.repository.UserRepository;
import tech.filatov.bestrest.repository.VoteRepository;
import tech.filatov.bestrest.util.TimeLimitUtil;

import java.time.LocalDateTime;
import java.util.List;

import static tech.filatov.bestrest.util.ValidationUtil.*;

public class VoteService {
    private final VoteRepository voteRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;


    public VoteService(VoteRepository repository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.voteRepository = repository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public void vote(int restaurantId, int userId) {
        Restaurant restaurant = restaurantRepository.getRef(restaurantId);
        User user = userRepository.get(userId);
        Vote vote = user.getVote();

        if (vote != null && TimeLimitUtil.canChangeVote(vote.getDateTime())) {
            vote.setRestaurant(restaurant);
        } else {
            vote = new Vote(user, restaurant, LocalDateTime.now());
        }
        voteRepository.save(vote);
    }

    public int getRestaurantVotes(int restaurantId) {
        List<Vote> votes = voteRepository.getRestaurantVotes(restaurantRepository.get(restaurantId));
        return votes.size();
    }

    public Vote get(int id) {
        return checkNotFoundWithId(voteRepository.get(id), id);
    }
}
