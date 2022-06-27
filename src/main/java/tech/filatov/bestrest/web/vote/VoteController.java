package tech.filatov.bestrest.web.vote;

import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.filatov.bestrest.AuthUser;
import tech.filatov.bestrest.model.dto.VoteTo;

import java.util.List;

@RestController
@RequestMapping(value = "/api/votes", produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteController extends AbstractVoteController {

    @GetMapping
    public List<VoteTo> getAll(@AuthenticationPrincipal AuthUser authUser) {
        return super.getAll(authUser.id());
    }

    //user can see his today's vote,        /api/votes/filter?startDate=&endDate= - method uses general filter but
    //                                                                              before inits startDate with current
    //                                                                              date
    //                 vote by the date     /api/votes/filter?startDate=&endDate=
    //                 votes for all time   /api/votes
    //user can see restaurant votes         /api/restaurant/{restaurantId}/votes - method ought to be in
    //                                                                             RestaurantController

}
