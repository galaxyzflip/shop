<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	function formSubmit(){
		var forms = document.getElementBuId("findform");
		
		if(forms.memberName == "" || forms.memberName.length <=1){
			alert("이름을 정확히 입력해 주십시오");
			forms.memberName.focus();
			return false;
			
		}
			
		if(forms.memberMobile == "" || forms.memberMobile.length <=1){
			alert("휴대폰번호를 정확히 입력해 주십시오");
			forms.memberName.focus();
			return false;
			
		}
		return true;
	}
	
	
	

</script>
</head>
<body>

<table width="450" height="20">

	<tr>
		<td aling="left">
			<b>아이디/비밀번호 찾기</b>
		</td>
	</tr>

</table>


<form action="./MemberFindAction.me" method="post" name="findform" onsubmit="return formSubmit();">

<table width="450">

	<th>
		<font size="2">이름과 핸드폰번호를 입력해주세요.</font>
	</th>
	
	<tr>
		<td height="29" bgcolor="#f3f3f3">
			<font size="2">이름</font>
		</td>
		
		<td>
			<input type="text" name="memberName" maxlength="12" size="14">
		</td>
	</tr>

	<tr>
		<td colspan="2" height="1"><
	</td>
	
	<tr>
		<td height="29" bgcolor="#f3f3f3">
			<font size="2">핸드폰번호</font>
		</td>
		
		<td>
			<input type="text" name="memberMobile" maxlength="14" size="14">
		</td>
	</tr>
	
	<tr>
		<td colspan="2" style="padding:10px 0 20px 0" align="center">
			<input type="submit" value="확인">
		</td>
	</tr>


</table>





</form>


</body>
</html>












