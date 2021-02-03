package commerce.training.payment.method.with.config.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
		category = "payment", scope = ExtendedObjectClassDefinition.Scope.GROUP
	)
@Meta.OCD(
	id = "commerce.training.payment.method.with.config.configuration.PaymentMethodCardGroupServiceConfiguration",
	localization = "content/Language",
	name = "commerce-payment-method-card-group-service-configuration-name"
)
public interface PaymentMethodCardGroupServiceConfiguration {

	@Meta.AD(name = "client-id", required = false)
	public String clientId();

	@Meta.AD(name = "mode", required = false)
	public String mode();

	@Meta.AD(name = "client-secret", required = false)
	public String clientSecret();

	@Meta.AD(deflt = "0", name = "payment-attempts-max-count", required = false)
	public String paymentAttemptsMaxCount();
}
