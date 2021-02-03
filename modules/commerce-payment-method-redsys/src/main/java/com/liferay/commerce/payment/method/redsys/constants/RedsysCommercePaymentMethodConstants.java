package com.liferay.commerce.payment.method.redsys.constants;

import com.liferay.commerce.payment.method.redsys.connector.RedsysEnvironment;
import com.liferay.portal.kernel.util.StringUtil;
/**
 * 
 * @author Roselaine Marques
 * 
 * Implemented only Authorization at this moment.
 *
 */
public class RedsysCommercePaymentMethodConstants {
	
	public static final String[] MODES = {
			StringUtil.toLowerCase(RedsysEnvironment.PROD.name()),
			StringUtil.toLowerCase(RedsysEnvironment.TEST.name())
			};
	
	public static final String[] TYPES_OF_TRANSACTION = {
			StringUtil.toLowerCase(RedsysTypeOfTransaction.T0.name())	
			/**
			 * TODO
			StringUtil.toLowerCase(RedsysTypeOfTransaction.T1.name()),
			StringUtil.toLowerCase(RedsysTypeOfTransaction.T2.name()),
			StringUtil.toLowerCase(RedsysTypeOfTransaction.T3.name()),
			StringUtil.toLowerCase(RedsysTypeOfTransaction.T5.name()),
			StringUtil.toLowerCase(RedsysTypeOfTransaction.T6.name()),
			StringUtil.toLowerCase(RedsysTypeOfTransaction.T7.name()),
			StringUtil.toLowerCase(RedsysTypeOfTransaction.T8.name()),
			StringUtil.toLowerCase(RedsysTypeOfTransaction.T9.name()),
			StringUtil.toLowerCase(RedsysTypeOfTransaction.TO.name()),
			StringUtil.toLowerCase(RedsysTypeOfTransaction.TP.name()),
			StringUtil.toLowerCase(RedsysTypeOfTransaction.TQ.name()),
			StringUtil.toLowerCase(RedsysTypeOfTransaction.TR.name()),
			StringUtil.toLowerCase(RedsysTypeOfTransaction.TS.name())
			
			*/
			};
			
	public static final String SERVICE_NAME = "com.liferay.commerce.payment.engine.method.redsys";

	public static final String SERVLET_PATH = "redsys-commerce-payment";
		
	public static final String COMMERCE_CHANNEL_ID = "commerceChannelId";

	public static final String BASE_NAME = "content.Language";
	
	public static final String REDIRECT_PARAM = "redirect=";
		
	public static final String DS_MERCHANT_AMOUNT = "DS_MERCHANT_AMOUNT";

	public static final String DS_MERCHANT_ORDER = "DS_MERCHANT_ORDER";

	public static final String DS_MERCHANT_MERCHANTCODE = "DS_MERCHANT_MERCHANTCODE";

	public static final String DS_MERCHANT_CURRENCY = "DS_MERCHANT_CURRENCY";

	public static final String DS_MERCHANT_TRANSACTIONTYPE = "DS_MERCHANT_TRANSACTIONTYPE";

	public static final String DS_MERCHANT_TERMINAL = "DS_MERCHANT_TERMINAL";

	public static final String DS_MERCHANT_MERCHANTURL = "DS_MERCHANT_MERCHANTURL";

	public static final String DS_MERCHANT_URLOK = "DS_MERCHANT_URLOK";

	public static final String DS_MERCHANT_URLKO = "DS_MERCHANT_URLKO";
	
	public static final String SETTINGS_DS_SIGNATURE_VERSION = "settings--ds_signature_version--";
	
	public static final String SETTINGS_CLIENT_SECRET = "settings--clientSecret--";

	public static final String SETTINGS_MERCHANT_CODE = "settings--merchantCode--";

	public static final String SETTINGS_TERMINAL = "settings--terminal--";

	public static final String SETTINGS_MODE = "settings--mode--";

	public static final String SETTINGS_TYPES_OF_TRANSACTION = "settings--type-of-transaction--";
	
	public static final String DS_MERCHANT_PARAMETERS = "Ds_MerchantParameters";
	
	public static final String DS_SIGNATURE_VERSION = "Ds_SignatureVersion";
	
	public static final String DS_SIGNATURE = "Ds_Signature";

	public static final String REDIRECT_URL = "redirectUrl";
	
	public static final String PARAMS = "params";

	public static final String SIGNATURE = "signature";
	
	public static final String DS_SIGNATURE_VERSION_PARAM = "dsSignatureVersion";

	public static final String COD_RESPONSE_REDSYS =  "codResponseRedsys";
	
	public static final String ERROR_SIGNATURE =  "Signature Calculed it's not equal Signature from Response";
	
	public static final String ERROR_PARAMETERS_COMPARE= "Parameters from Order it's not equal Parameters from Response";

}
