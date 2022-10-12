<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>
</head>
<body>

<table width="960" align="center">

	<tr>
		<td colspan="2">
		
			<form action="./OrderStart.or" name="basketForm" method="post">
				<input type="hidden" name="order" value="basket">
				
					<table width="80%">
						<tr align="center">
							<td><b>장 바 구 니</b></td>
						</tr>
					</table>
					
					<table width="80%">
						<tr height="26" bgcolor="#94d7e7">
							<td height="3" colspan="7" align="right"></td>
						</tr>
						
						<tr bgcolor="#f0f8ff" align="center">
							<td width="5%"><font size="2">번호</font></td>
							<td width="5%"><font size="2">사진</font></td>
							<td width="25%"><font size="2">제품명</font></td>
							<td width="8%"><font size="2">수량</font></td>
							<td width="8%"><font size="2">가격</font></td>
							<td width="8%"><font size="2">취소</font></td>
						</tr>
						
						<c:if test="${!empty basketLists}">
							<c:if test="${fn:length(basketLists) != 0 }">
								<c:forEach var="i" begin="0" end="${fn:length(basketLists) -1 }">
									<tr align="center">
										<td><font size="2">${basketLists[i].basketNum }</font></td>
										<td><font size="2"><img src="./upload/${fn:split(goodsLists[i].goodsImage,',')[0]}" width="50" height="50"></font></td>
										<td><font size="2">${goodsLists[i].goodsName }</font></td>
										<td><font size="2">${basketLists[i].basketGoodsAmount }</font></td>
										<td><font size="2">${goodsLists[i].goodsPrice }</font></td>
										<td><font size="2"><a href="BasketDelete.ba?num=${basketLists[i].basketNum }" onclick="return confirm('취소하시겠습니까')">취소</a></font></td>
									</tr>
								</c:forEach>
							</c:if>
						</c:if>
							
						<c:if test="${empty basketLists }">
							<tr>
								<td colspan="7" align="center">
									<font size="2">장바구니에 담긴 상품이 없습니다.</font>
								</td>
							</tr>
						</c:if>
					</table>
					
					<table width="80%">
						<tr>
							<td align="center">
								<c:if test="${!empty basketLists }">
									<c:if test="${fn:length(basketLists) != 0 }">
										<a href="JavaScript:basketForm.submit()">[구매하기]</a>
									</c:if>
								</c:if>
								
								<c:if test="${empty basketLists }">
									<a href="JavaScript:alert('주문할 상품이 없습니다.')">[구매하기]</a>
								</c:if>
								
								<c:if test="${empty item }">
									<a href="./GoodsList.go?item=newItem">[계속 쇼핑하기]</a>
								</c:if>
					
								<c:if test="${!empty item }">
									<a href="./Goods_Detail.go?item=${item }&gr_goods_num=${gr_good_num}&isItem=${isItem}">[계속 쇼핑하기]</a>
								</c:if>
							</td>
						</tr>
					</table>
			</form>
		</td>
	</tr>

</table>


</body>
</html>