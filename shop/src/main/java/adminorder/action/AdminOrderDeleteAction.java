package adminorder.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminorder.db.AdminOrderDAO;
import controller.CommandAction;

public class AdminOrderDeleteAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		AdminOrderDAO orderDao = new AdminOrderDAO();
		
		boolean result = false;
		String num = request.getParameter("num");
		result = orderDao.deleteOrder(Integer.parseInt(num));
		
		if(result == false) {
			System.out.println("상품 삭제 실패");
			return null;
		}
		
		response.sendRedirect("./AdminOrderList.ao");
		
		return null;
	}

}
