package bean.service.Impl;

import bean.dao.GoodsDAO;
import bean.service.GoodsService;
import bean.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDAO goodsDAO;

    public ArrayList getGoodsByPage(int pageNo){
        return goodsDAO.getGoodsByPage((pageNo-1)*2);
    }

    public GoodsVo getGoodsById(String goodsId){
        return goodsDAO.getGoodsById(goodsId);
    }

    public int getPageCount(){
        return goodsDAO.getPageCount();
    }

    public void add_goods(GoodsVo goodsVo){
        goodsDAO.add_goods(goodsVo);
    }

    public void delete_goods(String goodsId){
        goodsDAO.delete_goods(goodsId);
    }

    public void modify_goods(GoodsVo goodsVo){
        goodsDAO.modify_goods(goodsVo);
    }

    public GoodsVo find_goods(String goodsId){
        return goodsDAO.find_goods(goodsId);
    }
}
