<%@ include file="init.jsp"%>

<portlet:defineObjects />
<portlet:actionURL name="/addEmployee" var="addEmployeeActionURL"/>

<p class="employeeForm">Employee Form</p>

<aui:form action="<%=addEmployeeActionURL%>" name="employeeForm" method="POST" class="w-75">

	<div class="row">
		<div class="col-5">
			<aui:input name="firstName" >
 				<aui:validator name="required"/>
 				<aui:validator name="required"/>
			</aui:input>
		</div>
	
		<div class="col-5">
			<aui:input name="lastName" >
 				<aui:validator name="required"/>
 				<aui:validator name="required"/>
			</aui:input>
		</div>
	</div>
	
	<div class="col-10 p-0">
		<aui:input name="designation">
  	 		<aui:validator name="required"/>
 			<aui:validator name="alpha"/>
		</aui:input>
	</div>
	
	<div class="row">
		<div class="col-5">
			<aui:input name="email">
 				<aui:validator name="required"/>
 				<aui:validator name="required"/>
			</aui:input>
		</div>
		
		<div class="col-5">
			<aui:input name="phoneNumber">
 				<aui:validator name="required"/>
 				<aui:validator name="digits"/>
			</aui:input>
		</div>
	</div>
	
	<div class="row"> 
		<div class="col-5">
			<aui:input name="addressLine1">
 				<aui:validator name="required"/>
 				<aui:validator name="required"/>
			</aui:input>
		</div>
		
		<div class="col-5">
			<aui:input name="addressLine2">
 				<aui:validator name="required"/>
 				<aui:validator name="required"/>
			</aui:input>
		</div>
	</div>
	
	<div class="row">
		<div class="col-5">
			<aui:input name="city">
 				<aui:validator name="required"/>
 				<aui:validator name="alpha"/>
			</aui:input>
		</div>
		
		<div class="col-5">
			<aui:input name="zipCode">
 				<aui:validator name="required"/>
 				<aui:validator name="number"/>
			</aui:input>
		</div>
	</div>
	
	<div class="d-flex justify-content-end col-10 p-0 pt-4">
		<aui:button type="submit" value="SUBMIT" name="submit"/>
	</div>

</aui:form>