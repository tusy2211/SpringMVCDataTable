<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link href = "//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel = "stylesheet">
<script src = "//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script>
	$(function() {
		$(".datepicker").datepicker({
			altFormat: "yy-mm-dd",
			maxDate: "0d",
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<div class="container table-responsive">
    <div class="well lead">Add Employee</div>
<form:form method="post" modelAttribute="emp"  class="form-horizontal">
<form:input type="hidden" path="eId" id="eId"/>



			<div class="row">

				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="eName">Employee
						Name</label>
					<div class="col-md-7">
						<form:input type="text" path="eName" class="form-control input-sm" />

					</div>
				</div>
			</div>


			<div class="row">

				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="eGender">Status</label>
					<div class="col-md-7">
						<form:radiobutton path="eGender" value="0" />
						Male
						<form:radiobutton path="eGender" value="1" />
						Female
						<div class="has-error">
							<form:errors path="eGender" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="department">Dept</label>
					<div class="col-md-7">

						<form:select path="department.deptId" items="${eDept}"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="department" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">

				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="eBirthDay">Birth Day</label>
					<div class="col-md-7">
						<form:input type="text" path="eBirthDay" class="datepicker form-control input-sm" />

					</div>
				</div>
			</div>
			
			<div class="row">

				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="eEmail">Email</label>
					<div class="col-md-7">
						<form:input type="text" path="eEmail" class="form-control input-sm" />

					</div>
				</div>
			</div>
			
			<div class="row">

				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="eImage">Image</label>
					<div class="col-md-7">
						<form:input type="text" path="eImage" class="form-control input-sm" />

					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-actions floatLeft">
					<input type="submit" value="Save" id="btn"
						class="btn btn-primary btn-sm" /> <input type="reset"
						value="Reset" class="btn btn-primary btn-sm" />
						<a href="<c:url value='/emplist.do' />"
						class="btn btn-primary btn-sm"> Back
					</a>
				</div>
			</div>

		</form:form>
</div>


</body>
</html>