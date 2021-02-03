package com.liferay.commerce.payment.method.redsys.connector;

/**
 * 
 * @author Roselaine Marques
 *
 */
public enum RedsysEnvironment {

	PROD("https://sis.redsys.es/sis/realizarPago"),
	TEST("https://sis-t.redsys.es:25443/sis/realizarPago");
	
	public String getUrl() {
		return _url;
	}

	private RedsysEnvironment(String url) {
		_url = url;
	}

	private final String _url;
	
}
