package tech.filatov.bestrest.web.vote;

import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import tech.filatov.bestrest.AuthUser;
import tech.filatov.bestrest.model.Vote;
import tech.filatov.bestrest.to.VoteTo;

import java.util.List;

@RestController
@RequestMapping(value =  "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteController extends AbstractVoteController {

    @GetMapping("/votes")
    public List<VoteTo> getAll(@AuthenticationPrincipal AuthUser authUser) {
        return super.getAll(authUser.id());
    }

    @PostMapping("/restaurants/{restaurantId}/votes")
    public Vote voteForRestaurant(@PathVariable int restaurantId, @AuthenticationPrincipal AuthUser authUser) {
        return super.voteForRestaurant(restaurantId, authUser.id());
    }
}
