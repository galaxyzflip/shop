package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import member.db.MemberBean;
import member.db.MemberDAO;


public class MemberModifyAction_2 implements CommandAction{


	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		if(id == null || id.isBlank()) {
			return "/MemberLogin.me";
		}
		
		MemberDAO memberDao = new MemberDAO();
		MemberBean dto = new MemberBean();
		
		dto.setMemberId(id);
		dto.setMemberName(request.getParameter("member_name"));
		dto.setMemberPw(request.getParameter("member_pw"));
		dto.setMemberEmail(request.getParameter("member_email1")+"@"+request.getParameter("member_email2"));
		dto.setMemberEmailGet(request.getParameter("member_email_get"));
		dto.setMemberMobile(request.getParameter("member_mobile"));
		dto.setMemberMobileGet(request.getParameter("member_mobile_get"));
		dto.setMemberPhone(request.getParameter("member_phone"));
		dto.setMemberZipcode(request.getParameter("member_zipcode"));
		dto.setMemberAddr1(request.getParameter("member_addr1"));
		dto.setMemberAddr2(request.getParameter("member_addr2"));
		
		memberDao.updateMember(dto);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('회원정보 수정에 성공하였습니다.');");
		out.println("</script>");
		out.close();
		
		return "/shop/MemberModifyAction_1.me";
		
	}

}
