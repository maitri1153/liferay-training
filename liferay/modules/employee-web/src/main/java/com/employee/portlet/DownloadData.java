package com.employee.portlet;

import java.io.IOException;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.employee.constants.EmployeeWebPortletKeys;
import com.employee.service.model.EmployeeDetail;
import com.employee.service.service.EmployeeDetailLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
		property = { 
			"javax.portlet.name =" + EmployeeWebPortletKeys.EMPLOYEEWEB,
			"mvc.command.name=/download" 
		}, service = MVCResourceCommand.class
	)

public class DownloadData implements MVCResourceCommand{

	@Reference
	EmployeeDetailLocalService employeeDetailLocalService;
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		
		long employeeId =  ParamUtil.getLong(resourceRequest,EmployeeWebPortletKeys.EMPLOYEE_ID);
		EmployeeDetail employee;
		try {
			resourceResponse.setContentType("application/pdf");
			employee = employeeDetailLocalService.getEmployeeDetail(employeeId);
			PortletResponseUtil.sendFile(resourceRequest, resourceResponse,"user.txt",employee.toString().getBytes(),"application/pdf");

			return false;
		} catch (PortalException | IOException e) {
			e.printStackTrace();
			return true;
		}
	}
}
