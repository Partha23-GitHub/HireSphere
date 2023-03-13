
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

        <title>HireSphere | Home</title>
        <!-- Custom fonts for this template-->
        <link href="./css/all.min.css" rel="stylesheet" type="text/css" />
        <!-- Custom styles for this template-->
        <link href="./css/sb-admin-2.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/styles.css">

        <style>
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
                    <a class="nav-link" href="hrmanagerhome.jsp">
                        <span style="margin-left: 2rem">&#9751;&nbsp;Home</span></a
                    >
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider" />

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a
                        class="nav-link collapsed"
                        href="VisitHRManagerProfile?userId=${User.getUserId()}"
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
                <!--                <li class="nav-item">
                                    <a class="nav-link collapsed" onclick="fetchContent('jobpost', 'hr-home-content', '0')">
                                        <span style="margin-left: 0.8rem; font-weight: 700;cursor: pointer";
                                              >&#9755; &nbsp; Post Jobs</span
                                        >
                                    </a>
                                </li>-->

                <!-- Nav Item - Charts -->


                <!-- Nav Item - Tables -->
                <li class="nav-item">
                    <a class="nav-link collapsed" onclick="fetchContent('allpostedjobs', 'hr-Manager-home-content',${User.getUserId()})">
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
                                    href="VisitHRManagerProfile?userId=${User.getUserId()}"
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
                                    <a class="dropdown-item" href="VisitHRManagerProfile?userId=${User.getUserId()}">
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
                    <div id="hr-Manager-home-content">
                        <div class="container-fluid">


                            <!-- Content Row -->
                            <div class="row">
                                <!-- Earnings (Monthly) Card Example -->
                                <div class="col-xl-3 col-md-6 mb-4">
                                    <div class="card border-left-primary shadow h-100 py-2">
                                        <div class="card-body">
                                            <div class="row no-gutters align-items-center">
                                                <div class="col mr-2">
                                                    <div class="h5 mb-0 font-weight-bold text-gray-800">
                                                        POSTED JOBS<hr><h3>15</h3>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!-- Earnings (Monthly) Card Example -->
                                <div class="col-xl-3 col-md-6 mb-4">
                                    <div class="card border-left-success shadow h-100 py-2">
                                        <div class="card-body">
                                            <div class="row no-gutters align-items-center">
                                                <div class="col mr-2">
                                                    <div class="h5 mb-0 font-weight-bold text-gray-800">
                                                        APPLICATION<hr><h3>9</h3>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-xl-3 col-md-6 mb-4">
                                    <div class="card border-left-info shadow h-100 py-2">
                                        <div class="card-body">
                                            <div class="row no-gutters align-items-center">
                                                <div class="col mr-2">
                                                    <div class="row no-gutters align-items-center">
                                                        <div class="col-auto">
                                                            <div
                                                                class="h5 mb-0 mr-3 font-weight-bold text-gray-800"
                                                                >
                                                                HIRED<hr><h3>5</h3>

                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!-- Pending Requests Card Example -->
                                <div class="col-xl-3 col-md-6 mb-4">
                                    <div class="card border-left-warning shadow h-100 py-2">
                                        <div class="card-body">
                                            <div class="row no-gutters align-items-center">
                                                <div class="col mr-2">
                                                    <div class="h5 mb-0 font-weight-bold text-gray-800">
                                                        PENDING <hr><h3>4</h3>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Content Row -->
                            <div id="pagecontent">
                                <div id="content-wrapper" class="d-flex flex-column">
                                    <div class="grid-container">

                                        <main class="main-container">




                                            <div class="charts">

                                                <div class="charts-card">
                                                    <h2 class="chart-title">JOB APPLICATION STATISTICS</h2>
                                                    <div id="bar-chart"></div>
                                                </div>

                                                <div class="charts-card">
                                                    <h2 class="chart-title"></h2>
                                                    <div id="area-chart"></div>
                                                </div>

                                            </div>
                                        </main>
                                        <!-- End Main -->

                                    </div>
                                </div>

                            </div>
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
                        function fetchContent(selected, target, valueId) {
                            //alert("HI");
                            $.ajax({
                                url: 'LoadHRManagerMenu',
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/apexcharts/3.35.5/apexcharts.min.js"></script>
    <!-- Custom JS -->
    <script src="js/scripts.js"></script>
</html>
