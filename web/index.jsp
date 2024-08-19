

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
         <title>Home Page</title>
        <link rel="stylesheet" href="style.css"  />
   
    </head>
    <body>
         <div id="faculty"><h3>Enter your choose...</h3>
         <div class="mg-y">
         <form action="addUser.jsp"><input style='  background-color: transparent;
    border: none;' name="data" type="submit" value="Enter Profile" ></form>
         </div>
             
     <div class="mg-y">
         <form action="trainChoice.jsp" method="post"  ><input style='  background-color: transparent;
            border: none;' name="data" type="submit" value="Enter Train Choice" ></form>
     </div>
             
      <div class="mg-y">
       <form action="oneUser.jsp" method="post"  ><input style='  background-color: transparent;
    border: none;' name="data" type="submit" value="Display Person Information" > 
       </form>
      </div>
             
      <div class="mg-y">
          <form action="Emp.jsp" method="get"  ><input style='  background-color: transparent;
    border: none;' name="data" type="submit" value="Display Complete Information" >
          </form>
      </div>
             
      <div class="mg-y">
          <form action="selectTrain.jsp" method="post"  ><input style='  background-color: transparent;
    border: none;' name="data" type="submit" value="Display Train Status" >
          </form>
      </div>      

      </div>
    </body>
</html>
