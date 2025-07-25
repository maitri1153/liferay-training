package com.entity.count.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import com.entity.count.constants.EntityCountWebPortletKeys;
import com.entity.count.portlet.EntityCountWebPortlet;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
	configurationPid = EntityCountWebPortletKeys.CONFIGURATION_ID, 
	configurationPolicy = ConfigurationPolicy.OPTIONAL, 
	immediate = true, property = {
		"javax.portlet.name=" + EntityCountWebPortletKeys.ENTITYCOUNTWEB, 
	}, service = ConfigurationAction.class
)

public class EntityCountAction extends DefaultConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		try {
			String category = ParamUtil.getString(actionRequest, EntityCountWebPortletKeys.CATEGORY);
			setPreference(actionRequest, EntityCountWebPortletKeys.CATEGORY, category);

			log.info("Values are fetched from the configuration");

		} catch (Exception e) {
			log.error(e);
		}
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	private static Log log = LogFactoryUtil.getLog(EntityCountWebPortlet.class);
}
