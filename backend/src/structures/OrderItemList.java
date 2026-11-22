package structures;

import model.OrderItem;

public class OrderItemList {
    private OrderItemNode head;
    private OrderItemNode tail;

    public boolean addItem(OrderItem item) {
        if (item == null) {
            return false;
        }

        OrderItemNode newNode = new OrderItemNode(item);

        if (head == null) {
            head = newNode;
            tail = newNode;
        }else {
            tail.setNext(newNode);
            tail = newNode;
        }

        return true;
    }

    public void printItems() {
        if (head == null) {
            System.out.println("Sipariş kalemi yok.");
            return;
        }

        OrderItemNode current = head;
        while (current != null) {
            System.out.println(current.getItem());
            current = current.getNext();
        }
    }
}
