
package com.liferay.commerce.training.condition.evaluator;

import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoCondition;
import com.liferay.portal.workflow.kaleo.model.KaleoInstance;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.runtime.condition.ConditionEvaluator;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceLocalService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = "scripting.language=java", service = ConditionEvaluator.class

)
public class VehicleServiceConditionEvaluator implements ConditionEvaluator {

	@Override
	public String evaluate(
		KaleoCondition kaleoCondition, ExecutionContext executionContext)
		throws PortalException {

		KaleoInstanceToken kaleoInstanceToken =
			executionContext.getKaleoInstanceToken();

		_log.debug("***In the java condition evaluator.***");

		KaleoInstance kaleoInstance =
			_kaleoInstanceLocalService.getKaleoInstance(
				kaleoInstanceToken.getKaleoInstanceId());

		CommerceOrder order = _commerceOrderLocalService.getCommerceOrder(
			kaleoInstance.getClassPK());

		List<CommerceOrderItem> commerceOrderItems =
			order.getCommerceOrderItems();

		boolean isVehicleServiceOrder = false;

		for (CommerceOrderItem commerceOrderItem : commerceOrderItems) {
			if (commerceOrderItem.getCPDefinition().getProductTypeName().equals(
				"Vehicle Service")) {
				isVehicleServiceOrder = true;
				break;
			}
		}

		if (isVehicleServiceOrder) {
			_log.debug("Vehicle Service Product Type");
			return "true";
		}
		else {
			_log.debug("Not Vehicle Service Product Type");
			return "false";
		}

	}

	private static final Log _log =
		LogFactoryUtil.getLog(VehicleServiceConditionEvaluator.class);

	@Reference
	private CommerceOrderLocalService _commerceOrderLocalService;

	@Reference
	private KaleoInstanceLocalService _kaleoInstanceLocalService;
}
