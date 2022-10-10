package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import member.db.MemberDAO;

public class MemberIdCheckAction implements CommandAction{

	

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String id = request.getParameter("memberId");
		
		MemberDAO memberDao = new MemberDAO();
		int check = memberDao.confirmId(id);
		
		request.setAttribute("id", id);
		request.setAttribute("check", check);
		
		return "/member/member_idchk.jsp";
	}

}
