package adminorder.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminorder.db.AdminOrderDAO;
import controller.CommandAction;

public class AdminOrderListsAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		AdminOrderDAO orderDao = new AdminOrderDAO();
		List orderLists = new ArrayList();

		int page = 1;
		int limit = 10;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));

		}

		int orderCount = orderDao.getOrderCount();
		orderLists = orderDao.getOrderLists(page, limit);

		int maxPage = (int) ((double) orderCount / limit + 0.95);
		/* int startPage = (int)(((page - 1) / limit) * limit) + 1; */
		int startPage = (page - 1) * limit + 1;

		int endPage = maxPage;

		if (endPage > startPage)
			endPage = startPage;

		request.setAttribute("page", page);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("orderCount", orderCount);
		request.setAttribute("orderLists", orderLists);

		return "./adminOrder/admin_order_list.jsp";
	}

}
