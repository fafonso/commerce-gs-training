package com.liferay.commerce.payment.method.redsys.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;
/**
 * 
 * @author Roselaine Marques
 *
 */
@ExtendedObjectClassDefinition(
		category = "payment", scope = ExtendedObjectClassDefinition.Scope.GROUP
	)
@Meta.OCD(
	id = "com.liferay.commerce.payment.method.redsys.configuration.RedsysPaymentMethodCardGroupServiceConfiguration",
	localization = "content/Language",
	name = "redsys-commerce-payment-method-card-group-service-configuration-name"
)
public interface RedsysPaymentMethodCardGroupServiceConfiguration {

	@Meta.AD(deflt="HMAC_SHA256_V1",name = "ds-signature-version", required = false)
	public String dsSignatureVersion();

	@Meta.AD(deflt="https://sis-t.redsys.es:25443/sis/realizarPag", name = "mode", required = false)
	public String mode();

	@Meta.AD(deflt="sq7HjrUOBfKmC576ILgskD5srU870gJ7",name = "client-secret", required = false)
	public String clientSecret();

	@Meta.AD(deflt = "999008881", name = "merchant-code", required = false)
	public String merchantCode();
	
	@Meta.AD(deflt = "0",name = "type-of-transaction", required = false)
	public String typeTransaction();

	@Meta.AD(deflt = "01",name = "terminal", required = false)
	public String terminal();
}
