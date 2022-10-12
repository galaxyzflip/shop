package basket.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import basket.db.BasketDAO;
import controller.CommandAction;

public class BasketDeleteAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		BasketDAO basketDao = new BasketDAO();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		if(id == null) {
			return "로그인 안했을때 보내기";
		}
		
		String num = request.getParameter("num");
		if(num == null) {
			return null;
			
		}
		
		basketDao.basketRemove(Integer.parseInt(num));

		response.sendRedirect("./BasketList.ba");
		
		return null; 
	}

}
