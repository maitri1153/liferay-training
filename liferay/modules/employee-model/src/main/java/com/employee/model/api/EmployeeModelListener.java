package com.employee.model.api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.employee.model.constant.EmployeeConstant;
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
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;

@Component(
	immediate = true, 
	service = ModelListener.class
)

public class EmployeeModelListener extends BaseModelListener<EmployeeDetail> {

	private static Log log = LogFactoryUtil.getLog(EmployeeModelListener.class);
	
	@Reference
	ObjectDefinitionLocalService ObjectDefinitionLocalService;

	@Reference
	private ObjectEntryLocalService objectEntryLocalService;

	@Reference
	private ObjectDefinitionLocalService objectDefinitionLocalService;

	@Reference
	UserLocalService userLocalService;

	@Override
	public void onAfterUpdate(EmployeeDetail originalModel, EmployeeDetail model) 
			throws ModelListenerException {
		try {
			log.info("Started modelListener");
			
			Set<String> IPAddresses =  PortalUtil.getComputerAddresses();
			String ipAddress = IPAddresses.toString();
			
			String objectDefinitionName = getObjectDefinationName();
			
			ObjectDefinition objectDefinition = objectDefinitionLocalService
					.fetchObjectDefinitionByClassName(model.getCompanyId(), objectDefinitionName);

			if (objectDefinition != null) {
				ServiceContext serviceContext = new ServiceContext();
				Map<String, Serializable> values = setValues(ipAddress,EmployeeConstant.UPDATE,model);
				
				ObjectEntry objectEntry = objectEntryLocalService
					.addObjectEntry(model.getUserId(), model.getGroupId(),objectDefinition.getObjectDefinitionId()
							,values, serviceContext);
				log.info("Object entry created with ID: " + objectEntry.getObjectEntryId());
			}
			
		} catch (PortalException e) {
			log.error("Error creating activity entry: " + e.getMessage(), e);
		}
		super.onAfterUpdate(originalModel, model);
	}
	
	@Override
	public void onAfterRemove(EmployeeDetail model) throws ModelListenerException {
		try {
			log.info("Started modelListener");
			
			Set<String> IPAddresses =  PortalUtil.getComputerAddresses();
			String ipAddress = IPAddresses.toString();
			
			String objectDefinitionName = getObjectDefinationName();
			
			ObjectDefinition objectDefinition = objectDefinitionLocalService
					.fetchObjectDefinitionByClassName(model.getCompanyId(), objectDefinitionName);

			if (objectDefinition != null) {
				ServiceContext serviceContext = new ServiceContext();
				Map<String, Serializable> values = setValues(ipAddress,EmployeeConstant.DELETE,model);
				
				ObjectEntry objectEntry = objectEntryLocalService
					.addObjectEntry(model.getUserId(), model.getGroupId(),objectDefinition.getObjectDefinitionId()
							,values, serviceContext);
				log.info("Object entry created with ID: " + objectEntry.getObjectEntryId());
			}
			
		} catch (PortalException e) {
			log.error("Error creating activity entry: " + e.getMessage(), e);
		}
		super.onAfterRemove(model);
	}
	
	@Override
	public void onAfterCreate(EmployeeDetail model) throws ModelListenerException {
		try {
			log.info("Started modelListener");
			
			Set<String> IPAddresses =  PortalUtil.getComputerAddresses();
			String ipAddress = IPAddresses.toString();
			
			String objectDefinitionName = getObjectDefinationName();
			
			ObjectDefinition objectDefinition = objectDefinitionLocalService
					.fetchObjectDefinitionByClassName(model.getCompanyId(), objectDefinitionName);

			if (objectDefinition != null) {
				ServiceContext serviceContext = new ServiceContext();
				Map<String, Serializable> values = setValues(ipAddress,EmployeeConstant.INSERT,model);
				log.info("get values of employee: "+values);
				ObjectEntry objectEntry = objectEntryLocalService
					.addObjectEntry(model.getUserId(), model.getGroupId(),objectDefinition.getObjectDefinitionId()
							,values, serviceContext);
				log.info("Object entry created with ID: " + objectEntry.getObjectEntryId());
			}
			
		} catch (PortalException e) {
			log.error("Error creating activity entry: " + e.getMessage(), e);
		}
		super.onAfterCreate(model);
	}

	public String getObjectDefinationName() {
		Locale locale = LocaleUtil.fromLanguageId(EmployeeConstant.ACTIVITY);
		String objectDefinitionName = null;
		List<ObjectDefinition> objectDefinitions = objectDefinitionLocalService.getObjectDefinitions(-1, -1);
		for (ObjectDefinition objectDefinition : objectDefinitions) {
			if (objectDefinition.getLabel(locale).equals(EmployeeConstant.ACTIVITY)) {
				objectDefinitionName = objectDefinition.getClassName();
			}
		}
		log.info(objectDefinitionName);
		return objectDefinitionName;
	}
	
	public Map<String, Serializable> setValues(String ipAddress,String type,EmployeeDetail model) {
		log.info("Setting values for activity" + ipAddress + type + model);
		Map<String, Serializable> values = new HashMap<>();
		values.put(EmployeeConstant.ACTIVITY_TYPE,type);
		values.put(EmployeeConstant.DETAILS, model.getFirstName() + model.getEmail());
		values.put(EmployeeConstant.IP_ADDRESS, ipAddress);
		log.info(values);
		return values;
	}
}

