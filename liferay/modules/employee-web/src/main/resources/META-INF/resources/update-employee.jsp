<%@ include file="init.jsp"%>

<portlet:defineObjects />
<portlet:actionURL name="/employee/updateEmployee" var="updateEmployeeActionURL"/>

<%
	String employeeId = renderRequest.getParameter("employeeId");
	/* String firstName = renderRequest.getParameter("firstName");
	String lastName = renderRequest.getParameter("lastName");
	String email = renderRequest.getParameter("email");
	String phoneNumber = renderRequest.getParameter("phoneNumber");
	String addressLine1 = renderRequest.getParameter("addressLine1");
	String addressLine2 = renderRequest.getParameter("addressLine2");
	String city = renderRequest.getParameter("city");
	String zipCode = renderRequest.getParameter("zipCode");
	String designation = renderRequest.getParameter("designation"); */
%>

<aui:form action="<%=updateEmployeeActionURL%>" method="POST" name="employeeForm">
	<aui:input name="employeeId" type="text" value="${employee.employeeId }"/>
	<aui:input name="firstName" type="text" value="${employee.firstName}"/>
	<aui:input name="lastName" type="text" value="${employee.lastName}" />
	<aui:input name="email" type="text" value="${employee.email}"/>
	<aui:input name="phoneNumber" type="text" value="${employee.phoneNumber}" />
	<aui:input name="addressLine1" type="text" value="${employee.addressLine1}"/>
	<aui:input name="addressLine2" type="text" value="${employee.addressLine2}"/>
	<aui:input name="city" type="text" value="${employee.city}"/>
	<aui:input name="zipCode" type="text" value="${employee.zipCode}"/>
	<aui:input name="designation" type="text" value="${employee.designation}"/>
	<aui:button type="submit" value="Submit" name="Submit"></aui:button>
</aui:form>