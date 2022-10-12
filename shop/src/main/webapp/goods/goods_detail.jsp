<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>
<script>
	function isBuy(goodsForm){
		if(document.goodsForm.size.value==""){
			alert("사이즈를 선택해주세요");
			return;
		}else if(document.goodsForm.color.value==""){
			alert("색상을 선택해주세요");
			return;
		}
		
		var amount = document.goodsForm.amount.value;
		var size = document.goodsForm.size.value;
		var type = document.goodsForm.color.value;
		
		var isBuy = confirm("구매하시겠습니까?");
		
		if(isBuy == true){
			goodsForm.action="./OrderStart.or";
			goodsForm.submit();
			
		}else{
			return;
			
		}
	}
	
	function isBasket(basketForm){
		if(document.goodsForm.size.value==""){
			alert("사이즈를 선택해주세요.");
			return ;
			
		}else if(document.goodsForm.color.value=""){
			alert("색상을 선택해주세요");
			return;
		}
		
		var amount = document.goodsForm.amount.value;
		var size = document.goodsForm.size.value;
		var type = document.goodsForm.color.value;
		
		var isBuy = confirm("장바구니에 저장하시겠습니까?");
		
		if(isBuy == true){
			basketForm.action="./BasketAdd.ba";
			basketForm.submit();
			
		}else{
			return;
		}
	}
	
	function count_chnage(temp){
		var test = document.goodsForm.amount.value;
		if(temp == 0){
			test++;
		}else if(temp == 1){
			if(text > 1) test--;
		}
		document.goodsForm.amount.value = test;
	}

</script>


</head>
<body>

<table width="960" align="center">

	<tr>
		<td colspan="2" align="center">
		<!-- 상품 내용 -->
			<form name="goodsForm" action="#" method="post">
				<input type="hidden" name="goodsNum" value="${itemArray.goodsNum }">
				<input type="hidden" name="item" value="${item }">
				<input type="hidden" name="gr_goods_num" value="${gr_goods_num }">
				<input type="hidden" name="isItem" value="${isItem }">
				<input type="hidden" name="order" value="goods">
				<input type="hidden" name="price" value="${itemArray.goodsPrice }">
				<input type="hidden" name="goodsName" value="${itemArray.goodsName }">
				<input type="hidden" name="goodsImage" value="${fn:trim(mainImage) }">
				
				<table width="600" align="center">
					<tr>
						<td height="60" align="center">상 세 보 기</td>
					</tr>
					
					<tr>
						<td width="300" height="220" align="center" valign="middel">
							<img src="./upload/${fn:trim(mainImage) }" width="300" height="300"/>
						</td>
						
						<td width="380" align="center" valign="middel">
						
							<table width="300" height="200">
								<tr>
									<td colspan="4" align="center" height="50">
										<b>${itemArray.goodsName }</b>
									</td>
								</tr>
								
								<tr>
									<td>판매가격&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<td colspan="3">${itemArray.goodsPrice }원</td>
								</tr>
								
								<tr>
									<td rowspan="2">수량&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td width="60" rowspan="2">
										<input type="text" name="amount" style="text-align: right" value="1" size="4">
									</td>
									
									<td valign="bottom">
										<a href="JavaScript:count_change(0)">▲</a>
									</td>
									
									<td width="70" rowspan="2" align="left">개</td>
								</tr>
								
								<tr>
									<td vlaign="top">
										<a href="JavaScript:count_change(1)">▼</a>
									</td>
								</tr>
								
								<tr>
									<td align="left" colspan="4" height="30" valign="middle">
										남은수량 (${itemArray.goodsAmount }) 개
									</td>
								</tr>
								
								<tr>
									<td colspan="4">사이즈&nbsp;&nbsp;&nbsp;&nbsp;
										<select name="size" size="1">
											<option value="">크기를 선택하세요</option>	
											<option value="">-------------</option>
											
											<c:forTokens var="size" items="${itemArray.goodsSize }" delims=",">
												<option value="${fn:trim(size) }">
													${fn:trim(size) }
												</option>
											</c:forTokens>	
										</select>
									</td>
								</tr>
								
								<tr>
									<td colspan="4">컬러&nbsp;&nbsp;&nbsp;&nbsp;
										<select name="color" size="1">
											<option value="">컬러를 선택하세요</option>
											<option value="">-------------</option>
											
											<c:forTokens var="color" items="${itemArray.goodsColor }" delims=",">
												<option value="${fn:trim(color) }">
													${fn:trim(color)}
												</option>
											</c:forTokens>
										</select>
									</td>
								</tr>
								
								<tr>
									<td colspan="4">
										<a href="JavaScript:isBuy(goodsForm);">[구매하기]</a>
										<a href="JavaScript:isBasket(goodsForm);">[장바구니 담기]</a>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					
					<tr>
						<td align="center"></td>
						<td>&nbsp;</td>
					</tr>
					
					<tr>
						<td colspan="2">
							<table align="center">
								<tr>
									<td>
										<c:if test="${prevPage.goodsNum != 0 }">
										
											<c:if test="${price eq 'no' }">
												<a href="Goods_Detail.go?search=prev&gr_goods_num=${itemArray.goodsNum }&item=${category}">
											</c:if>
										
											<c:if test="${price ne 'no' }">
												<a href="Goods_Detail.go?search=prev&gr_goods_num=${itemArray.goodsNum }&item=${category}&price=${price}">
											</c:if>
												
												[이전상품]
												</a>
									</td>
									
									<td width="100" align="left">
										<img src="./upload/${prevPage.goodsImage }" width="70" height="50"><br>
										${prevPage.goodsName }
									</td>
										</c:if>
										
										
										
									<td width="100" align="right">	
										
										<c:if test="${nextPage.goodsNum != 0 }">
										
										<img src="./upload/${nextPage.goodsImage }" width="70" height="50"><br>
										${nextPage.goodsName }
										
											<c:if test="${price eq 'no' }">
												<a href="Goods_Detail.go?search=next&gr_goods_num=${itemArray.goodsNum }&item=${category}">
											</c:if>
										
											<c:if test="${price ne 'no' }">
												<a href="Goods_Detail.go?search=next&gr_goods_num=${itemArray.goodsNum }&item=${category}&price=${price}">
											</c:if>
												
												[다음상품]
												</a>
										</c:if>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				
				</table>
			</form>
			<!-- 상품 구매 끝 -->
			
			<!-- 상품 내용 -->
			
			<table width="700" height="300" align="center">
			
				<tr>
					<td align="center"> ${itemArray.goodsContent }</td>
				</tr>
			</table>
			
			<br><br>
			
			<table width="200" align="center">
				<tr align="left">
					<td colspan="3">
						<c:forEach var="itemimg" items="${requestScope.contentImage }">
							<img src="./upload/${fn:trim(itemimg) }"/>
						</c:forEach>
					</td>
				</tr>
			</table>
			<!-- 상품 내용 끝 -->
		</td>

</table>


</body>
</html>






