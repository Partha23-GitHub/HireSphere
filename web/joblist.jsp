<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html class="no-js" lang="zxx">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Job board HTML-5 Template </title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="manifest" href="site.webmanifest">
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

        <!-- CSS here -->
        <link rel="stylesheet" href="./css/candidate_menu.css">
        <link rel="stylesheet" href="./css/jobdiv.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <link rel="stylesheet" href="css/jobdetail.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/octicons/8.5.0/octicons.min.css">
    </head>

    <body>

        <section>
            <jsp:include page="menu.jsp"></jsp:include>
            </section>
            <div class="top-banner">
                <div class="container">
                    <div class="small-bold-text banner-text">Find your dream job now</div>
                </div>
            </div>
            <hr>
            <main>
                <div class="container" style="display: flex;justify-content: center;align-items: center;">
                    <form class="d-flex"action="JobSearchByKeyword" method="Post">
                        <input class="form-control me-2 " style="width: 400px; text-align: center; border-radius: 10px;height: 3rem;" type="search" placeholder="jobTitle" aria-label="Search" type="text" id="floatingInput"  name="keyword">
                        &nbsp;&nbsp;&nbsp;
                        <a href="JobSearchByTitle">
                            <button class="hover-link primary-button" style="border: none; width: 200px; border-radius: 10px; " type="submit">Search</button>
                        </a> 
                    </form>
                </div>

                <div class="flex">
                    <div class="container">
                        <div class="row">
                            <!-- Left content -->
                            <!-- Right content -->
                            <div class="container">
                                <section>

                                <c:forEach items="${JobDetailsList}" var="jobDetails">
                                    <div class="row rounded">
                                        <div class="col-12">
                                            <div class="tab-content mt-2" id="pills-tabContent">
                                                <div
                                                    class="tab-pane fade show active"
                                                    id="recent-job"
                                                    role="tabpanel"
                                                    aria-labelledby="recent-job-tab"
                                                    >
                                                    <div class="row">
                                                        <div class="col-lg-12">
                                                            <div
                                                                class="job-box bg-white overflow-hidden border rounded mt-4 position-relative overflow-hidden"
                                                                >
                                                                <div class="lable text-center pt-2 pb-2">
                                                                    <ul
                                                                        class="list-unstyled best text-white mb-0 text-uppercase"
                                                                        >
                                                                        <li class="list-inline-item">
                                                                            <i class="mdi mdi-star"></i>
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                                <div class="p-4">
                                                                    <div class="row align-items-center">
                                                                        <div class="col-md-2">
                                                                            <div class="mo-mb-2">
                                                                                <img
                                                                                    src="./assets/Exavalu Logo.png"
                                                                                    alt=""
                                                                                    class="img-fluid mx-auto d-block"
                                                                                    />
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <div>
                                                                                <h5 class="f-18">
                                                                                    <a href="#" class="text-dark">${jobDetails.getJobTitle()}</a>
                                                                                </h5>
                                                                                <p class="text-muted mb-0">${jobDetails.companyName}</p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <div>
                                                                                <p class="text-muted mb-0">${jobDetails.getLocation()}</p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-2">
                                                                            <div>
                                                                                <p class="text-muted mb-0 mo-mb-2">
                                                                                    <span class="text-primary"> &#8377; &nbsp;</span
                                                                                    >${jobDetails.salary}
                                                                                </p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-2">
                                                                            <div>
                                                                                <p class="text-muted mb-0">&nbsp;&nbsp;&nbsp;&nbsp;${jobDetails.jobType}</p>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="p-3 bg-light">
                                                                    <div class="row">
                                                                        <div class="col-md-4">
                                                                            <div>
                                                                                <p class="text-muted mb-0 mo-mb-2">
                                                                                    <span class="text-dark">Experience :</span
                                                                                    >${jobDetails.experience} Year
                                                                                </p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <div>
                                                                                <p class="text-muted mb-0 mo-mb-2">
                                                                                    <span class="text-dark">Notes :</span> Candidate
                                                                                    should familier with English
                                                                                </p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-2">
                                                                            <div>
                                                                                <a
                                                                                    href="ViewJobDetails?jobId=${jobDetails.jobId}" 
                                                                                        class="primary-button"
                                                                                        >View Details
                                                                                        <i class="mdi mdi-chevron-double-right"></i
                                                                                        ></a>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                </c:forEach>
                            </section>
                        </div>
                    </div>
                </div>
            </div>



        </main>
        <hr>
        <jsp:include page="footer.jsp"></jsp:include>       
    </body>
</html>