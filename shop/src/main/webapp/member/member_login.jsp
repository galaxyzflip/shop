<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>

<script>
	function check(){
		var id = loginform.memberId.value;
		var pass = loginform.memberPw.value;
		
		if(id.length == 0){
			alert("아이디를 입력하세요.");
			loginform.memberId.focus();
			return false;
			
		}
		
		if(pass.length == 0){
			alert("비밀번호를 입력하세요");
			loginform.memberPw.focus();
			return flase;
		}
		return true;
	}
	
	function openConfirmId(loginform){
		var url="./MemberFind.me";
		open(url, "confirm", "toolbar=no,location=no,status=no,menuvar=no,scrollbars=no,resizable=no,width=450px,height=300");
	}

</script>


</head>
<body>


<table width="960" align="center">
<form action="/shop/MemberLoginAction.me" method="post" name="loginform" onsubmit="return check()">

	<tr>
		<td width="20%"> 아이디 </td>
		<td><input type="text" name="memberId" size="12" maxlength="20"></td>
	</tr>
	
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="memberPw"></td>
	</tr>
	
	<tr>
		<td colspan="4">
			<input type="submit" value="로그인">
			<input type="button" value="회원가입" onclick="javascript:window.location='./MemberJoin.me'">
			<input type="button" value="아이디/비밀번호 찾기" onclick="openConfirmId(this.form)">
		</td>
	</tr>

	
</form>
</table>




</body>
</html>















