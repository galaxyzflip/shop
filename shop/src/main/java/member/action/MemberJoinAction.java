package member.action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.db.MemberBean;
import member.db.MemberDAO;


public class MemberJoinAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		MemberDAO memberDao = new MemberDAO();
		MemberBean dto = new MemberBean();
		ActionForward forward = null;
		
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
		
		memberDao.insertMember(dto);
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('회원가입에 성공하였습니다.');");
		out.println("location.href='/MemberLogin.me';");
		out.println("</script>");
		out.close();
		
		
		return forward;
	}

}
