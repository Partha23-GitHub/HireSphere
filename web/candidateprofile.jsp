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
               
                background-image: url("./assets/profile-background.png");
                
            }
            #closing-logo-profile{
                transform: translate(22.5rem,-5.1rem);
                    
            }
            #closing-logo-login{
                padding-top: 0px;
                padding-bottom: 5px; 
            }
            #logo-profile{
              transform: translate(6.5rem,-0.1000000000009rem);
            }
        </style>
        <!--<link rel="stylesheet" href="css/bootstrap.min.css">-->
        <link rel="stylesheet" href="css/profileDecoration.css">
        <!--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">-->
    </head>
    <body>

        <c:set var="candidate" value="${Candidate}"></c:set>       
         <c:set var="male" value="Male" />
             <c:set var="female" value="Female" />
            <div class="bg-image">
            <section class="container forms">
                <div class="form login">
                    <div class="form-content">
                        <a href="candidatehome.jsp"><img id="closing-logo-profile" src="assets/close-icon.png" alt="alt"/></a>

                        <c:if test="${candidate.getGender()==null}"> 
                            <img id="logo-profile" src="./assets/logo-profile.png" alt="Logo"/>
                        </c:if> 
                        <c:if test="${candidate.getGender()== male}"> 
                            <img id="logo-profile" src="./assets/logo_profile-male.png" alt="Logo"/>
                        </c:if> 
                        <c:if test="${candidate.getGender()== female}"> 
                            <img id="logo-profile" src="./assets/logo-profile.png" alt="Logo"/>
                        </c:if> 

                        <hr>

                        <header class="profile-name">${User.getName()}</header>
                    <form action="UpdateProfile?candidateId=${candidate.getCandidateId()}" method="Post">



                        <div class="field input-field">
                            <input type="text" placeholder="Gender" class="input" name="gender" value="${candidate.getGender()}">

                        </div>

                        <div class="field input-field">
                            <input type="text" placeholder="Phone Number" class="input" name="phoneNumber" value="${candidate.getPhoneNumber()}">
                            <i class='bx bx-hide eye-icon'></i>
                        </div>
                        <div class="field input-field">
                            <input type="text" placeholder="City" class="input" name="city" value="${candidate.getCity()}">
                            <i class='bx bx-hide eye-icon'></i>
                        </div>
                        <div class="field input-field">
                            <input type="text" placeholder="State" class="input" name="state" value="${candidate.getState()}">
                            <i class='bx bx-hide eye-icon'></i>
                        </div>
                        <div class="field input-field">
                            <input type="text" placeholder="Country" class="input" name="country" value="${candidate.getCountry()}">
                            <i class='bx bx-hide eye-icon'></i>
                        </div>
                            <div class="field input-field" style="background: #FFF !important;">
                            <input type="file" placeholder="Resume" class="input" name="resume" value="Upload">
                            <i class='bx bx-hide eye-icon'></i>
                        </div>
                        <div style="display: flex;align-items: center;justify-content: center;"> 
                            <div class="field button-field">

                                <button type="submit">Update</button>

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