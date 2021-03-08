<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ROUTE DELETE PAGE</title>
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
	
	<h1> ROUTE DETAILS DELETE FORM</h1>
	<br>
	<br>
	
	
	
	<table border="1" bordercolor=#92a8d1  border-style= solid>

		<thead>
			<tr>
				<th>ROUTE ID</th>
				<th>SOURCE</th>
				<th>DESTINATION</th>
				<th>TRAVEL DURATION</th>
				<th>FARE</th>
				<th>  DELETE  </th>
			</tr>
		</thead>
		<tbody>


			<tr>

				<td><% String routeid=(String) session.getAttribute("routeid");if(routeid!=null){ %>
				
				<%=routeid %> <%} %>
				</td>
				
				<td><% String source=(String)session.getAttribute("source"); if(source!=null){%>				
				<%=source %> <%} %>
				</td>
				
				<td><% String destination=(String)session.getAttribute("destination");if(destination!=null){%>				
				<%=destination %>  <%} %>
				</td>
				
				<td><% String travelduration=(String)session.getAttribute("travelduration");if(travelduration!=null){%>				
				<%=travelduration%>  <%} %>
				</td>
				
				<td><% String fare=(String)session.getAttribute("fare");if(fare!=null){%>				
				<%=fare%>  <%} %>
				</td>
				
				
				<td> 
				
				<a href="routedeletedo"<%= session.getAttribute("routeid") %>"
							> <input type="submit" value="DELETE"> </a></td>
			</tr>

		</tbody>

				<%
				String msg = (String) request.getAttribute("MESSAGE");
				if (msg != null) {
			%>


			<h1><%=msg%></h1>
			<%
				}
			%>

	
	</table>
	
	<br>
	<br>
	<input action="action" type="button" value="BACK" onclick="history.go(-1);" />
</div>

</body>
</html>