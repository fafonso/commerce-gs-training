package commerce.training.payment.method.with.config.taglib.ui;

import com.liferay.frontend.taglib.servlet.taglib.ScreenNavigationEntry;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.settings.GroupServiceSettingsLocator;
import com.liferay.portal.kernel.settings.ParameterMapSettingsLocator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.commerce.payment.constants.CommercePaymentScreenNavigationConstants;
import com.liferay.commerce.payment.model.CommercePaymentMethodGroupRel;
import com.liferay.commerce.product.model.CommerceChannel;
import com.liferay.commerce.product.service.CommerceChannelService;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import commerce.training.payment.method.with.config.CommercePaymentMethodWithConfig;
import commerce.training.payment.method.with.config.configuration.PaymentMethodCardGroupServiceConfiguration;
import commerce.training.payment.method.with.config.constants.PaymentMethodCardGroupServiceConstants;

@Component(
		property = "screen.navigation.entry.order:Integer=20",
		service = ScreenNavigationEntry.class
	)
public class CommercePaymentMethodCardConfigurationScreenNavigationEntry implements ScreenNavigationEntry<CommercePaymentMethodGroupRel> {

	public static final String
	ENTRY_KEY_CARD_COMMERCE_PAYMENT_METHOD_CONFIGURATION =
		"card-configuration";
	
	@Override
	public String getCategoryKey() {
		return CommercePaymentScreenNavigationConstants.
				CATEGORY_KEY_COMMERCE_PAYMENT_METHOD_CONFIGURATION;
	}

	@Override
	public String getEntryKey() {
		return ENTRY_KEY_CARD_COMMERCE_PAYMENT_METHOD_CONFIGURATION;
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(
				locale,
				CommercePaymentScreenNavigationConstants.
					CATEGORY_KEY_COMMERCE_PAYMENT_METHOD_CONFIGURATION);
	}

	@Override
	public String getScreenNavigationKey() {
		return CommercePaymentScreenNavigationConstants.
				SCREEN_NAVIGATION_KEY_COMMERCE_PAYMENT_METHOD;
	}

	@Override
	public boolean isVisible(
		User user, CommercePaymentMethodGroupRel commercePaymentMethod) {

		if (commercePaymentMethod == null) {
			return false;
		}

		if (CommercePaymentMethodWithConfig.KEY.equals(
				commercePaymentMethod.getEngineKey())) {

			return true;
		}

		return false;
	}
	
	@Override
	public void render(HttpServletRequest httpServletRequest,
	HttpServletResponse httpServletResponse) throws IOException {

		try {
			long commerceChannelId = ParamUtil.getLong(httpServletRequest, "commerceChannelId");

			CommerceChannel commerceChannel = _commerceChannelService.getCommerceChannel(commerceChannelId);

			PaymentMethodCardGroupServiceConfiguration paymentCardGroupServiceConfiguration =
				_configurationProvider.getConfiguration(
					PaymentMethodCardGroupServiceConfiguration.class,
					new ParameterMapSettingsLocator(httpServletRequest.getParameterMap(),
					new GroupServiceSettingsLocator(commerceChannel.getGroupId(),
					PaymentMethodCardGroupServiceConstants.SERVICE_NAME))
					);

			httpServletRequest.setAttribute(
					PaymentMethodCardGroupServiceConfiguration.class.getName(),paymentCardGroupServiceConfiguration);
		}
		catch (Exception e) {
			throw new IOException(e);
		}

		_jspRenderer.renderJSP(
			_servletContext, httpServletRequest, httpServletResponse,
			"/configuration.jsp");
	}

	@Reference
	private CommerceChannelService _commerceChannelService;

	@Reference
	private ConfigurationProvider _configurationProvider;

	@Reference
	private JSPRenderer _jspRenderer;

	@Reference(
		target = "(osgi.web.symbolicname=commerce.training.payment.method.with.config)"
	)
	private ServletContext _servletContext;

}
