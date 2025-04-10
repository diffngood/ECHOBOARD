<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${!empty message}">
	<script>alert('${message}');</script>
</c:if>
<c:if test="${!empty returnUrl}">
	<c:choose><c:when test="${returnUrl eq 'history.back(-1)'}">
	<script>${returnUrl};</script>
	</c:when><c:otherwise>
	<script>location.replace('${returnUrl}');</script>
	</c:otherwise></c:choose>
</c:if>