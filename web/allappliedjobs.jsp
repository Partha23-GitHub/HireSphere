
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <style>
            a{
                text-decoration: none !important;
            }
            h2 {
                display: flex;
                justify-content: center;
                align-items: center;
            }
        </style>
        <title>All Application list</title>
    </head>
</html>

<head>

</head>
<body>
    <section>
        <div class="top-banner">
            <div class="container">
                <div class="small-bold-text banner-text ">Find your dream job now</div>
            </div>
        </div>
        <jsp:include page="menu.jsp"></jsp:include>
        </section>
        <br>
        <h2 class="thead-dark">Your All Application</h2>
        <hr>
        <div class="container">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <!--<th scope="col">Application Id</th>-->
                        <th scope="col">Company Name</th>
                        <th scope="col">Job Title</th>
                        <th scope="col">Job Type</th>
                        <th scope="col">Resume</th>
                        <th scope="col">Status</th>

                    </tr>
                </thead>

                <tbody>


                <c:forEach var = "jobApplication" items = "${JobApplicationList}">

                    <tr>

<!--<td>${jobApplication.getApplicationId()}</td>-->
                        <td>${jobApplication.getCompanyName()}</td>
                        <td>${jobApplication.getJobTitle()}</td>
                        <td>${jobApplication.getJobType()}</td>

                        <td>
                            <a href="./Resume/${jobApplication.getResumePath()}" target="_blank">
                                View Resume
                            </a>
                        </td>
                        <td>${jobApplication.getApplicationMessage()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <br> <br><br><br><br><br><br><br><br><br><br><br><br> 
    <hr>
    <jsp:include page="footer.jsp"></jsp:include>
</body>

