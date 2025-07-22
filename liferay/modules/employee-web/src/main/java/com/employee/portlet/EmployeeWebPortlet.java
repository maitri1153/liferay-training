package com.employee.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.employee.constants.EmployeeWebPortletKeys;
import com.employee.service.model.EmployeeDetail;
import com.employee.service.service.EmployeeDetailLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserGroupRoleLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

@Component(
	property = { 
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EmployeeWeb", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmployeeWebPortletKeys.EMPLOYEEWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	}, service = Portlet.class
)

public class EmployeeWebPortlet extends MVCPortlet {

	private static final Log log = LogFactoryUtil.getLog(EmployeeWebPortlet.class);
	
	@Reference
	EmployeeDetailLocalService employeeDetailLocalService;
	
	@Reference
	UserGroupRoleLocalService userGroupRoleLocalService;
	
	@Reference
	RoleLocalService roleLocalService;
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {
			
			log.info("Render method is started");
			
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			long groupId = themeDisplay.getScopeGroupId();
			long companyId = themeDisplay.getCompanyId();
			Role hrRole = roleLocalService.getRole(companyId, EmployeeWebPortletKeys.HR);
			boolean isHr = userGroupRoleLocalService.hasUserGroupRole(userId, groupId, hrRole.getRoleId());
			renderRequest.setAttribute("isHr", isHr);
			
			SearchContext searchContext = SearchContextFactory.getInstance(PortalUtil.getHttpServletRequest(renderRequest));
			searchContext.setCompanyId(companyId);
			searchContext.setAttribute("head", true);
		
			Indexer<EmployeeDetail> indexer = IndexerRegistryUtil.getIndexer(EmployeeDetail.class);
			try {
				Hits hits = indexer.search(searchContext);		
				List<EmployeeDetail> employees = new ArrayList<>();
				if (hits != null && hits.getDocs() != null) {
				    for (Document doc : hits.getDocs()) {
				        try {
				            long employeeId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
				            EmployeeDetail employee = employeeDetailLocalService.getEmployeeDetail(employeeId);
				            employees.add(employee);
				        } catch (PortalException | SystemException e) {
				            log.info("Error while converting to employeeList from hits");
				        }
				    }
				}
				log.info(hits);
				renderRequest.setAttribute("employeeList", employees);
			} catch (SearchException e) {
				e.printStackTrace();
			}
			
			log.info("EmployeeList attribute is set");
			
			super.render(renderRequest, renderResponse);
			
		}catch(Exception e) {
			log.error("Error while fetching employee data : "+ e);
		}
	}
}