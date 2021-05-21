
package commerce.training.custom.data.integration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.commerce.data.integration.model.CommerceDataIntegrationProcess;
import com.liferay.commerce.data.integration.model.CommerceDataIntegrationProcessLog;
import com.liferay.commerce.data.integration.service.CommerceDataIntegrationProcessLocalService;
import com.liferay.commerce.data.integration.service.CommerceDataIntegrationProcessLogLocalService;
import com.liferay.commerce.data.integration.service.ScheduledTaskExecutorService;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;

import commerce.training.car.garage.service.CarGarageLocalService;
import commerce.training.car.garage.service.CarGarageProductLocalService;
import commerce.training.custom.data.integration.type.CommerceTrainingCustomDataIntegrationType;

@Component(immediate = true, property = "data.integration.service.executor.key=" +
	CommerceTrainingCustomDataIntegrationType.KEY, service = ScheduledTaskExecutorService.class)
public class CommerceTrainingCustomScheduledTaskExecutorService
	implements ScheduledTaskExecutorService {

	@Override
	public String getName() {
		return null;
	}

	/**
	 * This process is run by Data Integration Admin
	 * return Orders with vehicle service item
	 */
	@Override
	public void runProcess(long commerceDataIntegrationProcessId)
		throws IOException, PortalException {

		if (_log.isDebugEnabled()) {
			_log.debug("runProcess");
		}

		String successMessage = "Export Successful";

		CommerceDataIntegrationProcess commerceDataIntegrationProcess =
			_commerceDataIntegrationProcessLocalService.getCommerceDataIntegrationProcess(
				commerceDataIntegrationProcessId);

		UnicodeProperties typeSettingsProperties =
			commerceDataIntegrationProcess.getTypeSettingsProperties();

		if (typeSettingsProperties.containsKey("extra-data")) {
			successMessage += typeSettingsProperties.get("extra-data");
		}

		// the log that appears in the log tab of data integration.
		CommerceDataIntegrationProcessLog commerceDataIntegrationProcessLog =
			_commerceDataIntegrationProcessLogLocalService.addCommerceDataIntegrationProcessLog(
				commerceDataIntegrationProcess.getUserId(),
				commerceDataIntegrationProcess.getCommerceDataIntegrationProcessId(),
				null, null, BackgroundTaskConstants.STATUS_IN_PROGRESS,
				new Date(), null);

		List<CommerceOrder> commerceOrders =
			_commerceOrderLocalService.getCommerceOrders(
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		List<CommerceOrder> carGarageOrders = new ArrayList<CommerceOrder>();
		List<String> carGarageTitles = new ArrayList<String>();

		for (CommerceOrder commerceOrder : commerceOrders) {

			List<CommerceOrderItem> commerceOrderItems =
				commerceOrder.getCommerceOrderItems();

			boolean isVehicleServiceOrder = false;
			String title = "";
			for (CommerceOrderItem commerceOrderItem : commerceOrderItems) {
				if (commerceOrderItem.getCPDefinition().getProductTypeName().equals(
					"Vehicle Service")) {
					isVehicleServiceOrder = true;
					title = _carGarageLocalService.findByCPDefinitionId(
						commerceOrderItem.getCPDefinition().getCPDefinitionId()).getTitle();
					break;
				}
			}
			if (isVehicleServiceOrder) {
				carGarageOrders.add(commerceOrder);
				carGarageTitles.add(title);
			}

		}

		if (_log.isDebugEnabled()) {
			_log.debug("number of orders to export: " + carGarageOrders.size());
		}

		exportCSVData(carGarageOrders, carGarageTitles);

		_commerceDataIntegrationProcessLogLocalService.updateCommerceDataIntegrationProcessLog(
			commerceDataIntegrationProcessLog.getCommerceDataIntegrationProcessLogId(),
			"", successMessage, BackgroundTaskConstants.STATUS_SUCCESSFUL,
			new Date());

	}

	/**
	 * Export csv for car garage orders.
	 * 
	 * @param carGarageOrders
	 * @param carGarageTitles
	 */
	protected void exportCSVData(
		List<CommerceOrder> carGarageOrders, List<String> carGarageTitles) {

		StringBundler sb = new StringBundler();

		for (String columnName : columnNames) {
			sb.append(getCSVFormattedValue(columnName));
			sb.append(CSV_SEPARATOR);
		}

		sb.setIndex(sb.index() - 1);
		sb.append(CharPool.NEW_LINE);

		for (CommerceOrder carGarageOrder : carGarageOrders) {

			int index = carGarageOrders.indexOf(carGarageOrder);

			if (_log.isDebugEnabled()) {
				_log.debug(index);
			}

			sb.append(
				getCSVFormattedValue(
					String.valueOf(carGarageOrder.getCommerceOrderId())));
			sb.append(CSV_SEPARATOR);
			sb.append(
				getCSVFormattedValue(
					String.valueOf(carGarageOrder.getOrderStatus())));
			sb.append(CSV_SEPARATOR);
			sb.append(
				getCSVFormattedValue(
					String.valueOf(carGarageOrder.getPaymentStatus())));
			sb.append(CSV_SEPARATOR);
			sb.append(
				getCSVFormattedValue(
					String.valueOf(carGarageOrder.getTotal())));
			sb.append(CSV_SEPARATOR);

			sb.append(
				getCSVFormattedValue(
					String.valueOf(carGarageTitles.get(index))));
			sb.append(CSV_SEPARATOR);
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);
		}

	     String fileName = "garage_service.csv";


		if (_log.isDebugEnabled()) {
			_log.debug(sb.toString());
		}

		File file = new File(fileName);
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write(sb.toString());
		}
		catch (IOException e) {
			_log.error(e.getMessage(), e);
		}

	}

	protected String getCSVFormattedValue(String value) {

		StringBundler sb = new StringBundler(3);
		sb.append(CharPool.QUOTE);
		sb.append(
			StringUtil.replace(value, CharPool.QUOTE, StringPool.DOUBLE_QUOTE));
		sb.append(CharPool.QUOTE);
		return sb.toString();
	}

	public static String[] columnNames = {
		"OrderId", "Order Status", "Payment Status", "Total", "Car Garage"
	};
	public static final String CSV_SEPARATOR = ",";

	@Reference
	private CommerceOrderLocalService _commerceOrderLocalService;

	@Reference
	private CarGarageLocalService _carGarageLocalService;

	@Reference
	private CarGarageProductLocalService _carGarageProductLocalService;

	@Reference
	private CommerceDataIntegrationProcessLocalService _commerceDataIntegrationProcessLocalService;

	@Reference
	private CommerceDataIntegrationProcessLogLocalService _commerceDataIntegrationProcessLogLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		CommerceTrainingCustomScheduledTaskExecutorService.class);

}
