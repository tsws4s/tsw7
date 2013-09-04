<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.resource-resources" />
<fmt:setBundle basename="bundles.level-resources" />
<fmt:setBundle basename="bundles.price-resources" />

<html>
<head>
<title>Account</title>
</head>
<body style="width:600px;">
	<div class="panel">
			<div class="formular">
			<div class="title-large">
				<h2>Account Info</h2>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>
			<div class="content inpad">
			<fieldset>
				<table>
					<tbody>
						<tr>
						<td width="250px;">
						<br />
						<div> 
						<label>Account Name</label>
						<label style="font-size:1.2em;">${tswacct.acctName}</label>
						</div>
						</td>
						</tr>
						<tr>
						<td width="250px;">
						<br />
						<div> 
						<label>Administrator Name</label>
						<label style="font-size:1.2em;">${tswacct.customer.firstname}&nbsp;${tswacct.customer.lastname}</label>
						</div>
						</td>
						</tr>
						<tr>
						<td width="250px;">
						<br />
						<div>
						<label>Subscription Type</label>
						<label style="font-size:1.2em;">${tswacct.subscrType}</label>
						</div>
						</td>
						<td>
						<br />
						<div>
						<label>Paid</label>
						<label style="font-size:1.2em;">$ ${tswacct.amtPaid}</label>
						</div>
						</td>
						</tr>
						<tr>
						<td width="250px;">
						<br />
						<div>
						<label>Establish Date</label>
						<label style="font-size:1.2em;"><fmt:formatDate value='${tswacct.expireDate.time}' pattern='MM/dd/yyyy'/> </label>
						</div>
						<br />
						</td>
						<td>
						<br />
						<div>
						<label>Expire Date</label>
						<label style="font-size:1.2em;"><fmt:formatDate value='${tswacct.expireDate.time}' pattern='MM/dd/yyyy'/> </label>
						</div>
						<br />
						</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
		</div>
	</div>
</div>
	<div class="panel">
			<div class="title-large">
				<h2>List Resources</h2>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>
			<div class="content">

						<table class="tabularData">

							<thead>
								<tr>
									<th>&nbsp;</th>
									<th>Resource Name</th>
									<th class="center">Price</th>
									<th class="center">Active</th>
									<th>Resource Type</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="totalCount" value="0" />
								<c:forEach items="${resources}" var="current" varStatus="i">
									<c:set var="totalCount" value="${totalCount+1}" />
									<c:choose>
										<c:when test="${(i.count) % 2 == 0}">
											<c:set var="rowclass" value="rowtwo" />
										</c:when>
										<c:otherwise>
											<c:set var="rowclass" value="rowone" />
										</c:otherwise>
									</c:choose>
									<tr class="${rowclass}" >
										<td width="20px" class="center">&nbsp;</td>
										<td>${current.resourceName}&nbsp;</td>
										<td class="right">${current.price.priceField} (${current.price.priceCategory})</td>
										<td class="center">
										<c:if test='${current.activeYn == 1}'>	
											&nbsp;Yes
										</c:if> &nbsp;</td>
										<td>${current.resourceType}&nbsp;</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
			</div>
</div>
	<div class="panel">		
			<div class="title-large">
				<h2>List Levels</h2>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>
			<div class="content">
	
						<table class="tabularData">

							<thead>
								<tr>
									<th>&nbsp;</th>
									<th>Level Name</th>
									<th>Code</th>
									<th class="text-center">Age Low</th>
									<th class="text-center">Age High</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="totalCount" value="0" />
								<c:forEach items="${levels}" var="current" varStatus="i">
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
										<td width="20px" class="center">&nbsp;</td>
										<td>${current.levelName}&nbsp;</td>
										<td>${current.levelCode}&nbsp;</td>
										<td class="text-center">${current.ageLow}&nbsp;</td>
										<td class="text-center">${current.ageHigh}&nbsp;</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

				<!-- ## / Panel Content  -->
			</div>		
</div>
	<div class="panel">		
			<div class="title-large">
				<h2>List Prices</h2>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>
			<div class="content">
						<table class="tabularData">
							<thead>
								<tr>
									<th>&nbsp;</th>
									<th><fmt:message key="price.pricecategory.title" /></th>
									<th class="center"><fmt:message key="price.pricefield.title" /></th>
									<th class="center"><fmt:message key="price.pricecolor.title" /></th>
								</tr>
							</thead>
							<tbody>
								<c:set var="totalCount" value="0" />
								<c:forEach items="${prices}" var="current" varStatus="i">
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
										<td width="20px" class="center">&nbsp;</td>
										<td>${current.priceCategory}&nbsp;</td>
										<td class="center">${current.priceField}&nbsp;</td>
										<td class="center">${current.priceColor}&nbsp;</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
		
				<!-- ## / Panel Content  -->
			</div>
			<div class="button-bar">
				<span style="padding-left: 90px;"> 
					<input class="button-clean" type="button" name="select" value="Print" onclick="window.print()" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="button-clean" type="button" name="cancel" value="Close" onclick="window.close()" />
				 </span>
				<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></span>
			</div>

	</div>

</body>
</html>

