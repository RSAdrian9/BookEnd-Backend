package org.Aruiz.model;

import jakarta.persistence.*;

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

    @Column(name = "status")
    private String status; // Pendiente, completada, cancelada, etc.

    @Column(name = "payment_method")
    private String paymentMethod; // Efectivo, tarjeta de crédito, etc.

    @Column(name = "shipping_address")
    private String shippingAddress; // Dirección de envío para compras

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    // Constructor, getters y setters

    // Método para calcular el precio total
    @Transient // No persistir en la base de datos
    public void calculateTotalPrice() {
        this.totalPrice = this.quantity * this.unitPrice;
    }

    @Entity
    @DiscriminatorValue("compra")
    class Purchase extends Transaction {
        // Atributos específicos de las compras
    }

    @Entity
    @DiscriminatorValue("venta")
    class Sale extends Transaction {
        // Atributos específicos de las ventas
    }
}



