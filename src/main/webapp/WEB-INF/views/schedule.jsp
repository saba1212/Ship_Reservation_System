<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SCHEDULE PAGE</title>
</head>
<body>
<style>
 body {
            background-image: url("file:///C:/Users/Win/workspace2/SRS/src/main/webapp/WEB-INF/images/Cruise.jpg");
         }
</style>

<div align="center"> 
		<h1>SCHEDULE LIST FORM</h1>
		
			 <form action ="schedule.html" method ="post">
              
              <br />
        	 <br />  
        	                                                
            <label>SCHEDULE ID: </label>
             <input type = "text" name = "scheduleid" />   <br/><br/> 
             
             <label> SHIP ID:</label> 
             <input type= "text" name= "shipid"/> <br/><br/>
             
             
             <label> ROUTE ID:</label>
             <input type= "text" name="routeid" /> <br/> <br/>
             
                                   
             
             <label>STARTING DATE:</label>

			<input type="text" name="startingdate"/> <br/> <br/>
      		 
             
			 <label>DEPARTURE TIME :</label> 
			 <input type="text" name="departuretime" /> <br>
			<br> 
			    <input type="submit" value="ADD" />
            
                                 
                                          
      </form>

<%String msg=(String)request.getAttribute("MESSAGE");

if(msg!=null){ %>
	
	<h1> <%=msg %></h1>
	<%} %>

</div>    

</body>
</html>
