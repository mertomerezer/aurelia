package service;

import model.OrderStatus;
import structures.OrderList;
import structures.OrderQueue;
import model.Order;
import java.time.LocalDateTime;

public class OrderService {
    private final OrderList orderList;
    private final OrderQueue kitchenQueue;

    public OrderService() {
        this.orderList = new OrderList();
        this.kitchenQueue = new OrderQueue();
    }

    public Order createOrder(int orderId, int tableNumber, LocalDateTime createdAt) {
        Order order = new Order(orderId, tableNumber, createdAt, OrderStatus.ALINDI);

        if (!orderList.addOrder(order)) {
            return null;
        }

        kitchenQueue.enqueue(order);
        return order;
    }

    public Order findOrderById(int orderId) {
        return orderList.findOrderById(orderId);
    }

    public Order takeNextOrderForKitchen() {
        Order order = kitchenQueue.dequeue();

        if (order  == null) {
            return null;
        }

        order.setStatus(OrderStatus.HAZIRLANIYOR);
        return order;
    }

    public boolean advanceOrderStatus(int orderId) {
        Order order = findOrderById(orderId);

        if (order == null) {
            return false;
        }

        if (order.getStatus() == OrderStatus.HAZIRLANIYOR) {
             order.setStatus(OrderStatus.HAZIR);
             return true;
        }

        if (order.getStatus() == OrderStatus.HAZIR) {
            order.setStatus(OrderStatus.TESLIM_EDILDI);
            return true;
        }

        return false;
    }

     public boolean cancelOrder(int orderId) {
        Order order = findOrderById(orderId);

        if (order == null) {
            return false;
        }

        if (order.getStatus() == OrderStatus.ALINDI) {
            if (!kitchenQueue.removeOrderById(orderId)) {
                return false;
            }

            order.setStatus(OrderStatus.IPTAL);
            return true;
        }

        if (order.getStatus() == OrderStatus.HAZIRLANIYOR)  {
            order.setStatus(OrderStatus.IPTAL);
            return true;
        }

        return false;
     }
}
