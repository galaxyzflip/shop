package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.db.*;

public class MemberFindAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		ActionForward forward = new ActionForward();
		MemberDAO memberDao = new MemberDAO();
		MemberBean member = new MemberBean();
		
		String name = request.getParameter("memberName");
		String mobile = request.getParameter("memberMobile");
		
		member = memberDao.findId(name, mobile);
		
		if(member != null) {
			request.setAttribute("id", member.getMemberId());
			request.setAttribute("passwd", member.getMemberPw());
			
			forward.setRedirect(false);
			forward.setPath("./member/member_find_ok.jsp");
			return forward;
			
		}else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('입력한 정보가 일치하지 않습니다');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		return null;
	}

}
