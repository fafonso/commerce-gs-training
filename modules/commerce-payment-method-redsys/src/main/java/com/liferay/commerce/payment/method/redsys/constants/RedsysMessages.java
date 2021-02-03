package com.liferay.commerce.payment.method.redsys.constants;
/**
 * 
 * @author Roselaine Marques
 *
 */
public enum RedsysMessages {
	
	M0000("authorized-transaction-payments-and-pre-authorizations"),
	M0900("authorized-transaction-refund-and-confirmations"),
	M0400("transaction-authorized-cancellations"),
	M0101("expired-card"),
	M0102("card-temporary-exception-suspicion-fraud"),
	M0106("pin-attempts-exceeded"),
	M0125("card-not-effective"),
	M0129("incorrect-security-code"),
	M0180("non-service-card"),
	M0184("error-authentication-holder"),
	M0190("refusal-without-specifying-reason"),
	M0191("wrong-expiration-date"),
	M0202("card-temporary-exception-suspicion-fraud-card-withdrawal"),
	M0904("trade-not-registered-fuc"),
	M0909("system-error"),
	M0913("repeat-order"),
	M0944("incorrect-session"),
	M0950("refund-operation-not-allowed"),
	M9912("issuer-not-available"),
	M0912("issuer-not-available"),
	M9064("incorrect-number-card-positions"),
	M9078("type-operation-not-allowed-for-card"),
	M9093("card-does-not-exist"),
	M9094("rejection-international-servers"),
	M9104("trade-with-secure-and-owner-without-secure-purchase-key"),
	M9218("trade-does-not-allow-op-safe-for-entry"),
	M9253("card-does-not-satisfy-check-digit"),
	M9256("merchant-cannot-perform-pre-authorizations"),
	M9257("card-does-not-allow-pre-authorization-operations"),
	M9261("operation-stopped-exceeding-control-sis"),
	M9913("error-confirmation-merchant-sends-only-applicable-soap-synchronization"),
	M9914("confirmation-ko-merchant-only-applicable-soap-synchronization"),
	M9915("users-request-payment-has-been-canceled"),
	M9928("authorization-cancellation-perform-by-sis"),
	M9929("cancellation-deferred-authorization-by-merchant"),
	M9997("another-transaction-is-being-processed-with-same-card"),
	M9998("operation-in-process-requesting-card-data"),
	M9999("operation-has_been-redirected-to-issuer-to-authenticate");
		
		public String getMessage() {
			return _message;
		}

		private RedsysMessages(String message) {
			_message = message;
		}

		private final String _message;
		
}
