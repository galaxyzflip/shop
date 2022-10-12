<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="nowPage" value="${requestScope.page }"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>
</head>
<body>

<table width="960" align=center>
	<tr>
		<td colspan="2" align="center">
		
			<table width="80%">
				<tr>
					<td align="right" colspan="10" height="25" style="font-family:Tahoma;font-size:8pt;">
						전체 주문 수 <b>${orderCount }</b> 개 &nbsp;&nbsp;&nbsp;
					</td>
				</tr>
				
				<!--  주문목록 -->
				
				<tr align="center" height="20">
					<td style="font-family:Tahoma;font-size:8pt; font-weight:bold">주문번호</td>
					<td style="font-family:Tahoma;font-size:8pt; font-weight:bold">주문자</td>
					<td style="font-family:Tahoma;font-size:8pt; font-weight:bold">결제방법</td>
					<td style="font-family:Tahoma;font-size:8pt; font-weight:bold">주문금액</td>
					<td style="font-family:Tahoma;font-size:8pt; font-weight:bold">주문상태</td>
					<td style="font-family:Tahoma;font-size:8pt; font-weight:bold">주문일시</td>
					<td style="font-family:Tahoma;font-size:8pt; font-weight:bold">수정/삭제</td>
				</tr>
				
				<tr>
					<td style="background-color:#f0f0f0; height:1pt;" colspan="6"></td>
				</tr>
				
				<c:forEach var="order" items="${orderLists }">
					<tr align="center" height="20">
						<td style="font-family:Tahoma;font-size:7pt;">${order.orderTradeNum } </td>
						<td style="font-family:Tahoma;font-size:7pt;">${order.orderMemberId } </td>
						<td style="font-family:Tahoma;font-size:7pt;">${order.orderTradeType } </td>
						<td style="font-family:Tahoma;font-size:7pt;">${order.orderSumMoney } </td>
						<td style="font-family:Tahoma;font-size:7pt;">
							<c:if test="${order.orderStatus == 0 }"> 대기중 </c:if>
							<c:if test="${order.orderStatus == 1 }"> 발송준비 </c:if>
							<c:if test="${order.orderStatus == 2 }"> 발송완료 </c:if>
							<c:if test="${order.orderStatus == 3 }"> 배송중 </c:if>
							<c:if test="${order.orderStatus == 4 }"> 배송완료 </c:if>
							<c:if test="${order.orderStatus == 5 }"> 주문취소 </c:if>
						</td>
						
						<td style="font-family:Tahoma;font-size:8pt;">${order.orderDate }</td>
						<td style="font-family:Tahoma;font-size:8pt;">
							<a href="./AdminOrderDetail.ao?num=${order.orderNum }">수정</a>
							<a href="./AdminOrderDelete.ao?num=${order.orderNum }" onclick="return confirm('삭제하시겠습니까?')">삭제</a>
						</td>
					</tr>
					
					<tr>
						<td style="backgroud-color:#f0f0f0; height:1px;" colspan="6"></td>
					</tr>
				</c:forEach>
				
				<!-- 페이징 -->
				<tr align="center" height="20">
					<td colspan="7" style="font-family:Tahoma; font-size:10pt;">
						<c:if test="${nowPage <= 1 }"> [이전] &nbsp;</c:if>
						<c:if test="${nowPage > 1 }"> <a href="./AdminOrderList.ao?page=${nowPage - 1 }">[이전]</a>&nbsp;</c:if>
					
						<c:forEach var="a" begin="${startPage }" end="${endPage }">
							<c:if test="${a == nowPage }">[${a }]</c:if>
							<c:if test="${a != nowPage }"><a href="./AdminOrderLists.ao?page=${a }">[${a }]</a></c:if>
						</c:forEach>
						
						<c:if test="${nowPage >= endPage }">&nbsp; [다음]</c:if>
						<c:if test="${nowPage < endPage }"><a href="./AdminOrderLists.ao?page=${nowPage + 1 }">[다음]</a></c:if> 
					</td>
				</tr>
			</table>
		</td>
	</tr>

</table>


</body>
</html>