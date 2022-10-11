package admin.action;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import admin.db.*;
import controller.CommandAction;




public class AdminGoodsAddAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		GoodsDAO goodsDao = new GoodsDAO();
		GoodsBean goods = new GoodsBean();
		
		String realPath = "";
		String savePath = "upload";
		int maxSize = 5 * 1024 * 1024;
		int check = 0;
		
		realPath = request.getRealPath(savePath);
		/* realPath = "C:\\Users\\pigcs\\git\\shop\\shop\\src\\main\\webapp\\upload"; */
		realPath = "C:\\Users\\EZEN\\git\\shop\\shop\\src\\main\\webapp\\upload";
		
		
		List saveFiles = new ArrayList();
		
		try {
			MultipartRequest multi = null;
			multi = new MultipartRequest(request, realPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration files = multi.getFileNames();
			
			while(files.hasMoreElements()) {
				String name = (String)files.nextElement();
				
				if(files.hasMoreElements()) {
					saveFiles.add(multi.getFilesystemName(name)+",");
					
				}else {
					saveFiles.add(multi.getFilesystemName(name));
					
				}
			}
			
			StringBuffer fl = new StringBuffer();
			
			for(int i=0;i<saveFiles.size();i++) {
				fl.append(saveFiles.get(i));
			}
			
			goods.setGoodsCategory(multi.getParameter("goodsCategory"));
			goods.setGoodsName(multi.getParameter("goodsName"));
			goods.setGoodsContent(multi.getParameter("goodsContent"));
			goods.setGoodsSize(multi.getParameter("goodsSize"));
			goods.setGoodsColor(multi.getParameter("goodsColor"));
			goods.setGoodsAmount(Integer.parseInt(multi.getParameter("goodsAmount")));
			goods.setGoodsPrice(Integer.parseInt(multi.getParameter("goodsPrice")));
			goods.setGoodsImage(fl.toString());
			goods.setGoodsBest(Integer.parseInt(multi.getParameter("goodsBest")));
			
			check = goodsDao.insertGoods(goods);
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		request.setAttribute("check", check);		
		
		return "/adminGoods/admin_goods_writeCheck.jsp";
	}

}




