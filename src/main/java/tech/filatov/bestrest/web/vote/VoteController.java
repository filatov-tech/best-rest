package tech.filatov.bestrest.web.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.annotations.ApiIgnore;
import tech.filatov.bestrest.AuthUser;
import tech.filatov.bestrest.model.Vote;
import tech.filatov.bestrest.service.VoteService;
import tech.filatov.bestrest.to.VoteResultTo;
import tech.filatov.bestrest.to.VoteTo;

import java.net.URI;
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
    public ResponseEntity<Vote> voteForRestaurant(@PathVariable int restaurantId, @AuthenticationPrincipal @ApiIgnore AuthUser authUser) {
        Vote vote = voteService.voteForRestaurant(restaurantId, authUser.id());

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/../../../votes/{id}")
                .buildAndExpand(vote.getId()).normalize().toUri();

        return ResponseEntity.created(uriOfNewResource).body(vote);
    }

    @GetMapping("/restaurants/{restaurantId}/votes")
    public List<Vote> getTodaysVotesByRestaurant(@PathVariable int restaurantId) {
        return voteService.getTodaysVotesByRestaurant(restaurantId);
    }

    @GetMapping("/restaurants/votes")
    public List<VoteResultTo> getVotingResult() {
        return voteService.getVotingResult();
    }
}
