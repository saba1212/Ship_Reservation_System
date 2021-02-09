<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SHIP LIST PAGE</title>

<style type="text/css">
.myTable { background-color:#FFFFE0;border-collapse:collapse; }
.myTable th { background-color:#92a8d1;color:white;width:40%; }
.myTable td, .myTable th { padding:2px;border:1px solid #BDB76B; }
.myTable tr:nth-child(odd) {
 
 background-color: lightgreen;
 
  color:white;
  
  body{
 background-image: url("file:///C:/Users/Win/workspace2/SRS/src/main/webapp/WEB-INF/images/Ship.jpg");
 }
}
</style>
</head>
<body>
<style>
 
</style>
<div align="left">

<h1> SHIP LIST</h1>

	<table border="2" bordercolor =blue; "-collapse:collaps" backgroundcolor = background-color:coral;color:white;width:90%;>

		<thead>
			<table class="myTable">
			<tr>
				<th>SHIP ID</th>
				<th>SHIP NAME</th>
				<th>SEATING CAPACITY</th>
				<th>RESERVATION CAPACITY</th>
				<th>    DELETE </th>
				<th>    MODIFY  </th>
			</tr>
		</thead>
		
		<tbody>

			<c:forEach var="s" items="${SHIP_LIST}">
				<tr>
					<td>${s.shipid}</td>
					<td>${s.shipname}</td>
					<td>${s.seatingcapacity}</td>
					<td>${s.reservationcapacity}</td>
					<td> <a href="shipdelete?shipid=${s.shipid}&shipname=${s.shipname}&seatingcapacity=${s.seatingcapacity}&reservationcapacity=${s.reservationcapacity}"
							> DELETE </a></td>
					<td> <a href="shipmodify?shipid=${s.shipid}&shipname=${s.shipname}&seatingcapacity=${s.seatingcapacity}&reservationcapacity=${s.reservationcapacity}"
							> MODIFY </a></td>
					
	
				</tr>


			</c:forEach>

		</tbody>


	</table>
	<%
		String msg =(String)request.getAttribute("MESSAGE");
	
		if (msg != null) {
	%>

	<h1>
		<%=msg%></h1>
	<%
		}
	%> 
	
	<br>
	
	<a href="index.jsp"> 
	                          <input type="submit" value="BACK"/></a>
</div>
</body>
</html>