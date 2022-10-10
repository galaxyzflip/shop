package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import member.db.MemberBean;
import member.db.MemberDAO;

public class MemberModifyAction_1 implements CommandAction {


	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession(true);
		String id = (String) session.getAttribute("id");
		
		if(id==null || id.isBlank()) {
			return "/shop/MemberLogin.me";
		}
		
		MemberDAO memberDao = new MemberDAO();
		MemberBean dto = memberDao.getMembers(id);
		
		request.setAttribute("member", dto);
		
		return "./member/member_info.jsp";
	}

}
