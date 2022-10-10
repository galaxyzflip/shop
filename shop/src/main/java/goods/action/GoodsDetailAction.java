package goods.action;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.db.GoodsBean;
import admin.db.GoodsDAO;
import controller.CommandAction;

public class GoodsDetailAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		GoodsDAO goodsDao = new GoodsDAO();
		
		List imgLists = new ArrayList();
		int gr_goods_num = 0;
		
		GoodsBean isNextPage = null;
		GoodsBean isPrevPage = null;
		GoodsBean itemArray = null;
		GoodsBean nextBean = null;
		GoodsBean prevBean = null;
		
		String item = null;
		String price = "no";
		
		gr_goods_num = Integer.parseInt(request.getParameter("gr_goods_num"));
		item = request.getParameter("item");
		
		int nextPage = 0;
		int prevPage = 0;
		
		if(!(request.getParameter("price") == null || !request.getParameter("price").isBlank())) {
			price = request.getParameter("price");
			
		}
		
		if(request.getParameter("search") != null) {
			if(request.getParameter("search").equals("next")){
				nextBean = goodsDao.findDetail(gr_goods_num, item, price, "next");
				nextPage = nextBean.getGoodsNum();
				
				itemArray = goodsDao.findDetailLists(nextPage, item);
				isNextPage = goodsDao.findDetail(nextPage, item, price, "next");
				isPrevPage = goodsDao.findDetail(nextPage, item, price, "prev");
				
			}else if(request.getParameter("search").equals("prev")){
				prevBean = goodsDao.findDetail(gr_goods_num, item, price, "prev");
				prevPage = prevBean.getGoodsNum();
				
				itemArray = goodsDao.findDetailLists(prevPage, item);
				isNextPage = goodsDao.findDetail(prevPage, item, price, "next");
				isPrevPage = goodsDao.findDetail(prevPage, item, price, "prev");
				
			}
		}else {
			itemArray = goodsDao.findDetailLists(gr_goods_num, item);
			
			if(request.getParameter("isItem").equals("new")) {
				item = "newItem";
				
			}else if(request.getParameter("isItem").equals("hit")) {
				item = "hitItem";
			}
			
			isNextPage = goodsDao.findDetail(gr_goods_num, item, price, "next");
			isPrevPage = goodsDao.findDetail(gr_goods_num, item, price, "prev");
		}
		
		String images = itemArray.getGoodsImage();
		StringTokenizer st = new StringTokenizer(images, ",");
		
		while(st.hasMoreTokens()) {
			imgLists.add(st.nextToken());
		}
		
		String mainImage = (String)imgLists.get(1);
		List contentImage = new ArrayList();
		
		for(int i=2; i<imgLists.size(); i++) {
			contentImage.add(imgLists.get(i));
		}
		
		request.setAttribute("itemArray", itemArray);
		request.setAttribute("category", item);
		request.setAttribute("mainImage", mainImage);
		request.setAttribute("contenImage", contentImage);
		request.setAttribute("prevPage", isPrevPage);
		request.setAttribute("nextPage", isNextPage);
		request.setAttribute("price", price);
		
		return "./goods/goods_detail.jsp";
		
	}

	
	
	
	
	
	
	
	
	
}
