package tech.filatov.bestrest;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.filatov.bestrest.model.*;
import tech.filatov.bestrest.repository.*;
import tech.filatov.bestrest.service.UserService;
import tech.filatov.bestrest.service.VoteService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class BestRestApplication implements ApplicationRunner {

    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final VoteRepository voteRepository;
    private final VoteService voteService;
    private final DishRepository dishRepository;
    private final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(BestRestApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userRepository.save(new User("filatov.dd@yandex.ru", "{noop}123456", null, Set.of(Role.USER)));
        userRepository.save(new User("fotbal@mail.ru", "{noop}adsfgh", null, Set.of(Role.ADMIN, Role.USER)));
        userRepository.save(new User("chizhan@mail.com", "{noop}qwerty", null, Set.of(Role.USER)));
        userRepository.save(new User("shanya@milo.ta", "{noop}tuttyFrutty", null, Set.of(Role.USER)));

        Restaurant surf = restaurantRepository.save(new Restaurant(null, "Surf Coffee"));
        dishRepository.save(new Dish(null, "Filtered Coffee", 350), surf.id());
        dishRepository.save(new Dish(null, "Latte Litchi Rosa", 450), surf.id());
        dishRepository.save(new Dish(null, "Sweet Pipe", 450), surf.id());

        Restaurant stim = restaurantRepository.save(new Restaurant(null, "Stim"));
        dishRepository.save(new Dish(null, "Charlott", 390), stim.id());
        dishRepository.save(new Dish(null, "Phoebe", 400), stim.id());
        dishRepository.save(new Dish(null, "Walter", 410), stim.id());

        voteService.vote(100008, 100000);
    }
}
