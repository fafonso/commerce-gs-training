<%@ include file="./../init.jsp" %>
<%@ page import="java.net.URLDecoder" %>

<%
String redirectUrlAttribute = (String)request.getAttribute(RedsysCommercePaymentMethodConstants.REDIRECT_URL);

String redirectUrl = URLCodec.decodeURL(redirectUrlAttribute);

String paramsAtrribute = (String)request.getAttribute(RedsysCommercePaymentMethodConstants.PARAMS);

String params = URLDecoder.decode(paramsAtrribute, StringPool.UTF8);

String signatureAttribute = (String)request.getAttribute(RedsysCommercePaymentMethodConstants.SIGNATURE);

String signature = URLDecoder.decode(signatureAttribute, StringPool.UTF8);

String dsSignatureVersion = (String)request.getAttribute(RedsysCommercePaymentMethodConstants.DS_SIGNATURE_VERSION_PARAM);


%>

<form action="<%= redirectUrl %>" class="hide" id="formRedsys" method="post" name="formRedsys">
	<input name="<%= RedsysCommercePaymentMethodConstants.DS_SIGNATURE_VERSION %>" type="hidden" value="<%= dsSignatureVersion %>" />
	<input name="<%= RedsysCommercePaymentMethodConstants.DS_MERCHANT_PARAMETERS %>" type="hidden" value="<%= params %>" />
	<input name="<%= RedsysCommercePaymentMethodConstants.DS_SIGNATURE %>" type="hidden" value="<%= signature %>" />
	
	<button id="btnContinue">Continue</button>
</form>

<script>
	window.onload = function() {
		document.querySelector('form').submit();
	};
</script>