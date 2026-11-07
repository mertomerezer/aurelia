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
}


