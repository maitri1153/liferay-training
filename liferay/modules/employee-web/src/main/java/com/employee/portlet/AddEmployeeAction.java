package com.employee.portlet;

import java.util.List;
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
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.AddressLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserGroupRoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

@Component(
	property = { 
		"javax.portlet.name =" + EmployeeWebPortletKeys.EMPLOYEEWEB,
		"mvc.command.name=/addEmployee" 
	}, service = MVCActionCommand.class
)

public class AddEmployeeAction extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) 
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		long currentuserId = themeDisplay.getUserId();
		User currentUser = themeDisplay.getUser();
		String currentUserName = currentUser.getScreenName();

		long employeeId = ParamUtil.getLong(actionRequest, EmployeeWebPortletKeys.EMPLOYEE_ID);
		String firstName = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.FIRSTNAME);
		String lastName = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.LASTNAME);
		String email = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.EMAIL);
		long phoneNumber = ParamUtil.getLong(actionRequest, EmployeeWebPortletKeys.PHONE_NUMBER);
		String addressLine1 = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.ADDRESS_LINE1);
		String addressLine2 = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.ADDRESS_LINE2);
		String city = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.CITY);
		long zipCode = ParamUtil.getLong(actionRequest, EmployeeWebPortletKeys.ZIPCODE);
		String designation = ParamUtil.getString(actionRequest, EmployeeWebPortletKeys.DESIGNATION);

		if (employeeId > 0) {

			log.info("Update Employee action method is started");
			EmployeeDetail employee = employeedetailLocalService.fetchEmployeeDetail(employeeId);
			String userEmail = employee.getEmail();
			log.info(employee);
			log.info(userEmail);
			User user = userLocalService.fetchUserByEmailAddress(companyId, userEmail);
			log.info(user);
			
			try {
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

				if (Validator.isNotNull(user)) {
					user.setFirstName(firstName);
					user.setLastName(lastName);
					user.setEmailAddress(email);
					user.setJobTitle(designation);
					userLocalService.updateUser(user);
					
					log.info("User information is updated");
					
					long classPk = user.getContactId();
					String className = Contact.class.getName();
					List<Address> addresses = addressLocalService.getAddresses(companyId, className, classPk);
					Address address = addresses.get(0);
					address.setCity(city);
					address.setStreet1(addressLine1);
					address.setStreet2(addressLine2);
					String zip = String.valueOf(zipCode);
					address.setZip(zip);
					addressLocalService.updateAddress(address);
					log.info("Address is updated");
				 } 
			}catch(Exception e) {
				log.error(e);
			}
			
		} else {
			log.info("Add Employee action method is started");

			Role empRoles = roleLocalService.getRole(companyId, EmployeeWebPortletKeys.EMPLOYEE);
			long empId = empRoles.getRoleId();

			long[] groupIds = new long[5];
			groupIds[0] = groupId;

			String password1 = "test";
			String password2 = "test";
			String screenName = firstName + lastName;
			String middleName = null;

			int birthDay = 11;
			int birthYear = 2000;
			int birthMonth = 05;
			int type = UserConstants.TYPE_REGULAR;

			boolean autoScreenName = true;
			boolean autoPassword = false;
			boolean male = false;
			boolean sendMail = false;

			Locale locale = LocaleUtil.getDefault();

			ServiceContext serviceContext = new ServiceContext();
			serviceContext = ServiceContextFactory.getInstance(User.class.getName(), actionRequest);
			
			long addressId = counterLocalService.increment(Address.class.getName());
			long newEmployeeId = counterLocalService.increment(EmployeeDetail.class.getName());

			User user = userLocalService.addUser(currentuserId, companyId, autoPassword, password1, password2,
					autoScreenName, screenName, email, locale, firstName, middleName, lastName, -1, -1, male,
					birthMonth, birthDay, birthYear, designation, type, groupIds, null, null, null, sendMail,
					serviceContext);

			userGroupRoleLocalService.addUserGroupRole(user.getUserId(), groupId, empId);
			user.setStatus(WorkflowConstants.STATUS_APPROVED);
			user.setPasswordEncrypted(false);
			userLocalService.updateUser(user);
			log.info("User is added");

			long contactId = user.getContactId();
			Address address = addressLocalService.createAddress(addressId);
			address.setCity(city);
			address.setStreet1(addressLine1);
			address.setStreet2(addressLine2);
			String zip = String.valueOf(zipCode);
			address.setZip(zip);
			address.setClassPK(contactId);
			String className = Contact.class.getName();
			addressLocalService.addAddress(null, currentuserId, className, contactId, null, null, addressLine1, addressLine2,
					null, city, zip, 0, 0, 21, false, true, null, serviceContext);
			log.info("User Address is added");

			EmployeeDetail employee = employeedetailLocalService.createEmployeeDetail(newEmployeeId);
			employee.setEmployeeId(newEmployeeId);
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

			log.info("Employee is added");
		}
	}
	
	private static final Log log = LogFactoryUtil.getLog(AddEmployeeAction.class);

	@Reference
	AddressLocalService addressLocalService;

	@Reference
	CounterLocalService counterLocalService;

	@Reference
	EmployeeDetailLocalService employeedetailLocalService;

	@Reference
	RoleLocalService roleLocalService;

	@Reference
	UserLocalService userLocalService;

	@Reference
	UserGroupRoleLocalService userGroupRoleLocalService;
}
