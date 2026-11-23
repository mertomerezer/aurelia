package structures;

import model.Order;

public class OrderListNode {
    private Order order;
    private OrderListNode next;

    public OrderListNode(Order order) {
        this.order = order;
        this.next = null;
    }
    public Order getOrder() {
        return order;
    }

    public OrderListNode getNext() {
        return next;
    }

    public void setNext(OrderListNode next) {
        this.next = next;
    }
}
