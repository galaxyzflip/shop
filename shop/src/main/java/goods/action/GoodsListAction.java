package goods.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.db.GoodsBean;
import admin.db.GoodsDAO;
import controller.CommandAction;

public class GoodsListAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		List<GoodsBean> itemLists = null;
		String item = null;
		String price = null;
		int count = 1;
		int page = 1;
		
		GoodsDAO goodsDao = new GoodsDAO();
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		item=request.getParameter("item");
		
		itemLists = goodsDao.itemList(item, page, price);
		count = goodsDao.getCount(item);
			
		int pageSize = 12;
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int startPage = (int)((page - 1) / pageSize) * pageSize + 1;
		int endPage = startPage + pageSize - 1;
		if(endPage > pageCount) endPage = pageCount;
		
		request.setAttribute("itemLists", itemLists);
		request.setAttribute("category", item);
		request.setAttribute("count", count);
		request.setAttribute("price", price);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		return "./goods/goods_list.jsp";
	}

}
