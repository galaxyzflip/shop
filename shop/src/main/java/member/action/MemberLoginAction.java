package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import member.db.MemberDAO;

public class MemberLoginAction implements CommandAction{


	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		MemberDAO memberDao = new MemberDAO();
		
		String id = request.getParameter("memberId");
		String pass = request.getParameter("memberPw");
		String path = "";
		
		int check = memberDao.userCheck(id, pass);
		if(check == 1) {
			session.setAttribute("id", id);
			
			if(memberDao.isAdmin(id)) {
				
				/* path = "./GoodsList.ag"; */
				path = "./AdminGoodsList.ag";
				
			}else {
				/* return "./GoodsList.go?item=new_item"; */
				path = "/GoodsList.go?item=newItem";
			}
				
		}else if(check == 0) {
			path = "/member/test.jsp";
			
		}
		
		
		return path;
	}
	

}
