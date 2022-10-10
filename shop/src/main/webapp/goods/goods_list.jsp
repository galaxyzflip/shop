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
	function searchPrice(item, searchPrice){
		if(searchPrice != "all"){
			window.location.href="GoodsList.go?item"+item+"&page=1&searchPrice="+searchPrice;
		}else{
			window.location.href="GoodsList.go?item="+item+"&page=1";
		}
	}
</script>

</head>
<body>

	<table width="960" align="center">
		<tr>
			<td colspan="2">
			
			<table width="700" height="460" align="center">
			
				<tr valign="middel">
					<td height="50" width="700" align="right" valign="middel" conspan="4">
						- 상품목록 - &nbsp;
						<a href="JavaScript:searchPrice('${category }', '1~3')">[3만원 미만]</a>
						<a href="JavaScript:searchPrice('${category }', '3~5')">[3~5만원]</a>
						<a href="JavaScript:searchPrice('${category }', '5~7')">[5~7만원]</a>
						<a href="JavaScript:searchPrice('${category }', '7~10')">[7~10만원]</a>
						<a href="JavaScript:searchPrice('${category }', '10')">[10만원 이상]</a>
						<a href="JavaScript:searchPrice('${category }', 'all')">[전체보기]</a>
					</td>
				</tr>
				
				<tr>
					<td valign="top">
					<!-- 상품 리스트 -->
					
					<table>
						<tr>
							<c:choose>
								<c:when test="${requestScope.itemLists[0].goodsNum == null }">
									<tr>
										<td width="700" height="300" align="center">
											등록된 글이 없습니다.
										</td>
									</tr>
								</c:when>
								
								<c:otherwise>
									<c:forEach var="item" items="${requestScope.itemLists }">
										<td  width="180" valign="top">
										
											<c:if test="${category eq 'newItem' }">
											
												<c:if test="${price eq 'no'}">
													<a href="Goods_Detail.go?item=${item.goodsCategory }&gr_goods_num=${item.goodsNum}&isItem=new">
												</c:if>
											
												<c:if test="${price ne 'no'}">
													<a href="Goods_Detail.go?item=${item.goodsCategory }&gr_goods_num=${item.goodsNum}&isItem=new&price=${price}">
												</c:if>
											
											</c:if>
											
											<c:if test="${category eq 'hitItem' }">
											
												<c:if test="${price eq 'no' }">
													<a href="Goods_Detail.go?item=${item.goodsCategory }&gr_goods_num=${item.goodsNum}&isItem=hit">
												</c:if>
												
												<c:if test="${price ne 'no' }">
													<a href="Goods_Detail.go?item=${item.goodsCategory }&gr_goods_num=${item.goodsNum}&isItem=hit&price=${price}">
												</c:if>
												
											</c:if>
											
											<c:if test="${category ne 'hitItem' && category ne 'newItem' }">
											
												<c:if test="${price eq 'no' }">
													<a href="Goods_Detail.go?item=${item.goodsCategory }&gr_goods_num=${item.goodsNum}&isItem=other">
												</c:if>
												
												<c:if test="${price ne 'no' }">
													<a href="Goods_Detail.go?item=${item.goodsCategory }&gr_goods_num=${item.goodsNum}&isItem=other&price=${price}">
												</c:if>
											</c:if>
											
											<img src="./upload/${fn:trim(item.goodsImage)}" width="130" height="130" border="0"/><br>
											${item.goodsName }<br>
											</a>
											<br><b>${item.goodsPrice }</b>
											<br>
										</td>

									</c:forEach>
								</c:otherwise>
								
							</c:choose>
						</tr>
					</table>
					
					<!--  상품리스트 -->
					</td>
				</tr>
			
				<tr>
					<td height="20" conspan="4" align="center">
					<!-- 페이징 -->
						<c:if test="${count > 0 }">
							<c:if test="${startPage > 10 }">
								<a href="GoodsList.go?item=${category }&page=${startPage - 1}">[이전]</a>
							</c:if>
							
							<c:forEach var="i" begin="${startPage }" end="${endPage }">
							
								<c:if test="${i == nowPage}">
									<font color="red">[${i }]</font>
								</c:if>
								
								<c:if test="${i != nowPage }">
									<c:if test="${price eq 'no' }">
										<a href="GoodsList.go?item=${category }">[${i}]</a>
									</c:if>
									
									<c:if test="${price ne 'no' }">
										<a href="GoodsList.go?item=${category }&page=${i}&searchPrice=${price}">[${i }]</a>
									</c:if>
								</c:if>
								
							</c:forEach>
							
							<c:if test="${endPage < pageCount }">
								<a href="GoodsList.go?item=${category }&page=${endPage + 1}">[다음]</a>
							</c:if>
						</c:if>
					<!-- 페이징 -->
					</td>
				</tr>
			</table>
			</td>
		</tr>
	
	</table>

</body>
</html>