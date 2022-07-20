package tech.filatov.bestrest.to;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class VoteTo {
    private int id;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Europe/Moscow")
    private LocalDateTime dateTime;

    private int userId;

    private int restaurantId;
}
