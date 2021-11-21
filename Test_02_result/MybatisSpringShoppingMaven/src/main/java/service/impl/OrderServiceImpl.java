package service.impl;

import bean.vo.Order;
import dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import service.ItemService;
import service.OrderService;

import javax.annotation.Resource;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource(name = "orderDao")
    OrderDao orderDao;
    @Resource(name = "itemService")
    ItemService itemService;

    @Override
    public List<Order> findAllOrders() {
        return orderDao.findAllOrders();
    }

    @Override
    public Integer saveOrder(Order newOrder) {
         orderDao.saveOrder(newOrder);
        return orderDao.saveOrderItems(newOrder);
    }

    @Override
    public Integer deleteOrderById(Integer OrderId) {
        //先获得需要被删除的所有Items的Ids
        List<Integer> deletedItemsIds  = orderDao.findNeededDeletedItemsIds(OrderId);
        //删除Order对应的Item关联数据
        orderDao.deleteOrderByItems(OrderId);
        //删除Items
        itemService.deleteItemByIds(deletedItemsIds);
        //删除Order
        return orderDao.deleteOrderById(OrderId);
    }


}
