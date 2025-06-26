package com.employee.action;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;

import com.employee.constants.EmployeeWebPortletKeys;
import com.employee.service.model.EmployeeDetail;
import com.employee.service.service.EmployeeDetailLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

@Component(
	configurationPolicy = ConfigurationPolicy.OPTIONAL, 
	immediate = true, 
	property = {
		"javax.portlet.name=" + EmployeeWebPortletKeys.EMPLOYEEWEB, 
	}, service = Portlet.class
)

public class EmployeeAction extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(EmployeeAction.class);
	
	@Reference
	EmployeeDetailLocalService employeedetailLocalService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		List<EmployeeDetail> employeeList = employeedetailLocalService.getEmployeeDetails(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute("employeeList", employeeList);
		
		log.info(employeeList);
		super.render(renderRequest, renderResponse);
	}

}
