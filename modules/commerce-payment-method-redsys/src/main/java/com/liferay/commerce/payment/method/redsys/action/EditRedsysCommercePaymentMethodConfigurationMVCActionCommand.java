package com.liferay.commerce.payment.method.redsys.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.settings.GroupServiceSettingsLocator;
import com.liferay.portal.kernel.settings.ModifiableSettings;
import com.liferay.portal.kernel.settings.Settings;
import com.liferay.portal.kernel.settings.SettingsFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.commerce.payment.method.redsys.constants.RedsysCommercePaymentMethodConstants;
import com.liferay.commerce.product.constants.CPPortletKeys;
import com.liferay.commerce.product.model.CommerceChannel;
import com.liferay.commerce.product.service.CommerceChannelService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author Roselaine Marques
 *
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + CPPortletKeys.COMMERCE_PAYMENT_METHODS,
		"mvc.command.name=editCommercePaymentMethodConfiguration"
	},
	service = MVCActionCommand.class
)
public class EditRedsysCommercePaymentMethodConfigurationMVCActionCommand extends BaseMVCActionCommand{

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
				actionRequest, RedsysCommercePaymentMethodConstants.COMMERCE_CHANNEL_ID);

		CommerceChannel commerceChannel =
				_commerceChannelService.getCommerceChannel(commerceChannelId);

		Settings settings = _settingsFactory.getSettings(
				new GroupServiceSettingsLocator(
						commerceChannel.getGroupId(),
						RedsysCommercePaymentMethodConstants.SERVICE_NAME));

		ModifiableSettings modifiableSettings =
				settings.getModifiableSettings();

		String dsSignatureVersion = ParamUtil.getString(
				actionRequest, RedsysCommercePaymentMethodConstants.SETTINGS_DS_SIGNATURE_VERSION);

		modifiableSettings.setValue("dsSignatureVersion", dsSignatureVersion);

		String clientSecret = ParamUtil.getString(
				actionRequest, RedsysCommercePaymentMethodConstants.SETTINGS_CLIENT_SECRET);

		modifiableSettings.setValue("clientSecret", clientSecret);

		String mode = ParamUtil.getString(actionRequest, RedsysCommercePaymentMethodConstants.SETTINGS_MODE);

		modifiableSettings.setValue("mode", mode);

		String merchantCode = ParamUtil.getString(
				actionRequest, RedsysCommercePaymentMethodConstants.SETTINGS_MERCHANT_CODE);

		modifiableSettings.setValue("merchantCode", merchantCode);

		String terminal = ParamUtil.getString(actionRequest, RedsysCommercePaymentMethodConstants.SETTINGS_TERMINAL);

		modifiableSettings.setValue("terminal", terminal);

		String typeTransaction = ParamUtil.getString(actionRequest, RedsysCommercePaymentMethodConstants.SETTINGS_TYPES_OF_TRANSACTION);

		modifiableSettings.setValue("typeTransaction", typeTransaction);

		modifiableSettings.store();
	}

		@Reference
		private CommerceChannelService _commerceChannelService;

		@Reference
		private SettingsFactory _settingsFactory;

}
