<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<p align="center">
		
			<form action="./MemberDeleteAction.me" method="post">
			
			<table border="1" width="380">
			
				<tr>
					<td align="center" colspan="2">
						<font size="4"><b>회원 탈퇴</b></font>
					</td>
				</tr>			
			
				<tr>
					<td align="center" height="35" width="125">
						<font size="2">비밀번호</font>
					</td>
					
					<td>
						<input type="password" name="memberPw">
					</td>
				</tr>
				
				<tr>
					<td align="center" colspan="2" height="35">
						<input type="submit" value="회원탈퇴">
						<input type="reset" value="취 소">
					</td>
				</tr>
						 
			
			</table>
			
			</form>

</table>


</body>
</html>