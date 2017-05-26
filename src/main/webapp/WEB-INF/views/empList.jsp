<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>

<link rel="stylesheet" href='<c:url value="/resources/lib/bootstrap-3.3.6/css/bootstrap.css" />' >
<script src='<c:url value= "/resources/lib/bootstrap-3.3.6/js/jquery-2.2.3.min.js" />' ></script>
<script src='<c:url value="/resources/lib/bootstrap-3.3.6/js/jquery-ui.js" />' ></script>
<script type="text/javascript"
	src='<c:url value="/resources/lib/bootstrap-3.3.6/js/jquery.popconfirm.js"/>'></script>
<script src='<c:url value="/resources/lib/bootstrap-3.3.6/js/bootstrap.min.js" />'  ></script>
<link rel="stylesheet"
	href='<c:url value="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" />'  >
<script
	src='<c:url value="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js" />' ></script>
<script type="text/javascript"
	src='<c:url value="/resources/lib/bootstrap-3.3.6/js/dataTables.checkboxes.min.js"/>'></script>	

<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable({
			"lengthMenu": [ 4, 15, 25, 50, 100],
		    "responsive": true,
		    "destroy": true,
		    "paginationType" : "full_numbers",
		    "processing" : false,
		    "serverSide" : false,
		    "bFilter": true,
		    "paging" :true,
		    "bLengthChange": true,
		    "bPaginate": true,
		    "pageLength": 15,
		    "bSort" : true,
		    "autoWidth": true,
		    'columnDefs': [
                {
                   'targets': 0,
                   'checkboxes': {
                      'selectRow': true
                   }
                }
             ],
             'select': {
                'style': 'multi'
             },
             'order': [[1, 'asc']]
		});

	});
</script>

</head>
<body>
<%@include file="authheader.jsp"%>
<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">
		<span class="lead">Employees</span>
	</div>
	<table id="example" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Employee Id</th>
				<th>Name</th>
				<th>Gender</th>
				<th>Department</th>
				<th>BirthDay</th>
				<th>Email</th>
				<th>Image</th>
				<th width="100"></th>
				<th width="100"></th>
				<th width="100"></th>
				<th width="100"></th>
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${emplist}" var="em">

					<tr>
						<td>${em.eId}</td>
						<td>${em.eName}</td>
						<c:choose>
							<c:when test="${em.eGender==1}">
								<td>Female</td>
								<br />
							</c:when>
							<c:otherwise>
								<td>Male</td>
								<br />
							</c:otherwise>
						</c:choose>

						<td>${em.department.deptName}</td>
						<td>${em.eBirthDay}</td>
						<td>${em.eEmail}</td>
						<td>${em.eImage}</td>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<td><a href="<c:url value='/edit-emp-${em.eId}' />"
								class="btn btn-success custom-width">edit</a></td>
							<td><a href="<c:url value='/delete-emp-${em.eId}' />"
								class="del btn btn-danger custom-width">delete</a></td>
						</sec:authorize>
						<td><a href="<c:url value='/detail-emp-${em.eId}' />"
							class="btn btn-info custom-width">Detail</a></td>
						<td><input type="button" onclick="anomalieTotalizzatoriss()" /> </td>
					</tr>

				</c:forEach>
			</tbody>
		</table>

</div>
 <!--  popup detail -->
 
 <div aria-hidden="true" aria-labelledby="totalizzatori" role="dialog"
		tabindex="-1" id="totalizzatori" class="modal fade"
		style="display: none;">
		<div class="modal-dialog" style="margin-top: 150px;">

			<div class="modal-content">
				<div class="modal-header">
					<button aria-hidden="true" data-dismiss="modal" class="close"
						type="button">×</button>
					<h4 id="modalLabelTotalizzatori" class="modal-title">Totalizzatori</h4>
				</div>
				<div class="modal-body">
						
				</div>
				<div class="modal-footer" style="border: 0px;">
					<div style="padding-left: 0px;">
						<button id="callAnnullaContestazioniButton" onclick="onClickAnnulla_Totalizzatoriss()"
							type="button" style="float: right;">Cancel</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
	</div>

<sec:authorize access="hasRole('ROLE_ADMIN')">
			<div class="well">
				<a href="<c:url value='/addemp.do' />">Add New Employee</a>
			</div>
			<div class="well">
				<a href="<c:url value='/newuser' />">Add New User</a>
			</div>
		</sec:authorize>



<!-- 	<script type="text/javascript" -->
<%-- 		src='<c:url value="/resources/lib/jquery/jquery-ui-1.10.4.custom.js"/>'></script> --%>
<!-- 	<script type="text/javascript" -->
<%-- 		src='<c:url value="/resources/lib/bootstrap-3.3.6/js/bootstrap.min.js"/>'></script> --%>

	<script type="text/javascript">
		// Delete confirmation
		$(".del").popConfirm({
			title : "Delete",
			content : "Are you sure you want to delete this item?",
			placement : "top"
		});
		
		// detail popup
		function anomalieTotalizzatoriss() {
			$("#totalizzatori").modal('show');
		}
		
		function onClickAnnulla_Totalizzatoriss() {
			$('#totalizzatori').modal('hide');
		}
	</script>

</body>

</html>