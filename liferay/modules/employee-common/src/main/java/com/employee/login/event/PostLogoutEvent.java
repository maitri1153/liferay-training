package com.employee.login.event;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.employee.constant.EmployeeConstant;
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
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

@Component(
	property = {
		"key=logout.events.post"
	},
	service = LifecycleAction.class
)

public class PostLogoutEvent implements LifecycleAction {
	
	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		try {
			
			log.info("Post Logout event is Started");
			
			HttpServletRequest request = PortalUtil.getOriginalServletRequest(lifecycleEvent.getRequest());
			String ipAddress = request.getRemoteAddr();
			log.info("Client IP Address: " + ipAddress);
			
			long companyId = PortalUtil.getUser(request).getCompanyId();
			
			Group group = GroupLocalServiceUtil.getGroup(companyId, EmployeeConstant.IGNEK_INTRANET);
			long groupId = group.getGroupId();
			
			ObjectDefinition objectDefinition =
				    objectDefinitionLocalService.fetchObjectDefinitionByExternalReferenceCode(
				        EmployeeConstant.ACTIVITY,companyId);
		
			if (Validator.isNotNull(objectDefinition)) {
				ServiceContext serviceContext = new ServiceContext();
				Map<String, Serializable> values = new HashMap<>();
				values.put(EmployeeConstant.ACTIVITY_TYPE,EmployeeConstant.LOGOUT);
				values.put(EmployeeConstant.DETAILS, PortalUtil.getUser(request).getEmailAddress());
				values.put(EmployeeConstant.IP_ADDRESS, ipAddress);
				log.info("Values are set for activity");
				
				ObjectEntry objectEntry = objectEntryLocalService
					.addObjectEntry(PortalUtil.getUser(request).getUserId() ,groupId,
						objectDefinition.getObjectDefinitionId(), values ,serviceContext);
				
				log.info("Object entry created with ID: " + objectEntry.getObjectEntryId());
			}
		} catch(Exception e) {
			log.info("Error occured while generation activity entry "+ e);
		}
	}
	
	private static final Log log = LogFactoryUtil.getLog(PostLogoutEvent.class);

	@Reference
	ObjectEntryLocalService objectEntryLocalService;

	@Reference
	ObjectDefinitionLocalService objectDefinitionLocalService;
	
	@Reference 
	GroupLocalService groupLocalService;
}
