<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@include file="_inc/title.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("input[type='text']").keyup(function(e) {
			if(e.keyCode == "13") {
				login();
			}
		});
		
		$("input[type='password']").keyup(function(e) {
			if(e.keyCode == "13") {
				login();
			}
		});
		
		readCookie();	
	});
	
	function login() {
		if ($("#loginId").val() == "") {
			alert("아이디를 입력하세요.");
			$("#loginId").focus();
			return;
		}
		if ($("#loginPass").val() == "") {
			alert("비밀번호를 입력하세요.");
			$("#loginPass").focus();
			return;
		}

		if (checkChecked("save_id", "checkbox")) {
			setCookie("idCook", $("#loginId").val(), 10);
		} else {
			deleteCookie("idCook");
		}

		$("#login_frm").submit();
	}
	
	function getCookie(cookieName){
		var search = cookieName + "=";
		var cookie = document.cookie;

		if( cookie.length > 0 ){
		startIndex = cookie.indexOf( cookieName );

		 	if( startIndex != -1 ){
				startIndex += cookieName.length;
				endIndex = cookie.indexOf( ";", startIndex );
		
				if( endIndex == -1) endIndex = cookie.length;
				return unescape( cookie.substring( startIndex + 1, endIndex ) );
		  	}else{
				return false;
		  	}
		}else{
			return false;
		}
	}
	
	function setCookie(cookieName, cookieValue, expireDate){
		var today = new Date();
		today.setDate( today.getDate() + parseInt( expireDate ) );
		document.cookie = cookieName + "=" + escape( cookieValue ) + "; path=/; expires=" + today.toGMTString() + ";";
	}

	function readCookie(){
		if(getCookie("idCook")!=false){
			$("input:checkbox[id='save_id']").attr("checked", true);
			$("input:checkbox[id='save_id']").parent().addClass("checked");
			$("#loginId").val(getCookie("idCook"));
			$("#loginPass").focus();
		}else{
			$("#loginId").focus();
		}
	}

	function deleteCookie(cookieName){
		var expireDate = new Date();
		expireDate.setDate( expireDate.getDate() - 1 );
		document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString() + "; path=/";
	}
</script>
</head>
<body>
	<div class="login-container">
		<h2>관리자 로그인</h2>
		<form name="login_frm" id="login_frm" method="post" action="<c:url value='/adm/actionLogin.do'/>" >
			<label for="username">아이디</label>
			<input type="text" id="loginId" name="loginId" placeholder="아이디를 입력하세요" required>
	      
			<label for="password">비밀번호</label>
			<input type="password" id="loginPass" name="loginPass" placeholder="비밀번호를 입력하세요" required>
	      
			<div class="remember-me">
				<input type="checkbox" id="save_id"  name="save_id">
				<label for="remember">아이디 저장하기</label>
			</div>
	      
			<button type="button" onclick="javascript:login();">로그인</button>
		</form>
		<div class="footer">
			Copyright(C) EchoBoard. All rights Reserved.
		</div>
	</div>
</body>
</html>
