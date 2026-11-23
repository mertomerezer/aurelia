package structures;

import model.Order;

public class OrderQueueNode {
    private Order order;
    private OrderQueueNode next;

    public OrderQueueNode(Order order) {
        this.order = order;
        this.next = null;
    }

    public Order getOrder() {
        return order;
    }

    public OrderQueueNode getNext() {
        return next;
    }

    public void setNext(OrderQueueNode next) {
        this.next = next;
    }
}
