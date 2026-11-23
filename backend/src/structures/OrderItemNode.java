package structures;

import model.OrderItem;

public class OrderItemNode {
    private OrderItem item;
    private OrderItemNode next;

    public OrderItemNode(OrderItem item) {
        this.item = item;
        this.next = null;
    }

    public OrderItem getItem() {
        return item;
    }

    public OrderItemNode getNext() {
        return next;
    }

    public void setNext(OrderItemNode next) {
        this.next = next;
    }
}
