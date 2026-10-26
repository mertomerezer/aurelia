package model;

import java.time.LocalDateTime;

public class Order {
    private int orderId;
    private int tableNumber;
    private LocalDateTime createdAt;
    private String status;


    public Order(int orderId, int tableNumber, LocalDateTime createdAt, String status) {
        this.orderId = orderId;
        this.tableNumber = tableNumber;
        this.createdAt = createdAt;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", tableNumber=" + tableNumber + ", createdAt=" + createdAt + ", status='" + status +  '}';
    }
}



