package com.employee.service.search.impl;

import java.util.List;
import java.util.Locale;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import org.osgi.service.component.annotations.Component;
import com.employee.service.model.EmployeeDetail;
import com.employee.service.service.EmployeeDetailLocalServiceUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelperUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.GetterUtil;

@Component(
	immediate=true,
	service = Indexer.class
)

public class EmployeeDetailIndexer extends BaseIndexer<EmployeeDetail> {

	public static final String CLASS_NAME = EmployeeDetailIndexer.class.getName();
	
	public EmployeeDetailIndexer() {
		setDefaultSelectedFieldNames(
				Field.COMPANY_ID, Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK,
				Field.MODIFIED_DATE, Field.CREATE_DATE , Field.USER_NAME, Field.USER_ID, Field.GROUP_ID);
			setPermissionAware(true);
			setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, String entryClassName, long entryClassPK,
			String actionId) throws Exception {
		return super.hasPermission(permissionChecker, entryClassName, entryClassPK, actionId);
	}

	public static String getPortletId() {
		return EmployeeDetail.class.getName();
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest,
			PortletResponse portletResponse) throws Exception {
		Summary summary = createSummary(document);
		summary.setMaxContentLength(200);
		return summary;
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		EmployeeDetail employee = EmployeeDetailLocalServiceUtil.getEmployeeDetail(classPK);
		doReindex(employee);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	@Override
	protected void doReindex(EmployeeDetail employee) throws Exception {
		Document document = getDocument(employee);
		IndexWriterHelperUtil.updateDocument(employee.getCompanyId(), document);
	}
	
	@Override
	protected void doDelete(EmployeeDetail employee) throws Exception {
		deleteDocument(employee.getCompanyId(), employee.getEmployeeId());
	}
	
	@Override
	protected Document doGetDocument(EmployeeDetail employee) throws Exception {
		
		Document document = getBaseModelDocument(EmployeeDetail.class.getName(), employee);
		
		document.addNumber("employeeId", employee.getEmployeeId());
		document.addText("firstName", employee.getFirstName());
		document.addText("lastName", employee.getLastName());
		document.addText("email", employee.getEmail());
		document.addNumber("phoneNumber", employee.getPhoneNumber());
		document.addText("designation", employee.getDesignation());
		document.addText("addressLine1", employee.getAddressLine1());
		document.addText("addressLine2", employee.getAddressLine2());
		document.addText("city", employee.getCity());
		document.addNumber("zipCode", employee.getZipCode());
		return document;
	}
	
	protected void reindexEntries(long companyId) throws Exception {
		List<EmployeeDetail> employees = EmployeeDetailLocalServiceUtil.getEmployeeDetails(-1, -1);
		for (EmployeeDetail employee : employees) {
			Document document = getDocument(employee);
			IndexWriterHelperUtil.updateDocument(companyId, document);
		}
	}

	@Override
	public String getClassName() {
		return EmployeeDetail.class.getName();
	}
}
