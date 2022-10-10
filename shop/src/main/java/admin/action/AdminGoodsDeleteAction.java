package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admin.db.*;

import controller.CommandAction;

public class AdminGoodsDeleteAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		GoodsBean goods = new GoodsBean();
		
		goods.setGoodsNum(Integer.parseInt(request.getParameter("goodsNum")));
		
		int check = new GoodsDAO().deleteGoods(goods);
		
		request.setAttribute("check", check);
		
		return "/adminGoods/admin_goods_deleteCheck.jsp";
	}

}
