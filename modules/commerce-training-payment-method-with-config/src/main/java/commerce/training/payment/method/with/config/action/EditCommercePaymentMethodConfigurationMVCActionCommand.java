package commerce.training.payment.method.with.config.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.settings.GroupServiceSettingsLocator;
import com.liferay.portal.kernel.settings.ModifiableSettings;
import com.liferay.portal.kernel.settings.Settings;
import com.liferay.portal.kernel.settings.SettingsFactory;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.commerce.product.constants.CPPortletKeys;
import com.liferay.commerce.product.model.CommerceChannel;
import com.liferay.commerce.product.service.CommerceChannelService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import commerce.training.payment.method.with.config.constants.PaymentMethodCardGroupServiceConstants;

/**
 * @author Roselaine Marques
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + CPPortletKeys.COMMERCE_PAYMENT_METHODS,
		"mvc.command.name=editCommercePaymentMethodConfiguration"
	},
	service = MVCActionCommand.class
)
public class EditCommercePaymentMethodConfigurationMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		if (cmd.equals(Constants.UPDATE)) {
			_updateCommercePaymentMethod(actionRequest);
		}
		
	}
	private void _updateCommercePaymentMethod(ActionRequest actionRequest)
			throws Exception {

			long commerceChannelId = ParamUtil.getLong(
				actionRequest, "commerceChannelId");

			CommerceChannel commerceChannel =
				_commerceChannelService.getCommerceChannel(commerceChannelId);

			Settings settings = _settingsFactory.getSettings(
				new GroupServiceSettingsLocator(
					commerceChannel.getGroupId(),
					PaymentMethodCardGroupServiceConstants.SERVICE_NAME));

			ModifiableSettings modifiableSettings =
				settings.getModifiableSettings();

			String clientId = ParamUtil.getString(
				actionRequest, "settings--clientId--");

			modifiableSettings.setValue("clientId", clientId);

			String clientSecret = ParamUtil.getString(
				actionRequest, "settings--clientSecret--");

			modifiableSettings.setValue("clientSecret", clientSecret);

			String mode = ParamUtil.getString(actionRequest, "settings--mode--");

			modifiableSettings.setValue("mode", mode);

			String paymentAttempts = ParamUtil.getString(
				actionRequest, "settings--paymentAttempts--");

			modifiableSettings.setValue("paymentAttemptsMaxCount", paymentAttempts);

			modifiableSettings.store();
		}

		@Reference
		private CommerceChannelService _commerceChannelService;

		@Reference
		private SettingsFactory _settingsFactory;

}
