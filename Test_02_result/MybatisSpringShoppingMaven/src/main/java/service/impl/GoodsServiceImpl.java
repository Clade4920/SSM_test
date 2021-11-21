package service.impl;

import bean.vo.GoodsVo;
import dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.GoodsService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource(name="goodsDao")
    private GoodsDao goodsDAO;
    private final int LIMIT = 2;
    @Override
    public List<GoodsVo> getGoodsByPage(int pageNo) {
//        int index = (pageNo-1)*LIMIT;
//        Map map = new HashMap();
//        map.put("pageNo",index);
//        map.put("limit",LIMIT);
//        return goodsDAO.getGoodsByPage(map);
        List<GoodsVo> allGoods = goodsDAO.getGoodsWithItems();
        int begin = (pageNo-1)*LIMIT;
        int end = begin + LIMIT;

        List<GoodsVo> pageList = new ArrayList<GoodsVo>();
        for(int i = 0;i<allGoods.size();i++){
            if(i >= begin && i < end){
                pageList.add(allGoods.get(i));
            }
        }
        return pageList;
    }

    @Override
    public GoodsVo getGoodsById(String goodsId) {
        return goodsDAO.getGoodsById(goodsId);
    }

    @Override
    public int getPageCount() {
        int rst = goodsDAO.getPageCount();
        return (rst - 1) / 2 + 1;

    }

    @Override
    public Integer saveGoods(GoodsVo newGoods){
        int rst = -1;
        rst = goodsDAO.saveGoods(newGoods);
        return  rst;
    }

    @Override
    public Integer modifyGoods(GoodsVo modifiedGoods){
        int rst = -1;
        rst = goodsDAO.modifyGoods(modifiedGoods);
        return  rst;
    }

    @Override
    public Integer deleteGoods(String goodsId) {
        int rst = -1;
        rst = goodsDAO.deleteGoods(goodsId);
        return  rst;
    }
}
