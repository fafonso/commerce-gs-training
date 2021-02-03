package commerce.training.custom.data.integration.type;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

import com.liferay.commerce.data.integration.process.type.ProcessType;
import com.liferay.portal.kernel.language.LanguageUtil;


@Component(
		immediate = true,
		property = {
			"commerce.data.integration.process.type.key=" + CommerceTrainingCustomDataIntegrationType.KEY,
			"commerce.data.integration.process.type.order=90"
		},
		service = ProcessType.class
	)
public class CommerceTrainingCustomDataIntegrationType implements ProcessType {

	public static final String KEY = "Garage Service CSV";

	@Override
	public String getKey() {
		return KEY;
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, getKey());
	}

}