<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@include file="_inc/title.jsp"%>
</head>
<body>
  <div class="login-container">
    <h2>관리자 로그인</h2>
    <form action="/admin/login" method="post">
      <label for="username">아이디</label>
      <input type="text" id="loginId" name="loginId" placeholder="아이디를 입력하세요" required>
      
      <label for="password">비밀번호</label>
      <input type="password" id="loginPass" name="loginPass" placeholder="비밀번호를 입력하세요" required>
      
      <button type="submit">로그인</button>
    </form>
    <div class="footer">
      Copyright(C) EchoBoard. All rights Reserved.
    </div>
  </div>
</body>
</html>
