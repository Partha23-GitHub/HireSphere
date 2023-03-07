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
                    <a href="#" class="field facebook">
                        <i class='bx bxl-facebook facebook-icon'></i>
                        <span>Login with Facebook</span>
                    </a>
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

                            <input type="email"  pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$" placeholder="Email" class="input" name="email" required>
                        </div>
                        <div class="field input-field">
                            <div style="background-color: white !important; height: 50px !important; border-radius: 6px !important;">
                                <label style="display: flex;justify-content: center;" class="input" for="cars">Choose a Role:</label>
                                <div style="transform: translateX(8rem);"> 
                            <select name="cars" id="cars">
                                <option value="volvo">HR</option>
                                <option value="saab">HR Manager</option>
                            </select>
                                    </div>
                            </div>
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

            function onSignIn(googleUser) {
                var profile = googleUser.getBasicProfile();
                alert(profile.getName());
                console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
                console.log('Name: ' + profile.getName());
                console.log('Image URL: ' + profile.getImageUrl());
                console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
            }
        </script>
    </body>
</html>