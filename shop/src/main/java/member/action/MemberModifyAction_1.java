package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.db.MemberBean;
import member.db.MemberDAO;

public class MemberModifyAction_1 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession(true);
		String id = (String) session.getAttribute("id");
		
		if(id==null || id.isBlank()) {
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");
			return forward;
			
		}
		
		MemberDAO memberDao = new MemberDAO();
		MemberBean dto = memberDao.getMembers(id);
		
		request.setAttribute("member", dto);
		
		forward.setRedirect(false);
		forward.setPath("./member/member_info.jsp");
		return forward;
		
	}

}
