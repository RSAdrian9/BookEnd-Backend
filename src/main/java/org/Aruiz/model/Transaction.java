package org.Aruiz.model;

import jakarta.persistence.*;
import org.Aruiz.utils.TransactionStatus;

import java.time.LocalDateTime;

@Entity
@Table(name="transactions")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_transaction", discriminatorType=DiscriminatorType.STRING)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "total_price")
    private double totalPrice; // Precio total calculado

    /*
    @Column(name = "status")
    private String status; // Pendiente, completada, cancelada, etc.
     */

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TransactionStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Transaction() {

    }

    // Constructor, getters y setters

    // Método para calcular el precio total
    @Transient // No persistir en la base de datos
    public void calculateTotalPrice() {
        this.totalPrice = this.quantity * this.unitPrice;
    }

    public Transaction(int id, LocalDateTime date, int quantity, double unitPrice, double totalPrice, TransactionStatus status, User user, Book book) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.status = status;
        this.user = user;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date=" + date +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", user=" + user +
                ", book=" + book +
                '}';
    }

    @Entity
    @DiscriminatorValue("compra")
    class Purchase extends Transaction {
        @Column(name = "payment_method")
        private String paymentMethod; // Efectivo, tarjeta de crédito, etc.

        @Column(name = "shipping_address")
        private String shippingAddress; // Dirección de envío para compras

        public Purchase(int id, LocalDateTime date, int quantity, double unitPrice, double totalPrice, TransactionStatus status, User user, Book book) {
            super(id, date, quantity, unitPrice, totalPrice, status, user, book);
        }

        public Purchase() {
            super();
        }
    }

    @Entity
    @DiscriminatorValue("venta")
    class Sale extends Transaction {
        public Sale(int id, LocalDateTime date, int quantity, double unitPrice, double totalPrice, TransactionStatus status, User user, Book book) {
            super(id, date, quantity, unitPrice, totalPrice, status, user, book);
        }

        public Sale() {
            super();
        }
        // Atributos específicos de las ventas
    }


}



