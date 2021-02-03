package commerce.training.exchange.rate.api;

import com.liferay.commerce.currency.model.CommerceCurrency;
import com.liferay.commerce.currency.util.ExchangeRateProvider;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.math.BigDecimal;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Roselaine Marques
 */

@Component(
	    immediate = true,
	    property = "commerce.exchange.provider.key=" + CommerceTrainigExchangeRateProvider.KEY,
	    service = ExchangeRateProvider.class
	)
public class CommerceTrainigExchangeRateProvider implements ExchangeRateProvider {
	
	/**
	 * It is important to provide a distinct key for the exchange rate provider so that Liferay Commerce 
	 * can distinguish the new exchange rate provider from others in the exchange rate provider registry. 
	 * Reusing a key that is already in use will override the existing associated exchange rate provider.
	 */
	public static final String KEY = "Example";
	
	/**
	 * This method is called to calculate the exchange rate between currencies. The chosen data source for 
	 * the rates must be able to handle any of the currencies that may be used in your instance of Liferay Commerce.
	 */
	@Override
	public BigDecimal getExchangeRate(CommerceCurrency primaryCommerceCurrency, CommerceCurrency secondaryCommerceCurrency) throws Exception {
	
		String primaryCurrencyCode = primaryCommerceCurrency.getCode();
		String secondaryCurrencyCode = secondaryCommerceCurrency.getCode();

		primaryCurrencyCode = StringUtil.toUpperCase(primaryCurrencyCode);
		secondaryCurrencyCode = StringUtil.toUpperCase(secondaryCurrencyCode);

		JSONArray exchangeRatesArray = _getStaticExchangeRates();

		List<String> codesList = JSONUtil.toStringList(
			exchangeRatesArray, "code");

		double primaryRate = _getRateForCode(
			exchangeRatesArray, codesList, primaryCurrencyCode);
		double secondaryRate = _getRateForCode(
			exchangeRatesArray, codesList, secondaryCurrencyCode);

		return new BigDecimal(secondaryRate / primaryRate);
	}
	
	private double _getRateForCode(
			JSONArray ratesArray, List<String> codesList, String code) {

			int index = codesList.indexOf(code);

			JSONObject jsonObject = ratesArray.getJSONObject(index);

			return jsonObject.getDouble("rate");
		}

		private JSONArray _getStaticExchangeRates() throws Exception {
			Class<?> clazz = getClass();

			String countriesPath = "com/exchange/rates/exchange_rates.json";

			String countriesJSON = StringUtil.read(
				clazz.getClassLoader(), countriesPath, false);

			return JSONFactoryUtil.createJSONArray(countriesJSON);
		}
}