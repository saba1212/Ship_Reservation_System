<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SHIP DELETE PAGE</title>
</head>
<body>
<style>

table 
{
  border-collapse: collapse;
  width: 75%;
}

th, td 
{
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}
h {
  background-color: green;
  color: white;
}


</style>


	<div align="center">
	
	<h1> SHIP DETAILS DELETE FORM</h1>
	<br>
	<br>
	
	
	
	<table border="1" bordercolor=#92a8d1  border-style= solid>

		<thead>
			<tr>
				<th>SHIP ID</th>
				<th>SHIP NAME</th>
				<th>SEATING CAPACITY</th>
				<th>RESERVATION CAPACITY</th>
				<th>  DELETE  </th>
			</tr>
		</thead>
		<tbody>


			<tr>

				<td><% String shipid=(String) session.getAttribute("shipid");if(shipid!=null){ %>
				
				<%=shipid %> <%} %>
				
				</td>
				<td><% String shipname=(String)session.getAttribute("shipname"); if(shipname!=null){%>
				
				<%=shipname %> <%} %>
				</td>
				<td><% String seatingcapacity=(String)  String.valueOf(session.getAttribute("seatingcapacity"));if(seatingcapacity!=null){%>
				
				<%=seatingcapacity %>  <%} %>
				</td>
				<td><% String reservationcapacity=(String)  String.valueOf(session.getAttribute("reservationcapacity"));%>
				
				<%=String.valueOf(reservationcapacity) %> 
				
				</td>
				<td> 
				
				<a href="shipdeletedo"<%= session.getAttribute("shipid") %>"
							> <input type="submit" value="DELETE"> </a></td>
			</tr>

		</tbody>



	
	</table>
	
	<br>
	<br>
	<input action="action" type="button" value="BACK" onclick="history.go(-1);" />
</div>
</body>
</html>