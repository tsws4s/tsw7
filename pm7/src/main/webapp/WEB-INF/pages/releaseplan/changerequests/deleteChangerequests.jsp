<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.releaseplan-resources"/>
<html>
<head>
<title>View <fmt:message key="releaseplan.title"/> <fmt:message key="changerequest.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="changerequest.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectReleaseplan?releaseIdKey=${releaseplan_releaseId}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="changerequest.changeid.title"/>:
						</td>
						<td>
							${changerequest.changeId}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="changerequest.status.title"/>:
						</td>
						<td>
							${changerequest.status}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="changerequest.changepriority.title"/>:
						</td>
						<td>
							${changerequest.changePriority}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="changerequest.changecode.title"/>:
						</td>
						<td>
							${changerequest.changeCode}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="changerequest.changename.title"/>:
						</td>
						<td>
							${changerequest.changeName}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="changerequest.changedescription.title"/>:
						</td>
						<td>
							${changerequest.changeDescription}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/deleteReleaseplanChangerequests?releaseplan_releaseId=${releaseplan_releaseId}&related_changerequests_changeId=${changerequest.changeId}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
