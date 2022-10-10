package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import member.db.MemberBean;
import member.db.MemberDAO;


public class MemberJoinAction implements CommandAction{


	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		MemberDAO memberDao = new MemberDAO();
		MemberBean dto = new MemberBean();
		boolean check = false;
		
		dto.setMemberId(request.getParameter("memberId"));
		dto.setMemberPw(request.getParameter("memberPw"));
		dto.setMemberName(request.getParameter("memberName"));
		dto.setMemberBirthday(request.getParameter("memberBirthday"));
		dto.setMemberEmail(request.getParameter("memberEmail") + "@" + request.getParameter("memberEmail2"));
		dto.setMemberEmailGet(request.getParameter("memberEmailGet"));
		dto.setMemberMobile(request.getParameter("memberMobile"));
		dto.setMemberMobileGet(request.getParameter("memberMobileGet"));
		dto.setMemberMale(request.getParameter("memberMale"));
		dto.setMemberPhone(request.getParameter("memberPhone"));
		dto.setMemberZipcode(request.getParameter("memberZipcode"));
		dto.setMemberAddr1(request.getParameter("memberAddr1"));
		dto.setMemberAddr2(request.getParameter("memberAddr2"));
		dto.setMemberAdmin(0);
		
		check = memberDao.insertMember(dto);
		request.setAttribute("check", check);
		
		/*
		 * response.setContentType("text/html; charset=utf-8");
		 * 
		 * PrintWriter out = response.getWriter();
		 * 
		 * out.println("<script>"); out.println("alert('회원가입에 성공하였습니다.');");
		 * out.println("location.href='/shop/MemberLogin.me';");
		 * out.println("</script>");
		 */
		
		
		return "/member/member_join_check.jsp";
		/* return "/member/member_login.jsp"; */
		/* return "/MemberLogin.me"; */
	}

}
