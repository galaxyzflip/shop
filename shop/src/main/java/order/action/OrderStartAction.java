package order.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import basket.db.BasketDAO;
import controller.CommandAction;
import member.db.MemberBean;
import member.db.MemberDAO;

public class OrderStartAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		
		if(id == null) {
			return "비로그인";
		}
		
		request.setCharacterEncoding("utf-8");
		
		List orderInfoLists = new ArrayList();
		String order = request.getParameter("order");
		
		if(order.equals("goods")) {
			orderInfoLists.add(Integer.parseInt(request.getParameter("goodsNum")));
			orderInfoLists.add(request.getParameter("goodsName"));
			orderInfoLists.add(Integer.parseInt(request.getParameter("amount")));
			orderInfoLists.add(request.getParameter("size"));
			orderInfoLists.add(request.getParameter("color"));
			orderInfoLists.add(Integer.parseInt(request.getParameter("price")));
			orderInfoLists.add(request.getParameter("goodsImage"));
			request.setAttribute("orderType", "goods");
			request.setAttribute("orderInfoLists", orderInfoLists);
			
		}else {
			BasketDAO basketDao = new BasketDAO();
			Vector vector = basketDao.getBasketLists(id);
			List basketLists = (ArrayList)vector.get(0);
			List goodsLists = (ArrayList)vector.get(1);
			
			request.setAttribute("orderType", "basket");
			request.setAttribute("basketLists", basketLists);
			request.setAttribute("goodsLists", goodsLists);
			
		}
		
		MemberDAO memberDao = new MemberDAO();
		MemberBean member = memberDao.getMembers(id);
		request.setAttribute("member", member);
		
		return "/goods_order/goods_buy.jsp";
		
	}

}
