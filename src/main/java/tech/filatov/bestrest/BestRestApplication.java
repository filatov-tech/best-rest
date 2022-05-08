package tech.filatov.bestrest;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import tech.filatov.bestrest.model.*;
import tech.filatov.bestrest.repository.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDateTime;
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
    }
}
