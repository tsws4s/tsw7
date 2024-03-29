<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.books-resources"/>
<html>
<head>
<title>View <fmt:message key="books.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="books.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexBooks"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="books.bookid.title"/>:
						</td>
						<td>
							${books.bookId}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="books.orderdate.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${books.orderDate.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="books.title.title"/>:
						</td>
						<td>
							${books.title}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="books.format.title"/>:
						</td>
						<td>
							${books.format}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="books.asinisbn.title"/>:
						</td>
						<td>
							${books.asinIsbn}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="books.author.title"/>:
						</td>
						<td>
							${books.author}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="books.releasedate.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${books.releaseDate.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="books.price.title"/>:
						</td>
						<td>
							${books.price}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="books.userfk.title"/>:
						</td>
						<td>
							${books.userFk}
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