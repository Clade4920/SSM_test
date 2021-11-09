package bean.dao;

import java.util.ArrayList;

import bean.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//使用Spring JdbcTemplate对象改写接口GoodsDAO.java及其实现类GoodsDAOImpl.java对数据库进行访问
@Repository("goodsDAO")
public class GoodsDAOImpl implements GoodsDAO{
	@Autowired
	//使用配置文件中的JDBC模版
	private JdbcTemplate jdbcTemplate;

	public ArrayList<GoodsVo> getGoodsByPage(int pageNo){
		String sql = "SELECT * FROM goods LIMIT ?,2";

		RowMapper<GoodsVo> rowMapper = new BeanPropertyRowMapper<GoodsVo>(GoodsVo.class);
		return (ArrayList<GoodsVo>)jdbcTemplate.query(sql,rowMapper,pageNo);
//
//		int numPerPage = 2;
//		ArrayList rst = new ArrayList();
//		String sql = "select * from goods";
//		DBBean db = new DBBean();
//		Connection con = db.getConnection();
//		ResultSet rs = null;
//
//		try {
//			 rs = db.executeQuery(sql, null);
//
//			 if(rs != null){
//				int index = 1;
//				int beginIndex = (pageNo - 1)*numPerPage+1;
//				int endIndex = pageNo * 2;
//
//				while(rs.next()){
//					if(index < beginIndex){
//						index ++;
//						continue;
//					}
//
//					if(index > endIndex){
//						index ++;
//						break;
//					}
//
//					String goodsId = rs.getString(1);
//					String goodsName = rs.getString(2);
//					Float price = rs.getFloat(3);
//
//					GoodsVo g = new GoodsVo();
//					g.setGoodsId(goodsId);
//					g.setGoodsName(goodsName);
//					g.setPrice(price);
//
//					rst.add(g);
//					index ++;
//				}
//			}
//
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rst;
	}

	public GoodsVo getGoodsById(String goodsId){
		String sql = "select * from goods where goodsId=?";

		RowMapper<GoodsVo> rowMapper = new BeanPropertyRowMapper<GoodsVo>(GoodsVo.class);
		return jdbcTemplate.queryForObject(sql,rowMapper,goodsId);

//		GoodsVo g = null;
//
//		ArrayList rst = new ArrayList();
//
//		String sql = "select * from goods where goodsid=?";
//		ArrayList params = new ArrayList();
//		params.add(goodsId);
//
//		DBBean db = new DBBean();
//		Connection con = db.getConnection();
//		ResultSet rs = null;
//
//		try {
//			 rs = db.executeQuery(sql, params);
//
//			 if(rs != null){
//
//				rs.next();
//
//				String goodsId_ = rs.getString(1);
//				String goodsName = rs.getString(2);
//				Float price = rs.getFloat(3);
//
//				g = new GoodsVo();
//				g.setGoodsId(goodsId_);
//				g.setGoodsName(goodsName);
//				g.setPrice(price);
//
//		     }
//
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return g;
	}

	public int getPageCount(){
		String sql = "select count(*) from goods";

		Integer rst = jdbcTemplate.queryForObject(sql,Integer.class);
		assert rst != null;
		return (rst.byteValue()-1)/2+1;

//		int rst = 0;
//		DBBean db = new DBBean();
//		Connection con = db.getConnection();
//		String sql = "select count(*) from goods";
//		try {
//			ResultSet rs = db.executeQuery(sql,null);
//
//			String count = null;
//			if(rs.next())
//				 count = rs.getString(1);
//
//			rst = Integer.parseInt(count);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return (rst-1)/2+1;
	}

	public void add_goods(GoodsVo goodsVo){
		String sql = "INSERT INTO goods(goodsId,goodsName,price) VALUES(?,?,?)";
		jdbcTemplate.update(sql,goodsVo.getGoodsId(),goodsVo.getGoodsName(),goodsVo.getPrice());
	}

	public void delete_goods(String goodsId){
		String sql = "DELETE FROM goods where goodsId=?";
		jdbcTemplate.update(sql,goodsId);
	}

	public void modify_goods(GoodsVo goodsVo){
		String sql = "UPDATE goods SET goodsName=?,price=? where goodsId = ?";
		jdbcTemplate.update(sql,goodsVo.getGoodsName(),goodsVo.getPrice(),goodsVo.getGoodsId());
	}

	public GoodsVo find_goods(String goodsId){
		String sql = "select * from goods where goodsId=?";

		RowMapper<GoodsVo> rowMapper = new BeanPropertyRowMapper<GoodsVo>(GoodsVo.class);
		return jdbcTemplate.queryForObject(sql,rowMapper,goodsId);
	}

}
