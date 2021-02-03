<%@ include file="/init.jsp"%>

<%
CPContentHelper cpContentHelper = (CPContentHelper)request.getAttribute(CPContentWebKeys.CP_CONTENT_HELPER);

CPCatalogEntry cpCatalogEntry = cpContentHelper.getCPCatalogEntry(request);

CPSku cpSku = cpContentHelper.getDefaultCPSku(cpCatalogEntry);

long cpDefinitionId = cpCatalogEntry.getCPDefinitionId();

%>

<h1>Example Product Renderer</h1>

<c:if test="<%= cpSku != null %>">

	<div class="row">
		<div class="col-lg-2 col-md-3 col-xs-2">
			<div id="<portlet:namespace />thumbs-container">

				<%
							for (CPMedia cpMedia : cpContentHelper.getImages(cpDefinitionId, themeDisplay)) {
							%>

				<div class="card thumb" data-url="<%= cpMedia.getUrl() %>">
					<img class="center-block img-responsive"
						src="<%= cpMedia.getUrl() %>" />
				</div>

				<%
							}
							%>

			</div>
		</div>
	</div>

	<h3><%= "SKU: " + cpSku.getSku() %></h3>

	<h3><%= "Price: " + cpSku.getPrice().toString() %></h3>

	<h3><%= "Availability: " + cpContentHelper.getAvailabilityLabel(request) %></h3>

	<h3><%= "Stock Quantity: " + cpContentHelper.getStockQuantityLabel(request) %></h3>

</c:if>

<div class="row">
	<div class="col-md-12">
		<liferay-util:dynamic-include
			key="com.liferay.commerce.product.content.web#/add_to_cart#" />
	</div>
</div>