<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.invoiceitem-resources"/>
<html>
<head>
<title>Edit <fmt:message key="invoiceitem.title"/></title>
</head>
<body>
	<div class="panel-wrapper">
		<div class="panel">
		<form:form action="${pageContext.request.contextPath}/saveInvoiceitem" method="POST" modelAttribute="invoiceitem" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="invoiceitem.title"/>
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="invoiceitem.title"/>
								<form:hidden id="invoiceitem_invoiceitemId" path="invoiceitemId"/>
								</c:otherwise>
							</c:choose>
								</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">	

<div class="group fixed">
	<label>
		<fmt:message key="invoiceitem.invoiceitemid.title"/>:
	</label> 

							<c:choose>
								<c:when test='${newFlag}' >
							<form:input id="invoiceitem_invoiceItemId" path="invoiceItemId" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoiceitem_invoiceItemId",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoiceitem.invoiceitemid.help"/>", constraints : {places:0}}})); </script>
								</c:when>
								<c:otherwise>
							${invoiceitem.invoiceItemId}
						&nbsp;
									<form:hidden id="invoiceitem_invoiceItemId" path="invoiceItemId"/>
								</c:otherwise>
							</c:choose>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoiceitem.invoiceitemdesc.title"/>:
	</label> 

							<form:input id="invoiceitem_invoiceItemDesc" path="invoiceItemDesc" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoiceitem_invoiceItemDesc",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoiceitem.invoiceitemdesc.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoiceitem.itemamt.title"/>:
	</label> 

							<form:input id="invoiceitem_itemAmt" path="itemAmt" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoiceitem_itemAmt",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoiceitem.itemamt.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoiceitem.projectexpenseyn.title"/>:
	</label> 

							<form:input id="invoiceitem_projectExpenseYn" path="projectExpenseYn" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoiceitem_projectExpenseYn",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoiceitem.projectexpenseyn.help"/>", constraints : {places:0}}})); </script>
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save Invoiceitem"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/indexInvoiceitem">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	

</body>
</html>