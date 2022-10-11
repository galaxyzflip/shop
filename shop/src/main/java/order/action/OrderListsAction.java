package order.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import order.db.OrderBean;
import order.db.OrderDAO;

public class OrderListsAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		if(id == null) {
			return "로그인 안했을때 보내는곳";
		}
		
		int page = 1;
		int limit = 10;
		OrderDAO orderDao = new OrderDAO();
		List<OrderBean> goodsOrderLists = new ArrayList<>();
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		try {
			
			int orderCount = orderDao.getOrderCount(id);
			int totalMoney = orderDao.getOrderSumMoney(id);
			goodsOrderLists = orderDao.getOrderLists(page, limit, id);
			
			int maxPage = (int)((double)orderCount / limit + 0.95);
			int startpage = (((int)((double)page / 10 + 0.9)) - 1) * 10 + 1;
			int endPage = maxPage;
			
			if(endPage > startpage + 10 - 1) endPage = startpage + 10 - 1;
			
			request.setAttribute("page", page);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startpage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("orderCount", orderCount);
			request.setAttribute("totalMoney", totalMoney);
			request.setAttribute("goodsOrderLists", goodsOrderLists);
			
			return "./goods_order/goods_my_order.jsp";
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

	
}
