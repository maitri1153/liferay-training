package com.employee.rest.internal.resource.v1_0;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import com.employee.rest.dto.v1_0.EmployeeDetailObject;
import com.employee.rest.resource.v1_0.EmployeeDetailResource;
import com.employee.service.model.EmployeeDetail;
import com.employee.service.service.EmployeeDetailLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

/**
 * @author ignek
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/employee-detail.properties", 
	scope = ServiceScope.PROTOTYPE, service = EmployeeDetailResource.class
)

public class EmployeeDetailResourceImpl extends BaseEmployeeDetailResourceImpl {

	@Reference
	EmployeeDetailLocalService employeeDetailLocalService;
	
	@Reference
	CounterLocalService counterLocalService;
	
	@Reference
	UserLocalService userLocalService;

	@Override
	public EmployeeDetailObject getEmployeeDetailById(@NotNull Long employeeId) 
			throws Exception {
		
		EmployeeDetail employee = employeeDetailLocalService.getEmployeeDetail(employeeId);
		EmployeeDetailObject employeeObject = getEmployeeDetailFromModel(employee);
		log.info("Employee detail is fetched by ID");
		return employeeObject;
	}

	@Override
	public EmployeeDetailObject updateEmployeeDetail(EmployeeDetailObject employeeDetailObject) 
			throws Exception {

		long groupId = contextUser.getGroupId();
		long userID = contextUser.getUserId();
		User currentUser = userLocalService.getUser(userID);
		String userName = currentUser.getScreenName();
		long companyId = contextCompany.getCompanyId();
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setCompanyId(companyId);
		serviceContext.setUserId(contextUser.getUserId());
		
		long employeeId = employeeDetailObject.getEmployeeId();
		String firstName = employeeDetailObject.getFirstName();
		String lastName = employeeDetailObject.getLastName();
		String designation = employeeDetailObject.getDesignation();
		long phoneNumber = employeeDetailObject.getPhoneNumber();
		String email = employeeDetailObject.getEmail();
		String addressLine1 = employeeDetailObject.getAddressLine1();
		String addressLine2 = employeeDetailObject.getAddressLine2();
		String city = employeeDetailObject.getCity();
		long zipCode = employeeDetailObject.getZipCode();

		try {
			if(Validator.isNotNull(employeeId)) {
				EmployeeDetail employee = employeeDetailLocalService.getEmployeeDetail(employeeId);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setEmail(email);
				employee.setDesignation(designation);
				employee.setPhoneNumber(phoneNumber);
				employee.setAddressLine1(addressLine1);
				employee.setAddressLine2(addressLine2);
				employee.setCity(city);
				employee.setZipCode(zipCode);
				employee = employeeDetailLocalService.updateEmployeeDetail(employee);
				log.info("Employee detail is Updated");
			}else {
				employeeId = counterLocalService.increment(EmployeeDetail.class.getName());
				EmployeeDetail employee = employeeDetailLocalService.createEmployeeDetail(employeeId);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setEmail(email);
				employee.setDesignation(designation);
				employee.setPhoneNumber(phoneNumber);
				employee.setAddressLine1(addressLine1);
				employee.setAddressLine2(addressLine2);
				employee.setCity(city);
				employee.setZipCode(zipCode);
				employee.setGroupId(groupId);
				employee.setUserId(userID);
				employee.setUserName(userName);
				employee = employeeDetailLocalService.addEmployeeDetail(employee);
				log.info("Employee detail is Inserted");
			}
			employeeDetailObject.setEmployeeId(employeeId);
			
		} catch (Exception e) {
			log.error(e);
		}
		return employeeDetailObject;
	}
	
	@Override
	public EmployeeDetailObject deleteEmployeeDetailById(@NotNull Long employeeID) 
			throws Exception {
		EmployeeDetailObject employeeObject = new EmployeeDetailObject();
		try {
			employeeDetailLocalService.deleteEmployeeDetail(employeeID);
			log.info("Employee data is deleted");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return employeeObject;
	}
	
	@Override
	public Page<EmployeeDetailObject> getEmployees(Pagination pagination) 
			throws Exception {
		List<EmployeeDetail> employees = employeeDetailLocalService.getEmployeeDetails(-1, -1);
		List<EmployeeDetailObject> employeeObject = new ArrayList<>();
		for(EmployeeDetail employee : employees) {
			employeeObject.add(getEmployeeDetailFromModel(employee));
		}
		log.info("Employee Details are fetched");
		return Page.of(employeeObject);
	}
	
	private EmployeeDetailObject getEmployeeDetailFromModel(EmployeeDetail employee) {
		EmployeeDetailObject employeeObject = new EmployeeDetailObject();
		employeeObject.setDesignation(employee.getDesignation());
		employeeObject.setFirstName(employee.getFirstName());
		employeeObject.setLastName(employee.getLastName());
		employeeObject.setEmail(employee.getEmail());
		employeeObject.setCity(employee.getCity());
		employeeObject.setAddressLine1(employee.getAddressLine1());
		employeeObject.setAddressLine2(employee.getAddressLine2());
		employeeObject.setZipCode(employee.getZipCode());
		employeeObject.setEmployeeId(employee.getEmployeeId());
		employeeObject.setPhoneNumber(employee.getPhoneNumber());
		return employeeObject;
	}

	public static final Log log = LogFactoryUtil.getLog(EmployeeDetailResourceImpl.class);
	
}