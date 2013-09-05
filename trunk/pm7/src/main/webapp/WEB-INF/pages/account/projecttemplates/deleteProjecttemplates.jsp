<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.account-resources"/>
<html>
<head>
<title>View <fmt:message key="account.title"/> <fmt:message key="projecttemplate.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="projecttemplate.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectAccount?accountIdKey=${account_accountId}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="projecttemplate.templateid.title"/>:
						</td>
						<td>
							${projecttemplate.templateId}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="projecttemplate.templatename.title"/>:
						</td>
						<td>
							${projecttemplate.templateName}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="projecttemplate.templatedesc.title"/>:
						</td>
						<td>
							${projecttemplate.templateDesc}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="projecttemplate.activeyn.title"/>:
						</td>
						<td>
							${projecttemplate.activeYn}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/deleteAccountProjecttemplates?account_accountId=${account_accountId}&related_projecttemplates_templateId=${projecttemplate.templateId}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
