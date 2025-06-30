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
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
	property = { 
		"javax.portlet.name =" + EmployeeWebPortletKeys.EMPLOYEEWEB,
		"mvc.command.name=/addEmployee"
	}, service = MVCActionCommand.class
)

public class AddEmployeeAction extends BaseMVCActionCommand {

	private static Log log = LogFactoryUtil.getLog(AddEmployeeAction.class);
	
	@Reference
	CounterLocalService counterLocalService;

	@Reference
	EmployeeDetailLocalService employeedetailLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) 
			throws Exception {
		
		log.info("Add Employee action method is started");
		
		long employeeId = counterLocalService.increment(EmployeeDetail.class.getName());
		String firstName = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.FIRSTNAME);
		String lastName = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.LASTNAME);
		String email = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.EMAIL);
		long phoneNumber = ParamUtil.getLong(actionRequest, EmployeeWebPortletKeys.PHONE_NUMBER);
		String addressLine1 = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.ADDRESS_LINE1);
		String addressLine2 = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.ADDRESS_LINE2);
		String city = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.CITY);
		long zipCode = ParamUtil.getLong(actionRequest, EmployeeWebPortletKeys.ZIPCODE);
		String designation = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.DESIGNATION);

		EmployeeDetail employee = employeedetailLocalService.createEmployeeDetail(employeeId);
		employee.setEmployeeId(employeeId);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		employee.setPhoneNumber(phoneNumber);
		employee.setAddressLine1(addressLine1);
		employee.setAddressLine2(addressLine2);
		employee.setCity(city);
		employee.setZipCode(zipCode);
		employee.setDesignation(designation);
		
		employeedetailLocalService.addEmployeeDetail(employee);
		
		log.info("Employee data is inserted");
	}
}
