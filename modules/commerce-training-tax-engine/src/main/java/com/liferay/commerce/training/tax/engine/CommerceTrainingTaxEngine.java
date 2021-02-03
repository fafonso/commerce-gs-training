package com.liferay.commerce.training.tax.engine;

import com.liferay.commerce.exception.CommerceTaxEngineException;
import com.liferay.commerce.tax.CommerceTaxCalculateRequest;
import com.liferay.commerce.tax.CommerceTaxEngine;
import com.liferay.commerce.tax.CommerceTaxValue;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.math.BigDecimal;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = "commerce.tax.engine.key=" + CommerceTrainingTaxEngine.KEY,
	service = CommerceTaxEngine.class
)
public class CommerceTrainingTaxEngine implements CommerceTaxEngine {

	/**
	 * It is important to provide a distinct key for the tax engine so that Liferay Commerce can distinguish 
	 * the new engine from others in the tax engine registry. Reusing a key that is already in use will override 
	 * the existing associated tax engine.
	 */
	public static final String KEY = "Example";

	/**
	 * This method will be where the business logic is implemented for our tax engine.
	 * The CommerceTaxCalculateRequest parameter contains information needed for making our calculation. 
	 * For this example, we use the price from the CommerceTaxCalculateRequest, as well as a value indicating whether
	 * to apply the rate as a percentage
	 */
	@Override
	public CommerceTaxValue getCommerceTaxValue(
			CommerceTaxCalculateRequest commerceTaxCalculateRequest)
		throws CommerceTaxEngineException {

		BigDecimal flatTaxValue = new BigDecimal("1.50");

		if (commerceTaxCalculateRequest.isPercentage()) {
			flatTaxValue = flatTaxValue.divide(new BigDecimal(100.0));

			flatTaxValue = flatTaxValue.multiply(
				commerceTaxCalculateRequest.getPrice());
		}

		return new CommerceTaxValue("flat-tax", KEY, flatTaxValue);
	}
	/**
	 * This returns a brief description of our tax engine. Retrieving the description with a language key.
	 */
	@Override
	public String getDescription(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(
			resourceBundle, "a-flat-tax-rate-that-does-not-adjust");
	}
	/**
	 * This returns the name of our tax engine. It works similarly to the getDescription method.
	 */
	@Override
	public String getName(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "flat-tax");
	}

}