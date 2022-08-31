package tech.filatov.bestrest;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class BestRestApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(BestRestApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
    }
}
