<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello OSEM!  
</h1>
	<table>
	<c:forEach items="${entities}" var="college">
		<c:url var="editUrl" value="edit">
		  <c:param name="id" value="${college.id}"/>
		</c:url>
		<c:url var="deleteUrl" value="delete">
		  <c:param name="id" value="${college.id}"/>
		</c:url>
	    <tr>
	        <td><c:out value="${college.id}" /></td>
	        <td><c:out value="${college.name}" /></td>
	        <td><a href="<c:out value="${editUrl}"/>">Edit</a></td>
	        <td><a href="<c:out value="${deleteUrl}"/>">Delete</a></td>
	    </tr>
	</c:forEach>
	</table>
	
	<c:url var="addUrl" value="add"/>
	<a href="<c:out value="${addUrl}"/>">Add</a>

</body>
</html>
