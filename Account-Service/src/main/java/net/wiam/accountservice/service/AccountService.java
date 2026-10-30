package net.wiam.accountservice.service;

import net.wiam.accountservice.domain.Account;
import net.wiam.accountservice.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account findAccountById(UUID id) {

        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

}
