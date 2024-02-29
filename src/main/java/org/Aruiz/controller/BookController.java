package org.Aruiz.controller;

import org.Aruiz.model.Book;
import org.Aruiz.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * Obtiene todos los libros.
     *
     * @return ResponseEntity con una lista de libros en formato JSON.
     */
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    /**
     * Obtiene libros por su ISBN.
     *
     * @param isbn El ISBN del libro a buscar.
     * @return El libro con el isbn dado
     */
    @GetMapping("/{isbn}")
    public ResponseEntity<List<Book>> getBooksByIsbn(@PathVariable String isbn) {
        List<Book> books = bookService.getBooksByIsbn(isbn);
        return ResponseEntity.ok(books);
    }

    /**
     * Obtiene libros por su título.
     *
     * @param title El título del libro a buscar.
     * @return El libro con el título dado
     */
    @GetMapping("/title/{title}")
    public ResponseEntity<List<Book>> getBooksByTitle(@PathVariable String title) {
        List<Book> books = bookService.getBooksByTitle(title);
        return ResponseEntity.ok(books);
    }

    /**
     * Crea o actualiza un libro.
     *
     * @param book El libro a crear o actualizar
     * @return ResponseEntity con el libro creado o actualizado
     */
    @PostMapping
    public ResponseEntity<Book> createOrUpdateBook(@RequestBody Book book) {
        Book savedBook = bookService.createOrUpdateBook(book);
        return ResponseEntity.ok(savedBook);
    }

    /**
     * Elimina un libro por su isbn
     *
     * @param isbn El isbn del usuario a eliminar
     */
    @DeleteMapping("/{isbn}")
    public void deleteBookByISBN(@PathVariable String isbn) {
        bookService.deleteBookByISBN(isbn);
    }
}
