package com.email.scheduler;

import javax.mail.internet.InternetAddress;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.liferay.dispatch.executor.BaseDispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutorOutput;
import com.liferay.dispatch.model.DispatchTrigger;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@Component(
	immediate = true, 
	property = { 
		"dispatch.task.executor.name=Email Scheduler",
		"dispatch.task.executor.type=Email Schedular" 
	}, service = DispatchTaskExecutor.class
)

public class EmailScheduler extends BaseDispatchTaskExecutor {

	@Override
	public String getName() {
		return "Email Scheduler";
	}

	@Override
	public void doExecute(DispatchTrigger dispatchTrigger, DispatchTaskExecutorOutput dispatchTaskExecutorOutput)
			throws Exception {

		MailMessage mailMessage = new MailMessage();
		mailMessage.setTo(new InternetAddress("alt.ti-boo5inp2@yopmail.com"));
		mailMessage.setFrom(new InternetAddress("maitri.patel.ignek@gmail.com"));
		mailMessage.setSubject("Scheduled Email from Liferay");
		mailMessage.setBody("This is an automated email sent by a Liferay Job Scheduler.");
		mailMessage.setHTMLFormat(false);

		mailService.sendEmail(mailMessage);
		log.info("Mail is sent without any intruption");

		log.info("Scheduled task executed...");
		dispatchTaskExecutorOutput.setOutput("Scheduled task executed successfully.");
	}

	private static final Log log = LogFactoryUtil.getLog(EmailScheduler.class);

	@Reference
	MailService mailService;
}