<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${empty member }">
	<script>
		alert("일치하는 정보가 없습니다.");
		history.go(-1);
	</script>
	
</c:if>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script>
	function windowclose(){
		self.close();
	}
</script>


</head>
<body>

<c:if test="${!empty member }">

<table width="450" height="35">
	<tr>
		<td align="left"><b>아이디/비밀번호 찾기</b></td>
	</tr>
</table>


<table width="440">
	
	<th>검색된 아이디/비밀번호 입니다.</th>
	
	<tr><td align="left"> 아이디 : ${member.memberId }</td></tr>
	<tr><td align="left"> 비밀번호 : ${member.memberPw }</td></tr>
	
</table>

<table width="450">

	<tr>
		<td align="center"><br><br>
			<input type="button" value="닫기" onclick="windowclose()"/>
		</td>
	</tr>

</table>
</c:if>

</body>
</html>