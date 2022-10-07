package member.action;

import javax.servlet.http.*;
import member.db.MemberDAO;

public class MemberIdCheckAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		String id = request.getParameter("memberId");
		
		MemberDAO memberDao = new MemberDAO();
		int check = memberDao.confirmId(id);
		
		request.setAttribute("id", id);
		request.setAttribute("check", check);
		
		forward.setRedirect(false);
		forward.setPath("./member/member_idchk.jsp");
		return forward;
	}

}
