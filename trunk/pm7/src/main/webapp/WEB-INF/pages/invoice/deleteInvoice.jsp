<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.invoice-resources"/>
<html>
<head>
<title>Confirm Delete <fmt:message key="invoice.title"/></title>
</head>
<body>
		<div class="panel-wrapper">
					<div class="panel">
		
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
								<img src="css/images/icons/icon-user.png" alt="">
									&nbsp;&nbsp;<fmt:message key="navigation.delete"/> <fmt:message key="invoice.title"/> 
								</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">

<div class="group fixed">
	<label>
		<fmt:message key="invoice.invoiceid.title"/>:
	</label> 
							${invoice.invoiceId}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.invoicenumber.title"/>:
	</label> 
							${invoice.invoiceNumber}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.invoicedate.title"/>:
	</label> 
							<fmt:formatDate dateStyle="short" type="both" value="${invoice.invoiceDate.time}"/>
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.invoicedesc.title"/>:
	</label> 
							${invoice.invoiceDesc}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.status.title"/>:
	</label> 
							${invoice.status}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.paymentsched.title"/>:
	</label> 
							${invoice.paymentSched}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.billedrate.title"/>:
	</label> 
							${invoice.billedRate}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.discountamt.title"/>:
	</label> 
							${invoice.discountAmt}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.taxesamt.title"/>:
	</label> 
							${invoice.taxesAmt}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.totalamt.title"/>:
	</label> 
							${invoice.totalAmt}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.paidamt.title"/>:
	</label> 
							${invoice.paidAmt}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.balanceamt.title"/>:
	</label> 
							${invoice.balanceAmt}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.message.title"/>:
	</label> 
							${invoice.message}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.billedhrs.title"/>:
	</label> 
							${invoice.billedHrs}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.expensesamt.title"/>:
	</label> 
							${invoice.expensesAmt}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.itemsamt.title"/>:
	</label> 
							${invoice.itemsAmt}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.logofilename.title"/>:
	</label> 
							${invoice.logoFilename}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="invoice.activeyn.title"/>:
	</label> 
							${invoice.activeYn}
						&nbsp;
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<a class="button-red" href="${pageContext.request.contextPath}/deleteInvoice?invoiceIdKey=${invoice.invoiceId}&">Confirm Delete <img alt="" src="css/images/icons/icon-delete.png"></a>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="button-pink" href="${pageContext.request.contextPath}/indexInvoice">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>						
					</div>
				<div class="shadow"></div>
		</div>

</body>
</html>