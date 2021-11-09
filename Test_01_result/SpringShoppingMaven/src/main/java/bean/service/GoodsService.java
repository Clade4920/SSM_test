package bean.service;

import bean.vo.GoodsVo;

import java.util.ArrayList;

public interface GoodsService {
    ArrayList getGoodsByPage(int pageNo);

    GoodsVo getGoodsById(String goodsId);

    int getPageCount();

    void add_goods(GoodsVo goodsVo);

    void delete_goods(String goodsId);

    void modify_goods(GoodsVo goodsVo);

    GoodsVo find_goods(String goodsId);

}
