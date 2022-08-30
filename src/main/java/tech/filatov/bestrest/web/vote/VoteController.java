package tech.filatov.bestrest.web.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import tech.filatov.bestrest.AuthUser;
import tech.filatov.bestrest.model.Vote;
import tech.filatov.bestrest.service.VoteService;
import tech.filatov.bestrest.to.VoteResultTo;
import tech.filatov.bestrest.to.VoteTo;

import java.util.List;

@RestController
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteController {

    @Autowired
    private VoteService voteService;

    @GetMapping("/votes")
    public List<VoteTo> getAllUserVotes(@AuthenticationPrincipal @ApiIgnore AuthUser authUser) {
        return voteService.getAll(authUser.id());
    }

    @PostMapping("/restaurants/{restaurantId}/votes")
    public Vote voteForRestaurant(@PathVariable int restaurantId, @AuthenticationPrincipal @ApiIgnore AuthUser authUser) {
        return voteService.voteForRestaurant(restaurantId, authUser.id());
    }

    @GetMapping("/restaurants/{restaurantId}/votes")
    public List<Vote> getVotesByRestaurant(@PathVariable int restaurantId) {
        return voteService.getRestaurantVotes(restaurantId);
    }

    @GetMapping("/restaurants/votes")
    public List<VoteResultTo> getVotingResult() {
        return voteService.getVotingResult();
    }
}
