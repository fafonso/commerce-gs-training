package com.liferay.commerce.payment.method.redsys.connector;

import com.liferay.portal.kernel.util.Validator;

import java.net.URI;
/**
 * 
 * @author Roselaine Marques
 *
 */
public class RedsysConfigClient {
	
	public RedsysConfigClient(String dsSignatureVersion, String signatureSecret, 
			RedsysEnvironment environment, String merchantCode)
		throws Exception {

		if (environment == null) {
			throw new Exception("Invalid Environment specified");
		}

		if (Validator.isBlank(dsSignatureVersion)) {
			throw new Exception("Invalid DS Signature Version specified");
		}

		if (Validator.isBlank(signatureSecret)) {
			throw new Exception("Invalid Signature Secret specified");
		}

		if (Validator.isBlank(merchantCode)) {
			throw new Exception("Invalid Merchant CODE specified");
		}

		_signatureSecret = signatureSecret;
		_dsSignatureVersion = dsSignatureVersion;
		_environment = environment;
		_merchantCode = merchantCode;

	}
	
	public URI getEnvironmentUrl() {
		return URI.create(_environment.getUrl());
	}

	public String getSignatureSecret() {
		return _signatureSecret;
	}

	public String getDsSignatureVersion() {
		return _dsSignatureVersion;
	}
	
	public String getMerchantCode() {
		return _merchantCode;
	}
	

	private final RedsysEnvironment _environment;
	private final String _signatureSecret;
	private final String _dsSignatureVersion;
	private final String _merchantCode;
	
}
