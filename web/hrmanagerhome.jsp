
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
                                                        POSTED JOBS<hr><h3>${NumberOfPostedJobs}</h3>

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
                                                       Total APPLICATION<hr><h3>${TotalApplication}</h3>

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

                                                                Shortlisted<hr><h3>${TotalShortlisted}</h3>

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
                                                        Jobs To Be Verified <hr><h3>${TotalPending}</h3>
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
    <script>

                               //// SIDEBAR TOGGLE
//
//var sidebarOpen = false;
//var sidebar = document.getElementById("sidebar");
//
//function openSidebar() {
//  if(!sidebarOpen) {
//    sidebar.classList.add("sidebar-responsive");
//    sidebarOpen = true;
//  }
//}
//
//function closeSidebar() {
//  if(sidebarOpen) {
//    sidebar.classList.remove("sidebar-responsive");
//    sidebarOpen = false;
//  }
//}
//
//

// ---------- CHARTS ----------

// BAR CHART
                        var postedJobs = '${NumberOfPostedJobs}';
                        var totalApplication = '${TotalApplication}';
                        var shortlisted = '${TotalShortlisted}';
                        var barChartOptions = {
                            series: [{
                                    data: [postedJobs, totalApplication, shortlisted],

                                    name: "Value",
                                }],
                            chart: {
                                type: "bar",
                                background: "transparent",

                                height: 300,

                                toolbar: {
                                    show: false,
                                },
                            },
                            colors: [
                                "#2962ff",
                                "#d50000",
                                "#2e7d32",
                                "#ff6d00",
                                "#583cb3",
                            ],
                            plotOptions: {
                                bar: {
                                    distributed: true,
                                    borderRadius: 4,
                                    horizontal: false,

                                    columnWidth: "40%"

                                }
                            },
                            dataLabels: {
                                enabled: false,
                            },
                            fill: {
                                opacity: 1,
                            },
                            grid: {
                                borderColor: "#55596e",
                                yaxis: {
                                    lines: {
                                        show: true,
                                    },
                                },
                                xaxis: {
                                    lines: {
                                        show: true,
                                    },
                                },
                            },
                            legend: {
                                labels: {
                                    colors: "#f5f7ff",
                                },
                                show: true,
                                position: "top",
                            },
                            stroke: {
                                colors: ["transparent"],
                                show: true,
                                width: 2
                            },
                            tooltip: {
                                shared: true,
                                intersect: false,
                                theme: "dark",
                            },
                            xaxis: {

                                categories: ["Posted Jobs", "Total Application", "Shortlisted"],

                                title: {
                                    style: {
                                        color: "#f5f7ff",
                                    },
                                },
                                axisBorder: {
                                    show: true,
                                    color: "#55596e",
                                },
                                axisTicks: {
                                    show: true,
                                    color: "#55596e",
                                },
                                labels: {
                                    style: {
                                        colors: "#f5f7ff",
                                    },
                                },
                            },
                            yaxis: {
                                title: {
                                    text: "Count",
                                    style: {
                                        color: "#f5f7ff",
                                    },
                                },
                                axisBorder: {
                                    color: "#55596e",
                                    show: true,
                                },
                                axisTicks: {
                                    color: "#55596e",
                                    show: true,
                                },
                                labels: {
                                    style: {
                                        colors: "#f5f7ff",
                                    },
                                },
                            }
                        };

                        var barChart = new ApexCharts(document.querySelector("#bar-chart"), barChartOptions);
                        barChart.render();


// AREA CHART
                        var areaChartOptions = {
                            series: [{
                                    name: "Total application",

                                    data: [${TotalApplication}, 40, 28, 51, 42, 109, 100],

                                }, {
                                    name: "Approved Application",
                                    data: [11, 32, 45, 32, 34, 52, 41],
                                }],
                            chart: {
                                type: "area",
                                background: "transparent",
                                height: 350,
                                stacked: false,
                                toolbar: {
                                    show: false,
                                },
                            },
                            colors: ["#00ab57", "#d50000"],
                            labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul"],
                            dataLabels: {
                                enabled: false,
                            },
                            fill: {
                                gradient: {
                                    opacityFrom: 0.4,
                                    opacityTo: 0.1,
                                    shadeIntensity: 1,
                                    stops: [0, 100],
                                    type: "vertical",
                                },
                                type: "gradient",
                            },
                            grid: {
                                borderColor: "#55596e",
                                yaxis: {
                                    lines: {
                                        show: true,
                                    },
                                },
                                xaxis: {
                                    lines: {
                                        show: true,
                                    },
                                },
                            },
                            legend: {
                                labels: {
                                    colors: "#f5f7ff",
                                },
                                show: true,
                                position: "top",
                            },
                            markers: {
                                size: 6,
                                strokeColors: "#1b2635",
                                strokeWidth: 3,
                            },
                            stroke: {
                                curve: "smooth",
                            },
                            xaxis: {
                                axisBorder: {
                                    color: "#55596e",
                                    show: true,
                                },
                                axisTicks: {
                                    color: "#55596e",
                                    show: true,
                                },
                                labels: {
                                    offsetY: 5,
                                    style: {
                                        colors: "#f5f7ff",
                                    },
                                },
                            },
                            yaxis:
                                    [
                                        {
                                            title: {
                                                text: "Total Application",
                                                style: {
                                                    color: "#f5f7ff",
                                                },
                                            },
                                            labels: {
                                                style: {
                                                    colors: ["#f5f7ff"],
                                                },
                                            },
                                        },
                                        {
                                            opposite: true,
                                            title: {
                                                text: "Approved Application",
                                                style: {
                                                    color: "#f5f7ff",
                                                },
                                            },
                                            labels: {
                                                style: {
                                                    colors: ["#f5f7ff"],
                                                },
                                            },
                                        },
                                    ],
                            tooltip: {
                                shared: true,
                                intersect: false,
                                theme: "dark",
                            }
                        };

                        var areaChart = new ApexCharts(document.querySelector("#area-chart"), areaChartOptions);
                        areaChart.render();

 

    </script>
</html>
