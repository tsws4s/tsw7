<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.budgetaccount-resources"/>
<html>
<head>
<title>View <fmt:message key="budgetaccount.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="budgetaccount.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexBudgetAccount"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="budgetaccount.budid.title"/>:
						</td>
						<td>
							${budgetaccount.budId}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="budgetaccount.account.title"/>:
						</td>
						<td>
							${budgetaccount.account}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="budgetaccount.incexp.title"/>:
						</td>
						<td>
							${budgetaccount.incExp}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="budgetaccount.budgetfk.title"/>:
						</td>
						<td>
							${budgetaccount.budgetFk}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="budgetaccount.jan.title"/>:
						</td>
						<td>
							${budgetaccount.jan}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="budgetaccount.feb.title"/>:
						</td>
						<td>
							${budgetaccount.feb}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="budgetaccount.mar.title"/>:
						</td>
						<td>
							${budgetaccount.mar}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="budgetaccount.apr.title"/>:
						</td>
						<td>
							${budgetaccount.apr}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="budgetaccount.may.title"/>:
						</td>
						<td>
							${budgetaccount.may}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="budgetaccount.jun.title"/>:
						</td>
						<td>
							${budgetaccount.jun}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="budgetaccount.jul.title"/>:
						</td>
						<td>
							${budgetaccount.jul}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="budgetaccount.aug.title"/>:
						</td>
						<td>
							${budgetaccount.aug}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="budgetaccount.sep.title"/>:
						</td>
						<td>
							${budgetaccount.sep}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="budgetaccount.oct.title"/>:
						</td>
						<td>
							${budgetaccount.oct}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="budgetaccount.nov.title"/>:
						</td>
						<td>
							${budgetaccount.nov}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="budgetaccount.dec.title"/>:
						</td>
						<td>
							${budgetaccount.dec}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="budgetaccount.total.title"/>:
						</td>
						<td>
							${budgetaccount.total}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="budgetaccount.activeyn.title"/>:
						</td>
						<td>
							${budgetaccount.activeYn}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="budgetaccount.userfk.title"/>:
						</td>
						<td>
							${budgetaccount.userFk}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>