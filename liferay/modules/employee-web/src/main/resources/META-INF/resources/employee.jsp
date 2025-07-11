<%@ include file="init.jsp"%>

<portlet:defineObjects />
<portlet:actionURL name="/addEmployee" var="addEmployeeActionURL" />

<div class="bg-white mt-3 addEmployeePage">
	<div class="empFormDiv">
	
		<p class="employeeForm">Employee Form</p>

		<aui:form action="<%=addEmployeeActionURL%>" name="employeeForm"
			method="POST" class="w-75">

			<div class="d-none">
				<aui:input name="employeeId" value="${employee.employeeId}"
					label="employeeId" type="text">
				</aui:input>
			</div>

			<div class="row">
				<div class="col-6">
					<aui:input name="firstName" placeholder="Enter your first name"
						label="First Name" value="${employee.firstName}">
						<aui:validator name="required" />
					</aui:input>
				</div>

				<div class="col-6">
					<aui:input name="lastName" placeholder="Enter your last name"
						label="Last Name" value="${employee.lastName}">
						<aui:validator name="required" />
					</aui:input>
				</div>
			</div>

			<div>
				<aui:input name="designation" placeholder="Enter your designation"
					label="Designation" value="${employee.designation}">
					<aui:validator name="required" />
					<aui:validator name="alpha" />
				</aui:input>
			</div>

			<div class="row">
				<div class="col-6">
					<aui:input name="email" placeholder="Enter your email"
						label="Email" value="${employee.email}">
						<aui:validator name="required" />
						<aui:validator name="email" />
					</aui:input>
				</div>

				<div class="col-6">
					<aui:input name="phoneNumber" placeholder="Enter your phone number"
						label="Phone" value="${employee.phoneNumber}">
						<aui:validator name="required" />
						<aui:validator name="digits" />
					</aui:input>
				</div>
			</div>

			<div class="row">
				<div class="col-6">
					<aui:input name="addressLine1"
						placeholder="Enter your house no / Bldg. / Appt."
						label="Address Line 1" value="${employee.addressLine1}">
						<aui:validator name="required" />
					</aui:input>
				</div>

				<div class="col-6">
					<aui:input name="addressLine2"
						placeholder="Enter your street / lane / area"
						label="Address Line 2" value="${employee.addressLine2}">
						<aui:validator name="required" />
					</aui:input>
				</div>
			</div>

			<div class="row">
				<div class="col-6">
					<aui:input name="city" placeholder="Enter your city" value="${employee.city}">
						<aui:validator name="required" />
						<aui:validator name="alpha" />
					</aui:input>
				</div>

				<div class="col-6">
					<aui:input name="zipCode" placeholder="Enter your post code/ zip code"
						label="Post Code/ Zip Code" value="${employee.zipCode}">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input>
				</div>
			</div>

			<div class="d-flex justify-content-end">
				<aui:button type="submit" value="SUBMIT" name="submit" />
			</div>
		</aui:form>
	</div>
</div>