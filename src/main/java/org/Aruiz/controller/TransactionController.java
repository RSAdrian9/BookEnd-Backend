package org.Aruiz.controller;

import org.Aruiz.model.Book;
import org.Aruiz.model.Transaction;
import org.Aruiz.service.BookService;
import org.Aruiz.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8100")
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
    public ResponseEntity<Transaction> getTransactionById(@PathVariable("id") int id) {
        Optional<Transaction> transaction = Optional.ofNullable(transactionService.getTransactionById(id));
        return transaction.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Transaction> createOrUpdateTransaction(@RequestBody Transaction transaction) {
        BookService bookService = new BookService();
        // Obtener el libro asociado a la transacción
        Book book = transaction.getBook();

        // Verificar si el libro ya existe en la base de datos
        if (book.getISBN() == null) {
            // Si el libro no tiene ID, significa que no está guardado en la base de datos
            // Guardar el libro en la base de datos primero
            book = bookService.createOrUpdateBook(book);
        }

        // Establecer la relación entre la transacción y el libro
        transaction.setBook(book);

        // Guardar la transacción en la base de datos
        Transaction savedTransaction = transactionService.createOrUpdateTransaction(transaction);

        return ResponseEntity.ok(savedTransaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransactionById(@PathVariable("id") int id) {
        try {
            transactionService.deleteTransactionById(id);
            return ResponseEntity.ok("Transacción eliminada con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar la transacción: " + e.getMessage());
        }
    }
}
