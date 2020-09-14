<%@page import="com.ui.model.PlanDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>All Plans are below.....</h1>
	<table border="1" width="310">
		<tr>
			<th>PlanID</th>
			<th>PlanName</th>
			<th>Validity</th>
			<th>Description</th>
		</tr>

		<%
			//out.println("map is:" + request.getSession().getAttribute("plansList"));
		java.util.List<PlanDTO> ldto = (java.util.List<PlanDTO>) request.getSession().getAttribute("plansList");
		
		for (PlanDTO pdto : ldto) {
			out.println("<tr>");
			out.println("<td>" + pdto.getPlanId() + "</td>");
			out.println("<td>" + pdto.getPlanName() + "</td>");
			out.println("<td>" + pdto.getValidity() + "</td>");
			out.println("<td>" + pdto.getDescription() + "</td>");
			out.println("</tr>");
		}
		%>
	</table>
	<%-- <c:forEach items="planList" var=${plan}  scope="Session">
    <tr>      
        <td>${plan.planId}</td>
        <td>${plans.planName}</td>
        <td>${plan.validity}</td>
        <td>${plan.description}</td>
    </tr>
</c:forEach> --%>
</body>
</html>