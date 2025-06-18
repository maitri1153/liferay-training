<%@ include file="init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="<%=true%>" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="<%=true%>" var="configurationRenderURL" />

<aui:form action="<%=configurationActionURL%>" method="post" name="fm">
    <aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />
	<aui:input name="redirect" type="hidden" value="<%=configurationRenderURL%>" />

	<aui:fieldset>
		<aui:select label="category" name="category" value="<%=category%>">
			<aui:option value="Image">Image</aui:option>
			<aui:option value="User">User</aui:option>
			<aui:option value="Technology">Technology</aui:option>
			<aui:option value="Employee">Employee</aui:option>
		</aui:select>
	</aui:fieldset>
    
	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>
