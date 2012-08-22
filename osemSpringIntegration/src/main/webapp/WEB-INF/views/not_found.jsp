<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Not found</title>
</head>
<body>
<h1>
	The entity with id=<c:out value="${id}" /> not found!
</h1>
	<c:url var="home" value=""/>
	<a href="<c:out value="${home}"/>">Home</a>

</body>
</html>
