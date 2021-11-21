package service;

import bean.vo.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAllOrders();
    Integer saveOrder(Order newOrder);
    Integer deleteOrderById (Integer OrderId);

}
