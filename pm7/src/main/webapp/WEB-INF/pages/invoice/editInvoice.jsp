<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.invoice-resources"/>
<html>
<head>
<title>Edit <fmt:message key="invoice.title"/></title>
<script>
function validateForm()
{
    if(document.parentform.program_programName.value=="")
    {
      alert("Name should not be left blank");
      document.parentform.program_programName.focus();
      return false;
    }
    else if(document.parentform.program_startDate.value=="")
    {
      alert("Start Date should not be left blank");
      document.parentform.program_startDate.focus();
      return false;
    }
    else if(document.parentform.program_gamesPerTeam.value=="")
    {
      alert("Number Sessions/Games should not be left blank");
      document.parentform.program_gamesPerTeam.focus();
      return false;
    }
    else if(document.parentform.program_sport.value=="")
    {
      alert("Sport should not be left blank");
      document.parentform.program_sport.focus();
      return false;
    }
} 
</script>
 <script>
$(function() {
	$( ".datepicker" ).datepicker({
		showOn: "button",
		buttonImage: "css/images/icons/icon-calendar.png",
		buttonImageOnly: true,
		showButtonPanel: true,
		changeMonth: true,
		changeYear: true
	});
});
</script>
</head>
<body>
	<div class="panel-wrapper">
		<div class="panel">
		<form:form action="${pageContext.request.contextPath}/saveInvoice" method="POST" modelAttribute="invoice" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="invoice.title"/>
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="invoice.title"/>
								<form:hidden id="invoice_invoiceId" path="invoiceId"/>
								</c:otherwise>
							</c:choose>
								</a></li>
							<li><a href="#" rel="tab-02-content">Description</a></li>
							<li><a href="#" rel="tab-03-content">Billing</a></li>
							<li><a href="#" rel="tab-04-content">Message</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">	

<div class="group fixed">
	<label>
		<fmt:message key="invoice.invoicenumber.title"/>:
	</label> 

							<form:input id="invoice_invoiceNumber" path="invoiceNumber" cssStyle="width:50px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoice_invoiceNumber",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoice.invoicenumber.help"/>", constraints : {places:0}}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.invoicedate.title"/>:
	</label> 

							<input class="datepicker" id="invoice_invoiceDate" name="invoiceDate" type="text" value="<fmt:formatDate value="${invoice.invoiceDate.time}" pattern="MM/dd/yyyy"/>" style="width:80px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoice_invoiceDate",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="navigation.dateTime.title"/>"}})); </script>
</div>

<div class="group fixed">
	<label>
		<fmt:message key="invoice.status.title"/>:
	</label> 

							<form:input id="invoice_status" path="status" cssStyle="width:80px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoice_status",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoice.status.help"/>"}})); </script>
</div>
</div>
<div id="tab-02-content">	
<div class="group fixed">
	<label>
		<fmt:message key="invoice.invoicedesc.title"/>:
	</label> 

							<form:textarea id="invoice_invoiceDesc" path="invoiceDesc" cssStyle="width:500px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoice_invoiceDesc",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoice.invoicedesc.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.paymentsched.title"/>:
	</label> 

							<form:input id="invoice_paymentSched" path="paymentSched" cssStyle="width:80px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoice_paymentSched",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoice.paymentsched.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.logofilename.title"/>:
	</label> 

							<form:input id="invoice_logoFilename" path="logoFilename" cssStyle="width:250px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoice_logoFilename",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoice.logofilename.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.activeyn.title"/>:
	</label> 

							<form:checkbox id="invoice_activeYn" path="activeYn" value=""/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoice_activeYn",widgetType : "dijit.form.CheckBox",widgetAttrs : {promptMessage: "<fmt:message key="invoice.activeyn.help"/>", constraints : {places:0}}})); </script>
</div>
</div>
<div id="tab-03-content">

<div class="group fixed">
	<label>
		<fmt:message key="invoice.billedrate.title"/>:
	</label> 

							<form:input id="invoice_billedRate" path="billedRate" cssStyle="width:80px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoice_billedRate",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoice.billedrate.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.discountamt.title"/>:
	</label> 

							<form:input id="invoice_discountAmt" path="discountAmt" cssStyle="width:80px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoice_discountAmt",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoice.discountamt.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.taxesamt.title"/>:
	</label> 

							<form:input id="invoice_taxesAmt" path="taxesAmt" cssStyle="width:80px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoice_taxesAmt",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoice.taxesamt.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.totalamt.title"/>:
	</label> 

							<form:input id="invoice_totalAmt" path="totalAmt" cssStyle="width:80px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoice_totalAmt",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoice.totalamt.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.paidamt.title"/>:
	</label> 

							<form:input id="invoice_paidAmt" path="paidAmt" cssStyle="width:80px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoice_paidAmt",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoice.paidamt.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.balanceamt.title"/>:
	</label> 

							<form:input id="invoice_balanceAmt" path="balanceAmt" cssStyle="width:80px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoice_balanceAmt",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoice.balanceamt.help"/>"}})); </script>
</div>
</div>
<div id="tab-04-content">	
<div class="group fixed">
	<label>
		<fmt:message key="invoice.message.title"/>:
	</label> 

							<form:textarea id="invoice_message" path="message" cssStyle="width:500px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoice_message",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoice.message.help"/>"}})); </script>
</div>

<div class="group fixed">
	<label>
		<fmt:message key="invoice.billedhrs.title"/>:
	</label> 

							<form:input id="invoice_billedHrs" path="billedHrs" cssStyle="width:80px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoice_billedHrs",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoice.billedhrs.help"/>", constraints : {places:0}}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.expensesamt.title"/>:
	</label> 

							<form:input id="invoice_expensesAmt" path="expensesAmt" cssStyle="width:80px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoice_expensesAmt",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoice.expensesamt.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.itemsamt.title"/>:
	</label> 

							<form:input id="invoice_itemsAmt" path="itemsAmt" cssStyle="width:80px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoice_itemsAmt",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoice.itemsamt.help"/>"}})); </script>
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save Invoice"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/indexInvoice">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	

</body>
</html>