<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Page</title>
        <link rel="stylesheet" href="./css/candidate_menu.css">
<!--        <style>
            .sticky {
                position: fixed;
                top: 0;
                width: 100%;
            }

            /* Add some top padding to the page content to prevent sudden quick movement (as the navigation bar gets a new position at the top of the page (position:fixed and top:0) */
            .sticky + .content {
                padding-top: 60px;
            }
        </style>-->
    </head>


    <body>
        
            <nav>
                <div class="container main-nav flex">
                    <a href="candidatehome.jsp" class="company-logo">
                        <img src="assets/HireSphere.png" alt="Company Logo">
                    </a>
                    <div class="nav-links">
                        <ul class="flex">
                            <li><a href="candidatehome.jsp" class="hover-link">Home</a></li>
                            <li><a href="JobSearch" class="hover-link">Job Search</a></li>
                            <c:set value="${Candidate}" var="candidate"/>
                            <li><a href="ViewApplication?candidateId=${candidate.getCandidateId()}" class="hover-link">View Applications</a></li>
                            <li><a href="#footer-id" class="hover-link">Contact</a></li>
                            <li><a href="VisitCandidateProfile?userId=${User.getUserId()}" class="hover-link">Profile: ${User.getName()}</a></li>
                            <li><a href="Logout" class="hover-link secondary-button">Logout</a></li>
                             
                        </ul>
                    </div>
                </div>
            </nav> 
            <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script>
               function visitCandidateProfile() {
          console.log("visit candidate profle is working");
          $.ajax({
              url: 'VisitCandidateProfile',

              success: function (responseText) {
// alert(responseText);
                  $("candidateProfile.jsp").html(responseText);

              }
          }
          );

         </script>
    </body>
</html>