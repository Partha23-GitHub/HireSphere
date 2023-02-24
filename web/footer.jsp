<%-- 
    Document   : footer
    Created on : 23-Feb-2023, 3:40:11 pm
    Author     : manis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Footer Page</title>
        <style>
            footer{
                background-color: #000 !important;
            }
            .footer-container,#hover-link-id{
                color: #fff !important;
            }
            .sub-footer{
                background-color: #fff !important;
                
            }
            #subh{
                color: #000 !important;
            }
        </style>
        <link rel="stylesheet" href="./css/candidate_menu.css">
    </head>
    <body class="footer-body">
        <div class="sticky-footer" id="footer-id">
        <footer>

        <div class="container flex footer-container">
            <a href="#" class="company-logo">
                <img src="./assets/HireSphere.png" alt="company logo">
            </a>
            <div class="link-column flex">
                <h4>Contact</h4>
                <a href="#" class="hover-link" id="hover-link-id"><i class="fa-brands fa-linkedin"></i> Linkedin</a>
                <a href="#" class="hover-link" id="hover-link-id"><i class="fa-brands fa-facebook"></i> Facebook</a>
                <a href="#" class="hover-link" id="hover-link-id"><i class="fa-brands fa-twitter"></i> Twitter</a>
            </div>
            <div class="link-column flex">
                <h4> Offices</h4>
                <a href="#" class="hover-link" id="hover-link-id"><i class="fa-sharp fa-solid fa-location-pin"></i>&nbsp;&nbsp;Kolkata</a>
                <a href="#" class="hover-link" id="hover-link-id"><i class="fa-sharp fa-solid fa-location-pin"></i>&nbsp;&nbsp;California</a>
                <a href="#" class="hover-link" id="hover-link-id"><i class="fa-sharp fa-solid fa-location-pin"></i>&nbsp;&nbsp;Dubai</a>
            </div>
            <div class="link-column flex">
                <h4>Product</h4>
                <a href="#" class="hover-link" id="hover-link-id">Overview</a>
                <a href="#" class="hover-link" id="hover-link-id">Pricing</a>
                <a href="#" class="hover-link" id="hover-link-id">Usability</a>
            </div>
        </div>
    </footer>

    <!-- sub footer  -->
    <div class="sub-footer">
        <div class="container flex subfooter-container">
            <a href="#" class="hover-link" id="subh">Privacy Policy</a>
            <a href="#" class="hover-link" id="subh">Terms & Condition</a>
            <a href="#" class="hover-link" id="subh">Security Information</a>
        </div>
    </div>
    </div>
        <script src="https://kit.fontawesome.com/37cc2e7603.js" crossorigin="anonymous"></script>
    </body>
</html>
