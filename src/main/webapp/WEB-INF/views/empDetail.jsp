<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Detail</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="well lead">Employee Detail</div>

		<form:form method="post" modelAttribute="employee"
			class="form-horizontal">
			<form:input type="hidden" path="eId" id="eId" />

			<div style="margin: 10px;" class="table-responsive">
				<div>
					<label for="usr">Name:</label> <input type="text"
						value="${employee.eName}" class="form-control" id="usr">
				</div>

				<div><c:choose>
					<c:when test="${employee.eGender==1}">
						<label for="usr">Gender:</label> <input type="text"
						value="Female" class="form-control" id="usr">
					</c:when>
					<c:otherwise>
						<label for="usr">Gender:</label> <input type="text"
						value="Male" class="form-control" id="usr">
					</c:otherwise>
					
					</c:choose>
				</div>

				<div>
					<label for="usr">Dept:</label> <input type="text"
						value="${employee.department.deptName}" class="form-control"
						id="usr">
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>