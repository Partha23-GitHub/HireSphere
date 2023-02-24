
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
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Phone Number</th>
                    <th scope="col">Email Address</th>
                    <th scope="col">Resume</th>
                    <th scope="col">Action</th>

                </tr>
            </thead>

            <tbody>
                <tr>
                    <td>${candidate.getName()}Shivam Mishra </td>
                <td>${candidate.getPhoneNUmber()} 9051284831</td>
                <td>${candidate.getEmail()}itsshivamm03@gmail.com</td>
                <td> 
                    <a href="" class="hover-link secondary-button">
                        View Resume
                    </a>
                </td>
                <td> 
                    <a href="" class="hover-link secondary-button">
                        Status
                    </a>
                </td>
            </tr>
            <tr>

                <td>${candidate.getName()}Shivam Mishra </td>
                <td>${candidate.getPhoneNUmber()} 9051284831</td>
                <td>${candidate.getEmail()}itsshivamm03@gmail.com</td>
                <td> 
                    <a href="">
                        View Resume
                    </a>
                </td>
                <td> 
                    <a href="">
                        Status
                    </a>
                </td>
            </tr>
            <c:forEach var = "candidate" items = "${CandidateList}">
                <tr>
                    <th scope="row">1</th>
                    <td>${candidate.getName()}</td>
                    <td>${candidate.getPhoneNUmber()}</td>
                    <td>${candidate.getEmail()}</td>
                    <td> 
                        <a href="" class="hover-link secondary-button">
                            View Resume
                        </a>
                    </td>
                    <td> 
                        <a href="" class="hover-link secondary-button">
                            Status
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
              <br> <br><br><br><br><br><br><br><br><br><br><br><br>  
    <jsp:include page="footer.jsp"></jsp:include>
</body>

