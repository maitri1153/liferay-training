package com.object.script.portlet;

import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.DestinationConfiguration;
import com.liferay.portal.kernel.messaging.DestinationFactory;
import com.liferay.portal.kernel.util.HashMapDictionaryBuilder;
import java.util.Dictionary;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = ObjectScriptWebPortlet.class
)
public class ObjectScriptWebPortlet {
	
	@Activate
	protected void activate(BundleContext BundleContext) {
		bundleContext = BundleContext;
		DestinationConfiguration destinationConfiguration = DestinationConfiguration
				.createSerialDestinationConfiguration("add/object/message");
		Destination destination = destinationFactory.createDestination(destinationConfiguration);
		Dictionary<String, Object> dictionary = HashMapDictionaryBuilder
				.<String, Object>put("destination.name", destination.getName()).build();
		serviceRegistration = bundleContext.registerService(Destination.class, destination, dictionary);
	}
	
	@Deactivate
	protected void deactivate() {
		if (serviceRegistration != null) {
			Destination destination = bundleContext.getService(serviceRegistration.getReference());
			serviceRegistration.unregister();
			destination.destroy();
		}
		bundleContext = null;
	}
	
	private volatile BundleContext bundleContext;
	@Reference
	private DestinationFactory destinationFactory;
	private ServiceRegistration<Destination> serviceRegistration;
}