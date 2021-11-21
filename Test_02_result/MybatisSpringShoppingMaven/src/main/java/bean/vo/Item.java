package bean.vo;

public class Item {
	private Integer id;
	private int quantity;
	private GoodsVo goods;

	public Item() {
	}

	public Item(Integer id, int quantity, GoodsVo goods) {
		this.id = id;
		this.quantity = quantity;
		this.goods = goods;
	}

	public Item(GoodsVo g, int quantity){
		this.setGoods(g);
		this.setQuantity(quantity);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public GoodsVo getGoods() {
		return goods;
	}
	public void setGoods(GoodsVo goods) {
		this.goods = goods;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
