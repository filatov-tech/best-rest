package tech.filatov.bestrest.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tech.filatov.bestrest.model.Restaurant;

import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
public class VoteResultTo {

    private int restaurantId;

    @Size(min = 1)
    private long votesNumber;
}
