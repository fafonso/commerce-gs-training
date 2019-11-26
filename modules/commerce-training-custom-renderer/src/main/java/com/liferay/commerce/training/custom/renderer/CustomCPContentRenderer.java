
package com.liferay.commerce.training.custom.renderer;

import com.liferay.commerce.product.catalog.CPCatalogEntry;
import com.liferay.commerce.product.content.render.CPContentRenderer;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import commerce.training.car.garage.model.CarGarage;
import commerce.training.car.garage.model.CarGarageProduct;
import commerce.training.car.garage.service.CarGarageLocalService;
import commerce.training.car.garage.service.CarGarageProductLocalService;

@Component(immediate = true, property = {
	"commerce.product.content.renderer.key=" + CustomCPContentRenderer.KEY,
	"commerce.product.content.renderer.type=Vehicle Service",
}, service = CPContentRenderer.class)
public class CustomCPContentRenderer implements CPContentRenderer {

	public static final String KEY = "vehicle-service";

	@Override
	public String getKey() {

		return KEY;
	}

	@Override
	public String getLabel(Locale locale) {

		return KEY;
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
