package org.Aruiz.utils;

public enum TransactionStatus {
    PENDING("Pendiente"),
    COMPLETED("Completada"),
    CANCELED("Cancelada"),
    REFUNDED("Reembolsada");

    private final String status;

    TransactionStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
