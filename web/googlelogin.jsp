<%-- 
    Document   : googlelogin
    Created on : Mar 13, 2023, 10:54:00 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>    
    <head>
        <title>Google Auth</title>         
        <meta name="google-signin-client_id" content="816324468267-473tpouctgevecfiffsl5gch1ljdcfar.apps.googleusercontent.com">
        <script src="https://accounts.google.com/gsi/client" async defer></script>
    </head>
    <body>
        <div id="g_id_onload"
             data-client_id="816324468267-473tpouctgevecfiffsl5gch1ljdcfar.apps.googleusercontent.com"
             data-context="signin"
             data-ux_mode="popup"
             data-callback="handleCredentialResponse"
             data-auto_prompt="false">
        </div>
        <div class="g_id_signin"
             data-type="standard"
             data-shape="pill"
             data-theme="outline"
             data-text="signin_with"
             data-size="large"
             >
        </div>
        <script>
            function handleCredentialResponse(response) {
                const responsePayLoad = decodeJwtResponse(response.credential);
                console.log(responsePayLoad);
                console.log("ID: " + responsePayLoad.sub);
                console.log("Name: " + responsePayLoad.name);
                console.log("Given Name: " + responsePayLoad.given_name);
                console.log("family Name: " + responsePayLoad.family_name);
                console.log("Image URL: " + responsePayLoad.picture);
                console.log("Email: " + responsePayLoad.email);
                $.ajax({
                    type: "POST",
                    url: "GoogleSign",
                    data: responsePayLoad,
                    success: function (responseText) {
                        alert(responseText);
                        $("#" + "social").html(responseText);
                    }
                });
            }
        </script>
        <script>
            function decodeJwtResponse(data) {
                var tokens = data.split(".");
                return JSON.parse(atob(tokens[1]));
            }
        </script>
    </body>
</html>