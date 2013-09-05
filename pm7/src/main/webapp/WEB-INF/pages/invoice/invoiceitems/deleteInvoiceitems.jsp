<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.invoice-resources"/>
<html>
<head>
<title>View <fmt:message key="invoice.title"/> <fmt:message key="invoiceitem.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="invoiceitem.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectInvoice?invoiceIdKey=${invoice_invoiceId}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoiceitem.invoiceitemid.title"/>:
						</td>
						<td>
							${invoiceitem.invoiceItemId}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoiceitem.invoiceitemdesc.title"/>:
						</td>
						<td>
							${invoiceitem.invoiceItemDesc}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoiceitem.itemamt.title"/>:
						</td>
						<td>
							${invoiceitem.itemAmt}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoiceitem.projectexpenseyn.title"/>:
						</td>
						<td>
							${invoiceitem.projectExpenseYn}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/deleteInvoiceInvoiceitems?invoice_invoiceId=${invoice_invoiceId}&related_invoiceitems_invoiceItemId=${invoiceitem.invoiceItemId}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
