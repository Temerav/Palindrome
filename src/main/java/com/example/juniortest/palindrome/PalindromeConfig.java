package com.example.juniortest.palindrome;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.util.List;

@Configuration
public class PalindromeConfig {

    @Bean
    CommandLineRunner commandLineRunner(PalindromeRepository repository) {
        return args -> {
            Palindrome example1 = new Palindrome(
              "abrakadabra",
              new Timestamp(System.currentTimeMillis())
            );

            Palindrome example2 = new Palindrome(
                    "alma",
                    new Timestamp(System.currentTimeMillis())
            );

            Palindrome example3 = new Palindrome(
                    "litvania",
                    new Timestamp(System.currentTimeMillis())
            );

            Palindrome example4 = new Palindrome(
                    "doorway",
                    new Timestamp(System.currentTimeMillis())
            );

            repository.saveAll(
                    List.of(example1, example2, example3, example4)
            );
        };
    }
}
