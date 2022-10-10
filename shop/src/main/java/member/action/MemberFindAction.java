package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import member.db.MemberBean;
import member.db.MemberDAO;

public class MemberFindAction implements CommandAction{
	

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
request.setCharacterEncoding("utf-8");
		
		MemberDAO memberDao = new MemberDAO();
		MemberBean member = new MemberBean();
		
		String path="";
		
		String name = request.getParameter("memberName");
		String mobile = request.getParameter("memberMobile");
		
		member = memberDao.findId(name, mobile);
		
		request.setAttribute("member", member);
		path =  "/member/member_find_ok.jsp";
			
		return path;
	}

}
