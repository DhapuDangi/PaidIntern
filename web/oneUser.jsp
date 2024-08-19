
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
           <link rel="stylesheet" href="oneuser.css"/>
    </head>
    <body>
        <div class="nav">
  </div>
       <div class="from">
                    <H2>View Individual User</H2>
                 
            
                    <form action="ViewUserChecker" method="Post">
                        <table >
                        <tr>
                            <td><strong>User Id:</strong></td>
                            <td><input type="text" name="id" placeholder="Enter Your User Id "></td>
        
                        </tr>
                     </table>
                        <div class="btn"><Button type="submit"> Submit</button></div>
                    </form>
                </div>
            </div>
    </body>
</html>

