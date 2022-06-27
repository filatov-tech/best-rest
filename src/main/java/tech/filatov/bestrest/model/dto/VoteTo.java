package tech.filatov.bestrest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class VoteTo {
    private int id;
    private LocalDateTime dateTime;
    private int userId;
    private int restaurantId;
}
