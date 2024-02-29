package org.Aruiz.service;

import org.Aruiz.exception.RecordNotFoundException;
import org.Aruiz.model.Transaction;
import org.Aruiz.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(int id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No se encontró la transacción con el ID: " + id));
    }

    public Transaction createOrUpdateTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void deleteTransactionById(int id) {
        if (!transactionRepository.existsById(id)) {
            throw new RecordNotFoundException("No se encontró la transacción con el ID: " + id);
        }
        transactionRepository.deleteById(id);
    }
}
