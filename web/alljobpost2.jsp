<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />
        <meta name="description" content="" />
        <meta name="author" content="" />

        <title>{Compamy-Name} | Home</title>
        <!-- Custom fonts for this template-->
        <link href="./css/all.min.css" rel="stylesheet" type="text/css" />
        <!-- Custom styles for this template-->
        <link href="./css/sb-admin-2.min.css" rel="stylesheet" />
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
        #Logo-HrMenu{
            max-width: 200px;
        }
    </style>
</head>

<body id="page-top">
    <!-- Page Wrapper -->
    <div id="wrapper">
        <!-- Sidebar -->
        <ul
            class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
            id="accordionSidebar"
            >
            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="hrmenupage.jsp"">
                <img id="Logo-HrMenu" src="./assets/HireSphere.png" alt="Company Logo" />
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0" />

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="hrmenupage.jsp">
                    <span style="margin-left: 2rem">&#9751;&nbsp;Home</span></a
                >
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider" />

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a
                    class="nav-link collapsed"
                    href="#"
                    data-target="#collapseTwo"
                    aria-expanded="true"
                    aria-controls="collapseTwo"
                    >
                    <span style="margin-left: 0.8rem; font-weight: 700"
                          >&#9854;&nbsp;My Profile</span
                    >
                </a>
            </li>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a
                    class="nav-link collapsed"
                    href="Logout"
                    data-target="#collapseUtilities"
                    aria-expanded="true"
                    aria-controls="collapseUtilities"
                    >
                    <span style="margin-left: 0.8rem; font-weight: 700"
                          >&#9854;&nbsp;Logout</span
                    >
                </a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider" />

            <!-- Heading -->
            <div class="sidebar-heading">Get Your Job Done By</div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" onclick="fetchContent('jobpost', 'hr-home-content', '0')">
                    <span style="margin-left: 0.8rem; font-weight: 700;cursor: pointer";
                          >&#9755; &nbsp; Post Jobs</span
                    >
                </a>
            </li>

            <!-- Nav Item - Charts -->


            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link collapsed" onclick="fetchContent('allpostedjobs', 'hr-home-content',${User.getUserId()})">
                    <span style="margin-left: 0.8rem; font-weight: 700;cursor: pointer"
                          >&#9755;&nbsp;View All Posted Jobs</span
                    >
                </a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block" />
        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
            <!-- Main Content -->
            <div id="content">
                <!-- Topbar -->
                <nav
                    class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow"
                    >
                    <!-- Sidebar Toggle (Topbar) -->
                    <button
                        id="sidebarToggleTop"
                        class="btn btn-link d-md-none rounded-circle mr-3"
                        >
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">
                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a
                                class="nav-link dropdown-toggle"
                                href="#"
                                id="userDropdown"
                                role="button"
                                data-toggle="dropdown"
                                aria-haspopup="true"
                                aria-expanded="false"
                                >
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"
                                      >${User.getName()}</span
                                >
                                <img
                                    class="img-profile rounded-circle"
                                    src="img/undraw_profile.svg"
                                    />
                            </a>
                            <!-- Dropdown - User Information -->
                            <div
                                class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown"
                                >
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">
                                    <i
                                        class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"
                                        ></i>
                                    Logout
                                </a>
                            </div>
                        </li>
                    </ul>
                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div id="hr-home-content">
                    <div class="container">
                        <h1 class="h3 mb-0 text-gray-800">Your Posted Jobs</h1>
                        <hr>
                        <table class="table" id="myTable">
                            <thead class="thead-dark thead">
                                <tr>
                                    <th scope="col">Job Title</th>
                                    <th scope="col">Job Type</th>
                                    <th scope="col">Job Location</th>
                                    <th scope="col">Job Salary</th>
                                    <th scope="col">Closes On</th>
                                    <th scope="col">Edit Job</th>
                                    <th scope="col">View All Application</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="jobs" items="${JobPostedByHr}">
                                    <tr>
                                        <td>${jobs.getJobTitle()}</td>
                                        <td>${jobs.getJobType()}</td>
                                        <td>${jobs.getLocation()}</td>
                                        <td>${jobs.getSalary()}</td>
                                        <td>${jobs.getClosingDate()}</td>
                                        <td><a href="EditJob?jobId=${jobs.getJobId()}" class="btn btn-primary"style="border-radius: 12px;">Edit</a></td>
                                        <td><a href="ViewApplicant?jobId=${jobs.getJobId()}" class="btn btn-primary"style="border-radius: 12px;">View Applicants</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- End of Main Content -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
</body>
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<script type="text/javascript">
    $(document).ready(function () {
                        $('#myTable').dataTable();
                    });
                    
                    function fetchContent(selected, target, valueId) {
                        //alert("HI");
                        $.ajax({
                            url: 'LoadHRMenu',
                            data: {
                                ['work']: (selected),
                                ['value']: (valueId)
                            },
                            success: function (responseText) {
                                $("#" + target).html(responseText);
                            }
                        });
                    }

</script>
</html>
