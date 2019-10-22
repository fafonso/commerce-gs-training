
package com.liferay.commerce.training.custom.checkout.step;

import com.liferay.commerce.constants.CommerceCheckoutWebKeys;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.commerce.util.CommerceCheckoutStep;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
	"commerce.checkout.step.name=" + CustomCommerceCheckoutStep.NAME,
	"commerce.checkout.step.order:Integer=" + (Integer.MAX_VALUE - 151)
}, service = CommerceCheckoutStep.class)
public class CustomCommerceCheckoutStep implements CommerceCheckoutStep {

	public static final String NAME = "Car Service Booking";

	@Override
	public String getLabel(Locale locale) {

		return NAME;
	}

	@Override
	public String getName() {

		return NAME;
	}

	/**
	 * Set active is order has a Vehicle Service order item.
	 */
	@Override
	public boolean isActive(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse)
		throws Exception {

		CommerceOrder commerceOrder =
			(CommerceOrder) httpServletRequest.getAttribute(
				CommerceCheckoutWebKeys.COMMERCE_ORDER);

		List<CommerceOrderItem> commerceOrderItems =
			commerceOrder.getCommerceOrderItems();

		for (CommerceOrderItem commerceOrderItem : commerceOrderItems) {
			if (commerceOrderItem.getCPDefinition().getProductTypeName().equals(
				"Vehicle Service")) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isOrder() {

		return false;
	}

	@Override
	public boolean isSennaDisabled() {

		return false;
	}

	@Override
	public boolean isVisible(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse)
		throws Exception {

		return isActive(httpServletRequest, httpServletResponse);
	}

	@Override
	public void processAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

	}

	/**
	 * Jsp to be rendered in checkout step.
	 */
	@Override
	public void render(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse)
		throws Exception {

		_jspRenderer.renderJSP(
			_servletContext, httpServletRequest, httpServletResponse,
			"/checkout_step/view.jsp");
	}

	@Override
	public boolean showControls(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		return true;
	}

	@Reference
	private JSPRenderer _jspRenderer;

	@Reference(target = "(osgi.web.symbolicname=com.liferay.commerce.training.custom.checkout.step)")
	private ServletContext _servletContext;

}
