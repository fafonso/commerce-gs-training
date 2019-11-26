<%@ include file="/init.jsp" %>

<h1>These are the custom details</h1>
<aui:form action="#" cssClass="container-fluid-1280" name="fm1">
			
			<aui:fieldset-group markupView="lexicon">
                <aui:fieldset>
					<aui:input name="customValue1" label="Custom Value One" type="String" value="" />
					<aui:input name="customValue1" label="Custom Value Two" type="String" value="" />
					<aui:button name="submit" type="submit" />
				</aui:fieldset>
        </aui:fieldset-group>
</aui:form>