<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SCHEDULE DELETE PAGE</title>
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
	
	<h1> SCHEDULE DETAILS DELETE FORM</h1>
	<br>
	<br>
	
	
	
	<table border="1" bordercolor=#92a8d1  border-style= solid>

		<thead>
			<tr>
				<th>SCHEDULE ID</th>
				<th>SHIP ID</th>
				<th>ROUTE ID </th>
				<th>STARTING  DATE</th>
				<th>DEPARTURE TIME</th>				
				<th>    DELETE </th>
			</tr>
		</thead>
		<tbody>


			<tr>

				<td><% String scheduleid=(String) session.getAttribute("scheduleid");if(scheduleid!=null){ %>
				
				<%=scheduleid %> <%} %>
				</td>
				
				<td><% String shipid=(String)session.getAttribute("shipid"); if(shipid!=null){%>				
				<%=shipid %> <%} %>
				</td>
				
				<td><% String routeid=(String)session.getAttribute("routeid");if(routeid!=null){%>				
				<%=routeid %>  <%} %>
				</td>
				
				<td><% String startingdate=(String) session.getAttribute("startingdate");if(startingdate!=null){%>				
				<%=startingdate%>  <%} %>
				</td>
				
				<td><% String departuretime=(String)session.getAttribute("departuretime");if(departuretime!=null){%>				
				<%=departuretime%>  <%} %>
				</td>
				
				
				<td> 
				
				<a href="scheduledeletedo"<%= session.getAttribute("scheduleid") %>"
							> <input type="submit" value="DELETE"> </a></td>
			</tr>

		</tbody>

			
	
	</table>
		<%
				String msg = (String) request.getAttribute("MESSAGE");
				if (msg != null) {
			%>


			<h1><%=msg%></h1>
			<%
				}
			%>
	
	<br>
	<br>
	<input action="action" type="button" value="BACK" onclick="history.go(-1);" />
</div>

</body>
</html>