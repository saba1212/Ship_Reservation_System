<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SHIP MODIFY PAGE</title>
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
		<h1>SHIP DETAILS MODIFY FORM</h1>

		<form action="shipmodify" method="post">

			<label> SHIP ID:</label> <input type="text"
				value="<%String shipid = (String) session.getAttribute("shipid");
			if (shipid != null) {%> <%=shipid%> <%}%>"
				name=shipid required readonly /> 
				<br> </br>
				
			 <label
				for="shipname">CHOOSE A SHIP:</label> 
				<select
				value="<%String shipname = (String) session.getAttribute("shipname");
			
				if (shipname != null) {%> <%=shipname%>  <%}%>"
				name="shipname" id="shipname" required>
				<option> <%=session.getAttribute("shipname")%></option>
				<option value="Golden Triangle Cruise">Golden Triangle Cruise</option>
				<option value="Chilika Lake Cruise">Chilika Lake Cruise</option>
				<option value="Sunderbans Boat Cruise">Sunderbans Boat Cruise</option>
				<option value="Kerala Back Water Cruise">Kerala Back Water Cruise</option>
				<option value="Kochi Cruise">Kochi Cruise</option>
			</select> 
			<br> </br> 
			
			<label> SEATING CAPACITY:</label> 
			<input type="text"
				value="<%=session.getAttribute("seatingcapacity")%>"
				name="seatingcapacity" required /> 
				<br> </br> 
				
			<label>RESERVATION CAPACITY:</label> 
			<input type="text"
				value="<%=session.getAttribute("reservationcapacity")%>"
				name="reservationcapacity" required /> 
				<br> </br> 
				
			<input type="submit" value="MODFIY" />

		</form>



		
<br>
<br> 
		<input action="action" type="button" value="BACK" onclick="history.go(-2);" />

	</div>

</body>
</html>