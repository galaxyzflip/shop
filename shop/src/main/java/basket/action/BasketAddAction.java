package basket.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import basket.db.BasketDAO;
import controller.CommandAction;

public class BasketAddAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		
		BasketDAO basketDao = new BasketDAO();
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		
		if(id == null) {
			return "./로그인 안했을때 보내는 경로";
		}
		
		int num = Integer.parseInt(request.getParameter("goodsNum"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		String size = request.getParameter("size");
		String color = request.getParameter("color");
		String item = request.getParameter("item");
		String gr_goods_num = request.getParameter("gr_goods_num");
		String isItem = request.getParameter("isItem");
		
		basketDao.basketAdd(id, num, amount, size, color);
		
		return "./BasketList.ba?item="+item+"&gr_goods_num="+gr_goods_num+"&isItem="+isItem;
	}

	
}
