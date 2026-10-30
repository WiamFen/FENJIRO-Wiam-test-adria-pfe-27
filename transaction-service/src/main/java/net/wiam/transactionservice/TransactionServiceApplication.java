package net.wiam.transactionservice;

import net.wiam.transactionservice.domain.Transaction;
import net.wiam.transactionservice.service.TransactionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class TransactionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(TransactionService transactionService) {

        return args -> {

            List<UUID> accountIds = List.of(
                    UUID.fromString("550e8400-e29b-41d4-a716-446655440001"),
                    UUID.fromString("550e8400-e29b-41d4-a716-446655440002"),
                    UUID.fromString("550e8400-e29b-41d4-a716-446655440003")
            );

            List<String> categories = List.of(
                    "SUPERMARKET",
                    "RESTAURANT",
                    "SHOPPING",
                    "TRANSPORT",
                    "ONLINE_PAYMENT"
            );

            List<String> countries = List.of(
                    "Morocco",
                    "France",
                    "Spain"
            );

            for (UUID accountId : accountIds) {

                for (int j = 0; j < 5; j++) {

                    transactionService.save(Transaction.builder()
                            .accountId(accountId)
                            .amount(BigDecimal.valueOf(
                                    100 + Math.random() * 5000))
                            .currency("MAD")
                            .merchantCategory(categories.get(
                                    (int) (Math.random() * categories.size())))
                            .country(countries.get(
                                    (int) (Math.random() * countries.size())))
                            .build());
                }
            }
        };
    }
}
