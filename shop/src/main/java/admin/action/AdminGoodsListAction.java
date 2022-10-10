package admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.db.GoodsBean;
import admin.db.GoodsDAO;
import controller.CommandAction;

public class AdminGoodsListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		List<GoodsBean> goodsLists = new ArrayList<>();
		goodsLists = new GoodsDAO().getGoodsLists();
		
		request.setAttribute("goodsLists", goodsLists);
		
		return "/adminGoods/admin_goods_list.jsp";
	}

}
