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
                        <h4 style="text-align: center;justify-content: center">Location</h4>
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3684.1041310182063!2d88.42524581493201!3d22.57520838518138!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3a02750014d7f12f%3A0xba88c52b0fa7f529!2sExavalu!5e0!3m2!1sen!2sin!4v1677558152689!5m2!1sen!2sin" width="200" height="120" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
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
