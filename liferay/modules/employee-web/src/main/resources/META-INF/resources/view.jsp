<%@ include file="init.jsp" %>

<portlet:defineObjects />

<portlet:renderURL var="addEmployeeRenderURL">
    <portlet:param name="mvcPath" value="/add-employee.jsp"/>
</portlet:renderURL>

<div class="mb-5">
    <a href="<%= addEmployeeRenderURL %>" class="btn  btn-primary btn-default">
        <i class="glyphicon glyphicon-plus"></i> Add Employee
    </a>
</div>
