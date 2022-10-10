<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
 <jsp:useBean id="goods" class="admin.db.GoodsBean">
 	<jsp:setProperty name="goods" property="*"/>
 </jsp:useBean>
 
 
 <% request.setAttribute("goods", goods);%>