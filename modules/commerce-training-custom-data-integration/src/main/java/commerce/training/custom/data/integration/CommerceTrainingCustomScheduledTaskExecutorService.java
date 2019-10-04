package commerce.training.custom.data.integration;

import java.io.IOException;

import org.osgi.service.component.annotations.Component;

import com.liferay.commerce.data.integration.service.ScheduledTaskExecutorService;
import com.liferay.portal.kernel.exception.PortalException;

import commerce.training.custom.data.integration.type.CommerceTrainingCustomDataIntegrationType;

/**
 * @author fafonso
 */
@Component(
		immediate = true,
		property = "data.integration.service.executor.key=" + CommerceTrainingCustomDataIntegrationType.KEY,
		service = ScheduledTaskExecutorService.class
	)
public class CommerceTrainingCustomScheduledTaskExecutorService implements ScheduledTaskExecutorService {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void runProcess(long commerceDataIntegrationProcessId) throws IOException, PortalException {
		// TODO Auto-generated method stub
		
	}
	

}