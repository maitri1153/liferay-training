package com.object.script.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true, 
	property = { "destination.name=add/object/message" }, 
	service = MessageListener.class
)
public class ObjectMessageBusListener extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws Exception {
		log.info("This is a destination class");
		log.info("Object entry Id" + message.getLong("entryId"));
	}
	private static final Log log = LogFactoryUtil.getLog(ObjectMessageBusListener.class);
}
