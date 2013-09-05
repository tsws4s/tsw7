<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<html>

    <head>
        <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>Load Result</title>
    </head>
    <body>

		<div class="panel">
			<div class="title">
				<h4>Loaded Records from: ${importFile.fileName}   ${requestScope.message}</h4>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>
			<div class="content">	
           <fieldset>
			<table class="tabularData">		
			<thead>
				<tr class="rowfive">
					<th>Loaded</th>
					<th>${importFile.headerRow[0]}</th>
					<th>${importFile.headerRow[1]}</th>
					<th>${importFile.headerRow[2]}</th>
					<th>${importFile.headerRow[3]}</th>
					<th>${importFile.headerRow[4]}</th>
				</tr>
			</thead>
			<tfoot>
				<tr class="rowfive">
					<th class="text-center" colspan=6>
					<span style="color:#000000;">Records marked 'true' have been loaded.  Those marked 'false' were not.</span></th>
				</tr>
			</tfoot>
			<tbody>
				<c:set var="recordCount" value="0"/>
				<c:forEach items="${importFile.importRecords}" var="current" varStatus="i">
				<c:set var="recordCount" value="${recordCount+1}"/>
					<c:choose>
						<c:when test="${(i.count) % 2 == 0}">
		    				<c:set var="rowclass" value="rowthree"/>
						</c:when>
						<c:otherwise>
		    				<c:set var="rowclass" value="rowfour"/>
						</c:otherwise>
					</c:choose>	
				<tr class="${rowclass}">
					<td class="${rowclass}">${importFile.recordLoaded[recordCount]}</td>
						<td class="${rowclass}">${current[0]}</td>
						<td class="${rowclass}">${current[1]}</td>
						<td class="${rowclass}">${current[2]}</td>
						<td class="${rowclass}">${current[3]}</td>
						<td class="${rowclass}">${current[4]}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</fieldset>
			<!-- ## / Panel Content   -->
			</div>
		<div class="button-bar">
			<span style="padding-left: 10px;"> 
				<input class="button-clean" type="button" name="ok" value="  OK  " onclick="location.href='${pageContext.request.contextPath}/importExport'" />
			</span> 
			<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/user.png" /></span>
		</div>
</div>
  </body>
</html>