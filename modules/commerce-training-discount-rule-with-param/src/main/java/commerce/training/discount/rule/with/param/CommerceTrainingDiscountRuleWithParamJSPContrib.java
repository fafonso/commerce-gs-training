package commerce.training.discount.rule.with.param;

import com.liferay.commerce.discount.rule.type.CommerceDiscountRuleTypeJSPContributor;
import com.liferay.commerce.discount.service.CommerceDiscountRuleService;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import commerce.training.discount.rule.with.param.display.context.CommerceTrainingDiscountRuleDisplayContext;

@Component(
		immediate = true,
		property = {
				"commerce.discount.rule.type.jsp.contributor.key=" + CommerceTrainingDiscountRuleWithParamJSPContrib.KEY
				},
		service = CommerceDiscountRuleTypeJSPContributor.class
	)
public class CommerceTrainingDiscountRuleWithParamJSPContrib implements CommerceDiscountRuleTypeJSPContributor {
	
	/**
	 * It is important to provide a distinct key for the JSP contributor so that Liferay Commerce can distinguish the contributor 
	 * from others in the discount rule type JSP contributor registry. Declaring a key that is already in use overrides the existing 
	 * associated type.
	 */
	public static final String KEY = "Minimum Number of Products";

	/**
	 * This is where the code to render a custom UI input for our discount rule type goes.
	 * In this example we have created a "*DisplayContext" (to get information to the inputs edit)
	 * Instance a variable of "*DisplayContext" with the params and set on httpServletRequest as attribute to recover on JSP. 
	 */
	@Override
	public void render(long commerceDiscountId, long commerceDiscountRuleId, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		
		CommerceTrainingDiscountRuleDisplayContext commerceTrainingDiscountRuleDisplayContext =
			new CommerceTrainingDiscountRuleDisplayContext(_commerceDiscountRuleService,httpServletRequest);

	httpServletRequest.setAttribute("view.jsp-commerceTrainingDiscountRuleDisplayContext",commerceTrainingDiscountRuleDisplayContext);
		
		_jspRenderer.renderJSP(
				_servletContext, httpServletRequest, httpServletResponse,
				"/view.jsp");
	}
	
	@Reference
	private CommerceDiscountRuleService _commerceDiscountRuleService;
	
	/**
	 * Use a JSPRenderer to render the JSP for the discount rule type’s custom UI input (in our example, view.jsp). 
	 * Provide the ServletContext as a parameter to find the JSP.
	 */
	@Reference
	private JSPRenderer _jspRenderer;

	/**
	 * Define the ServletContext in the JSP contributor class using the bundle’s symbolic name so it can find the JSP:
	 * The value set for osgi.web.symbolicname matches the value for Bundle-SymbolicName in the bnd.bnd file. 
	 * These values must match for the ServletContext to locate the JSP
	 * Declare a unique value for Web-ContextPath in the bnd.bnd file so the ServletContext is correctly generated. 
	 */
	@Reference(target = "(osgi.web.symbolicname=commerce.training.discount.rule.with.param)")
	private ServletContext _servletContext;
}
