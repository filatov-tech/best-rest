package tech.filatov.bestrest.util;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeLimitUtil {
    private static final LocalTime TIME_LIMIT = LocalTime.of(11, 0);

    private TimeLimitUtil() {
    }

//    public static boolean check(LocalDateTime votingDateTime) {
//        LocalDateTime current = LocalDateTime.now();
//        return current.toLocalDate().isAfter(votingDateTime.toLocalDate())
//                || current.toLocalTime().isBefore(TIME_LIMIT);
//    }

    public static boolean canChangeVote(LocalDateTime votingDateTime) {
        LocalDateTime current = LocalDateTime.now();
        return current.toLocalDate().isEqual(votingDateTime.toLocalDate())
                && current.toLocalTime().isBefore(TIME_LIMIT);
    }
}
