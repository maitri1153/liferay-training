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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

@Component(
	property = { 
		"javax.portlet.name =" + EmployeeWebPortletKeys.EMPLOYEEWEB,
		"mvc.command.name=/updateEmployee"
	}, service = MVCActionCommand.class
)

public class UpdateEmployeeAction extends BaseMVCActionCommand{

	private static Log log = LogFactoryUtil.getLog(UpdateEmployeeAction.class);
	
	@Reference
	CounterLocalService counterLocalService;

	@Reference
	EmployeeDetailLocalService employeedetailLocalService;
	
	@Reference
	UserLocalService userLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) 
			throws Exception {
		
		log.info("Update Action method is started");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		
		long employeeId = ParamUtil.getLong(actionRequest, EmployeeWebPortletKeys.EMPLOYEE_ID, GetterUtil.DEFAULT_LONG);
		String firstName = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.FIRSTNAME, GetterUtil.DEFAULT_STRING);
		String lastName = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.LASTNAME, GetterUtil.DEFAULT_STRING);
		String email = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.EMAIL, GetterUtil.DEFAULT_STRING);
		long phoneNumber = ParamUtil.getLong(actionRequest, EmployeeWebPortletKeys.PHONE_NUMBER,GetterUtil.DEFAULT_LONG);
		String addressLine1 = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.ADDRESS_LINE1, GetterUtil.DEFAULT_STRING);
		String addressLine2 = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.ADDRESS_LINE2, GetterUtil.DEFAULT_STRING);
		String city = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.CITY, GetterUtil.DEFAULT_STRING);
		long zipCode = ParamUtil.getLong(actionRequest, EmployeeWebPortletKeys.ZIPCODE,GetterUtil.DEFAULT_LONG);
		String designation = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.DESIGNATION, GetterUtil.DEFAULT_STRING);

		EmployeeDetail employee = null;
			employee = employeedetailLocalService.getEmployeeDetail(employeeId);
			employee.getEmail();
			
		    User user =	userLocalService.getUserByEmailAddress(companyId, email);

		if (Validator.isNotNull(employee)) {
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setEmail(email);
			employee.setPhoneNumber(phoneNumber);
			employee.setAddressLine1(addressLine1);
			employee.setAddressLine2(addressLine2);
			employee.setCity(city);
			employee.setZipCode(zipCode);
			employee.setDesignation(designation);
			employeedetailLocalService.updateEmployeeDetail(employee);
			log.info("Employee Detail is updated");
		}
		
		if(Validator.isNotNull(user)) {
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmailAddress(email);
			user.setJobTitle(designation);
			userLocalService.updateUser(user);
		}
	}
}
