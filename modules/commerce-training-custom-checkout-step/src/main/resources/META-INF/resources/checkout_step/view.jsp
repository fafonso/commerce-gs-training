<%@ include file="../init.jsp"%>

<div class="container-fluid product-detail">
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
</div>
