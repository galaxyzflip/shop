package order.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.db.GoodsBean;
import basket.db.BasketBean;
import basket.db.BasketDAO;
import controller.CommandAction;
import order.db.OrderBean;
import order.db.OrderDAO;

public class OrderAddAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		if(id == null) {
			return "비로그인";
		}
		
		Vector goodsVector = new Vector();
		
		OrderDAO orderDao = new OrderDAO();
		OrderBean order = new OrderBean();
		
		List basketLists = new ArrayList();
		List goodsLists = new ArrayList();
		
		GoodsBean goods = new GoodsBean();
		BasketDAO basketDao = new BasketDAO();
		BasketBean basket = new BasketBean();
		
		order.setOrderMemberId(request.getParameter("memberId"));
		order.setOrderReceiveName(request.getParameter("orderReceiveName"));
		order.setOrderReceivePhone(request.getParameter("orderReceivePhone"));
		order.setOrderReceiveMobile(request.getParameter("orderReceiveMobile"));
		order.setOrderReceiveAddr1(request.getParameter("orderReceiveZipcode") +" "+ request.getParameter("orderReceiveAddr1"));
		order.setOrderReceiveAddr2(request.getParameter("orderReceiveAddr2"));
		order.setOrderMemo(request.getParameter("orderMemo"));
		order.setOrderTradeType("온라인입금");
		order.setOrderTradePayer(request.getParameter("orderTradePayer"));
		
		String orderType = request.getParameter("orderType");
		
		if(orderType.equals("goods")) {
			basket.setBasketGoodsNum(Integer.parseInt(request.getParameter("goodsNum")));
			basket.setBasketGoodsAmount(Integer.parseInt(request.getParameter("goodsAmount")));
			basket.setBasketGoodsSize(request.getParameter("goodsSize"));
			basket.setBasketGoodsColor(request.getParameter("goodsColor"));
			
			goods.setGoodsName(request.getParameter("goodsName"));
			goods.setGoodsPrice(Integer.parseInt(request.getParameter("goodsPrice")));
			
			basketLists.add(basket);
			goodsLists.add(goods);
			goodsVector.add(basketLists);
			goodsVector.add(goodsLists);
			
		}else {
			goodsVector = basketDao.getBasketLists(id);
		}
			
		orderDao.addOrder(order, goodsVector);
		
		
		
		return "./OrderOk.or";
	}
	
	
}




















