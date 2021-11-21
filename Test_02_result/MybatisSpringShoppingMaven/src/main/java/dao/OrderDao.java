package dao;

import bean.vo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderDao")
@Mapper
public interface OrderDao {

    List<Order> findAllOrders();
    Integer saveOrder(Order newOrder);
    Integer saveOrderItems(Order newOrder);
    Integer deleteOrderById (Integer OrderId);
    Integer deleteOrderByItems (Integer OrderId);
    List<Integer> findNeededDeletedItemsIds(Integer orderId);
}
