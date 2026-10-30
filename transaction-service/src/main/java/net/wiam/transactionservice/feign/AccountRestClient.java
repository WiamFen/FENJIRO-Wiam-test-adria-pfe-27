package net.wiam.transactionservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.wiam.transactionservice.model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "Account-Service")
public interface AccountRestClient {
    @GetMapping("/accounts/{id}")
    @CircuitBreaker(name = "accountService", fallbackMethod = "getDefaultAccount")
    Account getAccountById(@PathVariable("id") UUID id);

    default Account getDefaultAccount(UUID id, Exception e) {
        return Account.builder()
                .id(id)
                .status("UNAVAILABLE")
                .build();
    }
}
