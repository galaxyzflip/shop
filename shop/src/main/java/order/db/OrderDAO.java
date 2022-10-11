package order.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import admin.db.GoodsBean;
import basket.db.BasketBean;
import util.JdbcUtil;


public class OrderDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs, rs1;
	
	public OrderDAO() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/OrackeDB");
			conn = ds.getConnection();
		
		}catch(SQLException ex) {
			ex.printStackTrace();
		}catch(NamingException ex) {
			ex.printStackTrace();
		}
		return ;
	}
	
	
	public int getOrderCount(String id) throws SQLException{
		
		String sql = "select count(1) from goods_order where order_member_id=?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		
		return 0;
	}
	
	public int getOrderSumMoney(String id) throws SQLException{
		String sql = "select sum(order_sum_money) from goods_order where order_member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		
		return 0;
	}
	
	
	public List getOrderLists(int page, int limit, String id) throws SQLException {
		
		String sql = "select * from (select rownum rnum, order_goods_num, order_goods_name, "
				+ " order_goods_amount, order_goods_size, "
				+ " order_goods_color, order_sum_money, order_date, order_status from "
				+ " (select * from goods_order where order_member_id = ? order by order_date desc))  "
				+ " where rnum >=? and rnum <= ? ";
		
		List goodsOrderLists = new ArrayList();
		
		int startRow = (page - 1) * 10 + 1;
		int endRow = startRow + limit - 1;
		
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderBean order = new OrderBean();
				order.setOrderGoodsNum(rs.getInt("order_goods_num"));
				order.setOrderGoodsName(rs.getString("order_goods_name"));
				order.setOrderGoodsAmount(rs.getInt("order_goods_amount"));
				order.setOrderGoodsSize(rs.getString("order_goods_size"));
				order.setOrderGoodsColor(rs.getString("order_goods_color"));
				order.setOrderStatus(rs.getInt("order_status"));
				order.setOrderDate(rs.getDate("order_dat"));
				
				goodsOrderLists.add(order);
			}
			
			return goodsOrderLists;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			
		}finally {
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		
		
		return null;
	}
	
	
	public int addOrder(OrderBean order, Vector goodsVector) {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		String sql = "select shop.order_seq.CURRVAL from dual";
		
		
		
		int orderNum = 0;
		
		
		
		List<BasketBean> basketLists = (ArrayList)goodsVector.get(0);
		List<GoodsBean> goodsLists = (ArrayList)goodsVector.get(1);
		
		for(int i=0;i<basketLists.size();i++) {
			BasketBean basket = basketLists.get(i);
			GoodsBean goods = goodsLists.get(i);
			int check = 0;
			
			try {
				
				conn.setAutoCommit(false);
				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					orderNum = rs.getInt(1);
					orderNum++;
				}else {
					throw new RuntimeException("order 시퀀스 없음");
				}
				
				
				sql = "insert into goods_order "
						+ " values(shop.order_seq.nextval ,?,?,?,?,?,?,?,?,?,?,?, "
						+ " ?,?,?,?,?,stsdate,?,sysdate,0) ";
				
				
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sdf.format(cal.getTime()).toString()+"-"+orderNum );
				pstmt.setString(2, " ");
				pstmt.setInt(3, goods.getGoodsNum());
				pstmt.setString(4, goods.getGoodsName());
				pstmt.setInt(5, basket.getBasketGoodsAmount());
				pstmt.setString(6, basket.getBasketGoodsSize());
				pstmt.setString(7, basket.getBasketGoodsColor());
				pstmt.setString(8, order.getOrderMemberId());
				pstmt.setString(9, order.getOrderReceiveName());
				pstmt.setString(10, order.getOrderReceiveAddr1());
				pstmt.setString(11, order.getOrderReceiveAddr2());
				pstmt.setString(12, order.getOrderReceivePhone());
				pstmt.setString(13, order.getOrderReceiveMobile());
				pstmt.setString(14, order.getOrderMemo());
				pstmt.setInt(15, goods.getGoodsPrice() * basket.getBasketGoodsAmount());
				pstmt.setString(16, order.getOrderTradeType());
				pstmt.setString(17, order.getOrderTradePayer());
				
				pstmt.executeUpdate();
				
				if(rs.next()) {
					if(rs.getInt(1) > 1) {
						JdbcUtil.rollback(conn);
						throw new RuntimeException("2개 이상 인설트");
					}
				}
				
				conn.commit();
				
			}catch(SQLException ex) {
				ex.printStackTrace();
			}finally {
				JdbcUtil.close(conn);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(rs);
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		return orderNum;
	}
	
}








;