<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.requirement-resources"/>
<html>
<head>
<title>View <fmt:message key="requirement.title"/> <fmt:message key="statusupdate.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="statusupdate.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectRequirement?reqmtIdKey=${requirement_reqmtId}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="statusupdate.statusid.title"/>:
						</td>
						<td>
							${statusupdate.statusId}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="statusupdate.statusdate.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${statusupdate.statusDate.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="statusupdate.statusupdatedesc.title"/>:
						</td>
						<td>
							${statusupdate.statusUpdateDesc}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="statusupdate.esthrsleft.title"/>:
						</td>
						<td>
							${statusupdate.estHrsLeft}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="statusupdate.riskgyr.title"/>:
						</td>
						<td>
							${statusupdate.riskGyr}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/deleteRequirementStatusupdates?requirement_reqmtId=${requirement_reqmtId}&related_statusupdates_statusId=${statusupdate.statusId}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
