package adminorder.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminorder.db.AdminOrderDAO;
import controller.CommandAction;
import member.db.MemberBean;
import member.db.MemberDAO;
import order.db.OrderBean;

public class AdminOrderDetailAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		MemberDAO memberDao = new MemberDAO();
		MemberBean member = new MemberBean();
		AdminOrderDAO orderDao = new AdminOrderDAO();
		OrderBean order = new OrderBean();
		
		String num = request.getParameter("num");
		order = orderDao.getOrderDetail(Integer.parseInt(num));
		member = memberDao.getMembers(order.getOrderMemberId());
		request.setAttribute("order", order);
		request.setAttribute("orderMember", member);
		
		return "./adminOrder/admin_order_modify.jsp";
		
	}

}
