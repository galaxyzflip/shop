package member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class MemberChangeAction implements CommandAction {

	private String path;

	public void setCommand(String command) {
		int idx = command.indexOf(".");
		path = command.substring(0, idx);

	}
	
	public String getCommand() {
		return this.path;
	}

	

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) 
			throws Throwable {
		
		
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());

		String path = null;

		// 포워드 처리만 한다.
		// 시스템에 변화가 생기지 않는 단순 조회

		if (command.equals("/MemberLogin.me")) {
			path = "./member/member_login.jsp";

		} else if (command.equals("/MemberJoin.me")) {
			path = "./member/member_join.jsp";

		} else if (command.equals("/MemberFind.me")) {
			path = "./member/member_find.jsp";

		} else if (command.equals("/MemberOut.me")) {
			path = "./member/member_out.jsp";

		} else if (command.equals("/Zipcode.me")) {
			path = "./member/member_zipcode.jsp";

		}else if (command.equals("/AdminGoodsAdd.ag")) {
			path = "./adminGoods/admin_goods_write.jsp";

		}

		if (path == null) {
			System.out.println("잘못된 명령입니다.");
			throw new RuntimeException("change경로이상");
		}

		return path;
	}

}
