<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.tswacct-resources" />
<html>
<head>
<title>Edit <fmt:message key="tswacct.title" />
</title>
<!--  link href="explorer/jquery/1.8/jquery-ui.css" rel="stylesheet" type="text/css" /  -->
<!--  script type='text/javascript' src='explorer/jquery/1.5/jquery.min.js'></script  -->
<script>
function validateForm()
{
    if(document.parentform.tswacct_acctName.value=="")
    {
      alert("Account Name should not be left blank");
      document.parentform.tswacct_acctName.focus();
      return false;
    }
    else if(document.parentform.tswacct_admin.value=="")
    {
      alert("Administrator should not be left blank");
      document.parentform.tswacct_admin.focus();
      return false;
    }
}
</script>
 <script>
$(function() {
	$( ".datepicker" ).datepicker({
		showOn: "button",
		buttonImage: "explorer/images/icon-calendar.png",
		buttonImageOnly: true,
		showButtonPanel: true,
		changeMonth: true,
		changeYear: true
	});
});
</script>
</head>
<body>

	<div id="content">
		<div class="formular">
			<div class="panel">
				<form:form action="${pageContext.request.contextPath}/saveTswacct" method="POST" modelAttribute="tswacct" name="parentform" onSubmit="return validateForm();">
					<div class="title-large">
						<c:choose>
							<c:when test='${newFlag}'>
								<h2>
									<fmt:message key="navigation.new" /> Account
								</h2>
							</c:when>
							<c:otherwise>
								<h2>
									<fmt:message key="navigation.edit" />
									Account (${tswacct.tswAcctId}) <strong>${tswacct.acctName}</strong>
								</h2>
								<form:hidden id="tswacct_tswAcctId" path="tswAcctId" />
							</c:otherwise>
						</c:choose>
						<ul class="tabs-box clearfix">
							<li class="selected"><a href="#" rel="acct-main">Account</a>
							</li>
							<li><a href="#" rel="acct-subscr">Subscription</a>
							</li>
						</ul>
						<div class="theme"></div>
						<div class="drop"></div>
					</div>
					<div class="content inpad">
						<div class="tabs-content selected" id="acct-main">
							<fieldset>
					<table>	
						<tbody>
							<tr style="width:100%;">				
								<td style="width:50%;">
								<br>
								<div>
									<label><fmt:message key="tswacct.acctname.title" /> *</label>
									<form:input id="tswacct_acctName" path="acctName" autofocus="autofocus" cssStyle="width:300px;" />
								</div>
								</td>
								</tr>
								<tr>
								<td>
								<br>
								<div>
									<label>Account Administrator *</label>
									<c:set var="custNum" value="4" />
									<c:if test='${tswacct.customer == null}'>
										<input id="tswacct_admin" type="text" name="custName4" value="" readonly="readonly" style="width: 180px;" />
									<a class="button-clean" href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/searchCustomers', 'myWin','dialogWidth:770px;dialogHeight:620px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
											<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										<input type="hidden" id="itemSelected4" name="selected_id4" value="" style="width: 20px;">
									</c:if>
									<c:if test='${tswacct.customer != null}'>
										<input id="tswacct_admin" type="text" name="custName4" value="${tswacct.customer.firstname}&nbsp;${tswacct.customer.lastname}" readonly="readonly" style="width: 180px;" />
									<a class="button-clean" href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/searchCustomers', 'myWin','dialogWidth:770px;dialogHeight:620px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
											<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										<input type="hidden" id="itemSelected4" name="selected_id4" value="${tswacct.customer.customerId}" style="width: 20px;">
									</c:if>
								</div>
								</td>
								<td>
									<div style="width:40px;">&nbsp;</div>
								</td>
								<td>
								<br>
								<div>
									<label>Subscription Type *</label>
									<form:select id="tswacct_subscrType" path="subscrType"
										selected="${tswacct.subscrType}">
										<form:option value="--">Select option</form:option>
										<form:option value="Tourney">Tourney - $80/2mo.</form:option>
										<form:option value="Basic">Basic - $70/mo.</form:option>
										<form:option value="Full">Full - $100/mo.</form:option>
										<form:option value="Extended">Extended - $150/mo.</form:option>
									</form:select>
									&nbsp;&nbsp;
								</div>
								</td>
								</tr>
								<tr>
								<td>
								<br>								
								<div>
									<label>Sales Rep</label>
									<c:if test='${tswacct.customerBySalesRepFk == null}'>
									<input id="tswacct_customerBySalesRepFk" type="text" name="custSalesRep" value="" readonly="readonly" style="width:200px;" />
									</c:if>
									<c:if test='${tswacct.customerBySalesRepFk != null}'>					
									<input id="tswacct_customerBySalesRepFk" type="text" name="custSalesRep" value="${tswacct.customerBySalesRepFk.firstname}&nbsp;${tswacct.customerBySalesRepFk.lastname}" readonly="readonly" style="width:200px;" />
									</c:if>
								</div>
								<br>
								</td>
								<td>
									<div style="width:40px;">&nbsp;</div>
								</td>
								<td>
								<br>
								<div>
									<label><fmt:message key="tswacct.activeyn.title" /></label>
									<form:checkbox id="tswacct_activeYn" path="activeYn" value="1" />
								</div>
								<br>
								</td>
							</tr>
						</tbody>
					</table>
							</fieldset>
						</div>
						<div class="tabs-content" id="acct-subscr">
							<fieldset>
					<table>	
						<tbody>
							<tr style="width:100%;">				
								<td style="width:50%;">
								<br>

								<div>
									<label><fmt:message key="tswacct.establishdate.title" /></label> 
									<input class="datepicker" id="tswacct_establishDate" type="text" readonly="readonly" name="establishDate" type="text" value='<fmt:formatDate value="${tswacct.establishDate.time}" pattern="MM/dd/yyyy"/>' style="width: 100px;" />
								</div>
								<br>
								</td>
								<td>
									<div style="width:40px;">&nbsp;</div>
								</td>
								<td>
								<br>								<div>
									<label><fmt:message key="tswacct.expiredate.title" /></label> 
									<input class="datepicker" id="tswacct_expireDate" type="text" readonly="readonly" name="expireDate" type="text" value='<fmt:formatDate value="${tswacct.expireDate.time}" pattern="MM/dd/yyyy"/>' style="width: 100px;" />
								</div>
								<br>
								</td>
								</tr>
								<tr>
								<td>
								<br>								
								<div>
									<label><fmt:message key="tswacct.amtpaid.title" /></label>
									$<form:input id="tswacct_amtPaid" type="text" readonly="readonly" path="amtPaid" cssStyle="width:150px;" />
								</div>
									<br>
								</td>
								<td>
									<div style="width:40px;">&nbsp;</div>
								</td>
								<td>
								<br>
								<div>
									<label>Discount</label>
									$<form:input id="tswacct_amtDiscount" type="text" readonly="readonly" path="amtDiscount" cssStyle="width:150px;" />
								</div>
								<br>
								</td>
							</tr>
						</tbody>
					</table>	
							</fieldset>
						</div>

					</div>

					<!-- ## / Panel Content  -->

					<div class="button-bar">
						<input class="button-clean submit" id="save" type="submit" value="Save Account" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="reset" name="reset" value="Reset" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/dashboard'" />
						<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></span>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
