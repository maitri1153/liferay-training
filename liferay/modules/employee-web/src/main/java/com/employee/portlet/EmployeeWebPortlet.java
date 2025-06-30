package com.employee.portlet;

import java.io.IOException;
import java.util.List;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.employee.constants.EmployeeWebPortletKeys;
import com.employee.service.model.EmployeeDetail;
import com.employee.service.service.EmployeeDetailLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

@Component(
	property = { 
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EmployeeWeb", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmployeeWebPortletKeys.EMPLOYEEWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	}, service = Portlet.class
)

public class EmployeeWebPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(EmployeeWebPortlet.class);
	
	@Reference
	EmployeeDetailLocalService employeedetailLocalService;
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		log.info("Render method is started");
		
		List<EmployeeDetail> employees = employeedetailLocalService.getEmployeeDetails(-1, -1);
		renderRequest.setAttribute("employeeList", employees);
		
		log.info("EmployeeList attribute is set");
		
		super.render(renderRequest, renderResponse);
	}
}