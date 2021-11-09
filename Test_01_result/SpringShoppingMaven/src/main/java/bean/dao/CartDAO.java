package bean.dao;

import bean.vo.GoodsVo;
import bean.vo.Item;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;

public interface CartDAO {
     void addToCart(String goodsId, int quantity);

     void update(String goodsId, int quantity);

     void delete(String goodsId);

     void delete_All();

}
