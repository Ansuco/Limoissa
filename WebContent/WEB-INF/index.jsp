<%@ page language="java" contentType="text/html;charset=ISO-8859-1"
    pageEncoding="UTF-8"
 %>
 
<jsp:include page="fragments/head.jsp" />
<body>
	<jsp:include page="redirect.jsp" >
		<jsp:param value="${actionName}" name="actionName" />
	</jsp:include>

</body>