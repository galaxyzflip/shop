function check(){
	
	var forms = document.getElementById("joinform");
	
	if(forms.memberName.value==""){
		alert("이름을 제대로 입력해 주세요");
		forms.memberName.focus();
		return false;
	}
	
	if(forms.memberId.value==""){
		alert("아이디를 제대로 입력해 주세요");
		forms.memberId.focus();
		return false;
	}
	
	if(forms.memberPw.value==""){
		alert("비밀번호를 제대로 입력해 주세요");
		forms.memberPw1.focus();
		return false;
	}
	
	if(forms.memberPw2.value==""){
		alert("비밀번호확인을 제대로 입력해 주세요");
		forms.memberPw2.focus();
		return false;
	}
	
	if(forms.memberPw.value != forms.memberPw2.value){
		alert("비밀번호를 다르게 입력하셨습니다.");
		forms.memberPw.focus();
		return false;
	}
	
	if(forms.memberMale.value == ""){
		alert("성별을 입력해주세요.");
		forms.memberMale.focus();
		return false;
	}
	
	if(forms.memberEmail1.value=="" || forms.memberEmail2.value){
		alert("이메일을 제대로 입력해 주세요");
		forms.memberEmail1.focus();
		return false;
	}
	
	if(forms.memberZipcode.value==""){
		alert("우편번호를 입력해 주세요");
		forms.memberZipcode.focus();
		return false;
	}
	
	if(forms.memberAddr1.value=="" || forms.memberAddr2.value==""){
		alert("이메일을 제대로 입력해 주세요");
		forms.memberAddr1.focus();
		return false;
	}
	
	if(forms.memberMobile.value==""){
		alert("휴대폰번호를 입력해 주세요");
		forms.memberMobile.focus();
		return false;
	}
	
	joinform.submit();
}

function openConfirmId(joinform){
	var id = joinform.memberId.value;
	var url="./MemberIdCheckAction.me?memberId="+joinform.memberId.value;
	
	if(id.length == 0){
		alert("아이디를 입력하세요.");
		joinform.memberId.focus();
		return false;
	}
	open(url, "confirm", "toolbar=no,location=no,status=no,menuvar=no,scrollbars=no,resizable=no,width=400,height=200");
}


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