package bean.vo;

import java.util.List;

public class GoodsVo {
	private String goodsId;
	private String goodsName;
	private Float price;

	List<Item> soldItems;



	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getSoldQuantity(){
		int rst = 0;
		if(soldItems !=null && soldItems.size()>0){
			for(Item oneItems:soldItems){
				rst += oneItems.getQuantity();
			}
		}
		return rst;
	}
}
