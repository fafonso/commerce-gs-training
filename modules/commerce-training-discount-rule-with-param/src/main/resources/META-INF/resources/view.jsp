<%@ include file="/init.jsp" %>

<%
CommerceTrainingDiscountRuleDisplayContext commerceTrainingDiscountRuleDisplayContext = (CommerceTrainingDiscountRuleDisplayContext)request.getAttribute("view.jsp-commerceTrainingDiscountRuleDisplayContext");
String value = commerceTrainingDiscountRuleDisplayContext.getTypeSettings();
%>

<aui:input label="minimum-number-of-products" name="typeSettings" type="text" value="<%= value %>">
	<aui:validator name="digits" />
	<aui:validator name="min">1</aui:validator>
</aui:input>