<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Profile Details</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/loginstyle.css">
        <!-- CSS here -->
        <style>
            body {

                background-image: url("./assets/hrProfileBackGround.jpg");

            }
        </style>
        <!--<link rel="stylesheet" href="css/bootstrap.min.css">-->
        <link rel="stylesheet" href="css/profileDecoration.css">
        <!--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">-->
    </head>
    <body>

        <c:set var="hr" value="${HR}"></c:set>       

            <div class="bg-image">
                <section class="container forms">
                    <div class="form login">
                        <div class="form-content">
                            <header><img src="./assets/logo-profile.png" alt="Logo"/></header>

                            <hr>

                            <header class="profile-name">${User.getName()}</header>
                        <form action="UpdateHRProfile?hrId=${hr.getHrId()}" method="Post">


                            <div class="field input-field">
                                <input type="text" placeholder="Gender" class="input" name="gender" value="${hr.getGender()}">
                                <i class='bx bx-hide eye-icon'></i>
                            </div>

                            <div class="field input-field">
                                <input type="text" placeholder="Phone Number" class="input" name="contactNumber" value="${hr.getContactNumber()}" >
                                <i class='bx bx-hide eye-icon'></i>
                            </div>

                            <div class="field input-field">
                                <input type="text" placeholder="Company Name" class="input" name="companyNumber" value="${hr.getCompanyName()}" readonly>
                                <i class='bx bx-hide eye-icon'></i>
                            </div>
                          
                            <div style="display: flex;align-items: center;justify-content: center;"> 
                                <div class="field button-field">

                                    <button type="submit">Update</button>

                                </div>
                                &nbsp
                                <div class="field button-field">

                                    <a href="hrmenupage.jsp">

                                        <button class="field button-field" style="width: 180px !important; transform: translateY(-1.2rem) !important; transform: translateX(2ch) ;">Back</button>
                                    </a>
                                </div>
                            </div>
                        </form>

                    </div>



                </div>

            </section>
        </div>

        <!-- JavaScript -->
        <script src="js/loginscript.js"></script>
         </body>
</html>