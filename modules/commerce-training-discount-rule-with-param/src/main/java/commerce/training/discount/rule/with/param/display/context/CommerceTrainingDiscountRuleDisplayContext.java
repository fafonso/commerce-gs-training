package commerce.training.discount.rule.with.param.display.context;
import com.liferay.commerce.discount.model.CommerceDiscountRule;
import com.liferay.commerce.discount.service.CommerceDiscountRuleService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.bean.BeanParamUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Roselaine Marques
 */
public class CommerceTrainingDiscountRuleDisplayContext {
	
	public CommerceTrainingDiscountRuleDisplayContext(CommerceDiscountRuleService commerceDiscountRuleService,
			HttpServletRequest httpServletRequest){
		
		_commerceDiscountRuleService = commerceDiscountRuleService;
		_httpServletRequest = httpServletRequest;

	}
	
	public String getTypeSettings() throws PortalException {
		CommerceDiscountRule commerceDiscountRule = getCommerceDiscountRule();

		if (commerceDiscountRule == null) {
			return StringPool.BLANK;
		}

		String type = BeanParamUtil.getString(
			commerceDiscountRule, _httpServletRequest, "type");

		return commerceDiscountRule.getSettingsProperty(type);
	}

	public CommerceDiscountRule getCommerceDiscountRule()
			throws PortalException {

			if (_commerceDiscountRule != null) {
				return _commerceDiscountRule;
			}

			long commerceDiscountRuleId = ParamUtil.getLong(
				_httpServletRequest, "commerceDiscountRuleId");

			if (commerceDiscountRuleId > 0) {
				_commerceDiscountRule =
					_commerceDiscountRuleService.getCommerceDiscountRule(
						commerceDiscountRuleId);
			}

			return _commerceDiscountRule;
		}
	
	private final HttpServletRequest _httpServletRequest;
	private CommerceDiscountRule _commerceDiscountRule;
	private final CommerceDiscountRuleService _commerceDiscountRuleService;
}
