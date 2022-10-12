package adminorder.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminorder.db.AdminOrderDAO;
import controller.CommandAction;
import order.db.OrderBean;

public class AdminOrderModifyAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		AdminOrderDAO orderDao = new AdminOrderDAO();
		OrderBean order = new OrderBean();
		
		boolean result = false;
		
		request.setCharacterEncoding("utf-8");
		
		order.setOrderNum(Integer.parseInt(request.getParameter("num")));
		order.setOrderTransNum(request.getParameter("transportNum"));
		order.setOrderMemo(request.getParameter("memo"));
		order.setOrderStatus(Integer.parseInt(request.getParameter("status")));
		
		result = orderDao.modifyOrder(order);
		
		if(result == false) {
			System.out.println("상품 수정 실패");
			return null;
		}
		
		response.sendRedirect("./AdminOrderList.ao");
		
		return null;
	}

}
