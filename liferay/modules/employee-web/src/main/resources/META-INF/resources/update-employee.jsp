<%@ include file="init.jsp"%>

<portlet:defineObjects />
<portlet:actionURL name="/updateEmployee" var="updateEmployeeActionURL"/>

<p class="employeeForm">Employee Form</p>

<aui:form action="<%=updateEmployeeActionURL%>" method="POST" name="employeeForm">

    <aui:input name="employeeId" type="hidden" value="${employee.employeeId}"/>
	<div class="row">
		<div class="col-5">
			<aui:input name="firstName" type="text" value="${employee.firstName}" label="First Name"/>
		</div>
	
		<div class="col-5">
			<aui:input name="lastName" type="text" value="${employee.lastName}" label="Last Name"/>
		</div>
	</div>
	
	<div class="col-10 p-0">
		<aui:input name="designation" type="text" value="${employee.designation}" label="Designation"/>
	</div>
	
	<div class="row">
		<div class="col-5">
			<aui:input name="email" type="text" value="${employee.email}" label="Email"/>
		</div>
	
		<div class="col-5">
			<aui:input name="phoneNumber" type="text" value="${employee.phoneNumber}" label="Phone"/>
		</div>
	</div>
	
	<div class="row">
		<div class="col-5">
			<aui:input name="addressLine1" type="text" value="${employee.addressLine1}" label="Address Line 1"/>
		</div>
	
		<div class="col-5">
			<aui:input name="addressLine2" type="text" value="${employee.addressLine2}" label="Address Line 2"/>
		</div>
	</div>
	
	<div class="row">
		<div class="col-5">
			<aui:input name="city" type="text" value="${employee.city}" label="City"/>
		</div>
	
		<div class="col-5">
			<aui:input name="zipCode" type="text" value="${employee.zipCode}" label="Post Code/ Zip Code"/>
		</div>
	</div>
	
	<div class="d-flex justify-content-end col-10 p-0 pt-4">	
		<aui:button type="submit" value="Submit" name="Submit"/>
	</div>
</aui:form>