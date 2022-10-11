package basket.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import basket.db.BasketDAO;
import controller.CommandAction;

public class BasketListsAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		BasketDAO basketDao = new BasketDAO();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		
		Vector vector = basketDao.getBasketLists(id);
		List basketLists = (ArrayList)vector.get(0);
		List goodsLists = (ArrayList)vector.get(1);
		
		request.setAttribute("basketLists", basketLists);
		request.setAttribute("goodsLists", goodsLists);
		
		return "./goods_order/goods_basket.jsp";
	}

}
