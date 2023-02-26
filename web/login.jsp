<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login and Signup Form </title>

        <!-- CSS -->
        <link rel="stylesheet" href="css/loginstyle.css">

        <!-- Boxicons CSS -->
        <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id" content="586449488055-gnq921ei1bd0d7c0u1v5t6bit5ur0m4t.apps.googleusercontent.com">
    </head>
    <body>
        <section class="container forms">
            <div class="form login">
                <div class="form-content">
                    <header>Login</header>
                    <form action="Login" method="post">

                        <div class="field input-field">
                            <input type="email" placeholder="Email" class="input" name="email">
                        </div>

                        <div class="field input-field">
                            <input type="password" placeholder="Password" class="password" name="password">
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

                <div  class="g-signin2 media-options" data-onsuccess="onSignIn">
                    <a href="#" class="field google">
                        <img src="assets/google.png" alt="" class="google-img">
                        <span>Login with Google</span>
                    </a>
                </div>

            </div>

            <!-- Signup Form -->

            <div class="form signup">
                <div class="form-content">
                    <header>Signup</header>
                    <form action="Signup" method="post">
                        <div class="field input-field">
                            <input type="text" placeholder="Name" class="input" name="name">
                        </div>
                        <div class="field input-field">

                            <input type="email" placeholder="Email" class="input" name="email">
                        </div>

                        <div class="field input-field">
                            <input type="password" placeholder="Create password" class="password" name="password">
                        </div>

                        <div class="field input-field">
                            <input type="password" placeholder="Confirm password" class="password" name="confirmpassword">
                            <i class='bx bx-hide eye-icon'></i>
                        </div>

                        <div class="field button-field">
                            <button type="submit">Signup</button>
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
                     <div class="g-signin2" data-onsuccess="onSignIn"></div>
                    <a href="#" class="field google">
                        <img src="assets/google.png" alt="" class="google-img">
                        <span>Login with Google</span>
                    </a>
                </div>
               

            </div>
        </section>

        <!-- JavaScript -->
        <script src="js/loginscript.js"></script>
        <script>
            function onSignIn(googleUser) {
                var profile = googleUser.getBasicProfile();
                alert(  profile.getName());
                console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
                console.log('Name: ' + profile.getName());
                console.log('Image URL: ' + profile.getImageUrl());
                console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
            }
        </script>
    </body>
</html>