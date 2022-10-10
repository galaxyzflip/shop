<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러</title>
</head>
<body>

잘못된 요청입니다.<br>
commandHandlerURI.properties 파일을 참고하여<br> 
경로 및 클래스 파일들을 확인해주시기 바랍니다. <br>

/MemberLoginAction.me=member.action.MemberLoginAction<br>
/MemberJoinAction.me=member.action.MemberJoinAction<br>


#new=member.action.MemberJoinAction<br>
#/member/MemberFind.me=member.action.MemberFindAction<br>
#/member/MemberOut.me=member.action.MemberDeleteAction<br>
#/member/Zipcode.me=member.action.MemberZipcodeAction<br>

/MemberLogin.me=member.action.MemberChangeAction<br>
/MemberJoin.me=member.action.MemberChangeAction<br>
/MemberFind.me=member.action.MemberChangeAction<br>
/MemberOut.me=member.action.MemberChangeAction<br>
/Zipcode.me=member.action.MemberChangeAction<br>

if (command.equals("/MemberLogin.me")) {<br>
			af.setPath("./member/member_login.jsp");<br>
<br>
		} else if (command.equals("/MemberJoin.me")) {<br>
			af.setPath("./member/member_join.jsp");<br>
<br>
		} else if (command.equals("/MemberFind.me")) {<br>
			af.setPath("./member/member_find.jsp");<br>
<br>
		} else if (command.equals("/MemberOut.me")) {<br>
			af.setPath("./member/member_out.jsp");<br>
<br>
		} else if (command.equals("/Zipcode.me")) {<br>
			af.setPath("./member/member_zipcode.jsp");<br>
		}<br>
<br>
		if (af.getPath() == null) {<br>
			System.out.println("잘못된 명령입니다.");<br>
		}<br>


</body>
</html>