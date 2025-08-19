package com.ignek.portal.user.service.wrapper;

import java.util.Map;
import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.UserLocalServiceWrapper;

/**
 * @author ignek
 */
@Component(
	property = {
	},
	service = ServiceWrapper.class
)
public class CustomUserLocalServiceWrapper extends UserLocalServiceWrapper {

	public CustomUserLocalServiceWrapper() {
		super(null);
	}

	@Override
	public int authenticateByEmailAddress(long companyId, String emailAddress, String password,
			Map<String, String[]> headerMap, Map<String, String[]> parameterMap, Map<String, Object> resultsMap)
			throws PortalException {
		log.info("Customizing Authentication by email Address");
		return super.authenticateByEmailAddress(companyId, emailAddress, password, headerMap, parameterMap, resultsMap);
	}
	
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
}