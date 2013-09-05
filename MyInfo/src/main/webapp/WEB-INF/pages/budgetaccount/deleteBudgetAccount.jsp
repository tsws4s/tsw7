<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.budgetaccount-resources"/>
<html>
<head>
<title>Confirm Delete <fmt:message key="budgetaccount.title"/></title>
</head>
<body>
		<div class="panel-wrapper">
					<div class="panel">
		
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
								<img src="css/images/icons/icon-user.png" alt="">
									&nbsp;&nbsp;<fmt:message key="navigation.delete"/> <fmt:message key="budgetaccount.title"/> 
								</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">

<div class="group fixed">
	<label>
		<fmt:message key="budgetaccount.budid.title"/>:
	</label> 
							${budgetaccount.budId}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budgetaccount.account.title"/>:
	</label> 
							${budgetaccount.account}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budgetaccount.incexp.title"/>:
	</label> 
							${budgetaccount.incExp}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budgetaccount.budgetfk.title"/>:
	</label> 
							${budgetaccount.budgetFk}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budgetaccount.jan.title"/>:
	</label> 
							${budgetaccount.jan}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budgetaccount.feb.title"/>:
	</label> 
							${budgetaccount.feb}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budgetaccount.mar.title"/>:
	</label> 
							${budgetaccount.mar}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budgetaccount.apr.title"/>:
	</label> 
							${budgetaccount.apr}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budgetaccount.may.title"/>:
	</label> 
							${budgetaccount.may}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budgetaccount.jun.title"/>:
	</label> 
							${budgetaccount.jun}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budgetaccount.jul.title"/>:
	</label> 
							${budgetaccount.jul}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budgetaccount.aug.title"/>:
	</label> 
							${budgetaccount.aug}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budgetaccount.sep.title"/>:
	</label> 
							${budgetaccount.sep}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budgetaccount.oct.title"/>:
	</label> 
							${budgetaccount.oct}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budgetaccount.nov.title"/>:
	</label> 
							${budgetaccount.nov}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budgetaccount.dec.title"/>:
	</label> 
							${budgetaccount.dec}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budgetaccount.total.title"/>:
	</label> 
							${budgetaccount.total}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budgetaccount.activeyn.title"/>:
	</label> 
							${budgetaccount.activeYn}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budgetaccount.userfk.title"/>:
	</label> 
							${budgetaccount.userFk}
						&nbsp;
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<a class="button-red" href="${pageContext.request.contextPath}/deleteBudgetAccount?budgetaccountIdKey=${budgetaccount.budId}&">Confirm Delete <img alt="" src="css/images/icons/icon-delete.png"></a>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="button-pink" href="${pageContext.request.contextPath}/indexBudgetAccount">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>						
					</div>
				<div class="shadow"></div>
		</div>

</body>
</html>