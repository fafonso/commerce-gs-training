
package com.liferay.training.servlet.taglib.ui;

import com.liferay.commerce.product.definitions.web.portlet.action.ActionHelper;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.service.CPDefinitionLocalService;
import com.liferay.frontend.taglib.servlet.taglib.ScreenNavigationCategory;
import com.liferay.frontend.taglib.servlet.taglib.ScreenNavigationEntry;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.training.product.display.VehicleServiceDisplayContext;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import commerce.training.car.garage.service.CarGarageLocalService;
import commerce.training.car.garage.service.CarGarageProductLocalService;

@Component(property = {
	"screen.navigation.category.order:Integer=11",
	"screen.navigation.entry.order:Integer=11"
}, service = {
	ScreenNavigationCategory.class, ScreenNavigationEntry.class
})
public class VehicleServiceScreenNavigationEntry
	implements ScreenNavigationCategory, ScreenNavigationEntry<CPDefinition> {
	
	/**
	 * It is important to provide a distinct key for the navigation screen class 
	 * so that Liferay Commerce can distinguish it as a separate screen from the 
	 * existing screens. Reusing a key that is already in use will override the 
	 * existing associated navigation screen.
	 */
	public static final String KEY = "Vehicle Service";

	/**
	 * This returns a unique identifier for the category used for the screen navigation entry.
	 */
	@Override
	public String getCategoryKey() {

		return KEY;
	}
	/**
	 * This returns a unique identifier for the screen navigation entry. It returns the same 
	 * value as getCategoryKey.
	 */
	@Override
	public String getEntryKey() {

		return KEY;
	}
	/**
	 * This returns a text label for the screen navigation entry that will be displayed in the UI. 
	 * See the implementation in C1N4ScreenNavigationEntry.java for a reference in retrieving 
	 * the label with a language key.
	 */
	@Override
	public String getLabel(Locale locale) {

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "vehicle-service");
	}

	/**
	 * This is the same method as getScreenNavigationKey for the ScreenNavigationCategory interface. 
	 * We implemented this method by returning the string value "cp.definition.general".
	 */
	@Override
	public String getScreenNavigationKey() {

		return "cp.definition.general";
	}

	/**
	 * Implement logic here to determine when to show the custom screen. In our
	 * example, we only check whether the product type from the CPDefinition
	 * matches our example product type.
	 */
	@Override
	public boolean isVisible(User user, CPDefinition context) {

		if (context == null) {
			return false;
		}

		String productTypeName = context.getProductTypeName();

		if (productTypeName.equals(getCategoryKey())) {
			return true;
		}

		return false;
	}

	/**
	 * This is where we add the code to render a customized screen for our
	 * product type.
	 */
	@Override
	public void render(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse)
		throws IOException {

		try {
			VehicleServiceDisplayContext vehicleServiceDisplayContext =
				new VehicleServiceDisplayContext(
					_actionHelper, httpServletRequest, _carGarageLocalService,
					_carGarageProductLocalService, _cpDefinitionLocalService);

			httpServletRequest.setAttribute(
				WebKeys.PORTLET_DISPLAY_CONTEXT, vehicleServiceDisplayContext);

		}
		catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		_jspRenderer.renderJSP(
			_servletContext, httpServletRequest, httpServletResponse,
			"/edit_product.jsp");

	}

	private static final Log _log =
		LogFactoryUtil.getLog(VehicleServiceScreenNavigationEntry.class);

	@Reference
	private JSPRenderer _jspRenderer;

	/**
	 * Define the ServletContext in our ScreenNavigationEntry class using the symbolic name of our 
	 * bundle so that it can find the JSP in our module.
	 * 
	 * We declare a unique value for Web-ContextPath in our bnd.bnd file so the ServletContext is 
	 * correctly generated. In our example, Web-ContextPath is set to /commerce-training-product-type. See bnd.bnd for 
	 * a reference on these values.
	 */
	@Reference(target = "(osgi.web.symbolicname=commerce.training.product.type)")
	private ServletContext _servletContext;

	@Reference
	private ActionHelper _actionHelper;

	@Reference
	private CPDefinitionLocalService _cpDefinitionLocalService;

	@Reference
	private CarGarageLocalService _carGarageLocalService;

	@Reference
	private CarGarageProductLocalService _carGarageProductLocalService;

}
