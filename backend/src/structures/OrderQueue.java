package structures;

import model.Order;

public class OrderQueue {
    private OrderQueueNode front;
    private OrderQueueNode rear;

    public boolean enqueue(Order order) {
        if (order == null) {
            return false;
        }

        OrderQueueNode newNode = new OrderQueueNode(order);

        if (front == null) {
            front = newNode;
            rear = newNode;
        }else {
            rear.setNext(newNode);
            rear = newNode;
        }

        return true;
    }

    public Order dequeue() {
        if (front == null) {
            return null;
        }

        Order order = front.getOrder();
        front = front.getNext();

        if (front == null) {
            rear = null;
        }

        return order;
    }

    public Order peek() {
        if (front == null) {
            return null;
        }

        return front.getOrder();
    }

    public boolean isEmpty() {
        return front == null;
    }

    public boolean removeOrderById(int orderId) {
        OrderQueueNode previous = null;
        OrderQueueNode current = front;

        while (current != null && current.getOrder().getOrderId() != orderId) {
            previous = current;
            current = current.getNext();
        }

        if (current == null) {
            return false;
        }

        if (previous == null) {
            front = current.getNext();
        }else {
            previous.setNext(current.getNext());
        }

        if (current == rear) {
            rear = previous;
        }

        if (front == null) {
            rear = null;
        }

        return true;
    }
}


