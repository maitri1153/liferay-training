<#assign preferences = freeMarkerPortletPreferences.getPreferences({"portletSetupPortletDecoratorId": "barebone", "destination": "/search"}) />

<div class="justify-content-md-end mr-4 navbar-form align-items-baseline pt-2" role="search">
	<@liferay.search_bar default_preferences="${preferences}" />
		<a href="http://localhost:8080/web/ignek-intranet/manage?p_p_id=com_liferay_notifications_web_portlet_NotificationsPortlet&p_p_lifecycle=0&_com_liferay_notifications_web_portlet_NotificationsPortlet_backURL=%2Fweb%2Fignek-intranet%2Fhome&p_p_auth=ZvgLHumP" class="pl-3">
		<img src="${images_folder}/bell 1.png"/>
		</a>
</div>