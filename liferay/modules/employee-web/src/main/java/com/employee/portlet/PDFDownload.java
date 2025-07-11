package com.employee.portlet;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.employee.constants.EmployeeWebPortletKeys;
import com.employee.service.model.EmployeeDetail;
import com.employee.service.service.EmployeeDetailLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Component(
	property = { 
		"javax.portlet.name =" + EmployeeWebPortletKeys.EMPLOYEEWEB,
		"mvc.command.name=/pdfdownload" 
	}, service = MVCResourceCommand.class
)

public class PDFDownload implements MVCResourceCommand {

	private static final Log log = LogFactoryUtil.getLog(PDFDownload.class);

	@Reference
	EmployeeDetailLocalService employeeDetailLocalService;

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		long employeeId = ParamUtil.getLong(resourceRequest, EmployeeWebPortletKeys.EMPLOYEE_ID);

		try {
			EmployeeDetail employee = employeeDetailLocalService.fetchEmployeeDetail(employeeId);
			StringBuilder reportContent = new StringBuilder();
			reportContent.append("Employee Id : " + employee.getEmployeeId() + "\n");
			reportContent.append("First Name : " + employee.getFirstName() + "\n");
			reportContent.append("Last Name : " + employee.getLastName() + "\n");
			reportContent.append("Email : " + employee.getEmail() + "\n");
			reportContent.append("Phone Number : " + employee.getPhoneNumber() + "\n");
			reportContent.append("AddressLine 1 : " + employee.getAddressLine1() + "\n");
			reportContent.append("AddressLine 2 : " + employee.getAddressLine2() + "\n");
			reportContent.append("City : " + employee.getCity() + "\n");
			reportContent.append("Zip-Code : " + employee.getZipCode() + "\n");
			reportContent.append("Designation : " + employee.getDesignation() + "\n");
			String dataAsText = reportContent.toString();

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			Document document = new Document(PageSize.A4);
			PdfWriter.getInstance(document, baos);
			document.open();

			Font normalFont = new Font(Font.HELVETICA, 12, Font.NORMAL, Color.BLACK);

			String[] paragraphs = dataAsText.split("\n");

			for (String textBlock : paragraphs) {
				if (textBlock.trim().isEmpty()) {
					continue;
				}
				Paragraph paragraph = new Paragraph(textBlock.trim(), normalFont);
				paragraph.setSpacingAfter(10f);
				document.add(paragraph);
			}

			document.close();

			String fileName = "Employee_"+employeeId+".pdf";
			String contentType = "application/pdf";
			byte[] bytes = baos.toByteArray();

			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, fileName, bytes, contentType);
			
			log.info("PDF file generated successfully");

		} catch (Exception e) {
			log.error("Error retrieving or processing text data: " + e.getMessage(), e);
		}
		return false;
	}
}
