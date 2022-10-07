package member.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import util.JdbcUtil;

public class MemberDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MemberDAO() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/OracleDB");
			conn = ds.getConnection();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public boolean insertMember(MemberBean mb) throws SQLException{
		
		String sql = "";
		
		try {
			sql = " insert into member(member_id, member_pw, member_name, member_birthday, member_male,"
					+ " member_email, "
					+ " member_email_get,member_mobile, member_mobile_get, member_phone, member_zipcode, member_addr1, "
					+ " member_addr2, member_admin, member_join_date) "
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?, sysdate)";
			pstmt.setString(1, mb.getMemberId());
			pstmt.setString(2, mb.getMemberPw());
			pstmt.setString(3, mb.getMemberName());
			pstmt.setString(4, mb.getMemberBirthday());
			pstmt.setString(5, mb.getMemberMale());
			pstmt.setString(6, mb.getMemberEmail());
			pstmt.setString(7, mb.getMemberEmailGet());
			pstmt.setString(8, mb.getMemberMobile());
			pstmt.setString(9, mb.getMemberMobileGet());
			pstmt.setString(10, mb.getMemberPhone());
			pstmt.setString(11, mb.getMemberZipcode());
			pstmt.setString(12, mb.getMemberAddr1());
			pstmt.setString(13, mb.getMemberAddr2());
			pstmt.setInt(14, mb.getMemberAdmin());
			pstmt.executeLargeUpdate();
			
			return true;
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return false;
	}
	
	public int userCheck(String id, String pw)throws SQLException{
		
		String sql = null;
		int x = -1;
		
		try {
			sql = "select member_pw from member where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String memberpw = rs.getString("member_pw");
				
				if(memberpw.equals(pw)) {
					x = 1;
				}else {
					x = 0;
				}
			}else {
				x = -1;
			}
				
			return x;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		
		
		return -1;
	}
	
	
	public int confirmId(String id) throws SQLException{
		String sql = null;
		int x = -1;
		
		try {
			
			sql = "select member_id from member where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x = 1;
			}else
				x = -1;
			
			return x;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		
		
		return -1;
	}
	
	public MemberBean getMembers(String id) throws SQLException{
		MemberBean member = null;
		String sql = null;
		
		try {
			sql = "select * from member where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			if(rs.next()) {
				member = getRs(rs);
				return member;
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		
		
		return null;
	}
	
	public MemberBean getRs(ResultSet rs) {
		
		MemberBean member = null;
		
		try {
			member.setMemberId(rs.getString("member_id"));
			member.setMemberName(rs.getString("member_name"));
			member.setMemberBirthday(rs.getString("member_birthday"));
			member.setMemberEmail(rs.getString("member_email"));
			member.setMemberEmailGet(rs.getString("member_email_get"));
			member.setMemberMobile(rs.getString("member_mobide"));
			member.setMemberMobileGet(rs.getString("member_mobide_get"));
			member.setMemberPhone(rs.getString("member_phone"));
			member.setMemberZipcode(rs.getString("member_zipcode"));
			member.setMemberAddr1(rs.getString("member_addr1"));
			member.setMemberAddr2(rs.getString("member_addr2"));
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return member;
		
	}
	
	public void updateMember(MemberBean member) throws SQLException{
		String sql = null;
		int check = 0;
		
		try {
			
			conn.setAutoCommit(false);
			
			sql = "update member set member_pw = ?, member_name = ? , member_email = ?, member_email_get = ?, "
					+ " member_mobile = ?, "
					+ " member_mobile_get = ?, member_phone = ?, member_zipcode = ?, member_addr1 = ?, "
					+ " member_addr2 = ? "
					+ " where member_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getMemberName());
			pstmt.setString(3, member.getMemberEmail());
			pstmt.setString(4, member.getMemberEmailGet());
			pstmt.setString(5, member.getMemberMobile());
			pstmt.setString(6, member.getMemberMobileGet());
			pstmt.setString(7, member.getMemberPhone());
			pstmt.setString(8, member.getMemberZipcode());
			pstmt.setString(9, member.getMemberAddr1());
			pstmt.setString(10, member.getMemberAddr2());
			pstmt.setString(11, member.getMemberId());
			
			check = pstmt.executeUpdate();
			
			if(check > 1) {
				JdbcUtil.rollback(conn);
				throw new RuntimeException("업데이트 1개 이상");
			}
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		
		}finally {
			conn.setAutoCommit(true);
			JdbcUtil.close(pstmt);
		}
		
	}
	
	public int deleteMember(String id, String pw)throws SQLException{
		
		String sql = null;
		int x = -1;
		int check = 0;
		
		try {
			conn.setAutoCommit(false);
			
			sql="select member_pw from member where member_id=?";
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbPassword = rs.getString("member_pw");
				if(dbPassword.equals(pw)) {
					sql = "delete from member where member_id=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					check = pstmt.executeUpdate();
					if(check > 1) {
						throw new RuntimeException("2개 이상 삭제");
					}
					x = 1;
					
				}else
					x = 0;
			}
			conn.commit();
			return x;
			
			
		}catch(SQLException ex) {
			JdbcUtil.rollback(conn);
			ex.printStackTrace();
			
		}finally {
			conn.setAutoCommit(true);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
			
		}
		
		
		return -1;
	}
	
	public MemberBean findId(String name, String mobile) throws SQLException{
		
		String sql = null;
		MemberBean member = new MemberBean();
		
		try {
			
			sql = "select member_id, member_pw, member_mobile from member where member_name= ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbMobile = rs.getString("member_mobilde");
				
				if(dbMobile.equals(mobile)) {
					return member;
				}
			}
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
			
		}
		
		
		return null;
	}
	
	public boolean isAdmin(String id) {
		String sql = "select member_admin from member where member_id = ?";
		
		int member_admin = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member_admin = rs.getInt("member_admin");
				if(member_admin == 1) {
					return true;
				}
			}
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
		return false;
	}
	
	public List searchZipcode(String searchdong) {
		
		String sql = "select * from zipcode where dong like '%||?||%'";
		List zipcodeList = new ArrayList();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchdong);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String sido = rs.getString("sido");
				String gugun = rs.getString("gugun");
				String dong = rs.getString("dong");
				String ri = rs.getString("ri");
				String bunji = rs.getString("bunji");
				if(ri == null) ri = "";
				if(bunji == null) bunji = "";
				
				String zipcode = rs.getString("zipcode");
				String addr = sido + " " + gugun + " " + ri + " " + bunji;
				
				zipcodeList.add(zipcode+","+addr);
			}
			return zipcodeList;
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
