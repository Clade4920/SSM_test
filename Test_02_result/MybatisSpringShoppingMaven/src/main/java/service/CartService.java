package service;

import bean.vo.GoodsVo;
import bean.vo.Item;

import java.util.ArrayList;
import java.util.List;

public interface CartService {
    public void addToCart(String goodsId, int quantity);
    public void update(String goodsId, int quantity);
    public void delete(String goodsId);
    public List<Item> getCart();
    public void setCart(List<Item> cart);
    public void clearCart(List<Item> cart);
}
