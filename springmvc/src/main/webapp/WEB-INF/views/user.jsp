<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" modelAttribute="user">
		<form:hidden path="guid" />
		<form:errors path="*" cssClass="text-warning" />
		<fieldset>
			<form:label path="name">Name</form:label>
			<form:input path="name" type="text" required="required" />
			<form:errors path="name" cssClass="text-warning"/>
		</fieldset>
		<fieldset>
			<form:label path="userId">User Id</form:label>
			<form:input path="userId" type="text" required="required" />
			<form:errors path="userId" cssClass="text-warning"/>
		</fieldset>
		
		<fieldset>
			<form:label path="password">password</form:label>
			<form:input path="password" type="password" required="required" />
			<form:errors path="password" cssClass="text-warning"/>
		</fieldset>
		
		<fieldset>
			<form:label path="password2">password2</form:label>
			<form:input path="password2" type="password" required="required" />
			<form:errors path="password2" cssClass="text-warning"/>
		</fieldset>
		
		<input class="btn btn-success" type="submit" value="Submit" />
	</form:form>
</body>
</html>