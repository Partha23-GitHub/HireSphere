<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" 
href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
<script type="text/javascript" 
src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>

<style>
    .thead{
        background-color: #000;
    }
</style>
<div class="container">
    <h1 class="h3 mb-0 text-gray-800">Your Posted Jobs</h1>
    <hr>
    <table class="table" id="myTable">
        <thead class="thead-dark thead">
            <tr>
                <th scope="col">Job Id</th>
                <th scope="col">Job Title</th>
                <th scope="col">Job Location</th>
                <th scope="col">Job Salary</th>
                <th scope="col">Closes On</th>
                <th scope="col">Job Description</th>
                <th scope="col">Edit Job</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th scope="row">1</th>
                <td> SoftWare Developer</td>
                <td> Pune</td>
                <td> $500</td>
                <td> 24.03.2023</td>
                <td><a href="jobdetails.jsp" class="btn btn-primary"style="border-radius: 12px;">View More</a></td>
                <td><a href="jobdetails.jsp" class="btn btn-primary"style="border-radius: 12px;">Edit</a></td>
            <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
                <td>24.03.2023</td>
                <td><a href="jobdetails.jsp" class="btn btn-primary"style="border-radius: 12px;">View More</a></td>
                <td><a href="jobdetails.jsp" class="btn btn-primary"style="border-radius: 12px;">Edit</a></td>
            </tr>
        </tbody>
    </table>
</div>
<script>
    $(document).ready(function () {
        $('#myTable').dataTable();
    });
</script>