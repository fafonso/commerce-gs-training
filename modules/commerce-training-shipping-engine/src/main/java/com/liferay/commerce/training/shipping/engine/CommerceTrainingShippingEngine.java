
package com.liferay.commerce.training.shipping.engine;

import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.exception.CommerceShippingEngineException;
import com.liferay.commerce.model.CommerceAddress;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceShippingEngine;
import com.liferay.commerce.model.CommerceShippingMethod;
import com.liferay.commerce.model.CommerceShippingOption;
import com.liferay.commerce.service.CommerceAddressRestrictionLocalService;
import com.liferay.commerce.service.CommerceShippingMethodLocalService;
import com.liferay.commerce.shipping.engine.fixed.model.CommerceShippingFixedOption;
import com.liferay.commerce.shipping.engine.fixed.service.CommerceShippingFixedOptionLocalService;
import com.liferay.commerce.util.CommerceShippingHelper;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * It is important to provide a distinct key for the shipping engine so that
 * Liferay Commerce can distinguish the new engine from others in the shipping
 * engine registry. Reusing a key that is already in use will override the
 * existing associated engine.
 */
@Component(immediate = true, property = "commerce.shipping.engine.key=" +
	CommerceTrainingShippingEngine.KEY, service = CommerceShippingEngine.class)
public class CommerceTrainingShippingEngine implements CommerceShippingEngine {

	public static final double DISCOUNT_RATE = 0.75;

	public static final String KEY = "Example";

	/**
	 * This method returns a text label used for shipping options. See the
	 * implementation in CommerceTrainingShippingEngine.java for a reference in
	 * retrieving the description with a language key.
	 */
	@Override
	public String getCommerceShippingOptionLabel(String name, Locale locale) {

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, name);
	}

	/**
	 * This will be where we add the business logic for our custom shipping
	 * engine. It must fetch a list of available options, then perform the
	 * processing necessary to present them to the customer.
	 */
	@Override
	public List<CommerceShippingOption> getCommerceShippingOptions(
		CommerceContext commerceContext, CommerceOrder commerceOrder,
		Locale locale)
		throws CommerceShippingEngineException {

		List<CommerceShippingOption> commerceShippingOptions =
			new ArrayList<>();

		try {
			commerceShippingOptions = _getCommerceShippingOptions(
					commerceOrder.getGroupId() , commerceOrder, locale);
		}
		catch (PortalException pe) {
			if (_log.isDebugEnabled()) {
				_log.debug(pe, pe);
			}
		}

		return commerceShippingOptions;
	}

	@Override
	public String getDescription(Locale locale) {

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "ship-for-a-discounted-price");
	}

	@Override
	public String getName(Locale locale) {

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "discounted-rate");
	}

	/**
	 * First, use CommerceShippingMethodLocalService to get the “shipping method” (representing our shipping engine), 
	 * and then use CommerceShippingFixedOptionLocalService to get the available options.
	 */
	private List<CommerceShippingFixedOption> _getCommerceShippingFixedOptions(
		long groupId) {
		
		// We don't have implementation Shipping Options for this engine. For this I changed to get the Fixed Options -> changing the "KEY" to "fixed"
		//CommerceShippingMethod commerceShippingMethod =_commerceShippingMethodLocalService.fetchCommerceShippingMethod(groupId, KEY);
		
		CommerceShippingMethod commerceShippingMethod =_commerceShippingMethodLocalService.fetchCommerceShippingMethod(groupId, "fixed");

		
		if (commerceShippingMethod == null) {
			return Collections.emptyList();
		}

		return _commerceShippingFixedOptionLocalService.getCommerceShippingFixedOptions(
			commerceShippingMethod.getCommerceShippingMethodId(),
			QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	private List<CommerceShippingOption> _getCommerceShippingOptions(
		long groupId, CommerceOrder commerceOrder, Locale locale)
		throws PortalException {

		List<CommerceShippingOption> commerceShippingOptions =
			new ArrayList<>();

		List<CommerceShippingFixedOption> commerceShippingFixedOptions =
			_getCommerceShippingFixedOptions(groupId);

		for (CommerceShippingFixedOption commerceShippingFixedOption : commerceShippingFixedOptions) {

			if (_shippingOptionIsAddressRestricted(
				commerceOrder, commerceShippingFixedOption)) {

				continue;
			}

			String name = commerceShippingFixedOption.getName(locale);

			if (_commerceShippingHelper.isFreeShipping(commerceOrder)) {
				commerceShippingOptions.add(
					new CommerceShippingOption(name, name, BigDecimal.ZERO));
			}

			BigDecimal amount = commerceShippingFixedOption.getAmount();

			amount = amount.multiply(new BigDecimal(DISCOUNT_RATE));

			commerceShippingOptions.add(
				new CommerceShippingOption(name, name, amount));
		}

		return commerceShippingOptions;
	}

	private boolean _shippingOptionIsAddressRestricted(
		CommerceOrder commerceOrder,
		CommerceShippingFixedOption commerceShippingFixedOption)
		throws PortalException {

		CommerceAddress commerceAddress = commerceOrder.getShippingAddress();

		return _commerceAddressRestrictionLocalService.isCommerceShippingMethodRestricted(
			commerceShippingFixedOption.getCommerceShippingMethodId(),
			commerceAddress.getCommerceCountryId());
	}
	
	private static final Log _log =
		LogFactoryUtil.getLog(CommerceTrainingShippingEngine.class);

	@Reference
	private CommerceAddressRestrictionLocalService _commerceAddressRestrictionLocalService;

	@Reference
	private CommerceShippingFixedOptionLocalService _commerceShippingFixedOptionLocalService;

	@Reference
	private CommerceShippingHelper _commerceShippingHelper;

	@Reference
	private CommerceShippingMethodLocalService _commerceShippingMethodLocalService;

}
