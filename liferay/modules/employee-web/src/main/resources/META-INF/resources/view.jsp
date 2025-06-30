<%@ include file="init.jsp"%>

<portlet:defineObjects />

<portlet:renderURL var="addEmployeeRenderURL">
	<portlet:param name="mvcPath" value="/add-employee.jsp"/>
</portlet:renderURL>

<div class="mb-5">
	<a href="<%=addEmployeeRenderURL%>" class="btn  btn-primary btn-default"> 
		<i class="glyphicon glyphicon-plus"></i> 
		Add Employee
	</a>
</div>

<table class="table table-striped">
	<tr>
		<th>Id</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Phone Number</th>
		<th>Address Line 1</th>
		<th>Address Line 2</th>
		<th>City</th>
		<th>Zip-Code</th>
		<th>Designation</th>
		<th colspan="2" style="width: 100px">Action</th>
	</tr>
	
	<c:forEach var="employee" items="${employeeList}">

		<portlet:renderURL var="updateEmployeeRenderURL">
			<portlet:param name="mvcPath" value="/update-employee.jsp" />
			<portlet:param name="firstName" value="${employee.firstName}" />
			<portlet:param name="lastName" value="${employee.lastName}" />
			<portlet:param name="phoneNumber" value="${employee.phoneNumber}" />
			<portlet:param name="city" value="${employee.city}" />
			<portlet:param name="email" value="${employee.email}" />
			<portlet:param name="addressLine1" value="${employee.addressLine1}" />
			<portlet:param name="addressLine2" value="${employee.addressLine2}" />
			<portlet:param name="zipCode" value="${employee.zipCode}" />
			<portlet:param name="designation" value="${employee.designation}" />
			<portlet:param name="employeeId" value="${employee.employeeId}" />
		</portlet:renderURL>

		<portlet:actionURL name="/deleteEmployee" var="deleteEmployeeActionURL">
			<portlet:param name="employeeId" value="${employee.employeeId}" />
		</portlet:actionURL>

		<tr>
			<td>${employee.employeeId}</td>
			<td>${employee.firstName}</td>
			<td>${employee.lastName}</td>
			<td>${employee.email}</td>
			<td>${employee.phoneNumber}</td>
			<td>${employee.addressLine1}</td>
			<td>${employee.addressLine2}</td>
			<td>${employee.city}</td>
			<td>${employee.zipCode}</td>
			<td>${employee.designation}</td>

			<td class="text-center" style="width: 50px">
				<a href="<%=updateEmployeeRenderURL%>" class="btn btn-default btn-sm px-2 py-1"> 
					<i class="glyphicon glyphicon-edit"></i>
				</a>
			</td>

			<td class="text-center" style="width: 50px">
				<a href="<%=deleteEmployeeActionURL%>" class="btn btn-default btn-sm px-2 py-1"
					onclick="return confirm('Are you sure you want to delete this item?');">
					<i class="glyphicon glyphicon-remove"></i>
				</a>
			</td>
		</tr>
	</c:forEach>
</table>