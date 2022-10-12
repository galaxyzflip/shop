<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>

</head>
<body>

<table width="960" align="center">
	<tr>
		<td colspan="2" align="center">
		<!-- 주문 정보 수정(관리자) -->
		
			<form action="./AdminOrderModify.ao" name="orderForm" method="post">
				<input type="hidden" name="num" value="${order.orderNum }">
					
					<table width="80%" cellspacing="1">
						<tr>
							<td height="10"></td>
						</tr>
					
						<tr>
							<td height="10"></td>
						</tr>
						
						<tr>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" geight="24 bgcolor="#f7f7f7">운송장(등기)번호</td>
							<td width="320" height="24">
								<c:if test="${!empty order.orderTransNum }">
									<input type="text" name="transportNum" size="15" maxlength="20" value="${ order.orderTransNum}">
								</c:if>
					
								<c:if test="${empty order.orderTransNum }">
									<input type="text" name="transportNum" size="15" maxlength="20">
								</c:if>
							</td>
						</tr>
						
						
						<tr>
							<td style="background-color: #f0f0f0; height: 1px;" conspan="6"><td>
						</td>
						
						<tr>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24 bgcolor="#f7f7f7">주문번호</td>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">${order.orderTradeNum }</td>
						</tr>
						
						<tr>
							<td style="background-color: #f0f0f0; height: 1px;" conspan="6"><td>
						</td>
						
						<tr height="20">
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24 bgcolor="#f7f7f7" conspan="2">상품정보</td>
						</tr>
						
						<tr>
							<td style="background-color: #f0f0f0; height: 1px;" conspan="6"><td>
						</td>
						
						<tr>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24 bgcolor="#f7f7f7">상품이름</td>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">${order.orderGoodsName }</td>
						</tr>
						
						<tr>
							<td style="background-color: #f0f0f0; height: 1px;" conspan="6"><td>
						</td>
						
						<tr>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24" bgcolor="#f7f7f7">수량</td>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">${order.orderGoodsAmount }</td>
						</tr>
						
						<tr>
							<td style="background-color: #f0f0f0; height: 1px;" conspan="6"><td>
						</td>
						
						<tr>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24" bgcolor="#f7f7f7">사이즈</td>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">${order.orderGoodsSize }</td>
						</tr>
						
						<tr>
							<td style="background-color: #f0f0f0; height: 1px;" conspan="6"><td>
						</td>
						
						<tr>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24" bgcolor="#f7f7f7">색깔</td>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">${order.orderGoodsColor }</td>
						</tr>
						
						<tr>
							<td style="background-color: #f0f0f0; height: 1px;" conspan="6"><td>
						</td>
						
						<tr>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24" bgcolor="#f7f7f7" colspan="2">배송지정보</td>
						</tr>
						
						<tr>
							<td style="background-color: #f0f0f0; height: 1px;" conspan="6"><td>
						</td>
						
						<tr>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24 bgcolor="#f7f7f7">받는사람</td>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">${order.orderReceiveName }</td>
						</tr>
						
						<tr>
							<td style="background-color: #f0f0f0; height: 1px;" conspan="6"><td>
						</td>
						
						<tr height="23">
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24" bgcolor="#f7f7f7">집전화</td>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">${order.orderReceivePhone }</td>
						</tr>
						
						<tr>
							<td style="background-color: #f0f0f0; height: 1px;" conspan="6"><td>
						</td>
						
						<tr height="23">
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24" bgcolor="#f7f7f7">휴대폰</td>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">${order.orderReceiveMobile }</td>
						</tr>
						
						<tr>
							<td style="background-color: #f0f0f0; height: 1px;" conspan="6"><td>
						</td>
						
						<tr height="23">
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24" bgcolor="#f7f7f7">배송지주소</td>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">${order.orderReceiveAddr1 }</td>
						</tr>
						
						<tr>
							<td style="background-color: #f0f0f0; height: 1px;" conspan="6"><td>
						</td>
						
						<tr height="23">
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24" bgcolor="#f7f7f7">상세주소</td>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">${order.orderReceiveAddr2 }</td>
						</tr>
						
						<tr>
							<td style="background-color: #f0f0f0; height: 1px;" conspan="6"><td>
						</td>
						
						<tr height="23">
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24" bgcolor="#f7f7f7" colspan="2">주문자정보</td>
						</tr>
						
						<tr>
							<td style="background-color: #f0f0f0; height: 1px;" conspan="6"><td>
						</td>
						
						<tr height="23">
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24" bgcolor="#f7f7f7">이메일주소</td>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">${order.orderReceiveEmail }</td>
						</tr>
						
						<tr>
							<td style="background-color: #f0f0f0; height: 1px;" conspan="6"><td>
						</td>
						
						<tr height="23">
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24" bgcolor="#f7f7f7">집전화</td>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">${order.orderReceivePhone}</td>
						</tr>
						
						<tr>
							<td style="background-color: #f0f0f0; height: 1px;" conspan="6"><td>
						</td>
						
						<tr height="23">
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24" bgcolor="#f7f7f7">휴대폰</td>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">${order.orderReceiveMobile}</td>
						</tr>
						
						<tr>
							<td style="background-color: #f0f0f0; height: 1px;" conspan="6"><td>
						</td>
						
						<tr height="23">
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24" bgcolor="#f7f7f7">기타 요구사항</td>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">${order.orderMemo}</td>
						</tr>
						
						<tr>
							<td style="background-color: #f0f0f0; height: 1px;" conspan="6"><td>
						</td>
					</table>	
					
					<table width="80%" cellspacing="1">
						<tr><td height="10"></td></tr>
						<tr><td height="10"></td></tr>
						
						
						<tr>
							<td><b><font size="2">결제정보</font></b>
						</td>
						
						<tr>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24" bgcolor="#f7f7f7">주문 합계 금액 : </td>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">${order.orderSumMoney} 원</td>
						</tr>
						
						<tr>
							<td style="background-color: #f0f0f0; height: 1px;" conspan="6"><td>
						</td>
						
						<tr>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24" bgcolor="#f7f7f7">결제방법 : </td>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">${order.orderTradeType} 원</td>
						</tr>
						
							<tr>
							<td style="background-color: #f0f0f0; height: 1px;" conspan="6"><td>
						</td>
						
						<tr>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24" bgcolor="#f7f7f7">입금자명 : </td>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">${order.orderTradePayer} 원</td>
						</tr>
							
						<tr>
							<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;" width="130" height="24" bgcolor="#f7f7f7">주문 상태 : </td>
							<td width="320" height="24">
								<select name="status">
									<option value="0"  <c:if test="${order.orderStatus == 0 }"> selected="selected" </c:if>> 대기중</option>
									<option value="1"  <c:if test="${order.orderStatus == 1 }"> selected="selected" </c:if>> 발송 준비</option>
									<option value="2"  <c:if test="${order.orderStatus == 2 }"> selected="selected" </c:if>> 발송 완료</option>
									<option value="3"  <c:if test="${order.orderStatus == 3 }"> selected="selected" </c:if>> 배송중</option>
									<option value="4"  <c:if test="${order.orderStatus == 4 }"> selected="selected" </c:if>> 배송 완료</option>
									<option value="5"  <c:if test="${order.orderStatus == 5 }"> selected="selected" </c:if>> 주문 취소</option>
								</select>
							</td>
						</tr>
						
						<tr><td style="background-color: #f0f0f0; height: 1px;" colspan="6"></td></tr>
						<tr><td style="background-color: #f0f0f0; height: 1px;" colspan="6"></td></tr>
						
						<tr>
							<td align="center" style="background-color: $f0f0f0; height: 1px;" colspan="6">
								<input type="submit" value="수정">&nbsp;
								<input type="button" onclick="javaScript:location.href$'./AdminOrderList.ao')" value="취소">
							</td>
						</tr>
					
					</table>
				
			</form>
			<!-- 주문 정보 수정 -->
		</td>
	</tr>

</table>

</body>
</html>