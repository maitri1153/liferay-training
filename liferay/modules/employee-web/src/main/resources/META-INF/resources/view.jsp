<%@ include file="init.jsp"%>

<% List<EmployeeDetail> employees = (List<EmployeeDetail>) request.getAttribute("employeeList"); %>

<portlet:renderURL var="addEmployeeRenderURL">
	<portlet:param name="mvcPath" value="/employee.jsp" />
</portlet:renderURL>

<div class="employeeList">

	<div class="addEmpDiv pt-2">
		<p class="float-left employeeText">Employees</p>
		<a href="<%=addEmployeeRenderURL%>"
			class="btn btn-default addEmpButton"> 
				ADD NEW EMPLOYEE 
		</a>
	</div>

	<liferay-ui:search-container total="<%=employees.size()%>"
		var="searchContainer" delta="8" deltaConfigurable="true"
		emptyResultsMessage="Oops. There Are No Users To Display, Please add Employees">

		<liferay-ui:search-container-results
			results="<%=ListUtil.subList(employees, searchContainer.getStart(), searchContainer.getEnd())%>"/>

		<liferay-ui:search-container-row
			className="com.employee.service.model.EmployeeDetail"
			modelVar="employee" keyProperty="employeeId">

			<portlet:renderURL var="updateEmployeeRenderURL">
				<portlet:param name="mvcPath" value="/employee.jsp" />
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

			<portlet:actionURL name="/deleteEmployee"
				var="deleteEmployeeActionURL">
				<portlet:param name="employeeId" value="${employee.employeeId}" />
			</portlet:actionURL>
			
			<portlet:resourceURL id="/download" var="downloadURL" >
				<portlet:param name="employeeData" value="${employee}"/>
			</portlet:resourceURL>

			<liferay-ui:search-container-column-text name="Employee ID"
				value="${employee.employeeId}" />

			<liferay-ui:search-container-column-text name="Name"
				value="${employee.firstName} ${employee.lastName}" />

			<liferay-ui:search-container-column-text name="Designation"
				property="designation" value="${employee.designation}" />

			<liferay-ui:search-container-column-text name="Phone"
				property="phoneNumber" value="${employee.phoneNumber}" />

			<liferay-ui:search-container-column-text name="Email"
				property="email" value="${employee.email}" />

			<liferay-ui:search-container-column-text name="City" property="city"
				value="${employee.city }" />


			<liferay-ui:search-container-column-text name="Actions">
				<div class="icon-container">
					<liferay-ui:icon image="edit" message="Edit"
						url="<%=updateEmployeeRenderURL%>" />
					<button type="button" class="btn" data-toggle="modal"
						data-target="#exampleModal"><i class="bi bi-trash text-info"></i></button>
					<button type="button" class="btn">
					<i class="bi bi-download text-info"></i></button>
				</div>
			</liferay-ui:search-container-column-text>
			
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<p class="popupText">Are you sure, you want to delete this
					employee ?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn noBtn" data-dismiss="modal">NO</button>
				<a href="<%=deleteEmployeeActionURL%>"><button type="button"
						class="btn yesBtn">YES</button></a>
			</div>
		</div>
	</div>
</div>