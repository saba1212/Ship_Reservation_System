<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SHIP PAGE</title>
</head>
<body>

<style>
 body {
            background-image: url("file:///C:/Users/Win/workspace2/SRS/src/main/webapp/WEB-INF/images/Cruise.jpg");
         }
</style>


			 <form action ="ship.html" method ="post">
              
              <br />
        	 <br />                                                 
            SHIP ID:  <input type = "text" name = "shipid" />                               SHIP NAME: <input type = "text" name = "shipname" />   
            <p><font size="4" color="white">WARNING! Seating Capacity must be less than or equal to Reservation Capacity. Therfore enter the details properly</font></p>
        SEATING CAPACITY: <input type = "text" name = "seatingcapacity" />                 RESERVATION CAPACITY:<input type = "text" name = "reservationcapacity" />
            
         <br />
         <br />        
                                 
                                                <input type = "submit" value ="Submit" />
      </form>





</body>
</html>