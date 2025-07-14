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
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserGroupRoleLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

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

	private static final Log log = LogFactoryUtil.getLog(EmployeeWebPortlet.class);
	
	@Reference
	EmployeeDetailLocalService employeeDetailLocalService;
	
	@Reference
	UserGroupRoleLocalService userGroupRoleLocalService;
	
	@Reference
	RoleLocalService roleLocalService;
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {
			
			log.info("Render method is started");
			
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			long groupId = themeDisplay.getScopeGroupId();
			long companyId = themeDisplay.getCompanyId();
			Role hrRole = roleLocalService.getRole(companyId, EmployeeWebPortletKeys.HR);
			boolean isHr = userGroupRoleLocalService.hasUserGroupRole(userId, groupId, hrRole.getRoleId());

			renderRequest.setAttribute("isHr", isHr);
			
			List<EmployeeDetail> employees = employeeDetailLocalService.getEmployeeDetails(-1, -1);
			renderRequest.setAttribute("employeeList", employees);
			
			log.info("EmployeeList attribute is set");
			
			super.render(renderRequest, renderResponse);
		}catch(Exception e) {
			log.error("Error while fetching employee data : "+ e);
		}
	}
}