/*
 * package com.user.login;
 * 
 * import java.io.Serializable; import java.util.HashMap; import java.util.List;
 * import java.util.Locale; import java.util.Map; import java.util.Set; import
 * javax.servlet.http.HttpServletRequest; import
 * org.osgi.service.component.annotations.Component; import
 * org.osgi.service.component.annotations.Reference; import
 * com.liferay.object.model.ObjectDefinition; import
 * com.liferay.object.model.ObjectEntry; import
 * com.liferay.object.service.ObjectDefinitionLocalService; import
 * com.liferay.object.service.ObjectEntryLocalService; import
 * com.liferay.portal.kernel.events.ActionException; import
 * com.liferay.portal.kernel.events.LifecycleAction; import
 * com.liferay.portal.kernel.events.LifecycleEvent; import
 * com.liferay.portal.kernel.log.Log; import
 * com.liferay.portal.kernel.log.LogFactoryUtil; import
 * com.liferay.portal.kernel.service.ServiceContext; import
 * com.liferay.portal.kernel.service.UserLocalService; import
 * com.liferay.portal.kernel.util.LocaleUtil; import
 * com.liferay.portal.kernel.util.PortalUtil; import
 * com.user.constat.EventConstant;
 * 
 * @Component( property = { "key=login.events.post" }, service =
 * LifecycleAction.class )
 * 
 * public class UserLogin implements LifecycleAction{
 * 
 * private static Log log = LogFactoryUtil.getLog(UserLogin.class);
 * 
 * @Reference ObjectDefinitionLocalService ObjectDefinitionLocalService;
 * 
 * @Reference private ObjectEntryLocalService objectEntryLocalService;
 * 
 * @Reference private ObjectDefinitionLocalService objectDefinitionLocalService;
 * 
 * @Reference UserLocalService userLocalService;
 * 
 * @Override public void processLifecycleEvent(LifecycleEvent lifecycleEvent)
 * throws ActionException { try { log.info("Post Login Action is Started");
 * 
 * Set<String> IPAddresses = PortalUtil.getComputerAddresses(); String ipAddress
 * = IPAddresses.toString();
 * 
 * HttpServletRequest request = lifecycleEvent.getRequest(); long companyId =
 * PortalUtil.getUser(request).getCompanyId(); String objectDefinitionName =
 * getObjectDefinationName();
 * 
 * ObjectDefinition objectDefinition = objectDefinitionLocalService
 * .fetchObjectDefinitionByClassName(companyId, objectDefinitionName);
 * 
 * if (objectDefinition != null) { ServiceContext serviceContext = new
 * ServiceContext(); Map<String, Serializable> values = new HashMap<>();
 * values.put(EventConstant.ACTIVITY_TYPE,EventConstant.LOGIN);
 * values.put(EventConstant.DETAILS, PortalUtil.getUser(request).getFirstName()
 * + PortalUtil.getUser(request).getEmailAddress());
 * values.put(EventConstant.IP_ADDRESS, ipAddress); log.info(values);
 * 
 * ObjectEntry objectEntry = objectEntryLocalService
 * .addObjectEntry(PortalUtil.getUser(request).getUserId() ,39407,
 * objectDefinition.getObjectDefinitionId(), values ,serviceContext);
 * log.info("Object entry created with ID: " + objectEntry.getObjectEntryId());
 * } }catch(Exception e) {
 * log.info("Error occured while generation activity entry "+ e); } }
 * 
 * public String getObjectDefinationName() { Locale locale =
 * LocaleUtil.fromLanguageId(EventConstant.ACTIVITY); String
 * objectDefinitionName = null; List<ObjectDefinition> objectDefinitions =
 * objectDefinitionLocalService.getObjectDefinitions(-1, -1); for
 * (ObjectDefinition objectDefinition : objectDefinitions) { if
 * (objectDefinition.getLabel(locale).equals(EventConstant.ACTIVITY)) {
 * objectDefinitionName = objectDefinition.getClassName(); } }
 * log.info(objectDefinitionName); return objectDefinitionName; } }
 */