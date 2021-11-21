package dao;

import bean.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("goodsDao")
@Mapper
public interface GoodsDao {
//    @Param("pageNo") int pageNo, @Param("limit") int limit
    List<GoodsVo> getGoodsWithItems();
    GoodsVo getGoodsById(String goodsId);
    int getPageCount();
    Integer saveGoods(GoodsVo newGoods);
    Integer modifyGoods(GoodsVo modifiedGoods);
    Integer deleteGoods(String goodsId);
}
