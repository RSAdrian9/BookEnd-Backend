package org.Aruiz.controller;

import org.Aruiz.model.Transaction;
import org.Aruiz.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable int id) {
        Optional<Transaction> transaction = Optional.ofNullable(transactionService.getTransactionById(id));
        return transaction.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Transaction> createOrUpdateTransaction(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionService.createOrUpdateTransaction(transaction);
        return ResponseEntity.ok(savedTransaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransactionById(@PathVariable int id) {
        try {
            transactionService.deleteTransactionById(id);
            return ResponseEntity.ok("Transacción eliminada con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar la transacción: " + e.getMessage());
        }
    }
}
