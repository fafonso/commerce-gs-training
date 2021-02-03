
package com.liferay.training.product.display;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import com.liferay.commerce.product.display.context.BaseCPDefinitionsDisplayContext;
import com.liferay.commerce.product.portlet.action.ActionHelper;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.service.CPDefinitionLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import commerce.training.car.garage.model.CarGarage;
import commerce.training.car.garage.model.CarGarageProduct;
import commerce.training.car.garage.service.CarGarageLocalService;
import commerce.training.car.garage.service.CarGarageProductLocalService;
/**
 * 
 * @author Roselaine Marques
 * 
 * To get values based on CPDefinitions to show on edit_product.jsp.
 *
 */
public class VehicleServiceDisplayContext
	extends BaseCPDefinitionsDisplayContext {

	public VehicleServiceDisplayContext(
		ActionHelper actionHelper, HttpServletRequest httpServletRequest,
		CarGarageLocalService carGarageLocalService,
		CarGarageProductLocalService carGarageProductLocalService,
		CPDefinitionLocalService cpDefinitionLocalService) {

		super(actionHelper, httpServletRequest);

		_carGarageLocalService = carGarageLocalService;
		_carGarageProductLocalService = carGarageProductLocalService;
		_cpDefinitionLocalService = cpDefinitionLocalService;

	}

	public CarGarageLocalService getCarGarageLocalService() {

		return _carGarageLocalService;
	}

	public CarGarageProductLocalService getCarGarageProductLocalService() {

		return _carGarageProductLocalService;
	}

	@Override
	public PortletURL getPortletURL()
		throws PortalException {

		PortletURL portletURL = super.getPortletURL();

		portletURL.setParameter("mvcRenderCommandName", "editVehicleService");
		portletURL.setParameter(
			"screenNavigationCategoryKey", getScreenNavigationCategoryKey());

		return portletURL;
	}

	@Override
	public String getScreenNavigationCategoryKey() {

		return "vehicle-service";
	}

	public CarGarage fetchCarGarageByCPDefinitionId()
		throws PortalException {

		return _carGarageLocalService.fetchByCPDefinitionId(
			getCPDefinitionId());
	}

	public Class<CarGarage> getCarGarageClassName() {

		return CarGarage.class;

	}

	public Class<CarGarageProduct> getCarGarageProductClassName() {

		return CarGarageProduct.class;

	}

	public Class<CPDefinition> getCPDefinitionClassName() {

		return CPDefinition.class;

	}

	public List<CPDefinition> getCarGarageProductCPDefinitions()
		throws PortalException {

		CarGarage carGarage = fetchCarGarageByCPDefinitionId();
		List<CarGarageProduct> carGarageProducts =
			_carGarageProductLocalService.findByCarGarageId(
				carGarage.getCarGarageId());

		_log.debug(carGarageProducts.size());
		
		List<CPDefinition> carGarageProductCPDefinitions = new ArrayList<>();

		for (CarGarageProduct carGarageProduct : carGarageProducts) {
			carGarageProductCPDefinitions.add(
				_cpDefinitionLocalService.getCPDefinition(
					carGarageProduct.getCpDefinitionId()));
		}

		_log.debug(carGarageProductCPDefinitions.size());

		return carGarageProductCPDefinitions;

	}

	public List<CPDefinition> getCPDefinitions()
		throws PortalException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) liferayPortletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		return _cpDefinitionLocalService.getCPDefinitions(
			getCPDefinition().getGroupId(), "simple",
			themeDisplay.getLanguageId(), 0, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);

	}

	private static final Log _log =
		LogFactoryUtil.getLog(VehicleServiceDisplayContext.class);

	private final CarGarageLocalService _carGarageLocalService;
	private final CarGarageProductLocalService _carGarageProductLocalService;
	private final CPDefinitionLocalService _cpDefinitionLocalService;

}
