<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>

<script>

function check(){
	var id = joinform.memberId.value;
	var password1 = joinform.memberPw.value;
	var password2 = joinform.memberpw2.value;
	var email1 = joinform.memberEmail1.value;
	var email2 = joinform.memberEmail2.value;
	var phone = joinform.memberPhone.value;
	var addr1 = joinform.memberAddr1.value;
	var addr2 = joinform.memberAddr2.value;
	var mobile = joinform.memberMobile.value;
	var male = joinform.memberMale.value;
	
	var forms = document.getElementById("joinform");
	
	if((forms.memberName.value="" ) || forms.memberName.value.length<=1)){
		alert("이름을 제대로 입력해주세요.");
		forms.memberName.focus();
		return false;
	}
	
	if(forms.memberId.value=""){
		alert("아이디를 입력해주세요.");
		forms.memberId.focus();
		return false;
	}
	
	if(forms.memberPw.value=""){
		alert("비밀번호를 입력해주세요.");
		forms.memberPw.focus();
		return false;
	}
	
	if(forms.memberPw.value != forms.memterPw2.value){
		alert("비밀번호가 일치하지 않습니다.");
		joinform.memberPw.value="";
		joinform.memberPw2.value="";
		forms.memberPw.focus();
		return false;
	}
	
	if(forms.memberBirthday.value=""){
		alert("생일을 입력해주세요");
		forms.memberBirthday.focus();
		return false;
	}
	
	if(forms.memberMale.value=""){
		alert("성별을 입력해주세요");
		forms.memberMale.focus();
		return false;
	}
	
	if(email1.length == 0 || email2.length == 0){
		alert("이메일을 제대로 입력하세요");
		joinforms.memberEmail.focus();
		return false;
	}
	
	
	if(forms.memberZipcode.value=="" || forms.memberZipcode.value.length < 5){
		alert("우편번호를 입력해주세요.");
		forms.memberZipcode.focus();
		returnf false;
	}
	
	if(forms.memberAddr1 ==""){
		alert("집 주소를 입력하세요.");
		joinform.memberAddr1.focus();
		return false;
	}
	
	if(forms.memberAddr2 ==""){
		alert("상세주소 주소를 입력하세요.");
		joinform.memberAddr1.focus();
		return false;
	}
	
	if(forms.memberMobile.value ==""){
		alert("휴대폰번호를 입력해주세요");
		joinform.memberMobile.focus();
		return false;
	}
	
	return true;
	
}

function gNumCheck(){
	if(event.keycode >= 48 && event.keycode <= 57){
		return true;
	}else{
		event.returnvalue=false;
	}
}

</script>
<script language="JavaScript" src="script.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>

<table width="960" cellspacind="0" cellpadding="0" align="center">

	<tr>
		<td colspan="2">
		
		<form name="joinform" action="/MemberJoinAction.me" method="post" onsubmit="return check()">
		
		<p align="center">
			<table border="1" width="80%" height="80">
			
				<tr>
					<td width="17%" bgcolor="#f5f5f5">
						<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;아이디</font>
					</td>
					
					<td>&nbsp;&nbsp;&nbsp;
						<input type="text" name="memberId" size="10" maxlength="15"/>
						<input type="button" name="confirm_id" value="중복확인" onclick="openConfirmId(this.form)"/>
					</td>
				</tr>
				
				<tr>
					<td bgcolor="#f5f5f5">
						<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;비밀번호</font>
					</td>
					
					<td>
						<input type="password" name="memberPw" size="15">
					</td>
				</tr>
				
				<tr>
					<td>
						<font size="2">비밀번호 확인</font>
					</td>
					
					<td>
						<input type="password" name="memberPw2" size="15">
					</td>
				</tr>
				
				<tr>
					<td></td>
					<td>
						<font size="2">(아이디와 비밀번호는 문자와 숫자를 조합하여 2~12자리로 만들어주세요)</font>
					</td>
					
				</tr>
				
				<tr>
					<td>
						<font size="2">생일</font>
					</td>
					
					<td>
						<input type="date" name="memberBirthday" value="2000-01-01">
					</td>
				</tr>
				
				<tr>
					<td>
						<font size="2">성별</font>
					</td>
					<td>
						<select name="male">
							<option>-선택-</option>
							<option value="ma">남자</option>
							<option value="fe">남자</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td>
						<font size="2">이메일 주소</font>
					</td>
					
					<td>
						<input type="text" name="memberEmail1" size="13">@
						<input type="text" name="memberEmail2" size="15">
					</td>
				</tr>
				
				
				<tr>
					<td>
						<font size="2">메일 수신 여부</font>
					</td>
					
					<td>
						<input type="radio" name="memberEmailGet" value="yes" checked/>
							<font size="2">수신</font>
						<input type="radio" name="memberEmailGet" value="no"/>
							<font size="2">수신안함</font>
					</td>
				</tr>
				
				<tr>
					<td>
						<font size="2">집전화</font>
					</td>
					
					<td>
						<input type="text" name="memberPhone" size="24">
					</td>
				</tr>
				
				<tr>
					<td>
						<font size="2">우편번호</font>
					</td>
					<td>
						<input type="text" name="memberZipcode" id="sample6_postcode" size="7">
						<input type="button" onclick="sample6_execDaumPostcode()" value="다음우편번호"><br>
					</td>
				</tr>
				
				<tr> 
					<td>주소</td>
					<td><input type="text" name="memberAddr1" id="sample6_address" size="70"><br>
						<input type="text" name="memberAddr2" id="sample6_detailAddress" size="70">
					</td>
				</tr>
						
				<tr>
					<td>
						<font size="2">휴대폰</font>
					</td>
					
					<td>
						<input type="radio" name="memberMobile" value="yes" checked/>
							<font size="2">수신</font>
						<input type="radio" name="memberMobileGet" value="no"/>
							<font size="2">수신안함</font>
					</td>
				</tr>
			
			</table>
			
			<table width="80%">
				<tr>
					<td align='cetner'>
						<br><input type="submit" value="확인">&nbsp;
							<input type="reset" value="다시작성">
					</td>
				</tr>
			
			</table>
		
		</form>
		</td>
		</tr>

</table>

</body>
</html>













