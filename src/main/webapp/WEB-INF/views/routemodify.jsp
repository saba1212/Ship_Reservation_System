<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ROUTE MODFIY PAGE</title>
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
		<h1>ROUTE DETAILS MODIFY FORM</h1>
		
		<form action="routemodify" method="post">
			
			<label>ROUTE ID :</label> 
			<input type="text"   value="<%String routeid = (String) session.getAttribute("routeid");
			
			if (routeid != null) {%> <%=routeid%>  <%}%>"
				name="routeid" readonly  /> <br> <br>
				
			 <label>CHOOSE A SOURCE:</label>
			  <select    value="<%String source = (String) session.getAttribute("source");
			if (source != null) {%>  <%=source%> <%}%>"
				name="source" id="source" >
				<option> <%String source1 = (String) session.getAttribute("source");
			if (source1 != null) {%>  <%=source1%> <%}%></option>
				<option value="Banglore">Banglore</option>
				<option value="Chennai">Chennai</option>
				<option value="Delhi">Delhi</option>
				<option value="Mumbai">Mumbai</option>
				<option value="Kolkata">Kolkata</option>				
			</select> 
			
			<br> <br> 
			
			<label>CHOOSE  A DESTINATION:</label> 
			
			<select  value="<%String destination = (String) session.getAttribute("destination");
			if (destination != null) {%> <%=destination%>  <%}%>"
				name="destination" id="destination" >
				<option> <%=session.getAttribute("destination")%></option>
				<option value="Banglore">Banglore</option>
				<option value="Chennai">Chennai</option>
				<option value="Delhi">Delhi</option>
				<option value="Mumbai">Mumbai</option>
				<option value="Kolkata">Kolkata</option>
				<option value="Rajasthan">Rajasthan</option>
			</select>
			 <br> <br> 
			 
			 
			 <label> TRAVEL DURATION:</label> 
			 
			 <input type="text"  value="<%=session.getAttribute("travelduration")%>" name="travelduration"
				 /> 
			 <br> <br> 
			 
			 <label>ENTER FARE/MILE:</label>
			<input type="text" value="<%=session.getAttribute("fare")%>"
				name="fare" required />
			 <br> <br> 
			                          <input type="submit"    value="MODIFY" />

		</form>
		
		<br><br>
		
		      <input action="action" type="button" value="BACK" onclick="history.go(-2);" />

	</div>
		

</body>
</html>