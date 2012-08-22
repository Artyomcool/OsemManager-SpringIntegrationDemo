<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Edit</title>
</head>
<body>
<h1>
	Edit:
</h1>
	<form:form modelAttribute="entity" action="save" method="post">
		<form:hidden path="id"/>
		<fieldset>
		
		    <div class="field">
			    <div class="label"><form:label path="name">College</form:label></div>
			    <div class="input"><form:input path="name" /></div>
		    </div>
		
    		<div class="field">
			    <div class="input"><input type="submit" value="Save" /></div>
		    </div>
		    
		</fieldset>
	</form:form>

</body>
</html>
