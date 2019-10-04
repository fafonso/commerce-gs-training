package com.liferay.commerce.training.condition.evaluator;

import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.workflow.kaleo.model.KaleoCondition;
import com.liferay.portal.workflow.kaleo.model.KaleoInstance;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.runtime.condition.ConditionEvaluator;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
		immediate = true,
		property = "scripting.language=java",
		service = ConditionEvaluator.class
		
	)
public class PriceCheckConditionEvaluator implements ConditionEvaluator{
	@Override
	public String evaluate(KaleoCondition kaleoCondition, ExecutionContext executionContext) throws PortalException {
		KaleoInstanceToken kaleoInstanceToken =
				executionContext.getKaleoInstanceToken();
			
			System.out.println("***In the java condition evaluator.***");
		
		
			KaleoInstance kaleoInstance =
				_kaleoInstanceLocalService.getKaleoInstance(
					kaleoInstanceToken.getKaleoInstanceId());

			CommerceOrder order =
				_commerceOrderLocalService.getCommerceOrder(
					kaleoInstance.getClassPK());
		

			if(order.getSubtotal().intValue() >= 100) {
				return "over";
			} else {
				return "under";
			}
			
	}
	
	@Reference
	private CommerceOrderLocalService _commerceOrderLocalService;

	@Reference
	private KaleoInstanceLocalService _kaleoInstanceLocalService;
}
