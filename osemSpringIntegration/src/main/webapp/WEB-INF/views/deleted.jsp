<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Deleted</title>
</head>
<body>
<h1>
	Deleted:
</h1>
	<table>
	    <tr>
	        <td><c:out value="${entity.id}" /></td>
	        <td><c:out value="${entity.name}" /></td>
	    </tr>
	</table>
	<c:url var="home" value=""/>
	<a href="<c:out value="${home}"/>">Home</a>

</body>
</html>
