<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${check == true }">
	<script>
		alert("회원가입에 성공하였습니다.");
	</script>
	<meta http-equiv="Refresh" content="0;url=/shop/MemberLogin.me">	
</c:if>


<c:if test="${check == false }">
	<script>
		alert("회원가입에 살패하였습니다. 관리자에게 문의해주시기 바랍니다.");
		history.go(-1);
	</script>	
</c:if>

    
