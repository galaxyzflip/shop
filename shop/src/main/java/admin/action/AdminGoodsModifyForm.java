package admin.action;

import javax.servlet.http.*;
import admin.db.*;
import controller.CommandAction;

public class AdminGoodsModifyForm implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		
		GoodsBean goods = new GoodsBean();
		String num = request.getParameter("goodsNum");
		goods = new GoodsDAO().getGoods(Integer.parseInt(num));
		
		request.setAttribute("goods", goods);
		
		
		return "/adminGoods/admin_goods_modify.jsp";
	}

}
