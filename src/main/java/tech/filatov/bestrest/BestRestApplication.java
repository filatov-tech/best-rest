package tech.filatov.bestrest;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.filatov.bestrest.model.*;
import tech.filatov.bestrest.repository.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class BestRestApplication implements ApplicationRunner {

    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final VoteRepository voteRepository;
    private final DishRepository dishRepository;

    public static void main(String[] args) {
        SpringApplication.run(BestRestApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User("filatov.dd@yandex.ru", "123456", null, Set.of(Role.USER));
        userRepository.save(user);
//        userRepository.save(new User("fotbal@mail.ru", "adsfgh", null, Set.of(Role.ADMIN, Role.USER)));
//        userRepository.save(new User("chizhan@mail.com", "qwerty", null, Set.of(Role.USER)));


//        Restaurant surf = new Restaurant(null, "Surf Coffee");
//        restaurantRepository.save(surf);
//        Set<Dish> surfDishes = Set.of(
//                dishRepository.save(new Dish(null, "Coffee", 350, surf)),
//                dishRepository.save(new Dish(null, "Latte", 450, surf)));
//        surf.setDishes(surfDishes);


//        User user = userRepository.getByEmail("filatov.dd@yandex.ru");
//        user.setVote(new Vote());


//        restaurantRepository.save(surf);
//        restaurantRepository.save(new Restaurant(null, "Stim"));



//        System.out.println(userRepository.findAll());
//        System.out.println(restaurantRepository.findAll());
//        System.out.println(voteRepository.findAll());
//        System.out.println(dishRepository.findAll());

    }
}
