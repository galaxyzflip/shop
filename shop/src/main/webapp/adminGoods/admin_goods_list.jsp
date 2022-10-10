<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>

<script  type="text/JavaScript">
function goodsDelete(goodsNum){
	document.goodsForm.action="./AdminGoodsDelete.ag?goodsNum="+goodsNum;
	document.goodsForm.submit();
}

function goodsModify(goodsNum){
	document.goodsForm.action="./AdminGoodsModify.ag?goodsNum="+goodsNum;
	document.goodsForm.submit();
}
</script>

</head>



<body>

	<table width="960" color="gray" align="center">
	
		<tr>
			<td colspan="2">
			
			
			<table width="80%">
			
				<tr>
					<td>
						상품목록
					</td>
				</tr>
				
				<tr>
					<td>
						<a href="./AdminGoodsAdd.ag">상품등록</a>
					</td>
				</tr>
				
				<tr>
					<td>
					
					<form name="goodsForm" method="post">
					<table border="1">
						<tr>
							<td width="50">번호</td>
							<td width="141">카테고리</td>
							<td width="100">사진</td>
							<td width="141">상품명</td>
							<td width="141">단가</td>
							<td width="80">수량</td>
							<td width="141">등록일자</td>
							<td width="100">&nbsp;</td>
						</tr>
					
					<c:forEach var="goods" items="${goodsLists }">
					
						<tr>
							<td>${goods.goodsNum }</td>
							<td>${goods.goodsCategory }</td>
							
							<td>
								<img src="./upload/${fn:split(goods.goodsImage, ',')[0] }" width="50" height="50">
							</td>
							
							<td>${goods.goodsName }</td>
							<td>${goods.goodsPrice }</td>
							<td>${goods.goodsAmount }</td>
							
								<fmt:parseDate var="dateString" value="${goods.goodsDate }" pattern="yyyy-MM-dd"/>
							<td><fmt:formatDate value="${dateString }" pattern="yyyy-MM-dd"/></td>
							<td>
								<a href="javascript:goodsModify(${goods.goodsNum });">수정</a>
								<a href="javascript:goodsDelete(${goods.goodsNum });">삭제</a>
							</td>
						</tr>
					
					</c:forEach>
					</table>
	
			</table>
	
	</table>

</body>
</html>

























