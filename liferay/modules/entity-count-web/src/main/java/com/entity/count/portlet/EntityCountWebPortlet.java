package com.entity.count.portlet;

import java.util.List;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.entity.count.constants.EntityCountWebPortletKeys;
import com.liferay.adaptive.media.exception.AMRuntimeException.IOException;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetVocabularyLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ImageLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

@Component(
		property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EntityCountWeb", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.init-param.config-template=/configuration.jsp",
		"javax.portlet.name=" + EntityCountWebPortletKeys.ENTITYCOUNTWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
		}, service = Portlet.class
)

public class EntityCountWebPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(EntityCountWebPortlet.class);

	@Reference
	UserLocalService userLocalService;

	@Reference
	ImageLocalService imageLocalService;

	@Reference
	RoleLocalService roleLocalService;

	@Reference
	AssetCategoryLocalService categoryLocalService;

	@Reference
	AssetVocabularyLocalService vocabularyLocalService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException, java.io.IOException {
		try {
			javax.portlet.PortletPreferences portletPreferences = renderRequest.getPreferences();
			String category = portletPreferences.getValue(EntityCountWebPortletKeys.CATEGORY,
					EntityCountWebPortletKeys.IMAGE);

			if (category.equalsIgnoreCase(EntityCountWebPortletKeys.IMAGE)) {
				int imageCount = imageLocalService.getImagesCount();
				renderRequest.setAttribute(EntityCountWebPortletKeys.COUNT, imageCount);
			}

			if (category.equalsIgnoreCase(EntityCountWebPortletKeys.USER)) {
				int userCount = userLocalService.getUsersCount();
				renderRequest.setAttribute(EntityCountWebPortletKeys.COUNT, userCount);
			}

			if (category.equalsIgnoreCase(EntityCountWebPortletKeys.TECHNOLOGY)) {
				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
				long groupId = themeDisplay.getScopeGroupId();
				AssetVocabulary vocabularyname = vocabularyLocalService.getGroupVocabulary(groupId,
						EntityCountWebPortletKeys.TECHNOLOGY);
				long vocabularyid = vocabularyname.getVocabularyId();
				int categoryCount = categoryLocalService.getVocabularyRootCategoriesCount(vocabularyid);
				renderRequest.setAttribute(EntityCountWebPortletKeys.COUNT, categoryCount);
			}

			if (category.equalsIgnoreCase(EntityCountWebPortletKeys.EMPLOYEE)) {
				Long companyId = (Long) renderRequest.getAttribute(EntityCountWebPortletKeys.COMPANY_ID);
				List<Role> rolenames = roleLocalService.getRoles(companyId);
				short empCount = (short) rolenames.stream()
						.filter(Name -> Name.equals(EntityCountWebPortletKeys.ROLE_EMPLOYEE)).count();
				renderRequest.setAttribute(EntityCountWebPortletKeys.COUNT, empCount);
			}

			renderRequest.setAttribute(EntityCountWebPortletKeys.CATEGORY, category);

			log.info("Entity Count and name are fetched");

		} catch (Exception e) {
			log.error(e);
		}
		super.render(renderRequest, renderResponse);	
	}
}