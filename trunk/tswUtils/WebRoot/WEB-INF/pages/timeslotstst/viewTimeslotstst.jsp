<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.timeslotstst-resources"/>
<html>
<head>
<title>View <fmt:message key="timeslotstst.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="timeslotstst.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexTimeslotstst"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.timeslotid.title"/>:
						</td>
						<td>
							${timeslotstst.timeslotId}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.timeslot.title"/>:
						</td>
						<td>
							${timeslotstst.timeslot}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.date.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${timeslotstst.date.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.start.title"/>:
						</td>
						<td>
							<fmt:formatDate timeStyle="short" type="time" value="${timeslotstst.start.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.end.title"/>:
						</td>
						<td>
							<fmt:formatDate timeStyle="short" type="time" value="${timeslotstst.end.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.pricelevel.title"/>:
						</td>
						<td>
							${timeslotstst.priceLevel}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.custdisplay.title"/>:
						</td>
						<td>
							${timeslotstst.custDisplay}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.custfk.title"/>:
						</td>
						<td>
							${timeslotstst.custFk}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.gamefk.title"/>:
						</td>
						<td>
							${timeslotstst.gameFk}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.modifiedlast.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="both" value="${timeslotstst.modifiedLast.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.modifiedbyuserfk.title"/>:
						</td>
						<td>
							${timeslotstst.modifiedByUserFk}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.zamoperatorcustfk.title"/>:
						</td>
						<td>
							${timeslotstst.zamOperatorCustFk}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.activeyn.title"/>:
						</td>
						<td>
							${timeslotstst.activeYn}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.concessionwkrcustfk.title"/>:
						</td>
						<td>
							${timeslotstst.concessionWkrCustFk}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.officewkrcustfk.title"/>:
						</td>
						<td>
							${timeslotstst.officeWkrCustFk}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.t3sfk.title"/>:
						</td>
						<td>
							${timeslotstst.t3sFk}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.belongstoresid.title"/>:
						</td>
						<td>
							${timeslotstst.belongsToResId}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.programfk.title"/>:
						</td>
						<td>
							${timeslotstst.programFk}
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