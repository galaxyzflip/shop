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


<table width="960" color="gray" align="center">

	<tr>
		<td colspan="2">
		
		<table width="80%">
		
		<form name="goodsForm" action="./AdminGoodsModifyAction.ag" method="post">
			<input type="hidden" name="goodsNum" value="${goods.goodsNum }">
			
			<tr>
				<td>상 품 수 정</td>
			</tr>
			
			<tr>
				<td height="330">
					<table border="1" align="center" width="560">
					
						<tr>
							<td width="200" height="30">카테고리</td>
							<td width="350" height="30">
								<select name="goodsCategory" size="1" value="${goods.goodsCategory }">
									<option value="outwear">아웃웨어</option>
									<option value="fulldress" >정장/신사복</option>
									<option value="Tshirts" >티셔츠</option>
									<option value="shirts" >와이셔츠</option>
									<option value="pants" >팬츠</option>
									<option value="shoes" >슈즈</option>
								</select>
							</td>
						</tr>
						
						<tr>
							<td>상품이름</td>
							<td><input type="text" name="goodsName" value="${goods.goodsName }"></td>
						</tr>
							
						<tr>
							<td>판매가</td>
							<td><input type="text" name="goodsPrice" value="${goods.goodsPrice }"></td>
						</tr>
							
						<tr>
							<td>색상</td>
							<td><input type="text" name="goodsColor" value="${goods.goodsColor }"></td>
						</tr>
							
						<tr>
							<td>수량</td>
							<td><input type="text" name="goodsAmount" value="${goods.goodsAmount }"></td>
						</tr>
							
						<tr>
							<td>사이즈</td>
							<td><input type="text" name="goodsSize" value="${goods.goodsSize }"></td>
						</tr>
							
						<tr>
							<td>인기상품</td>
							
							<c:if test="${goods.goodsBest == 1 }">
								<td><input type="radio" name="goodsBest" value="1" checked>
								<td><input type="radio" name="goodsBest" value="0">
							</c:if>
							
							<c:if test="${goods.goodsBest == 0 }">
								<td><input type="radio" name="goodsBest" value="1">
								<td><input type="radio" name="goodsBest" value="0" checked>
							</c:if>

						</tr>
						
						<tr>
							<td width="200">제품정보</td>
							<td width="350">
								<textarea name="goodsContent" cols="50" rows="15">${goods.goodsContent }</textarea>
							</td>
						</tr>
					</table>
					</td>
				</tr>
				
				<tr>
					<td height="75"><input type="submit" value="수정">&nbsp;
									<input type="reset" value="다시쓰기">
					</td>
				</tr>
		</form>
		</table>
		</td>
	</tr>

</table>






</body>
</html>