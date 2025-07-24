package com.employee.login.event;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.user.constat.EventConstant;
import src.main.java.com.employee.login.event.UserLogin;
import com.liferay.portal.kernel.util.Validator;

@Component(
	property = {
		"key=logout.events.post"
	},
	service = LifecycleAction.class
)

public class PostLogoutEvent implements LifecycleAction {
	
	private static final Log log = LogFactoryUtil.getLog(PostLogoutEvent.class);

	@Reference
	ObjectEntryLocalService objectEntryLocalService;

	@Reference
	ObjectDefinitionLocalService objectDefinitionLocalService;
	
	@Reference 
	UserGroupRoleLocalService userGroupRoleLocalService;
	
	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		try {
			log.info("Post Logout event is Started");
			
			Set<String> IPAddresses =  PortalUtil.getComputerAddresses();
			String ipAddress = IPAddresses.toString();
			
			HttpServletRequest request = lifecycleEvent.getRequest();
			long companyId = PortalUtil.getUser(request).getCompanyId();
			
			Group group = GroupLocalServiceUtil.getGroup(companyId, "ignek intranet");
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
		}catch(Exception e) {
			log.info("Error occured while generation activity entry "+ e);
		}
	}
}
