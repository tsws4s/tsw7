<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.tswacct-resources" />
<html>
<head>
<title>Delete <fmt:message key="tswacct.title" />
</title>
</head>
<body>
	<div class="panel-wrapper fixed">
		<div class="panel">

			<div class="tabs">
				<ul>
					<li class="active"><a href="#" rel="tab-01-content"> <img
							src="simple/images/icons/icon-settings.png" alt="">
							&nbsp;&nbsp;<fmt:message key="navigation.delete" /> Account
							(${tswacct.tswAcctId}) <strong>${tswacct.acctName}</strong> </a>
					</li>
					<li class="last"><a href="#" rel="tab-02-content">Subscription</a>
					</li>
				</ul>
				<div class="collapse">collapse</div>
			</div>

			<div class="tabs-content">
				<!-- ## Panel Content  -->
				<div id="tab-01-content" class="active">

					<div class="group fixed">
						<label><fmt:message key="tswacct.acctname.title" />
						</label> <label><strong>${tswacct.acctName}</strong>
						</label>
					</div>
					<div class="group fixed">
						<label><fmt:message key="tswacct.amtpaid.title" />
						</label> <label><strong>${tswacct.amtPaid}</strong>
						</label>
					</div>
					<div class="group fixed">
						<label><fmt:message key="tswacct.activeyn.title" />
						</label>
						<c:if test='${tswacct.activeYn == 1}'>
							<label><strong>Yes</strong>
							</label>
						</c:if>
					</div>
				</div>
				<div id="tab-02-content">
					<div class="group fixed">
						<label><fmt:message key="tswacct.subscrtype.title" />
						</label> <label><strong>${tswacct.subscrType}</strong>
						</label>
					</div>
					<div class="group fixed">
						<label><fmt:message key="tswacct.establishdate.title" />
						</label> <label><strong><fmt:formatDate
									value="${tswacct.establishDate.time}" pattern="MM-dd-yyyy" />
						</strong>
						</label>
					</div>
					<div class="group fixed">
						<label><fmt:message key="tswacct.expiredate.title" />
						</label> <label><strong><fmt:formatDate
									value="${tswacct.expireDate.time}" pattern="MM-dd-yyyy" />
						</strong>
						</label>
					</div>
				</div>
				<!-- ## / Panel Content  -->
			</div>
			<div class="button-bar">
				<input class="button-clean" type="button" name="delete" value="Confirm Delete" onclick="location.href='${pageContext.request.contextPath}/deleteTswacct?tswAcctIdKey=${tswacct.tswAcctId}&amp;'" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/indexTswacct'" />
				<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></span>
			</div>
		</div>
		<div class="shadow"></div>
	</div>
</body>
</html>
