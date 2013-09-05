<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.tswacct-resources" />
<html>
<head>
<title>List <fmt:message key="tswacct.title" />s</title>
</head>
<body>
	<div class="panel-wrapper">
		<div class="panel">
			<div class="title">
				<h2>
					Manage Accounts
				</h2>
				<div class="collapse">collapse</div>
			</div>

			<div class="content">
				<!-- ## Panel Content  -->

				<table id="listTable" class="sortable resizable">

					<thead>
						<tr>
							<th>&nbsp;</th>
							<th><fmt:message key="tswacct.acctname.title" />
							</th>
							<th><fmt:message key="tswacct.subscrtype.title" />
							</th>
							<th><fmt:message key="tswacct.amtpaid.title" />
							</th>
							<th><fmt:message key="tswacct.establishdate.title" />
							</th>
							<th><fmt:message key="tswacct.expiredate.title" />
							</th>
							<th><fmt:message key="tswacct.activeyn.title" />
							</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="totalCount" value="0" />
						<c:forEach items="${tswaccts}" var="current" varStatus="i">
							<c:set var="totalCount" value="${totalCount+1}" />
							<c:choose>
								<c:when test="${(i.count) % 2 == 0}">
									<c:set var="rowclass" value="rowtwo" />
								</c:when>
								<c:otherwise>
									<c:set var="rowclass" value="rowone" />
								</c:otherwise>
							</c:choose>
							<tr class="${rowclass}">
								<td width="80px"><a class="icon"
									href="${pageContext.request.contextPath}/editTswacct?tswAcctIdKey=${current.tswAcctId}&amp;"><img
										src="simple/images/icons/icon-edit.png" alt="Edit">
								</a> <!-- 				<a class="icon" href="${pageContext.request.contextPath}/confirmDeleteTswacct?tswAcctIdKey=${current.tswAcctId}&"><img src="simple/images/icons/icon-delete.png" alt="Delete"></a> -->
								</td>

								<td>${current.acctName}&nbsp</td>
								<td>${current.subscrType}&nbsp;</td>
								<td>${current.amtPaid}&nbsp;</td>
								<td><fmt:formatDate type="date"
										value="${current.establishDate.time}" pattern="MM-dd-yyyy" />&nbsp;</td>
								<td><fmt:formatDate type="date"
										value="${current.expireDate.time}" pattern="MM-dd-yyyy" />&nbsp;</td>
								<td><c:if test='${current.activeYn == 1}'>	
						&nbsp;Yes
					</c:if> &nbsp;</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- ## / Panel Content  -->
			</div>

		</div>

		<div class="shadow"></div>
	</div>


</body>
</html>
