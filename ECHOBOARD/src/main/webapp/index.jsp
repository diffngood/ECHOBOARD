<%--
  Class Name : index.jsp
  Description : 최초화면으로 메인화면으로 이동한다.
  Modification Information
 
      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2025.04.03         경량환경 버전 생성
 
    author   : 실행환경 개발자 KWB
    since    : 2025.04.03
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
<jsp:forward page="/eb/main.do"/>
--%>
<script type="text/javaScript">document.location.href="<c:url value='/eb/main.do'/>"</script> 