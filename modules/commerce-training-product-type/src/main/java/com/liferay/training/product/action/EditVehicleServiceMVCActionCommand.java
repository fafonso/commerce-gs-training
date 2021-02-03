package com.liferay.training.product.action;

/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
import com.liferay.commerce.product.constants.CPPortletKeys;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.service.CPDefinitionLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import commerce.training.car.garage.model.CarGarage;
import commerce.training.car.garage.service.CarGarageLocalService;
import commerce.training.car.garage.service.CarGarageProductLocalService;

@Component(immediate = true, property = {
	"javax.portlet.name=" + CPPortletKeys.CP_DEFINITIONS,
	"mvc.command.name=editVehicleService"
}, service = MVCActionCommand.class)
public class EditVehicleServiceMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			CarGarage.class.getName(), actionRequest);

		long cpDefinitionId =
			ParamUtil.getLong(actionRequest, "cpDefinitionId");

		String title = ParamUtil.getString(actionRequest, "title");

		double latitude = ParamUtil.getDouble(actionRequest, "latitude");

		double longitude = ParamUtil.getDouble(actionRequest, "longitude");

		long[] cpDefinitionIds =
			ParamUtil.getLongValues(actionRequest, "cpDefinitionIds");

		CarGarage carGarage = _carGarageLocalService.addCarGarage(
			title, latitude, longitude, cpDefinitionId, serviceContext);

		for (int i = 0; i < cpDefinitionIds.length; i++) {

			CPDefinition cpDefinition =
				_cpDefinitionLocalService.getCPDefinition(cpDefinitionIds[i]);

			_carGarageProductLocalService.addCarGarageProduct(
				cpDefinitionIds[i], carGarage.getCarGarageId(),
				cpDefinition.getName(), serviceContext);

			if (_log.isDebugEnabled()) {
				_log.debug(
					"CarGarageProduct Added: " + carGarage.getCarGarageId());
			}

		}

	}

	private static final Log _log =
		LogFactoryUtil.getLog(EditVehicleServiceMVCActionCommand.class);

	@Reference
	private CarGarageLocalService _carGarageLocalService;

	@Reference
	private CarGarageProductLocalService _carGarageProductLocalService;

	@Reference
	private CPDefinitionLocalService _cpDefinitionLocalService;

}
