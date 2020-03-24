<%@ include file="../init.jsp"%>

<%-- <div class="container-fluid product-detail">
	<div class="row">
		<div class="col-4" id="minium-product-gallery">

			<p>
				<b><liferay-ui:message key="selectcarservicedateandtime" /></b>
			</p>

			<div class="aui-datepicker aui-helper-clearfix"
				id="#<portlet:namespace />startDatePicker">
				<input type="hidden" name="startDate"
					id="<portlet:namespace />startDate" size="30" />
			</div>
			<p>
				<%
					Calendar defaultValueDate = CalendarFactoryUtil.getCalendar();
				%>
				<liferay-ui:input-date
					dayValue="<%=defaultValueDate.get(Calendar.DATE)%>" dayParam="day"
					disabled="<%=false%>"
					firstDayOfWeek="<%=defaultValueDate.getFirstDayOfWeek() - 1%>"
					monthParam="month"
					monthValue="<%=defaultValueDate.get(Calendar.MONTH)%>"
					yearParam="year"
					yearValue="<%=defaultValueDate.get(Calendar.YEAR)%>" />
				<liferay-ui:input-time amPmParam="ampm" hourParam="hour"
					minuteParam="min" minuteInterval="10" />

			</p>

		</div>
	</div>
</div> --%>


<div class="address-fields">
	<portlet:actionURL name="addApprovalAddData"
		var="addApprovalAddDataActionUrl" />

	<div class="form-group-autofit">
				
		<aui:input type="text" data-format="dd/MM/yyyy"
			name="genericDateField" class="aui-datepicker" id="datepicker"
			label="Select Date of Service" wrapperCssClass="form-group-item">
			<aui:validator name="required" />
			<aui:validator name="date" />

		</aui:input>
		
		<aui:input type="text"
			name="genericTimeField" class="aui-datepicker" id="timepicker"
			label="Select Time of Service" wrapperCssClass="form-group-item">
			<aui:validator name="required" />

		</aui:input>

	</div>

	<aui:script>
		AUI().use('aui-datepicker', function(A) {
			var datepicker = new A.DatePicker({
				trigger : '#<portlet:namespace />datepicker',
				mask: '%m/%d/%Y',
				calendar: {
                    dateFormat: '%m/%d/%Y',
                },
				popover : {
					zIndex : 1
				}
			});
		});


		AUI().use('aui-timepicker', function(A) {
			var datepicker = new A.TimePicker({
				trigger : '#<portlet:namespace />timepicker',
				popover : {
					zIndex : 1
				}
			});
		});		
		
	</aui:script>

</div>
