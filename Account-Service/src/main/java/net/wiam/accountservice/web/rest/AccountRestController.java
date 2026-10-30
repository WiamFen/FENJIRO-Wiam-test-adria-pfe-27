package net.wiam.accountservice.web.rest;

import net.wiam.accountservice.domain.Account;
import net.wiam.accountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AccountRestController {
    private AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account findAccountById(@PathVariable UUID id) {
        return accountService.findAccountById(id);
    }

    @PostMapping("/accounts")
    public Account saveAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }
}
