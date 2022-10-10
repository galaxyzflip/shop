<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>

<script>



function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                
            
            } else {
                
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}

</script>
<!-- <script language="JavaScript" src="script.js"></script> -->
<script language="JavaScript" src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

</head>
<body>

<table width="960" cellspacind="0" cellpadding="0" align="center">

	<tr>
		<td colspan="2">
		
		<form name="joinform" action="/shop/MemberJoinAction.me" method="post" onsubmit="return check()">
		
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
							<option value="fe">여자</option>
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
							<input type="text" name="memberMobile" size="24">
					</td>
				</tr>
				
				<tr>
					<td>
						<font size="2">휴대폰 수신여부</font>
					</td>
					
					<td>
						<input type="radio" name="memberMobileGet" value="yes" checked/>
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













