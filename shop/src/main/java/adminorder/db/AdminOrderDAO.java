package adminorder.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import order.db.OrderBean;
import util.JdbcUtil;

public class AdminOrderDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public AdminOrderDAO() {
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
	
	public int getOrderCount() {
		
		String order_count_sql = "select count(1) from goods_order ";
		
		try {
			pstmt = conn.prepareStatement(order_count_sql);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				return rs.getInt(1);
			}
					
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return 0;
	}

	
	public List getOrderLists(int page, int limit) {
		String sql = "select * from ("
				+ " select rownum rnum, ORDER_NUM ,ORDER_TRADE_NUM, ORDER_TRANS_NUM, ORDER_GOODS_NUM, "
				+ " ORDER_GOODS_NAME, ORDER_GOODS_AMOUNT,ORDER_GOODS_SIZE, ORDER_GOODS_COLOR, "
				+ " ORDER_MEMBER_ID, ORDER_RECEIVE_NAME, ORDER_RECEIVE_ADDR1, ORDER_RECEIVE_ADDR2, "
				+ " ORDER_RECEIVE_PHONE, ORDER_RECEIVE_MOBILE, ORDER_MEMO, ORDER_SUM_MONEY, "
				+ " ORDER_TRADE_TYPE, ORDER_TRADE_DATE, ORDER_TRADE_PAYER, ORDER_DATE, ORDER_STATUS "
				+ " from (select * from goods_order order by order_date desc)) "
				+ " where rnum >= ? and rnum <= ? ";
		
		List orderLists = new ArrayList();
		
		int startRow = (page-1) * 10 + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderBean order = new OrderBean();
				order = getRs(rs);
				orderLists.add(order);
			}
			
			return orderLists;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
		return null;
	}
	
	public OrderBean getOrderDetail(int orderNum) {
		
		String sql = "select * from goods_order where order_num=?";
		OrderBean order = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				order = new OrderBean();
				order = getRs(rs);
				return order;
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			
		}
		
		return order;
	}
	
	
	public OrderBean getRs(ResultSet rs) {
		
		OrderBean order = new OrderBean();
		
		order = new OrderBean();
		
		try {
			order.setOrderNum(rs.getInt("order_Num"));
			order.setOrderTradeNum(rs.getString("order_trade_num"));
			order.setOrderTransNum(rs.getString("order_trans_num"));
			order.setOrderGoodsNum(rs.getInt("order_goods_num"));
			order.setOrderGoodsAmount(rs.getInt("order_goods_amount"));
			order.setOrderMemberId(rs.getString("order_member_id"));
			order.setOrderReceiveName(rs.getString("order_receive_name"));
			order.setOrderReceiveAddr1(rs.getString("order_receive_addr1"));
			order.setOrderReceiveAddr2(rs.getString("order_receive_addr2"));
			order.setOrderReceivePhone(rs.getString("order_receive_phone"));
			order.setOrderReceiveMobile(rs.getString("order_receive_Mobile"));
			order.setOrderMemo(rs.getString("order_memo"));
			order.setOrderSumMoney(rs.getInt("order_sum_money"));
			order.setOrderTradeType(rs.getString("order_trade_type"));
			order.setOrderTradeDate(rs.getDate("order_trade_date"));
			order.setOrderTradePayer(rs.getString("order_trade_payer"));
			order.setOrderDate(rs.getDate("order_date"));
			order.setOrderStatus(rs.getInt("order_status"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}


	public boolean modifyOrder(OrderBean order) {
		
		String sql = "update goods_order set order_stran_num=?, order_memo = ?, order_status = ?"
				+ " where order_num = ?";
		int result = 0;
		
		try {
			
			conn.setAutoCommit(false);
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order.getOrderTransNum());
			pstmt.setString(2, order.getOrderMemberId());
			pstmt.setInt(3, order.getOrderStatus());
			pstmt.setInt(4, order.getOrderNum());
			
			result = pstmt.executeUpdate();
			
			if(result == 1) {
				conn.commit();
				return true;
			}else if(result > 1){
				JdbcUtil.rollback(conn);
				throw new RuntimeException("2개 이상 업데이트");
			}
			
			
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
	
	
	
	public boolean deleteOrder(int orderNum) {
		
		String sql = "delete from goods_order where order_num = ?";
		int result = 0;
		
		try {
			
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderNum);
			result = pstmt.executeUpdate();
			
			if(result == 1) {
				conn.commit();
				return true;
			}else if(result > 1) {
				JdbcUtil.rollback(conn);
				throw new RuntimeException("2개 이상 삭제");
			}
			
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


