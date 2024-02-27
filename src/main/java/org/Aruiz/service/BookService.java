package org.Aruiz.service;

import org.Aruiz.exception.RecordNotFoundException;
import org.Aruiz.model.Book;
import org.Aruiz.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * Obtiene todos los libros
     *
     * @return La lista de libros
     */
    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    /**
     * Obtiene una lista de libros por su ISBN
     *
     * @param isbn El ISBN del libro
     * @return La lista de libros con el ISBN dado
     */
    public List<Book> getBooksByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    /**
     * Obtiene una lista de libros por su título
     *
     * @param title El título del libro
     * @return La lista de libros con el título dado
     */
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    /**
     * Crea o actualiza un libro
     *
     * @param book El libro a crear o actualizar
     * @return El libro creado o actualizado
     */
    public Book createOrUpdateBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * Elimina un libro por su ISBN
     *
     * @param isbn El ISBN del libro a eliminar
     */
    public void deleteBook(String isbn) {
        List<Book> books = bookRepository.findByIsbn(isbn);
        if (!books.isEmpty()) {
            bookRepository.deleteAll(books);
        } else {
            throw new RecordNotFoundException("No se encontró un libro con el ISBN: " + isbn);
        }
    }

}
