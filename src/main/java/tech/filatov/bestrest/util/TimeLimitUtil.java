package tech.filatov.bestrest.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeLimitUtil {
    private static final LocalTime TIME_LIMIT = LocalTime.of(11, 0);

    private TimeLimitUtil() {
    }

    public static boolean canChangeTodaysVote() {
        return LocalTime.now().isBefore(TIME_LIMIT);
    }

    public static boolean userNotVotingToday(LocalDateTime votingDateTime) {
        LocalDate presentDay = LocalDate.now();
        LocalDate votingDay = votingDateTime.toLocalDate();
        return votingDay.isBefore(presentDay);
    }
}
