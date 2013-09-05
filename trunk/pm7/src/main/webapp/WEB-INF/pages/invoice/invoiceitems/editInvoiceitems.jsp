<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.invoice-resources"/>
<html>
<head>
<title>Edit <fmt:message key="invoice.title"/> <fmt:message key="invoiceitem.title"/></title>
</head>
<body>
<%-- <div class="group fixed">
		<label>Level</label>
		<select id="itemSelected1" name="selected_id1">
		<option value="">Select level</option>
		<c:forEach items="${levels}" var="current" varStatus="i">
			<c:choose>
			<c:when test="${program.level!=null && current.levelId eq program.level.levelId}">
				<option value="${current.levelId}" selected="selected">${current.levelName}</option>
			</c:when>
			<c:otherwise>
				<option value="${current.levelId}">${current.levelName}</option>
			</c:otherwise>									
			</c:choose>
		</c:forEach>
		</select>		
	</div>
 --%>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
	<div id="content">
		<h1><fmt:message key="navigation.edit"/> <fmt:message key="invoiceitem.title"/></h1>
		<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectInvoice?invoiceIdKey=${invoice_invoiceId}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
		<form:form action="${pageContext.request.contextPath}/saveInvoiceInvoiceitems" method="POST" modelAttribute="invoiceitem">
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoiceitem.invoiceitemid.title"/>:
						</td>
						<td>
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
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoiceitem.invoiceitemdesc.title"/>:
						</td>
						<td>
							<form:input id="invoiceitem_invoiceItemDesc" path="invoiceItemDesc" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoiceitem_invoiceItemDesc",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoiceitem.invoiceitemdesc.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoiceitem.itemamt.title"/>:
						</td>
						<td>
							<form:input id="invoiceitem_itemAmt" path="itemAmt" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoiceitem_itemAmt",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoiceitem.itemamt.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoiceitem.projectexpenseyn.title"/>:
						</td>
						<td>
							<form:input id="invoiceitem_projectExpenseYn" path="projectExpenseYn" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "invoiceitem_projectExpenseYn",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="invoiceitem.projectexpenseyn.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
				</tbody>
			</table>
			<span class="inputbutton"><input class="savebutton" id="save" type="submit" value="<fmt:message key="navigation.save"/>"/></span>
			<script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'save', event:'onclick'}));</script>
				<input type="hidden" name="invoice_invoiceId" value="${invoice_invoiceId}" >
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		</form:form>
		<div class="clear">&nbsp;</div>
	</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
