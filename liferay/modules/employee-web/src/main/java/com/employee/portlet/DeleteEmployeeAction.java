package com.employee.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.employee.constants.EmployeeWebPortletKeys;
import com.employee.service.model.EmployeeDetail;
import com.employee.service.service.EmployeeDetailLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
	property = { 
		"javax.portlet.name =" + EmployeeWebPortletKeys.EMPLOYEEWEB,
		"mvc.command.name=/deleteEmployee", 
	}, service = MVCActionCommand.class
)

public class DeleteEmployeeAction extends BaseMVCActionCommand {

	private static Log log = LogFactoryUtil.getLog(DeleteEmployeeAction.class);

	@Reference
	CounterLocalService counterLocalService;

	@Reference
	EmployeeDetailLocalService employeedetailLocalService;
	
	@Reference
	UserLocalService userLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) 
			throws Exception {
		
		log.info("Delete Action method is started");
		
		long employeeId = ParamUtil.getLong(actionRequest, EmployeeWebPortletKeys.EMPLOYEE_ID, GetterUtil.DEFAULT_LONG);
		
		try {
			EmployeeDetail employee = employeedetailLocalService.getEmployeeDetail(employeeId);
			long userId = employee.getUserId();
			employeedetailLocalService.deleteEmployeeDetail(employeeId);
			userLocalService.deleteUser(userId);
			
			log.info("Employee data is deleted");
		} catch (Exception e) {
			log.error("error in deleteActionCommand");
		}
	}
}
