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
		<td colspan="2" align="right">
			<!-- 주문 페이지 -->
			<form action="./OrderAdd.or" method="post" name="orderForm">
				<input type="hidden" name="orderType" value="${orderType }"> 
			
				<c:if test="${orderType eq 'goods' }">
					<input type="hidden" name="goodsNum" value="${orderInfoLists[0] }">
					<input type="hidden" name="goodsName" value="${orderInfoLists[1] }">
					<input type="hidden" name="goodsAmount" value="${orderInfoLists[2] }">
					<input type="hidden" name="goodsColor" value="${orderInfoLists[3] }">
					<input type="hidden" name="goodsSize" value="${orderInfoLists[4] }">
					<input type="hidden" name="goodsPrice" value="${orderInfoLists[5] }">
				</c:if>
				
				<input type="hidden" name="memberId" value="${member.memberId }">
				<!-- 주문 상세내역 -->
				<table width="80%">
					<tr>
						<td><b><font size="2">주문 상세내역</font></b></td>
					</tr>
					
					<tr align="center" height="20">
						<td style="font-family:Tahoma; font-size: 8pt; font-weight: bold;">사진</td>
						<td style="font-family:Tahoma; font-size: 8pt; font-weight: bold;">상품명</td>
						<td style="font-family:Tahoma; font-size: 8pt; font-weight: bold;">수량</td>
						<td style="font-family:Tahoma; font-size: 8pt; font-weight: bold;">컬러</td>
						<td style="font-family:Tahoma; font-size: 8pt; font-weight: bold;">사이즈</td>
						<td style="font-family:Tahoma; font-size: 8pt; font-weight: bold;">가격</td>
					</tr>
					
					<tr>
						<td style="backgroud-color: #f0f0f0; height: 1px;" colspan="6"></td>
					</tr>
					
					<c:if test="${orderType eq 'goods' }">
						<tr align="center" height="20">
							<td style="font-family: Tahoma; font-size: 7pt;">
								<img src="./upload/${orderInfoLists[6] }" width="50" height="50">
							</td>
							<td style="font-family: Tahoma; font-size: 8pt;">${orderInfoLists[1] }</td>
							<td style="font-family: Tahoma; font-size: 8pt;">${orderInfoLists[2] }</td>
							<td style="font-family: Tahoma; font-size: 8pt;">${orderInfoLists[3] }</td>
							<td style="font-family: Tahoma; font-size: 8pt;">${orderInfoLists[4] }</td>
							<td style="font-family: Tahoma; font-size: 8pt;">${orderInfoLists[5] }</td>
						</tr>
						
						<tr>
							<td style="backgroud-color: #f0f0f0; height: 1px;" colspan="6"></td>
						</tr>
					</c:if>
					
					<!-- 장바구니 구매 -->
					<c:if test="${orderType ne 'goods' }">
						<c:forEach var="i" begin="0" end="${fn:length(basketLists)-1}">
							<tr align="center" height="20">
								<td style="font-family: Tahoma; font-size: 7pt;">
									<img src="./upload/${fn:split(goodsLists[i].goodsImage,',')[0] }" width="50" height="50">
								</td>
								<td style="font-family: Tahoma; font-size: 8pt;">${goodsLists[i].goodsName }</td>
								<td style="font-family: Tahoma; font-size: 8pt;">${basketLists[i].basketGoodsAmount }</td>
								<td style="font-family: Tahoma; font-size: 8pt;">${basketLists[i].basketGoodsColor }</td>
								<td style="font-family: Tahoma; font-size: 8pt;">${basketLists[i].basketGoodsSize }</td>
								<td style="font-family: Tahoma; font-size: 8pt;">${goodsLists[i].goodsPrice }</td>
							</tr>
							
							<tr>
								<td style="backgroud-color: #f0f0f0; height: 1px;" colspan="6"></td>
							</tr>
						</c:forEach>
					</c:if>
				</TABLE>
				
				<table width="80%">
					<tr>
						<td height="10"></td>
					</tr>
					
					<tr>
						<td height="10"></td>
					</tr>
					
					<tr>
						<td><b><font size="2">주문자 정보</font></b></td>
					</tr>
					
					<tr>
						<td style="font-family: Tahoma; font-size: 8pt;" width="80" height="24" bgcolor="f7f7f7">이름</td>
						<td width="320" height="24"><font size="2">${member.memberName }</font></td>
					</tr>
					
					<tr>
						<td style="backgroud-color: #f0f0f0; height: 1px;" colspan="6"></td>
					</tr>
					
					<tr>
						<td style="font-family: Tahoma; font-size: 8pt;" width="80" height="24" bgcolor="f7f7f7">휴대폰</td>
						<td width="320" height="24"><font size="2">${member.memberMobile }</font></td>
					</tr>
					
					<tr>
						<td style="backgroud-color: #f0f0f0; height: 1px;" colspan="6"></td>
					</tr>
					
					<tr>
						<td style="font-family: Tahoma; font-size: 8pt;" width="80" height="24" bgcolor="f7f7f7">이메일 주소</td>
						<td width="320" height="24"><font size="2">${member.memberMobile }</font></td>
					</tr>
					
					<tr>
						<td style="backgroud-color: #f0f0f0; height: 1px;" colspan="6"></td>

					</tr>
				</table>
				
				<table width="80%" cellspacing="1">
					<tr>
						<td height="10"></td>
						<td></td>
					</tr>
					
					<tr>
						<td height="10"></td>
						<td></td>
					</tr>
					
					<tr>
						<td><b><font size="2">배송비 정보</font></b>
					</td>
					
					<tr height="20">
						<td style="font-family: Tahoma; font-size: 8pt;" width="130" height="24" bgcolor="f7f7f7">받는 사람</td>
						<td style="font-family: Tahoma; font-size: 8pt;">
							<input type="text" name="orderReceiveName" size="12" value="${member.memberName }">
						</td>
					</tr>
					
					<tr>
						<td style="font-family: Tahoma; font-size: 8pt;" width="130" height="24" bgcolor="f7f7f7">집 전화</td>
						<td style="font-family: Tahoma; font-size: 8pt;">
							<input type="text" name="orderReceivePhone" size="12" value="${member.memberPhone }">
						</td>
					</tr>	
					
					<tr>
						<td style="font-family: Tahoma; font-size: 8pt;" width="130" height="24" bgcolor="f7f7f7">휴대폰</td>
						<td style="font-family: Tahoma; font-size: 8pt;">
							<input type="text" name="orderReceiveMobile" size="12" value="${member.memberMobile }">
						</td>
					</tr>		
					
					<tr>
						<td style="font-family: Tahoma; font-size: 8pt;" width="130" height="24" bgcolor="f7f7f7">배송지 우편번호</td>
						<td style="font-family: Tahoma; font-size: 8pt;">
							<input type="text" name="orderReceiveZipcode" size="12" value="${member.memberZipcode }">
						</td>
					</tr>					
					
					<tr>
						<td style="font-family: Tahoma; font-size: 8pt;" width="130" height="24" bgcolor="f7f7f7">배송지 주소</td>
						<td style="font-family: Tahoma; font-size: 8pt;">
							<input type="text" name="orderReceiveAddr1" size="12" value="${member.memberAddr1 }">
						</td>
					</tr>					
				
					<tr>
						<td style="font-family: Tahoma; font-size: 8pt;" width="130" height="24" bgcolor="f7f7f7">배송지 나머지 주소</td>
						<td style="font-family: Tahoma; font-size: 8pt;">
							<input type="text" name="orderReceiveAddr2" size="12" value="${member.memberAddr2 }">
						</td>
					</tr>		
					
					<tr>
						<td style="font-family: Tahoma; font-size: 8pt;" width="130" height="24" bgcolor="f7f7f7">기타 요구사항</td>
						<td style="font-family: Tahoma; font-size: 8pt;">
							<textarea name="orderMemo" cols="60" rows="12"></textarea>
						</td>
					</tr>		
					
					<tr>
						<td style="backgroud-color: #f0f0f0; height: 1px;" colspan="6"></td>
					</tr>
				
				</table>
				
				<table width="80%" cellspacing="1">
				
					<tr>
						<td height="10"></td>
						<td></td>
					</tr>
				
					<tr>
						<td height="10"></td>
						<td></td>
					</tr>
					
					<tr>
						<td><b><font size="2">결제정보</font></b></td>
					</tr>
					
					<tr>
						<td style="font-family: Tahoma; font-size: 8pt;" width="200" height="24" bgcolor="f7f7f7">입금자명(온라인입금일 경우)</td>
						<td style="font-family: Tahoma; font-size: 8pt;" width="320" height="24">
							<input type="text" name="orderTradePayer" size="20" value="${member.memberName }">
						</td>
					</tr>	
					
					<tr>
						<td style="backgroud-color: #f0f0f0; height: 1px;" colspan="6"></td>
					</tr>
					
					<tr>
						<td style="backgroud-color: #f0f0f0; height: 1px;" colspan="6">
							<input type="submit" value="주문">&nbsp;
							<input type="button" value="취소" onclick="JavaScript:history.go(-1)">
						</td>
					</tr>
				
				</table>
			
			</form>
			<!-- 주문 페이지 -->
		</td>
	</tr>

</table>
</body>
</html>




