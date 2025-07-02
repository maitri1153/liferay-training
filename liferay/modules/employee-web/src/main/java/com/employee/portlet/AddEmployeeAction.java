package com.employee.portlet;

import java.util.Date;
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
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

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
	
	@Reference
	GroupLocalService groupLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) 
			throws Exception {
		
		log.info("Add Employee action method is started");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long groupId = themeDisplay.getScopeGroupId();

		long companyId = themeDisplay.getCompanyId();
		
		Group guestGroup = groupLocalService.getGroup(companyId, GroupConstants.GUEST);
		
		Role role = roleLocalService.getRole(companyId,EmployeeWebPortletKeys.EMPLOYEE);
		long roleId = role.getRoleId();
		long[] roleIds = new long[5];
		roleIds[0]  = roleId;
		
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

		long userId = counterLocalService.increment(User.class.getName()); 
		User user = userLocalService.createUser(userId); 
		
		user.setCompanyId(companyId);
		user.setPassword("test");
		user.setScreenName(firstName+" "+lastName); 
		user.setFirstName(firstName);
		user.setLastName(lastName); 
		user.setEmailAddress(email);
		user.setJobTitle(designation); 
		user.setGroupId(groupId);
		user.setGroup(guestGroup);
		user.setRoleIds(roleIds);
		user.setType(UserConstants.TYPE_REGULAR);
		user.setModifiedDate(new Date());
		user.setCreateDate(new Date());
		user.setPasswordReset(false);
		user.setLanguageId(themeDisplay.getLanguageId());
        user.setTimeZoneId(themeDisplay.getTimeZone().getDisplayName());
		userLocalService.addUser(user); 
		
		log.info(user);
		
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
//		employee.setGroupId(groupId);
		
		employeedetailLocalService.addEmployeeDetail(employee);
		
		log.info("Employee data is inserted");
	}
}
