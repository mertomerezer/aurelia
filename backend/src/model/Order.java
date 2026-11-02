package model;

import java.time.LocalDateTime;
import structures.OrderItemList;

public class Order {
    private int orderId;
    private int tableNumber;
    private LocalDateTime createdAt;
    private OrderStatus status;
    private final OrderItemList items = new OrderItemList();

    public Order(int orderId, int tableNumber, LocalDateTime createdAt, OrderStatus status) {
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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public boolean addItem(OrderItem item) {
        return items.addItem(item);
    }

    public void printItems() {
        items.printItems();
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", tableNumber=" + tableNumber + ", createdAt=" + createdAt + ", status=" + status +  '}';
    }
}



