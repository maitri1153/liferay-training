package com.employee.login.events;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.employee.login.constant.EmployeeLoginConstant;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;

@Component(
	property = {
		"key=login.events.post"
	},
	service = LifecycleAction.class
)

public class EmployeeLoginEvents implements LifecycleAction {

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		
		try {
			log.info("Post Login event is Started");
			
			HttpServletRequest request = portal.getOriginalServletRequest(lifecycleEvent.getRequest());
			String ipAddress = request.getRemoteAddr();
			log.info("Client IP Address: " + ipAddress);
			
			long companyId = portal.getUser(request).getCompanyId();
			
			Group group = groupLocalService.getGroup(companyId, EmployeeLoginConstant.IGNEK_INTRANET);
			long groupId = group.getGroupId();
			
			ObjectDefinition objectDefinition =
				    objectDefinitionLocalService.fetchObjectDefinitionByExternalReferenceCode(
				    		EmployeeLoginConstant.ACTIVITY,companyId);
		
			if (Validator.isNotNull(objectDefinition)) {
				ServiceContext serviceContext = new ServiceContext();
				Map<String, Serializable> values = new HashMap<>();
				values.put(EmployeeLoginConstant.ACTIVITY_TYPE,EmployeeLoginConstant.LOGIN);
				values.put(EmployeeLoginConstant.DETAILS, portal.getUser(request).getEmailAddress());
				values.put(EmployeeLoginConstant.IP_ADDRESS, ipAddress);
				log.info("Values are set for activity");
				
				ObjectEntry objectEntry = objectEntryLocalService
					.addObjectEntry(portal.getUser(request).getUserId() ,groupId,
						objectDefinition.getObjectDefinitionId(), values ,serviceContext);
				
				log.info("Object entry created with ID: " + objectEntry.getObjectEntryId());
			}
		} catch(Exception e) {
			log.info("Error occured while generation activity entry "+ e);
		}
	}

	private static final Log log = LogFactoryUtil.getLog(EmployeeLoginEvents.class);

	@Reference
	ObjectEntryLocalService objectEntryLocalService;

	@Reference
	ObjectDefinitionLocalService objectDefinitionLocalService;
	
	@Reference 
	GroupLocalService groupLocalService;
	
	@Reference
	Portal portal;
}