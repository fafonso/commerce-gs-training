<%@ include file="/init.jsp"%>

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
