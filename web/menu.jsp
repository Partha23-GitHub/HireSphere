
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
                    <a href="#" class="company-logo">
                        <img src="assets/HireSphere.png" alt="Company Logo">
                    </a>
                    <div class="nav-links">
                        <ul class="flex">
                            <li><a href="candidatehome.jsp" class="hover-link">Home</a></li>
                            <li><a href="joblist.jsp" class="hover-link">Job Search</a></li>
                            <li><a href="allappliedjobs.jsp" class="hover-link">View Applications</a></li>
                            <li><a href="#footer-id" class="hover-link">Contact</a></li>
                            <li><a href="#" class="hover-link">Profile</a></li>
                            <li><a href="Logout" class="hover-link secondary-button">Logout</a></li>
                        </ul>
                    </div>
                </div>
            </nav> 
        
        <!--    <script type="text/javascript">
                window.addEventListener("scroll",function(){
                    var header = document.querySelector("header");
                    header.classList.toggle("stick",window.scrollY > 0);
                });
            </script>-->
<!--        <script type="text/javascript">
            window.onscroll = function () {
                myFunction()
            };

        // Get the navbar
            var navbar = document.getElementById("navbar");

        // Get the offset position of the navbar
            var sticky = navbar.offsetTop;

        // Add the sticky class to the navbar when you reach its scroll position. Remove "sticky" when you leave the scroll position
            function myFunction() {
                if (window.pageYOffset >= sticky) {
                    navbar.classList.add("sticky");
                } else {
                    navbar.classList.remove("sticky");
                }
            }
        </script>-->
    </body>
</html>