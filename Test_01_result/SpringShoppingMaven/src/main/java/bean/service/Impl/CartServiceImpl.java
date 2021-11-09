package bean.service.Impl;

import bean.dao.CartDAO;
import bean.dao.GoodsDAO;
import bean.service.CartService;
import bean.vo.GoodsVo;
import bean.vo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;

@Service("cartService")
public class CartServiceImpl implements CartService {

    ArrayList<Item> cart = new ArrayList<Item>();

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private GoodsDAO goodsDAO;

    @Override
    public void addToCart(String goodsId, int quantity){

        GoodsVo g = goodsDAO.getGoodsById(goodsId);

        Iterator<Item> it = cart.iterator();
        boolean find = false;
        while(it.hasNext()){
            Item oneItem = it.next();
            if(oneItem.getGoods().getGoodsId().equalsIgnoreCase(goodsId)){
                oneItem.setQuantity(oneItem.getQuantity() + quantity);
                find = true;
            }

            //
            cartDAO.update(goodsId,oneItem.getQuantity());
        }
        if(!find){
            Item newItem = new Item(g,quantity);
            cart.add(newItem);

            //
            cartDAO.addToCart(goodsId,quantity);
        }
    }

    public void update(String goodsId, int quantity){

//		System.out.println(goodsId);
        Iterator<Item> it = cart.iterator();
        while(it.hasNext()){
            Item oneItem = it.next();
            if(oneItem.getGoods().getGoodsId().equalsIgnoreCase(goodsId)){
                oneItem.setQuantity(quantity);
                break;
            }
        }

        //
        cartDAO.update(goodsId,quantity);
    }

    public void delete(String goodsId){
        if(cart != null){
            Iterator<Item> it = cart.iterator();
            while(it.hasNext()){
                Item temp = (Item)it.next();
                String tGoodsId = temp.getGoods().getGoodsId();

                if(tGoodsId.equals(goodsId)){
                    cart.remove(temp);
                    break;
                }

            }//while

        }//if

        //
        cartDAO.delete(goodsId);
    }

    public void delete_All(){
        cartDAO.delete_All();
    }


    public ArrayList<Item> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Item> cart) {
        this.cart = cart;
    }
}
