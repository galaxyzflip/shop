package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.db.*;
import controller.CommandAction;

public class AdminGoodsModifyAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");
		
		GoodsBean goods = new GoodsBean();
		
		goods.setGoodsNum(Integer.parseInt(request.getParameter("goodsNum")));
		goods.setGoodsCategory(request.getParameter("goodsCategory"));
		goods.setGoodsName(request.getParameter("goodsName"));
		goods.setGoodsContent(request.getParameter("goodsContent"));
		goods.setGoodsSize(request.getParameter("goodsSize"));
		goods.setGoodsColor(request.getParameter("goodsColor"));
		goods.setGoodsAmount(Integer.parseInt(request.getParameter("goodsAmount")));
		goods.setGoodsPrice(Integer.parseInt(request.getParameter("goodsPrice")));
		goods.setGoodsBest(Integer.parseInt(request.getParameter("goodsBest")));
		
		int result = new GoodsDAO().modifyGoods(goods);
		if(result <=0 ) {
			System.out.println("상품수정실패");
			
		}
		
		//goods.setGoodsNum(Integer.parseInt(request.getParameter("goodsNum")));
		//goods.setGoodsCategory(request.getParameter("goodsCategory"));
		
		request.setAttribute("check", result);
		
		return "/AdminGoodsList.ag";
	}

}
