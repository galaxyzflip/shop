<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="id" value="${requestScope.id }"/>
<c:set var="check" value="${requestScope.check }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>

<script>
	function windowclose(){
		opener.document.joinform.memberId.value='${id}';
		self.close();
	}

</script>


</head>
<body>

<c:if test="${check ==1 }">
	<table width="360" cellpadding="5">
		<tr align="center">
			<td height="30">
				<font size="2">${id }는 이미 사용중인 아이디 입니다.</font>
			</td>
		</tr>
	</table>
</c:if>

<c:if test="${check != 1 }">
<table width="360" cellpadding="5">
	<tr align="center">
		<td height="30">
			<font size="2">${id } 는 사용할 수 있는 아이디 입니다.</font><br><br>
			<input type="button" value="닫기" onclick="windowclose()"/>
		</td>
	</tr>
</table>
</c:if>



</body>
</html>