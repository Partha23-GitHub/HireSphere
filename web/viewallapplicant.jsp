<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" 
href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
<script type="text/javascript" 
src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<style>
    .viewallApplicant a {
        display: inline-block; /* to make the anchor tag behave like a block element */
        background-color: #20c9a6;
        padding: 5px;
        text-decoration: none;
        color: black;
    }
    .thead{
        background-color: #000;
    }
</style>
<div class="container viewallApplicant">
    <h1 class="h3 mb-0 text-gray-800">All Applied Candidates</h1>
    <hr>
    <table class="table" id="myTable">
        <thead class="thead-dark thead">
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
                <td>Shivam Mishra </td>
                <td> 9051284831</td>
                <td>itsshivamm03@gmail.com</td>
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
            <tr>

                <td>Shivam Mishra </td>
                <td> 9051284831</td>
                <td>itsshivamm03@gmail.com</td>
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
        </tbody>
    </table>
</div>
<script>
    $(document).ready(function () {
        $('#myTable').dataTable();
    });
</script>