package commerce.training.simple.product.render;

import com.liferay.commerce.product.catalog.CPCatalogEntry;
import com.liferay.commerce.product.content.render.CPContentRenderer;
import com.liferay.commerce.product.type.simple.constants.SimpleCPTypeConstants;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Roselaine Marques
 * 
 * A product content renderer provides a style of displaying product details for a 
 * specific product type, in a variety of widgets that can display products.
 * 
 * It is important to provide a distinct key for the product content renderer so that 
 * Liferay Commerce can distinguish the new renderer from others in the product content 
 * renderer registry. Reusing a key that is already in use will override the existing 
 * associated renderer. 
 * 
 * The commerce.product.content.renderer.order property determines 
 * the ordering of renderers in the UI, from lowest to highest value. For example, the 
 * SimpleCPContentRenderer has this property set to the minimum integer value, so other 
 * renderers for Simple type products will appear after it in the list. 
 * 
 * The commerce.product.content.renderer.type property determines what type of product 
 * this renderer can be used for. In our example, we use a Simple type, so the renderer 
 * will appear under the Simple category in the UI.
 * 
 */
@Component(
		immediate = true,
		property = {
			"commerce.product.content.renderer.key=" + SimpleCustomContentRender.KEY,
			"commerce.product.content.renderer.order=" + 1,
			"commerce.product.content.renderer.type=" + SimpleCPTypeConstants.NAME
		},
		service = CPContentRenderer.class
	)
public class SimpleCustomContentRender implements CPContentRenderer{
	
	public static final String KEY = "Example";

	/**
	 * This method provides a unique identifier for the product content renderer in the product 
	 * content renderer registry. The key can be used to fetch the renderer from the registry. 
	 * Reusing a key that is already in use will override the existing associated renderer.
	 */
	@Override
	public String getKey() {
		return KEY;
	}

	/**
	 * This returns a localizable text label that describes the product content renderer
	 */
	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "example");
	}
	
	/**
	 * This is where we add the code to render a customized view for our product content renderer.
	 * There are several ways to define a view: JSP, Freemarker template, or Soy template.
	 */
	@Override
	public void render(
			CPCatalogEntry cpCatalogEntry,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws Exception {

		_jspRenderer.renderJSP(
			_servletContext, httpServletRequest, httpServletResponse,
			"/view.jsp");
	}

	/**
	 * Use a JSPRenderer to render the JSP for our product content renderer (in this case, view.jsp). 
	 * Provide the ServletContext as a parameter to find the JSP we have created.
	 */
	@Reference
	private JSPRenderer _jspRenderer;
	
	/**
	 * The value we set for osgi.web.symbolicname matches the value for Bundle-SymbolicName in our bnd.bnd file.
	 * These values must match for the ServletContext to locate the JSP.
	 * 
	 * We also need to declare a unique value for Web-ContextPath in our bnd.bnd file so the ServletContext is 
	 * correctly generated.
	 */
	@Reference(target = "(osgi.web.symbolicname=commerce.training.simple.product.render)")
	private ServletContext _servletContext;

}