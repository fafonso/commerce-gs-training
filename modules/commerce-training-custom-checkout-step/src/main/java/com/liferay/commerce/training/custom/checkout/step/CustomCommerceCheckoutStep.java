
package com.liferay.commerce.training.custom.checkout.step;

import com.liferay.commerce.constants.CommerceCheckoutWebKeys;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.commerce.util.BaseCommerceCheckoutStep;
import com.liferay.commerce.util.CommerceCheckoutStep;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The checkout step name must be a unique value so that Liferay Commerce can
 * distinguish our checkout step from existing checkout steps. The
 * commerce.checkout.step.order value indicates how far into the checkout
 * process the checkout step will appear. For example, the shipping method
 * checkout step has a value of 20. Giving our checkout step a value of 21
 * ensures that it will appear immediately after the shipping method step.
 */

@Component(immediate = true, property = {
	"commerce.checkout.step.name=" + CustomCommerceCheckoutStep.NAME,
	"commerce.checkout.step.order:Integer=21"
	
}, service = CommerceCheckoutStep.class)
public class CustomCommerceCheckoutStep extends BaseCommerceCheckoutStep {

	public static final String NAME = "car-service-booking";

	/**
	 * This method returns the name of our checkout step. This name may be a 
	 * language key that corresponds to the name that will appear in the UI.
	 */	
	@Override
	public String getName() {
		return NAME;
	}
	/**
	 * The processAction method may be used to implement business logic 
	 * with the information passed through the ActionRequest if backend 
	 * processing is required.
	 */
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		
	}
	/**
	 * This will be where we add the code to render a customized screen for our checkout step.
	 */
	@Override
	public void render(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		_jspRenderer.renderJSP(
				_servletContext, httpServletRequest, httpServletResponse,
				"/checkout_step_custom.jsp");		
	}
	
	/**
	 * By default this method are implemented on "BaseCommerceCheckouStep" 
	 * Here we change the logic to Set active just if order has a Vehicle Service order item.
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
			
			if (commerceOrderItem.getCPDefinition().getProductTypeName().equals("Vehicle Service")) {
				return true;
			}
		}
		return true;
	}
	
	/**
	 * Use a JSPRenderer to render the JSP for our checkout step (in this case, checkout_step_custom.jsp). 
	 * Provide the ServletContext as a parameter to find the JSP we have created.
	 */
	@Reference
	private JSPRenderer _jspRenderer;
	
	/**
	 * Define the ServletContext using the symbolic name of our bnd.bnd
	 * These values must match for the ServletContext to locate the JSP.
	 */
	@Reference(target = "(osgi.web.symbolicname=com.liferay.commerce.training.custom.checkout.step)")
	private ServletContext _servletContext;
	
	/**
	 * We also need to declare a unique value for Web-ContextPath in our 
	 * bnd.bnd file so the ServletContext is correctly generated. In our example, 
	 * Web-ContextPath is set to  /commerce-training-custom-checkout-step
	 */
	

}
