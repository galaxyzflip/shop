package admin.db;

import java.sql.*;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.callback.ConfirmationCallback;
import javax.sql.DataSource;

import util.JdbcUtil;

public class GoodsDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public GoodsDAO() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/OracleDB");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("DB연결 실패 : " + e);
			return;
		}
	}
	
	public List<GoodsBean> getGoodsLists() {
		List<GoodsBean> goodslists = new ArrayList<>();
		try {
			String sql = "select * from goods order by goods_num";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GoodsBean goods = getRs(rs);
				goodslists.add(goods);
				
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			
		}
		
		
		return goodslists;
		
	}
	
	public GoodsBean getRs(ResultSet rs) {
		
		GoodsBean goods = new GoodsBean();
		try {
			goods.setGoodsNum(rs.getInt("goods_num"));
			goods.setGoodsCategory(rs.getString("goods_category"));
			goods.setGoodsName(rs.getString("goods_name"));
			goods.setGoodsContent(rs.getString("goods_content"));
			goods.setGoodsSize(rs.getString("goods_size"));
			goods.setGoodsColor(rs.getString("goods_color"));
			goods.setGoodsAmount(rs.getInt("goods_amount"));
			goods.setGoodsPrice(rs.getInt("goods_price"));
			goods.setGoodsImage(rs.getString("goods_image"));
			goods.setGoodsBest(rs.getInt("goods_best"));
			goods.setGoodsDate(rs.getString("goods_date"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return goods;
	}
	
	public GoodsBean getGoods(int num) {
		
		GoodsBean goods = null;
		try {
			String sql = "select * from goods where goods_num = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				goods = getRs(rs);
			}
			
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return goods;
	}
	
	public int insertGoods(GoodsBean goods) {
		
		int result = 0;
		int num = 0;
		
		String sql = " insert into goods(goods_num, goods_category, goods_name, goods_content, goods_size, "
				+ " goods_color, goods_AMOUNT, goods_price, goods_image, goods_best, goods_date) "
				+ " values(shop.goods_seq.nextVal, ?,?,?,?,?,?,?,?,?,sysdate) ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods.getGoodsCategory());
			pstmt.setString(2, goods.getGoodsName());
			pstmt.setString(3, goods.getGoodsContent());
			pstmt.setString(4, goods.getGoodsSize());
			pstmt.setString(5, goods.getGoodsColor());
			pstmt.setInt(6, goods.getGoodsAmount());
			pstmt.setInt(7, goods.getGoodsPrice());
			pstmt.setString(8, goods.getGoodsImage());
			pstmt.setInt(9, goods.getGoodsBest());
			
			result = pstmt.executeUpdate();
			
			return result;
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		//shop.goods_seq
		return 0;
	}
	
	public int deleteGoods(GoodsBean goods) {
		int result = 0;
		
		try {
			conn.setAutoCommit(false);
			
			String sql = "delete from goods where goods_num = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goods.getGoodsNum());
			
			result = pstmt.executeUpdate();
			
			if(result > 1) {
				JdbcUtil.rollback(conn);
				throw new RuntimeException("goods2개이상 삭제");
				
			}
			
			conn.commit();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			
		}finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}
	
	public int modifyGoods(GoodsBean goods) {
		
		int result = 0;
		
		try {
			
			conn.setAutoCommit(false);
			
			String sql = "update goods set goods_category=?, goods_name=?, goods_price=?, "
					+ "goods_color=?, goods_amount=?, goods_size=?, goods_content=?, goods_best=? "
					+ "where goods_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods.getGoodsCategory());
			pstmt.setString(2, goods.getGoodsName());
			pstmt.setInt(3, goods.getGoodsPrice());
			pstmt.setString(4, goods.getGoodsColor());
			pstmt.setInt(5, goods.getGoodsAmount());
			pstmt.setString(6, goods.getGoodsSize());
			pstmt.setString(7, goods.getGoodsContent());
			pstmt.setInt(8, goods.getGoodsBest());
			pstmt.setInt(9, goods.getGoodsNum());

			result = pstmt.executeUpdate();
			if(result > 1) {
				JdbcUtil.rollback(conn);
				throw new RuntimeException("2개 이상 업데이트");
			}
			
			conn.commit();
		}catch(SQLException ex) {
			ex.printStackTrace();
			
		}finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	
	
	public List<GoodsBean> itemList(String item, int page, String searchPrice) {
		
		List<GoodsBean> itemLists = new ArrayList<>();
		
		int pageSize = 12;
		int startNum = page * pageSize - (pageSize - 1);
		int endNum = page * pageSize;
		
		int firstPrice = 0;
		int secondPrice = 0;
		
		if(searchPrice != null ) {
			if(searchPrice.equals("1~3")) {
				firstPrice = 1;
				secondPrice = 29999;
				
			}else if(searchPrice.equals("3~5")) {
				firstPrice = 30000;
				secondPrice = 49999;
				
			}else if(searchPrice.equals("5~7")) {
				firstPrice = 50000;
				secondPrice = 69999;
				
			}else if(searchPrice.equals("7~10")) {
				firstPrice = 70000;
				secondPrice = 99999;
			}else {
				firstPrice = 0;
				secondPrice = 0;
			}
		}
		
		
		try {
			StringBuffer sql = new StringBuffer();
			
			sql.append("select * from (select goods_num, goods_category, goods_name, goods_content, ");
			sql.append(" goods_price, goods_image, goods_best, ruwnum r from goods where ");
			
			if(item.equals("newItem")) {
				sql.append(" goods_date >= goods_date - 7 ");
				
			}else if(item.equals("hitItem")) {
				sql.append(" goods_best = 1 ");
				
			}else {
				sql.append(" goods_category = ?");
			}
			
			if(searchPrice != null || !searchPrice.isBlank()) {
				sql.append(" and (goods_price between ? and ? )");
			}
			sql.append(" order by goods_num desc)");
			sql.append(" where r >= ? and r <= ?");
			pstmt = conn.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			if(item.equals("newItem") || item.equals("hitItem")) {
				pstmt.setInt(1, firstPrice);
				pstmt.setInt(2, secondPrice);
				pstmt.setInt(3, startNum);
				pstmt.setInt(4, endNum);
				
			}else {
				pstmt.setString(1, item);
				pstmt.setInt(2, firstPrice);
				pstmt.setInt(3, secondPrice);
				pstmt.setInt(4, startNum);
				pstmt.setInt(5, endNum);
				
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GoodsBean goods = getRs(rs);
				StringTokenizer st = new StringTokenizer(rs.getString("goodsImage"), ",");
				String firstimg = st.nextToken();
				goods.setGoodsImage(firstimg);
				
				itemLists.add(goods);
				
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return itemLists;
	}
	
	public GoodsBean findDetail(int goodsNum, String item, String price, String direction ) {
		
		GoodsBean goods = new GoodsBean();
		
		int startPrice = 0;
		int lastPrice = 0;
		
		if(price.equals("1~3")){
			startPrice = 1;
			lastPrice = 29999;
		}else if(price.equals("3~5")) {
			startPrice = 30000;
			lastPrice = 49999;
			
		}else if(price.equals("5~7")) {
			startPrice = 50000;
			lastPrice = 69999;
			
		}else if(price.equals("7~10")) {
			startPrice = 70000;
			lastPrice = 99999;
		}else if(price.equals("10")) {
			startPrice = 100_000;
			lastPrice = 9999999;
		}
		
		StringBuffer sql = new StringBuffer();
		
		if(direction.equals("next")) {
			sql.append("select goods_num, goods_catagory, goods_image, goods_name from goods ");
			sql.append(" where goods_num > ? and ");
			
			if(item.equals("newItem")) {
				sql.append(" goods_date >= goods_date - 7 ");
			} else if(item.equals("hitItem")) {
				sql.append(" goods_best = 1 ");
			}else {
				sql.append(" goods_category = ?");
			}
			if(!price.equals("no")) {
				sql.append(" and (goods_price between ? and ? ) ");
			}
		}else if(direction.equals("prev")) {
			sql.append(" select goods_num, goods_category, goods_image, goods_name from goods ");
			sql.append("  where goods_num < ? and ");
			
			if(item.equals("newItem")) {
				sql.append(" goods_date >= goods_date - 7 ");
			}else if(item.equals("hitItem")) {
				sql.append(" goods_best = 1" );
			}else {
				sql.append(" goods_category = ? ");
			}
			
			if(!price.equals("no")) {
				sql.append(" and (goods_price between ? and ? ) ");
			}
			sql.append(" order by goods_num desc ");
		}
		
		try {
			
			pstmt = conn.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			if(item.equals("newItem") || item.equals("hitItem")) {
				if(price.equals("no")) {
					pstmt.setInt(1, goodsNum);
					
				}else {
					pstmt.setInt(1, goodsNum);
					pstmt.setInt(2, startPrice);
					pstmt.setInt(3, lastPrice);
					
				}
			} else {
				if(price.equals("no")) {
					pstmt.setInt(1, goodsNum);
					pstmt.setString(2, item);
					
				}else {
					pstmt.setInt(1, goodsNum);
					pstmt.setString(2, item);
					pstmt.setInt(3, startPrice);
					pstmt.setInt(4, lastPrice);
				}
			}
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				goods = getRs(rs);
				StringTokenizer st = new StringTokenizer(rs.getString("goods_image"),",");
				goods.setGoodsImage(st.nextToken());
			}
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return goods;
	}
	
	
	public GoodsBean findDetailLists(int goodsNum, String item) {
		GoodsBean goods = null;
		
		try {
			StringBuffer sql = new StringBuffer();
			
			sql.append(" select * from goods where goods_num = ? and ");
			
			if(item.equals("newItem")) {
				sql.append(" goods_date >= goods_date - 7 ");
				
			}else if(item.equals("hitItem")) {
				sql.append(" goods_best = 1 ");
				
			}else {
				sql.append(" goods_category = ? ");
				
			}
			
			pstmt = conn.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			if(item.equals("newItem") || item.equals("hitItem")) {
				pstmt.setInt(1, goodsNum);
				
			}else {
				pstmt.setInt(1, goodsNum);
				pstmt.setString(2, item);
				
			}
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				goods = getRs(rs);
				
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
		return goods;
	}
	
	public int getCount(String item) {
		int count = 0;
		
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select count(1) from goods where ");
		
		if(item.equals("newItem")) {
			sql.append(" goods_date >= goods_date - 7 ");
			
		}else if(item.equals("hitItem")) {
			sql.append(" goods_best = ? ");
			
		}else {
			sql.append(" goods_category = ? ");
		}
		
		try {
			pstmt = conn.prepareStatement(sql.toString());
			
			if(item.equals("newItem")) {
				
			}else if(item.equals("hitItem")) {
				pstmt.setInt(1, 1);
				
			}else {
				pstmt.setString(1, item);
			}
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return count;
	}
	
	public int getCount(String item, String searchPrice) {
		int count = 0;
		int startPrice = 0;
		int endPrice = 0;
		
		if(searchPrice.equals("1~3")){
			startPrice = 1;
			endPrice = 29999;
		}else if(searchPrice.equals("3~5")) {
			startPrice = 30000;
			endPrice = 49999;
			
		}else if(searchPrice.equals("5~7")) {
			startPrice = 50000;
			endPrice = 69999;
			
		}else if(searchPrice.equals("7~10")) {
			startPrice = 70000;
			endPrice = 99999;
		}else {
			startPrice = 100_000;
			endPrice = 9999999;
		}
		
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select count(1) from goods where ");
		
		
		if(item.equals("newItem")) {
			sql.append(" goods_date >= goods_date - 7 ");
		} else if(item.equals("hitItem")) {
			sql.append(" goods_best = ? ");
		}else {
			sql.append(" goods_category = ?");
		}
		
		sql.append( " goods_category =? ");
		
		try {
			pstmt = conn.prepareStatement(sql.toString());
			
			if(item.equals("newItem")) {
				pstmt.setInt(1, startPrice);
				pstmt.setInt(2, endPrice);
				
			}else if(item.equals("hitItem")) {
				pstmt.setInt(1, 1);
				pstmt.setInt(2, startPrice);
				pstmt.setInt(3, endPrice);
				
			}else {
				pstmt.setString(1, item);
				pstmt.setInt(2, startPrice);
				pstmt.setInt(3, endPrice);
			}
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return count;
	}
	
}









