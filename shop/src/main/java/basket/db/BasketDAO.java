package basket.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import admin.db.GoodsBean;
import util.JdbcUtil;

public class BasketDAO {

	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	
	public BasketDAO() {
		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/OracleDB");
			conn = ds.getConnection();
		
		}catch(SQLException ex) {
			ex.printStackTrace();
		}catch(NamingException ex) {
			ex.printStackTrace();
		}
		return ;
	}
	
	public Vector getBasketLists(String id) {
		
		Vector vector = new Vector();
		List basketLists = new ArrayList();
		List goodsLists = new ArrayList();
		
		String sql = "select * from basket where basket_member_id=? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BasketBean basket = new BasketBean();
				GoodsBean goods = new GoodsBean();
				
				basket.setBasketNum(rs.getInt("basket_num"));
				basket.setBasketMemberId(rs.getString("basket_member_id"));
				basket.setBasketGoodsNum(rs.getInt("basket_goods_num"));
				basket.setBasketGoodsAmount(rs.getInt("basket_goods_amount"));
				basket.setBasketGoodsSize(rs.getString("basket_goods_size"));
				basket.setBasketGoodsColor(rs.getString("basket_goods_color"));
				basket.setBasketDate(rs.getDate("basket_date"));
				
				sql = "select * from goods where goods_num = ?";
				pstmt = conn.prepareCall(sql);
				pstmt.setInt(1, basket.getBasketGoodsNum());
				rs1 = pstmt.executeQuery();
				
				if(rs1.next()) {
					goods.setGoodsName(rs1.getString("goods_name"));
					goods.setGoodsPrice(rs1.getInt("goods_price"));
					goods.setGoodsImage(rs1.getString("goods_image"));
					
				}else {
					return null;
					
				}
				basketLists.add(basket);
				goodsLists.add(goods);
				
			}
			vector.add(basketLists);
			vector.add(goodsLists);
			
			return vector;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
		return null;
	}
	
	
	public void basketAdd(String id, int goodsNum, int amount, String size, String color) {
		
		String sql = "insert into basket(basket_num, basket_member_id, basket_goods_num, "
				+ " basket_goods_amount, "
				+ " basket_goods_size, basket_goods_color, basket_date) "
				+ " values(shop.basket_seq.NEXTVAL, ?,?,?,?,?,sysdate) ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, goodsNum);
			pstmt.setInt(3, amount);
			pstmt.setString(4, size);
			pstmt.setString(5, color);
			
			pstmt.executeQuery();
			
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public boolean basketRemove(int num) {
		
		String sql = "delete from basket where basket_num = ?";
		int check = 0;
		
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			check = pstmt.executeUpdate();
			
			if(check > 1) {
				JdbcUtil.rollback(conn);
				throw new RuntimeException("2개 이상 삭제");
			}
			conn.commit();
			
			return true;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			
		}finally {
			
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	
	
}











