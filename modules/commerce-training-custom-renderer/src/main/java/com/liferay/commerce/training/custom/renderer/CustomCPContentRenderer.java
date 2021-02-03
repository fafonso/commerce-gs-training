
package com.liferay.commerce.training.custom.renderer;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.commerce.product.catalog.CPCatalogEntry;
import com.liferay.commerce.product.content.render.CPContentRenderer;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import commerce.training.car.garage.model.CarGarage;
import commerce.training.car.garage.model.CarGarageProduct;
import commerce.training.car.garage.service.CarGarageLocalService;
import commerce.training.car.garage.service.CarGarageProductLocalService;

/**
 * It is important to provide a distinct key for the product content renderer so
 * that Liferay Commerce can distinguish the new renderer from others in the
 * product content renderer registry. Reusing a key that is already in use will
 * override the existing associated renderer. The
 * commerce.product.content.renderer.order property determines the ordering of
 * renderers in the UI, from lowest to highest value. For example, the
 * SimpleCPContentRenderer has this property set to the minimum integer value,
 * so other renderers for Simple type products will appear after it in the list.
 * The commerce.product.content.renderer.type property determines what type of
 * product this renderer can be used for. In our example, we use a Simple type,
 * so the renderer will appear under the Simple category in the UI.
 */
@Component(immediate = true, property = {
	"commerce.product.content.renderer.key=" + CustomCPContentRenderer.KEY,
    "commerce.product.content.renderer.order=" + 1,
	"commerce.product.content.renderer.type=Vehicle Service",
}, service = CPContentRenderer.class)
public class CustomCPContentRenderer implements CPContentRenderer {

	public static final String KEY = "vehicle-service";

	/**
	 * This method provides a unique identifier for the product content renderer
	 * in the product content renderer registry. The key can be used to fetch
	 * the renderer from the registry. Reusing a key that is already in use will
	 * override the existing associated renderer.
	 */
	@Override
	public String getKey() {

		return KEY;
	}

	/**
	 * This returns a text label that describes the product content renderer.
	 * See the implementation in CustomCPContentRenderer.java for a reference in
	 * retrieving the label with a language key.
	 */
	@Override
	public String getLabel(Locale locale) {

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "vehicle-service");
	}

	@Override
	public void render(
		CPCatalogEntry cpCatalogEntry, HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse)
		throws Exception {

		CarGarage carGarage = _carGarageLocalService.findByCPDefinitionId(
			cpCatalogEntry.getCPDefinitionId());

		List<CarGarageProduct> carGarageProducts =
			_carGarageProductLocalService.findByCarGarageId(
				carGarage.getCarGarageId());

		httpServletRequest.setAttribute("cpCatalogEntry", cpCatalogEntry);
		httpServletRequest.setAttribute("carGarage", carGarage);
		httpServletRequest.setAttribute("carGarageProducts", carGarageProducts);
		httpServletRequest.setAttribute(
			"carServiceName", cpCatalogEntry.getName());
		httpServletRequest.setAttribute("latitude", carGarage.getLatitude());
		httpServletRequest.setAttribute("longitude", carGarage.getLongitude());

		_jspRenderer.renderJSP(
			_servletContext, httpServletRequest, httpServletResponse,
			"/view.jsp");

	}

	private static final Log _log =
		LogFactoryUtil.getLog(CustomCPContentRenderer.class);

	@Reference
	private JSPRenderer _jspRenderer;

	@Reference(target = "(osgi.web.symbolicname=com.liferay.commerce.training.custom.renderer)")
	private ServletContext _servletContext;

	@Reference
	private CarGarageLocalService _carGarageLocalService;

	@Reference
	private CarGarageProductLocalService _carGarageProductLocalService;

}
