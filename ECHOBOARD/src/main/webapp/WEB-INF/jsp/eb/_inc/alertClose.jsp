<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${!empty message}">
	<script>alert('${message}');</script>
</c:if>
<script>
try {
	var openwin = window.open( 'proc_win.html', 'proc_win', '' );
	openwin.close();
}
catch(e) {}
self.close();
</script>