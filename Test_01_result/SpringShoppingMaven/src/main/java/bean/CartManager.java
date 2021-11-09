package bean;

import java.util.ArrayList;
import java.util.Iterator;

import bean.dao.GoodsDAO;
import bean.dao.GoodsDAOImpl;
import bean.vo.Item;
import bean.vo.GoodsVo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CartManager {
	ArrayList<Item> cart = new ArrayList<Item>();
	
	public void addToCart(String goodsId, int quantity){
		ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		GoodsDAO goodsDAO = (GoodsDAO) appCon.getBean("goodsDAO");
		
		GoodsVo g = goodsDAO.getGoodsById(goodsId);
		
		Iterator<Item> it = cart.iterator();
		boolean find = false;
		while(it.hasNext()){
			Item oneItem = it.next();
			if(oneItem.getGoods().getGoodsId().equalsIgnoreCase(goodsId)){
				oneItem.setQuantity(oneItem.getQuantity() + quantity);
				find = true;
			}
		}
		if(!find){
				Item newItem = new Item(g,quantity);
				cart.add(newItem);
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
		
	}
	
	public void delete(String goodsId){
		if(cart != null){
			Iterator it = cart.iterator();
			while(it.hasNext()){
				Item temp = (Item)it.next();
				String tGoodsId = temp.getGoods().getGoodsId();
				
				if(tGoodsId.equals(goodsId)){
					cart.remove(temp);
					break;
				}
				
			}//while
			
		}//if
	}
	
	
	public ArrayList<Item> getCart() {
		return cart;
	}

	public void setCart(ArrayList<Item> cart) {
		this.cart = cart;
	}
}
