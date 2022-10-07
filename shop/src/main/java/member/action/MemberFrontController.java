package member.action;

import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFrontController extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		
		if(command.equals("/MemberLogin.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/member_login.jsp");
			
		}else if(command.equals("/MemberJoin.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/member_join.jsp");
			
		}else if(command.equals("/MemberFind.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/member_find.jsp");
			
		}else if(command.equals("/MemberOut.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/member_out.jsp");
			
		}else if(command.equals("/Zipcode.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/member_zipcode.jsp");
			
			
			
			
		}else if(command.equals("/MemberLoginAction.me")) {
			forward = new ActionForward();
			
			try {
				forward = action.execute(request, response);
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}else if(command.equals("/MemberJoinAction.me")) {
			forward = new ActionForward();
			
			try {
				forward = action.execute(request, response);
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}else if(command.equals("/MemberModifyAction_1.me")) {
			forward = new ActionForward();
			
			try {
				forward = action.execute(request, response);
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}else if(command.equals("/MemberModifyAction_2.me")) {
			forward = new ActionForward();
			
			try {
				forward = action.execute(request, response);
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}else if(command.equals("/MemberDeleteAction.me")) {
			forward = new ActionForward();
			
			try {
				forward = action.execute(request, response);
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}else if(command.equals("/MemberIdCheckAction.me")) {
			forward = new ActionForward();
			
			try {
				forward = action.execute(request, response);
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}else if(command.equals("/MemberFindAction.me")) {
			forward = new ActionForward();
			
			try {
				forward = action.execute(request, response);
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}else if(command.equals("/MemberZipcodeAction.me")) {
			forward = new ActionForward();
			
			try {
				forward = action.execute(request, response);
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
		
		if(forward.isRedirect()) {
			response.sendRedirect(forward.getPath());
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
		
	}

	
}
























