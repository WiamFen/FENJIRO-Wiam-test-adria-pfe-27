package net.wiam.transactionservice.web;

import net.wiam.transactionservice.domain.Transaction;
import net.wiam.transactionservice.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class TransactionRestController {
    private TransactionService transactionService;

    public TransactionRestController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/transactions/{id}")
    public Transaction getTransactionById(@PathVariable UUID id) {
        return transactionService.getTransactionById(id);
    }

    @GetMapping("/accounts/{accountId}/transactions")
    public List<Transaction> getTransactionsByAccountId(
            @PathVariable UUID accountId) {
        return transactionService.getTransactionsByAccountId(accountId);
    }

    @PostMapping("/transactions")
    public Transaction save(@RequestBody Transaction transaction) {
        return transactionService.save(transaction);
    }
}
