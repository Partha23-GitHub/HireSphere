
<%@page import="com.hiresphere.models.FbProfile"%>
<%@page import="com.hiresphere.models.Fb_Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
        <style>
            body {

                background-image: url("./assets/profile-background.png");

            }
            </style>
    </head>
    <body>
        <%
            String access_token = (String) request.getParameter("access_token");
            Fb_Model obj_Profile_Modal = new Fb_Model();
            FbProfile obj_Profile_Bean = obj_Profile_Modal.call_me(access_token);
        %>
        <!--<img src="<%=obj_Profile_Bean.getProfile_picture()%>"></img>-->    
        <div style="display: flex; align-items: center;justify-content: center;">
   <h3>The App wants to access your personal information</h3>
        <form action="FaceBookLogin">
        <input type="text" name="name" id="name" value="<%=obj_Profile_Bean.getUser_name()%>" hidden >
        <input type="text" name="email" id="email" value="<%=obj_Profile_Bean.getEmail()%>" hidden >
        <input type="text" name="password" id="password" value="<%=obj_Profile_Bean.getId()%>" hidden>
         <button type="submit" class="nextBtn btnText">Allow</button>
    
        </form>
         </div>
<!--        <script>
        var name="<%=obj_Profile_Bean.getUser_name()%>";
        var names=name.split(' ');
        console.log("FirstName = "+ names[0]);
        console.log("LastName = "+ names[1]);
        </script>-->
<!--        var name="<%=obj_Profile_Bean.getUser_name()%>";
         var names=name.split(' ');
         var a=names[0];-->
    </body>
</html>
   