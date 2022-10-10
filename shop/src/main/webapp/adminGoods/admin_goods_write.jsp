<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		
		<!-- 상품등록 -->
		<table width="80%">
		
		<form action="./AdminGoodsAddAction.ag" method="post" name="goodsForm" enctype="multipart/form-data">
			<input type="hidden" name="goodsBest" value="0">
			
			<tr>
				<td>상 품 등 록</td>
			</tr>
			
			<tr>
				<td height="330">
				
				<table border="1" align=center width="560">
				
					<tr>
						<td width="200" height="30">
							카테고리
						</td>
					</tr>
					
					<tr>
						<td width="350" height="30">
							<select name="goodsCategory" size="1">
								<option value="outwear" selected>아웃웨어</option>
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
						<td><input type="text" name="goodsName"></td>				
					</tr>
					
					<tr>
						<td>판매가</td>
						<td><input type="text" name="goodsPrice"></td>				
					</tr>
					
					<tr>
						<td>색상</td>
						<td><input type="text" name="goodsColor"></td>				
					</tr>
					
					<tr>
						<td>수량</td>
						<td><input type="text" name="goodsAmount"></td>				
					</tr>
					
					<tr>
						<td>사이즈</td>
						<td><input type="text" name="goodsSize"></td>				
					</tr>
					
					<tr>
						<td>제품정보</td>
						<td><textarea name="goodsContent" cols="50" rows="15"></textarea>				
					</tr>
					
					<tr>
						<td>메인 제품미이지(gif)</td>
						<td><input type="file" name="file4"></td>
					<tr>
					
					<tr>
						<td>제품미이지1(gif)</td>
						<td><input type="file" name="file3"></td>
					<tr>
					
					<tr>
						<td>제품미이지2(gif)</td>
						<td><input type="file" name="file2"></td>
					<tr>
					
					<tr>
						<td>제품미이지3(gif)</td>
						<td><input type="file" name="file1"></td>
					<tr>
				</table>
				</td>
			</tr>
		
			<tr>
				<td height="75"><input type="submit" value="등록">&nbsp;
							<input type="reset" value="다시쓰기">
				</td>
			</tr>
			</table>
		
		</form>
		</td>
		</tr>

</table>




</body>
</html>