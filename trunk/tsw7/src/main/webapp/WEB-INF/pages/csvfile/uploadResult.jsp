<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<html>

    <head>
        <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>Upload Result</title>
    </head>
    <body>

		<div class="panel">
			<div class="title">
				<h4>Records from Upload File: ${importFile.fileName}   ${requestScope.message}</h4>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>
			<div class="content">	
           <fieldset>
			<table class="tabularData">		
			<thead>
				<tr class="rowfive">
					<c:set var="totalCount" value="0"/>
					<c:forEach items="${importFile.headerRow}" var="current3" varStatus="j">
						<th>${current3}</th>
						<c:set var="totalCount" value="${totalCount+1}"/>
					</c:forEach>
				</tr>
			</thead>
			<tfoot>
				<tr class="rowfive">
					<th class="text-center" colspan="${totalCount}">
					<span style="color:#000000;">Select <strong>LOAD Records</strong> to import if these records look good, else <strong>CANCEL</strong> and re-UPLOAD corrected file.</span></th>
				</tr>
			</tfoot>
			<tbody>
				<c:forEach items="${importFile.importRecords}" var="current" varStatus="i">
					<c:choose>
						<c:when test="${(i.count) % 2 == 0}">
		    				<c:set var="rowclass" value="rowthree"/>
						</c:when>
						<c:otherwise>
		    				<c:set var="rowclass" value="rowfour"/>
						</c:otherwise>
					</c:choose>	
				<tr class="${rowclass}">
					<c:forEach items="${current}" var="current2" varStatus="j">
						<td class="${rowclass}">${current2}</td>
					</c:forEach>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</fieldset>
						<!-- ## / Panel Content   -->
						</div>
		<div class="button-bar">
			<span style="padding-left: 5px;"> 
				<input class="button-clean" type="button" name="load" value="LOAD Records" onclick="location.href='${pageContext.request.contextPath}/saveImportFile'" />
			</span> 
			<span style="padding-left: 90px;color:#000000;"> 
				<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/indexResource'" />
			</span> 
			<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/user.png" /></span>
		</div>
</div>
  </body>
</html>