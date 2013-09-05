<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.client-resources"/>
<html>
<head>
<title>View <fmt:message key="client.title"/> <fmt:message key="invoice.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="invoice.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectClient?clientIdKey=${client_clientId}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoice.invoiceid.title"/>:
						</td>
						<td>
							${invoice.invoiceId}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoice.invoicenumber.title"/>:
						</td>
						<td>
							${invoice.invoiceNumber}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoice.invoicedate.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${invoice.invoiceDate.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoice.invoicedesc.title"/>:
						</td>
						<td>
							${invoice.invoiceDesc}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoice.status.title"/>:
						</td>
						<td>
							${invoice.status}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoice.paymentsched.title"/>:
						</td>
						<td>
							${invoice.paymentSched}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoice.billedrate.title"/>:
						</td>
						<td>
							${invoice.billedRate}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoice.discountamt.title"/>:
						</td>
						<td>
							${invoice.discountAmt}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoice.taxesamt.title"/>:
						</td>
						<td>
							${invoice.taxesAmt}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoice.totalamt.title"/>:
						</td>
						<td>
							${invoice.totalAmt}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoice.paidamt.title"/>:
						</td>
						<td>
							${invoice.paidAmt}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoice.balanceamt.title"/>:
						</td>
						<td>
							${invoice.balanceAmt}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoice.message.title"/>:
						</td>
						<td>
							${invoice.message}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoice.billedhrs.title"/>:
						</td>
						<td>
							${invoice.billedHrs}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoice.expensesamt.title"/>:
						</td>
						<td>
							${invoice.expensesAmt}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoice.itemsamt.title"/>:
						</td>
						<td>
							${invoice.itemsAmt}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoice.logofilename.title"/>:
						</td>
						<td>
							${invoice.logoFilename}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="invoice.activeyn.title"/>:
						</td>
						<td>
							${invoice.activeYn}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/deleteClientInvoices?client_clientId=${client_clientId}&related_invoices_invoiceId=${invoice.invoiceId}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
