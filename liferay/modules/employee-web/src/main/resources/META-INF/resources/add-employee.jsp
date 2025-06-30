<%@ include file="init.jsp"%>

<portlet:defineObjects />
<portlet:actionURL name="/addEmployee" var="addEmployeeActionURL"/>

<h2>Employee Form</h2>

<aui:form action="<%=addEmployeeActionURL%>" name="employeeForm" method="POST">

	<aui:input name="firstName" >
 		<aui:validator name="required"/>
 		<aui:validator name="required"/>
	</aui:input>
	
	<aui:input name="lastName" >
 		<aui:validator name="required"/>
 		<aui:validator name="required"/>
	</aui:input>
	
	<aui:input name="designation" >
 		<aui:validator name="required"/>
 		<aui:validator name="alpha"/>
	</aui:input>
	
	<aui:input name="email">
 		<aui:validator name="required"/>
 		<aui:validator name="required"/>
	</aui:input>

	<aui:input name="phoneNumber">
 		<aui:validator name="required"/>
 		<aui:validator name="digits"/>
	</aui:input>
	
	<aui:input name="addressLine1">
 		<aui:validator name="required"/>
 		<aui:validator name="required"/>
	</aui:input>
	
	<aui:input name="addressLine2">
 		<aui:validator name="required"/>
 		<aui:validator name="required"/>
	</aui:input>
	
	<aui:input name="city">
 		<aui:validator name="required"/>
 		<aui:validator name="alpha"/>
	</aui:input>
	
	<aui:input name="zipCode">
 		<aui:validator name="required"/>
 		<aui:validator name="number"/>
	</aui:input>
	
	<aui:button type="submit" value="submit" name="submit"></aui:button>

</aui:form>