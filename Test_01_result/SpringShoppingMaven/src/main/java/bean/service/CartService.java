package bean.service;

import bean.vo.Item;
import java.util.ArrayList;


public interface CartService {

     void addToCart(String goodsId, int quantity);

     void update(String goodsId, int quantity);

     void delete(String goodsId);

     void delete_All();

     ArrayList<Item> getCart();

     void setCart(ArrayList<Item> cart);

}
