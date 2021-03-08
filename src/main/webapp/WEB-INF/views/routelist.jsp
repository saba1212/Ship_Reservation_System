<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ROUTE LIST PAGE</title>

<style type="text/css">
.myTable { background-color:#FFFFE0;border-collapse:collapse; }
.myTable th { background-color:#92a8d1;color:white;width:40%; }
.myTable td, .myTable th { padding:2px;border:1px solid #BDB76B; }
.myTable tr:nth-child(odd) 
{
 
 background-color: lightgreen;
 
  color:white;
  
  
}
</style>
</head>
<body>

<div align="center">

<h1> ROUTE LIST</h1>

	<table border="2" bordercolor =blue; "-collapse:collaps" backgroundcolor = background-color:coral;color:white;width:90%;>

		<thead>
			<table class="myTable">
			<tr>
				<th>ROUTE ID</th>
				<th>SOURCE</th>
				<th>DESTINATION</th>
				<th>TRAVEL DURATION</th>
				<th>FARE/MILE</th>
				<th>    DELETE </th>
				<th>    MODIFY  </th>
			</tr>
		</thead>
		
		<tbody>

			<c:forEach var="r" items="${ROUTE_LIST}">
				<tr>
					<td>${r.routeid}</td>
					<td>${r.source}</td>
					<td>${r.destination}</td>
					<td>${r.travelduration}</td>
					<td>${r.fare}</td>
					<td> <a href="routedelete?routeid=${r.routeid}&source=${r.source}&destination=${r.destination}&travelduration=${r.travelduration}&fare=${r.fare}"
							> DELETE </a></td>
					<td> <a href="routemodify?routeid=${r.routeid}&source=${r.source}&destination=${r.destination}&travelduration=${r.travelduration}&fare=${r.fare}"
							> MODIFY </a></td>
					
					
	
				</tr>


			</c:forEach>

		</tbody>


	</table>
	 <%
		String msg =(String)request.getAttribute("MESSAGE");
	
		if (msg != null) {
	%>

	<h1>	<%=msg%></h1>
	<%
		}
	%> 
	
	<br> 
	
	<a href="index.jsp"> 
	                          <input type="submit" value="BACK"/></a>
</div>
</body>
</html>