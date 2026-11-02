package structures;

import model.Order;

public class OrderList {
    private OrderListNode head;
    private OrderListNode tail;

    public boolean addOrder(Order order) {
        if (order == null || findOrderById(order.getOrderId()) != null) {
            return false;
        }

        OrderListNode newNode = new OrderListNode(order);

        if (head == null) {
            head = newNode;
            tail = newNode;
        }else {
            tail.setNext(newNode);
            tail = newNode;
        }

        return true;
    }

    public Order findOrderById(int orderId) {
        OrderListNode current = head;

        while (current != null) {
            if (current.getOrder().getOrderId() == orderId) {
                return current.getOrder();
            }
            current = current.getNext();
        }
        return null;
    }

    public void printOrders() {
        if (head == null) {
            System.out.println("Sipariş kaydı yok.");
            return;
        }

        OrderListNode current = head;

        while (current != null) {
            System.out.println(current.getOrder());
            current = current.getNext();
        }
    }

    public boolean isEmpty() {

        return head == null;
    }
}
