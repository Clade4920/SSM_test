package bean.dao;

import bean.vo.GoodsVo;
import bean.vo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;

@Repository("cartDAO")
public class CartDAOImpl implements CartDAO{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addToCart(String goodsId, int quantity){
        String sql = "INSERT INTO cart(goodsId,quantity) VALUES(?,?)";
        jdbcTemplate.update(sql,goodsId,quantity);
    }

    public void update(String goodsId, int quantity){
        String sql = "UPDATE cart SET quantity=? where goodsId = ?";
        jdbcTemplate.update(sql,quantity,goodsId);
            }

    public void delete(String goodsId){
        String sql = "DELETE FROM cart where goodsId=?";
        jdbcTemplate.update(sql,goodsId);
    }

    public void delete_All(){
        String sql = "Delete From cart";
        jdbcTemplate.update(sql);
    }
}
