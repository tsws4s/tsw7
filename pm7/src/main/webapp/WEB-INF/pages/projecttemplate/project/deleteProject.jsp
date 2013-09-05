<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.projecttemplate-resources"/>
<html>
<head>
<title>View <fmt:message key="projecttemplate.title"/> <fmt:message key="project.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="project.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectProjecttemplate?templateIdKey=${projecttemplate_templateId}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="project.projectid.title"/>:
						</td>
						<td>
							${project.projectId}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="project.projectname.title"/>:
						</td>
						<td>
							${project.projectName}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="project.projectdesc.title"/>:
						</td>
						<td>
							${project.projectDesc}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="project.projecttype.title"/>:
						</td>
						<td>
							${project.projectType}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="project.startdate.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${project.startDate.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="project.duedate.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${project.dueDate.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="project.completedate.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${project.completeDate.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="project.estimatehrs.title"/>:
						</td>
						<td>
							${project.estimateHrs}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="project.actualhrs.title"/>:
						</td>
						<td>
							${project.actualHrs}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="project.hrrate.title"/>:
						</td>
						<td>
							${project.hrRate}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="project.activeyn.title"/>:
						</td>
						<td>
							${project.activeYn}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/deleteProjecttemplateProject?projecttemplate_templateId=${projecttemplate_templateId}&related_project_projectId=${project.projectId}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
