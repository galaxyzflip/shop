package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import member.db.MemberDAO;

public class MemberDeleteAction implements CommandAction{


	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		if(id == null || id.isBlank()) {
			return "/member/main.jsp";
		}
		
		MemberDAO memberDao = new MemberDAO();
		String pass = request.getParameter("member_pw");
		
		try {
			int check = memberDao.deleteMember(id, pass);
			
			if(check == 1) {
				session.invalidate();
				
				return "/member/member_out_ok.jsp";
			}else {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				
				out.println("<script>");
				out.println("alert('비밀번호가 맞지 않습니다.');");
				out.println("history.go(-1)");
				out.println("</script>");
				out.close();
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

}
