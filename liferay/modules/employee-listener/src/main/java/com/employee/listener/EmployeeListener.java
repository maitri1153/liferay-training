package com.employee.listener;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.employee.constant.EmployeeListenerConstant;
import com.employee.service.model.EmployeeDetail;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserGroupRoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Validator;

@Component(
	immediate = true, 
	service = ModelListener.class
)

public class EmployeeListener extends BaseModelListener<EmployeeDetail> {

	@Override
	public void onAfterUpdate(EmployeeDetail originalModel, EmployeeDetail employeeDetailModel) throws ModelListenerException {
		log.info("After Update method is started");
		handleActivityLogging(employeeDetailModel,EmployeeListenerConstant.UPDATE);
		super.onAfterUpdate(originalModel, employeeDetailModel);
	}
	
	@Override
	public void onAfterRemove(EmployeeDetail employeeDetailModel) throws ModelListenerException {
		log.info("After delete method is started");
		handleActivityLogging(employeeDetailModel,EmployeeListenerConstant.DELETE);
		super.onAfterRemove(employeeDetailModel);
	}
	
	@Override
	public void onAfterCreate(EmployeeDetail employeeDetailModel) throws ModelListenerException {
		log.info("After insert method is started");
		handleActivityLogging(employeeDetailModel,EmployeeListenerConstant.INSERT);
		super.onAfterCreate(employeeDetailModel);
	}
	
	public void handleActivityLogging(EmployeeDetail employeeDetailModel, String Type) {
		try {
			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			String ipAddress = serviceContext.getRemoteAddr();
			log.info("IpAddress is : "+ipAddress);
			
			ObjectDefinition objectDefinition =
				    ObjectDefinitionLocalService.fetchObjectDefinitionByExternalReferenceCode(
				        EmployeeListenerConstant.ACTIVITY, employeeDetailModel.getCompanyId());

			log.info("ObjectDefinition object is fetched");

			if (Validator.isNotNull(objectDefinition)) {
				
				Map<String, Serializable> values = new HashMap<>();
				values.put(EmployeeListenerConstant.ACTIVITY_TYPE, Type);
				values.put(EmployeeListenerConstant.DETAILS,employeeDetailModel.getEmail());
				values.put(EmployeeListenerConstant.IP_ADDRESS, ipAddress);
				log.info("Activity values are set");
			
				ObjectEntry objectEntry = objectEntryLocalService.addObjectEntry(employeeDetailModel.getUserId(),
						employeeDetailModel.getGroupId(), objectDefinition.getObjectDefinitionId(), values,
						serviceContext);
				
				log.info("Object entry created with ID: " + objectEntry.getObjectEntryId());
			}
		} catch (PortalException e) {
			log.error("Error creating activity entry: " + e.getMessage(), e);
		}
	}
	
	private static final Log log = LogFactoryUtil.getLog(EmployeeListener.class);

	@Reference
	private ObjectEntryLocalService objectEntryLocalService;

	@Reference
	ObjectDefinitionLocalService ObjectDefinitionLocalService;
	
	@Reference
	UserLocalService userLocalService;
	
	@Reference
	UserGroupRoleLocalService user;
}