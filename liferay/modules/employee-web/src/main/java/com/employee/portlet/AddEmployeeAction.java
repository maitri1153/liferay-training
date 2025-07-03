package com.employee.portlet;

import java.util.Locale;

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
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

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
	
	@Reference
	UserLocalService userLocalService;
	
	@Reference
	RoleLocalService roleLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) 
			throws Exception {
		
		log.info("Add Employee action method is started");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long groupId = themeDisplay.getScopeGroupId();

		long companyId = themeDisplay.getCompanyId();
		
		long currentuserId = themeDisplay.getUserId();
		
		User currentUser = themeDisplay.getUser(); 
		
		String currentUserName = currentUser.getScreenName();
	
		Role role = roleLocalService.getRole(companyId,EmployeeWebPortletKeys.EMPLOYEE);
		long roleId = role.getRoleId();
		long[] roleIds = new long[5];
		roleIds[0]  = roleId;
		
		long[] groupIds = new long[5];
		groupIds[0] = groupId;
		
		long[] organizationIds = new long[5];
		organizationIds = null;
		
		long[] userGroupIds = new long[5];
		userGroupIds = null;
		
		String password1 ="test";
		
		String password2="test";
		
		Locale locale = LocaleUtil.getDefault();
		boolean autoScreenName = true;
		
		boolean autoPassword = false;
		
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
		
		String screenName =firstName + " " + lastName;
		
		String middleName =" ";
		
		int birthDay =11;
		
		int birthYear = 2000;
		
		int birthMonth = 05;
		
		int type =0;
		
		boolean male =false;
		
		boolean sendMail =false;
		
		ServiceContext serviceContext = new ServiceContext();
		serviceContext = null;
		
		User user = userLocalService.addUser(currentuserId, companyId, autoPassword, password1, 
				password2, autoScreenName, screenName, email,locale, firstName,middleName, lastName, -1, -1, 
				male,birthMonth, birthDay,birthYear, designation, type, groupIds, organizationIds, roleIds, userGroupIds, 
				sendMail, serviceContext);
		user.setStatus(WorkflowConstants.STATUS_APPROVED);
		user.setPasswordEncrypted(false);
		userLocalService.updateUser(user);
		
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
		employee.setGroupId(groupId);
		employee.setUserId(currentuserId);
		employee.setUserName(currentUserName);
		
		employeedetailLocalService.addEmployeeDetail(employee);
		
		log.info("Employee data is inserted");
	}
}
