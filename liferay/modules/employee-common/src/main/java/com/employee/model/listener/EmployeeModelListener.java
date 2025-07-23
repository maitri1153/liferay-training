package com.employee.model.listener;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.employee.constant.EmployeeConstant;
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
import com.liferay.portal.kernel.util.Validator;

@Component(
	immediate = true, 
	service = ModelListener.class
)

public class EmployeeModelListener extends BaseModelListener<EmployeeDetail> {

	private static final Log log = LogFactoryUtil.getLog(EmployeeModelListener.class);

	@Reference
	private ObjectEntryLocalService objectEntryLocalService;

	@Reference
	ObjectDefinitionLocalService ObjectDefinitionLocalService;
	
	@Reference
	UserLocalService userLocalService;
	
	@Override
	public void onAfterUpdate(EmployeeDetail originalModel, EmployeeDetail employeeDetailModel) throws ModelListenerException {
		log.info("After Update method is started");
		handleActivityLogging(employeeDetailModel,EmployeeConstant.UPDATE);
		super.onAfterUpdate(originalModel, employeeDetailModel);
	}
	
	@Override
	public void onAfterRemove(EmployeeDetail employeeDetailModel) throws ModelListenerException {
		log.info("After delete method is started");
		handleActivityLogging(employeeDetailModel,EmployeeConstant.DELETE);
		super.onAfterRemove(employeeDetailModel);
	}
	
	@Override
	public void onAfterCreate(EmployeeDetail employeeDetailModel) throws ModelListenerException {
		log.info("After insert method is started");
		handleActivityLogging(employeeDetailModel,EmployeeConstant.INSERT);
		super.onAfterCreate(employeeDetailModel);
	}
	
	public void handleActivityLogging(EmployeeDetail employeeDetailModel, String Type) {
		try {
			Set<String> IPAddresses = PortalUtil.getComputerAddresses();
			String ipAddress = IPAddresses.toString();

			Locale locale = LocaleUtil.fromLanguageId(EmployeeConstant.ACTIVITY);
			ObjectDefinition objectDefinition = null;
			List<ObjectDefinition> objectDefinitions = ObjectDefinitionLocalService.getObjectDefinitions(-1, -1);
			for (ObjectDefinition object : objectDefinitions) {
				if (object.getLabel(locale).equals(EmployeeConstant.ACTIVITY)) {
					objectDefinition = object;
				}
			}

			log.info("objectDefinition object is fetched");
			
			if (Validator.isNotNull(objectDefinition)) {
				
				ServiceContext serviceContext = new ServiceContext();
				
				Map<String, Serializable> values = new HashMap<>();
				values.put(EmployeeConstant.ACTIVITY_TYPE, Type);
				values.put(EmployeeConstant.DETAILS,employeeDetailModel.getEmail());
				values.put(EmployeeConstant.IP_ADDRESS, ipAddress);
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
}