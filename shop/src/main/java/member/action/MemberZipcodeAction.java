package member.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.db.MemberDAO;

public class MemberZipcodeAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		MemberDAO memberDao = new MemberDAO();
		List zipcodeList = new ArrayList();
		
		String searchdong = request.getParameter("dong");
		zipcodeList = memberDao.searchZipcode(searchdong);
		
		request.setAttribute("zipcodeList", zipcodeList);
		forward.setRedirect(false);
		forward.setPath("./member/member_zipcode.jsp");
		return forward;
	}

}
