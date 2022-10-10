<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${check == 1 }">
	<script>
	alert("상품등록이 완료되었습니다.");
	</script>
	<meta http-equiv="Refresh" content="0;url=/shop/AdminGoodsList.ag">
</c:if>

<c:if test="${check < 1 }">

	<script>
	alert("상품등록에 실패하였습니다. 관리자에게 문의해주시기 바랍니다.");
	history.go(-1);
	</script>

</c:if>

