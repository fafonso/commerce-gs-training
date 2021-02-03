package com.liferay.commerce.payment.method.redsys.servlet.filter;

import javax.servlet.Filter;

import org.osgi.service.component.annotations.Component;

import com.liferay.commerce.payment.method.redsys.constants.RedsysCommercePaymentMethodConstants;
import com.liferay.portal.servlet.filters.authverifier.AuthVerifierFilter;

/**
 * 
 * @author Roselaine Marques
 *
 */
@Component(
		immediate = true,
		property = {
			"filter.init.auth.verifier.PortalSessionAuthVerifier.urls.includes=/" + RedsysCommercePaymentMethodConstants.SERVLET_PATH + "/*",
			"osgi.http.whiteboard.filter.name=com.liferay.commerce.payment.method.redsys.servlet.filter.RedsysCommercePaymentMethodVerifierFilter",
			"osgi.http.whiteboard.servlet.pattern=/" + RedsysCommercePaymentMethodConstants.SERVLET_PATH + "/*"
		},
		service = Filter.class
	)

public class RedsysCommercePaymentMethodVerifierFilter extends AuthVerifierFilter{

}
