package net.wiam.accountservice;

import net.wiam.accountservice.domain.Account;
import net.wiam.accountservice.enums.AccountStatus;
import net.wiam.accountservice.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountService accountService) {

        return args -> {

            List<String> customers = List.of(
                    "CUST001",
                    "CUST002",
                    "CUST003"
            );

            customers.forEach(reference -> {

                accountService.saveAccount(Account.builder()
                        .customerReference(reference)
                        .status(AccountStatus.ACTIVE)
                        .currency("MAD")
                        .balance(15000)
                        .build());

            });
        };
    }
}
