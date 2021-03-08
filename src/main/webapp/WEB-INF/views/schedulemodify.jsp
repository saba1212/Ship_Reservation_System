<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SCHEDULE MODFIY PAGE</title>
<style type="text/css">
.myTable { background-color:white;border-collapse:collapse; }
.myTable th { background-color:#92a8d1;color:white;width:40%; }
.myTable td, .myTable th { padding:2px;border:1px solid #BDB76B; }
.myTable tr:nth-child(odd) {
 
 background-color: white;
  color:white;
}
</style>
</head>
<body>

<div align="center">
		<h1>SCHEDULE DETAILS MODIFY FORM</h1>
		
		<form action="schedulemodify" method="post">
			
			<label>SCHEDULE  ID:</label> <input type="text" name="scheduleid"
				value="<%=session.getAttribute("scheduleid")%>" required readonly>
				
			<br> <br> 
			<label>SHIP ID:</label> <input type="text"
				name="shipid" value="<%=session.getAttribute("shipid")%>"
				required /> <br> <br> 
			
			<label>ROUTE ID:</label> <input
				type="text" name="routeid"
				value="<%=session.getAttribute("routeid")%>" required /> <br>
				
				<br> <br> 
			
				
			 <label> STARTING DATE:</label> 			 
			 <input type="text"  value="<%=session.getAttribute("startingdate")%>" name="startingdate"
				 /> 
			 <br> <br> 	
			 
			 
			<label> DEPARTURE TIME:</label> 			 
			 <input type="text"  value="<%=session.getAttribute("departuretime")%>" name="departuretime"
				 /> 
			 <br> <br> 
			
			
			 
			 
			
			                          <input type="submit"    value="MODIFY" />

		</form>
		
		<br><br>
		
		
		<%
			String msg = (String) request.getAttribute("MESSAGE");
			if (msg != null) {
		%>

		<h1>
			<%=msg%></h1>
		<%
			}
		%>
		
		      <input action="action" type="button" value="BACK" onclick="history.go(-2);" />

	</div>
		

</body>
</html>