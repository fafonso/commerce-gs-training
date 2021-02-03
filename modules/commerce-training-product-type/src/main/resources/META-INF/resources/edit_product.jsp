<%@ include file="/init.jsp"%>

<%
	VehicleServiceDisplayContext vehicleServiceDisplayContext =
		(VehicleServiceDisplayContext) request.getAttribute(
			WebKeys.PORTLET_DISPLAY_CONTEXT);

	PortletURL portletURL =
		vehicleServiceDisplayContext.getPortletURL();

	List<CPDefinition> cpDefinitions =
		vehicleServiceDisplayContext.getCPDefinitions();
%>

<portlet:actionURL name="editVehicleService" var="editVehicleServiceURL" />

<aui:form action="<%=editVehicleServiceURL%>" name="addCarGarageFm">

	<aui:input name="<%=Constants.CMD%>" type="hidden"
		value="<%=Constants.ADD%>" />

	<aui:input name="cpDefinitionId" type="hidden"
		value="<%=vehicleServiceDisplayContext.getCPDefinitionId()%>" />

	<aui:fieldset-group markupView="lexicon">

		<%-- <liferay-ui:message key="car-garage-info" /> --%>

		<aui:fieldset>

			<aui:model-context
				bean="<%=vehicleServiceDisplayContext.fetchCarGarageByCPDefinitionId()%>"
				model="<%=vehicleServiceDisplayContext.getCarGarageClassName()%>" />

			<aui:input name="title">
				<aui:validator name="required" />
			</aui:input>

			<aui:input name="latitude">
				<aui:validator name="required" />
			</aui:input>

			<aui:input name="longitude">
				<aui:validator name="required" />
			</aui:input>

			<aui:select name="cpDefinitionIds" id="cpDefinitions" multiple="true">

				<c:forEach items="<%=cpDefinitions%>" var="cpDefinition">
					<option value="${cpDefinition.CPDefinitionId}">${cpDefinition.name}</option>
				</c:forEach>

			</aui:select>

		</aui:fieldset>

	</aui:fieldset-group>

	<aui:button-row>
		<aui:button cssClass="btn btn-primary" type="submit" />
		<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}"
			type="cancel" />
	</aui:button-row>

</aui:form>