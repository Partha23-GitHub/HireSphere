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
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/jobdetail.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>

        <c:set var="candidate" value="${Candidate}"></c:set>       


            <section class="container forms">
                <div class="form login">
                    <div class="form-content">
                        <header>Profile</header>
                        <hr>
                        
                        <header>${User.getName()}</header>
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

                        <div class="field button-field">

                            <button type="submit">Update</button>

                        </div>

                        <div class="field button-field">

                            <a href="candidatehome.jsp">

                                <button class="btn-danger">Back</button>
                            </a>
                        </div>
                    </form>

                </div>



            </div>

        </section>

        <!-- JavaScript -->
        <script src="js/loginscript.js"></script>
    </body>
</html>