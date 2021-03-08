<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ROUTE PAGE</title>
</head>
<body>

<style>
 body {
            background-image: url("file:///C:/Users/Win/workspace2/SRS/src/main/webapp/WEB-INF/images/Cruise.jpg");
         }
</style>

<div align="center"> 
		<h1>ROUTE LIST FORM</h1>
		
			 <form action ="route.html" method ="post">
              
              <br />
        	 <br />  
        	                                                
            <label>ROUTE ID: </label>
             <input type = "text" name = "routeid" />   <br/><br/>                          
             
             <label>CHOOSE A SOURCE:</label> <select
				name="source" id="source">
				<option> </option>
				<option value="Banglore">Banglore</option>
				<option value="Chennai">Chennai</option>
				<option value="Delhi">Delhi</option>
				<option value="Mumbai">Mumbai</option>
				<option value="Kolkata">Kolkata</option>
				<option value="Rajasthan">Rajasthan</option>
			</select> <br> <br>
			 <label>CHOOSE A DESTINATION:</label> 
			 <select name="destination" id="destination" >
				<option> </option>
				<option value="Banglore">Banglore</option>
				<option value="Chennai">Chennai</option>
				<option value="Delhi">Delhi</option>
				<option value="Mumbai">Mumbai</option>
				<option value="Kolkata">Kolkata</option>
				<option value="Rajasthan">Rajasthan</option>
			</select> <br> <br> 
			<label> TRAVEL DURATION:</label>
			 <input type="text" name="travelduration" /> <br> <br> 
			 
			 <label>ENTER FARE :</label> 
			 <input type="text" name="fare" /> <br>
			<br> 
			    <input type="submit" value="ADD" />
            
                                 
                                          
      </form>



</div>    

</body>
</html>