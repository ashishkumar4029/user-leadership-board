<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leadership Board</title>
<link href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 14px;
	line-height: 1.42857143;
	color: #333;
	background-color: #fff;
	height: 200em;
}

table td {
	/* border-top: thin solid; */
	border-bottom: thin solid;
}

table td:first-child {
	border-left: thin solid;
}

table td:last-child {
	border-right: thin solid;
	border-left: thin solid;
}

table th {
	border-top: thin solid;
	border-bottom: thin solid;
}

table th:first-child {
	border-left: thin solid;
}

table th:last-child {
	border-right: thin solid;
	border-left: thin solid;
}

.uid {
	border: 1px solid #ccc;
	width: 60%;
	float: left;
	padding: 2px 0px 2px 30px;
}

.rank {
	border: 1px solid #ccc;
	width: 22%;
	float: left;
	padding: 2px 0px 2px 3px;
	text-align:center;
}
</style>
</head>
<body style="background: #f2f2f2;">
	<div style="">
		<div style="text-align: center; width: 100%">

			<form:form method="post" commandName="/board"
				modelAttribute="searchVo"
				style="width: 37%;float: left;margin-left: 21%;padding-top:1em;">
			Enter UID :
				<form:input type="text" id="userId" name="userId" path="userId"
					style="width: 60%;display: inline;" class="form-control" />
				<button type="submit" class="btn btn-success">Submit</button>

			</form:form>
			<form:form method="post" commandName="/board"
				modelAttribute="searchVo"
				style="width: 10%;FLOAT: RIGHT;margin-right: 32%;padding-top:1em;">
				<form:input type="hidden" id="searchType" name="searchType"
					path="searchType" value="topPlayers" />
				<button type="submit" class="btn btn-success">Leadership
					Board</button>
			</form:form>
		</div>

	</div>
	<div style="margin-left: 20em; background: white; margin-right: 30em;">
		<div style="text-align: center;/* align-items: center; */float: left;width: 100%;padding: 20px;">${errMsg}</div>
		<%-- <div style="text-align: center;">${noResu}</div> --%>
		<div style="padding: 3em; padding-left: 20%;height: 200em;padding-top:60px">
			<%-- <c:choose> --%>
			<c:if test="${not empty result}">
				<div>

					<div>
						<div class="uid" style="text-align: center; font-weight: bold;">UID</div>
						<div class="rank" style="text-align: center; font-weight: bold;">Rank</div>
					</div>

					<c:forEach items="${result}" var="data">
						<div>
							<div class="uid">${data.userId}</div>
							<div class="rank">${data.rank}</div>
						</div>
					</c:forEach>

				</div>
			</c:if>
			<%-- <c:otherwise>
			       <c:if test="${not empty noUserId}">No esult Found</c:if>
				</c:otherwise> --%>
			<%-- </c:choose> --%>
		</div>
	</div>
</body>
</html>
