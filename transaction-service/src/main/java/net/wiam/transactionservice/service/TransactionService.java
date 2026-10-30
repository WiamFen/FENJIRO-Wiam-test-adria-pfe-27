package net.wiam.transactionservice.service;

import net.wiam.transactionservice.domain.Transaction;
import net.wiam.transactionservice.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import java.time.Instant;
import java.util.UUID;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(UUID id) {
        return transactionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Transaction not found"));
    }

    public List<Transaction> getTransactionsByAccountId(UUID accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    public Transaction save(Transaction transaction) {
        transaction.setCreatedAt(Instant.now());
        return transactionRepository.save(transaction);
    }
}
