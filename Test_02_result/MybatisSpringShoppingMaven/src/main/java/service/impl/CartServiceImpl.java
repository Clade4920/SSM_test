package service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bean.vo.Item;
import bean.vo.GoodsVo;
import dao.GoodsDao;
import org.springframework.stereotype.Service;
import service.CartService;
import service.GoodsService;
import service.ItemService;

import javax.annotation.Resource;

@Service("cartService")
public class CartServiceImpl implements CartService {

	@Resource(name="goodsService")
    GoodsService goodsService;
	@Resource(name="itemService")
	ItemService itemService;

	List<Item> cart = new ArrayList<Item>();
	
	public void addToCart(String goodsId, int quantity){
		GoodsVo g = goodsService.getGoodsById(goodsId);
		
		Iterator<Item> it = cart.iterator();
		boolean find = false;
		while(it.hasNext()){
			Item oneItem = it.next();
			if(oneItem.getGoods().getGoodsId().equals(goodsId)){
				oneItem.setQuantity(oneItem.getQuantity() + quantity);
				find = true;
				itemService.modifyItem(oneItem);
			}
		}
		if(!find){
				Item newItem = new Item(g,quantity);
				cart.add(newItem);
				itemService.saveItem(newItem);
		}
	}

	public void update(String goodsId, int quantity){
//		System.out.println(goodsId);
		Iterator<Item> it = cart.iterator();
		while(it.hasNext()){
			Item oneItem = it.next();
			if(oneItem.getGoods().getGoodsId().equals(goodsId)){
				oneItem.setQuantity(quantity);
				itemService.modifyItem(oneItem);
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
					itemService.deleteItem(temp.getId());
					cart.remove(temp);
					break;
				}
				
			}//while
			
		}//if
	}
	
	
	public List<Item> getCart() {
		return cart;
	}

	public void setCart(List<Item> cart) {
		this.cart = cart;
	}

	@Override
	public void clearCart(List<Item> cart) {
		if(cart != null && cart.size() > 0){
			List<Integer> ids = new ArrayList<Integer>();
			for(Item item : cart){
				ids.add(item.getId());
			}
			itemService.deleteItemByIds(ids);
		}
	}
}
