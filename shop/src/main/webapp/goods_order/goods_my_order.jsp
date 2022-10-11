<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="nowPage" value="${requestScope.page }"/>

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
		<!-- 회원 주문내역 보기 -->
		
		<table width="700" align=center>
			<tr>
				<td>현재 (${id})고객님께서 주문하신 내역이 총 (${orderCount })개 있습니다.</td>
			</tr>
			
			<tr>
				<td height="62" align="center" vlaing="middle">
					<table width="700" border="1" bgcolor="#cccccc">
					
						<tr>
							<td height="20"><div align="center">상품명</div></td>
							<td height="20"><div align="center">색상/사이즈</div></td>
							<td height="20"><div align="center">수량</div></td>
							<td height="20"><div align="center">총 금액</div></td>
							<td height="20"><div align="center">주문 상태</div></td>
							<td height="20"><div align="center">주문 날짜</div></td>
						</tr>
						
						<c:if test="${fn:length(goodsOrderLists) == 0 }">
							<td align="center" colspan="6">주문 내역이 없습니다.</td>
						
						</c:if>
						
						<c:forEach var="order" items="${goodsOrderLists }">
						
							<tr align="center">
								<td height="20">${order.orderGoodsName }</td>
								<td height="20">${order.orderGoodsColor }/${order.orderGoodsSize }</td>
								<td height="20">${order.orderGoodsAmount }</td>
								<td height="20">${order.orderSumMoney }</td>
								<td>
									<c:if test="${order.orderStatus eq '0' }">대기중</c:if>
									<c:if test="${order.orderStatus eq '1' }">발송준비</c:if>
									<c:if test="${order.orderStatus eq '2' }">발송완료</c:if>
									<c:if test="${order.orderStatus eq '3' }">배송중</c:if>
									<c:if test="${order.orderStatus eq '4' }">배송완료</c:if>
									<c:if test="${order.orderStatus eq '5' }">주문취소</c:if>
								</td>
								<td>${order.orderDate }</td>
							</tr>
						</c:forEach>
					
					
					<!-- 페이징 -->
						<tr align=center height=20>
							<td colspan="7" style="font-family:Tahoma; font-size: 10pt;">
								<c:if test="${nowPage <= 1 }">
									[이전]&nbsp;
								</c:if>
								
								<c:if test="${nowPage > 1 }">
									<a href="./OrderList.or?page=${nowPage - 1 }">[이전]</a>&nbsp;
								</c:if>
								
								<c:forEach var="i" begin="${startPage }" end="${endPage }">
									<c:if test="${i eq nowPage }">
										[${i }]
									</c:if>
								
									<c:if test="${i ne nowPage }">
										<a href="./OrderList.or?page=${i }">[${i }]</a>
									</c:if>
								</c:forEach>
								
								<c:if test="${nowPage >= maxPage }">
									[다음]
								</c:if>
								
								<c:if test="${nowPage < maxPage }">
									<a href="./OrderList.or?page=${nowPage + 1 }">[다음]</a>
								</c:if>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		
		</table>
	</td>
</tr>

<tr>
	<td height="28">
		<div align="right">총 주문금액 : ${totalMoney }원</div>
	</td>
</tr>

</table>
</body>
</html>