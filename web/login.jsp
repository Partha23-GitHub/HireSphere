<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login and Signup Form </title>
        <style>
            body {

                background-image: url("./assets/profile-background.png");

            }
            #closing-logo{
                transform: translate(22.5rem,0.5rem);

            }
            #closing-logo-login{
                transform: translate(22.5rem,-1.1rem);

            }
            #signup-style{
                padding-top: 1px;
            }
            .g-signin2{
                margin-top: 16px;
                width: 50em;
            }
        </style>
        <!-- CSS -->
        <link rel="stylesheet" href="css/loginstyle.css">
        <!-- Boxicons CSS -->
        <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
        <meta name="google-signin-client_id" content="816324468267-473tpouctgevecfiffsl5gch1ljdcfar.apps.googleusercontent.com">
        <script src="https://apis.google.com/js/platform.js" async defer></script>
    </head>
    <body>
        <section class="container forms">
            <div class="form login">
                <div class="form-content">
                    <a href="landingpage.jsp"><img id="closing-logo-login" src="assets/close-icon.png" alt="alt"/></a>
                    <header>HireSphere</header>
                    <form action="Login" method="post">

                        <div class="field input-field">
                            <input type="email" placeholder="Email" class="input" name="email" required>
                        </div>

                        <div class="field input-field">
                            <input type="password" placeholder="Password" class="password" name="password" required>
                            <i class='bx bx-hide eye-icon'></i>
                        </div>

                        <div class="form-link">
                            <a href="#" class="forgot-pass">Forgot password?</a>
                        </div>

                        <div class="field button-field">
                            <button type="submit">Login</button>
                        </div>
                    </form>

                    <div class="form-link">
                        <span>Don't have an account? <a href="#" class="link signup-link">Signup</a></span>
                    </div>
                </div>

                <div class="line"></div>

                <div class="media-options">
                    <script>
                        // This is called with the results from from FB.getLoginStatus().
                        function statusChangeCallback(response) {
                            console.log('statusChangeCallback');
                            console.log(response);
                            console.log(response.authResponse.accessToken);
                            //alert(response.authResponse.accessToken);
                            if (response.status === 'connected') {
                                window.location.href = 'Sign_in_Controller.jsp?access_token=' + response.authResponse.accessToken;
                            } else {
                                // The person is not logged into your app or we are unable to tell.
                                document.getElementById('status').innerHTML = 'Please log ' +
                                        'into this app.';
                            }
                        }
                        // This function is called when someone finishes with the Login
                        // Button. See the onlogin handler attached to it in the sample
                        // code below.
                        function checkLoginState() {
                            FB.getLoginStatus(function (response) {
                                statusChangeCallback(response);
                            });
                        }
                        window.fbAsyncInit = function () {
                            FB.init({
                                appId: '900612777925075',
                                cookie: true, // enable cookies to allow the server to access 
                                // the session
                                xfbml: true, // parse social plugins on this page
                                version: 'v2.8' // use graph api version 2.8
                            });
                            FB.getLoginStatus(function (response) {
                                statusChangeCallback(response);
                            });
                        };
                        // Load the SDK asynchronously
                        (function (d, s, id) {
                            var js, fjs = d.getElementsByTagName(s)[0];
                            if (d.getElementById(id))
                                return;
                            js = d.createElement(s);
                            js.id = id;
                            js.src = "https://connect.facebook.net/en_US/sdk.js";
                            fjs.parentNode.insertBefore(js, fjs);
                        }(document, 'script', 'facebook-jssdk'));
                        // Here we run a very simple test of the Graph API after login is
                        // successful. See statusChangeCallback() for when this call is made.
                    </script>
                    <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
                    </fb:login-button>
                    <div id="status">
                    </div>
                </div>

                <div  class=" media-options" data-onsuccess="onSignIn">
                    <a href="#" class="field facebook">
                        <img src="assets/google.png" alt="" class="google-img">
                        <span>Login with Google</span>
                    </a>
                </div>

            </div>

            <!-- Signup Form -->

            <div class="form signup" id="signup-style">
                <div class="form-content">
                    <a href="landingpage.jsp"><img id="closing-logo" src="assets/close-icon.png" alt="alt"/></a>
                    <header>HireSphere</header>
                    <form action="Signup" method="post">
                        <div class="field input-field">
                            <input type="text" placeholder="Name" class="input" name="name" required>
                        </div>
                        <div class="field input-field">

                            <input type="email" onchange="checkEmail('useremail')" pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$" placeholder="Email" class="input" name="email" id="useremail" required>
                        </div>
                         
                        
                        <div class="field input-field">
                            <input type="password" placeholder="Create password" class="password" name="password" id="password1" required>
                        </div>

                        <div class="field input-field">
                            <input type="password" placeholder="Confirm password" class="password" name="confirmpassword" id="password2" required>
                            <i class='bx bx-hide eye-icon'></i>
                        </div>
                        <p id="password-error" style="text-align: center; color: red;"></p>

                        <div class="field button-field">
                            <button type="submit" onclick="passwordMatch()">Signup</button>
                        </div>
                    </form>

                    <div class="form-link">
                        <span>Already have an account? <a href="#" class="link login-link">Login</a></span>
                    </div>
                </div>

                <div class="line"></div>

                <div class="media-options">
                    <a href="#" class="field facebook">
                        <i class='bx bxl-facebook facebook-icon'></i>
                        <span>Login with Facebook</span>
                    </a>
                </div>

                <div class="media-options" >
                    <!--<div class="g-signin2" data-onsuccess="onSignIn"></div>-->
                    <a href="#" class="field facebook">
                        <img src="assets/google.png" alt="" class="google-img">
                        <span>Login with Google</span>
                    </a>
                </div>


            </div>
        </section>

        <!--for google-->


        <script src="js/loginscript.js"></script>
        <script>
                                function onSignIn(googleUser) {
//                                    var profile = googleUser.getBasicProfile();
//                                    alert(profile.getName());
//                                    console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
//                                    console.log('Name: ' + profile.getName());
//                                    console.log('Image URL: ' + profile.getImageUrl());
//                                    console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
                                    const responsePayLoad = decodeJwtResponse(response.credential);
                                    console.log(responsePayLoad);
                                    console.log(responsePayLoad.email);

                                }

        </script>

        <script >
            const passwordInput = document.getElementById('password1');
            const confirmPasswordInput = document.getElementById('password2');
            const passwordError = document.getElementById('password-error');

            confirmPasswordInput.addEventListener('input', () => {
                if (confirmPasswordInput.value !== passwordInput.value) {
                    passwordError.innerText = "Passwords do not match";
                } else {
                    passwordError.innerText = "";
                }
            });

        </script>
        <script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
    <script>
                        function checkEmail(selectedId) {
                            //alert(selectedId);
                            $.ajax({
                                url: 'CheckEmail',
                                data: {
                                    [email]: $("#" + selectedId).val()
                                }
                            });
                        }
    </script>
    </body>
</html>