package tech.filatov.bestrest.web.vote;

import org.springframework.beans.factory.annotation.Autowired;
import tech.filatov.bestrest.model.Vote;
import tech.filatov.bestrest.model.dto.VoteTo;
import tech.filatov.bestrest.service.VoteService;

import java.util.List;

public abstract class AbstractVoteController {
    @Autowired
    private VoteService voteService;

    public Vote voteForRestaurant(int restaurantId, int userId) {
        return voteService.voteForRestaurant(restaurantId, userId);
    }

    protected List<VoteTo> getAll(int userId) {
        return voteService.getAll(userId);
    }
}
