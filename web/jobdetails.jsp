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
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/jobdetail.css">
    </head>

    <body>

        <section>
            <jsp:include page="menu.jsp"></jsp:include>
            </section>
            <main>
                <div class="top-banner">
                    <div class="container">
                        <div class="small-bold-text banner-text">Find your dream job now</div>
                    </div>
                </div>
            <c:set var="jobDetails" value="${JobDetails}"></c:set>
                <div class="job-post-company pt-120 pb-120">
                    <div class="container">
                        <div class="row justify-content-between">
                            <!-- Left Content -->
                            <div class="col-xl-7 col-lg-8">
                                <!-- job single -->
                                <div class="single-job-items mb-50">
                                    <div class="job-items">
                                        <div class="col-md-3">
                                            <div class="mo-mb-2">
                                                <img
                                                    src="./assets/Exavalu Logo.png"
                                                    alt=""
                                                    class="img-fluid mx-auto d-block"
                                                    />
                                            </div>
                                        </div>
                                        <div class="job-tittle">
                                            <a href="#">
                                                <h4>${jobDetails.getJobTitle()}</h4>
                                        </a>
                                        <ul>
                                            <li>${jobDetails.companyName}</li>
                                            <li><i class="fas fa-map-marker-alt"></i>${jobDetails.location}</li>
                                            <li>${jobDetails.salary}</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <!-- job single End -->

                            <div class="job-post-details">
                                <div class="post-details1 mb-50">
                                    <!-- Small Section Tittle -->
                                    <div class="small-section-tittle">
                                        <h4>Job Description</h4>
                                    </div>
                                    <p>${jobDetails.description}</p>
                                </div>
                                <div class="post-details2  mb-50">
                                    <!-- Small Section Tittle -->
                                    <div class="small-section-tittle">
                                        <h4>Required Knowledge, Skills, and Abilities</h4>
                                    </div>
                                    <ul>
                                        <li>${jobDetails.requirements}</li>
                                        <li>${jobDetails.responsibilities}</li>

                                    </ul>
                                </div>
                                <div class="post-details2  mb-50">
                                    <!-- Small Section Tittle -->
                                    <div class="small-section-tittle">
                                        <h4>Education + Experience</h4>
                                    </div>
                                    <ul>
                                        <li>${jobDetails.educationQualification}</li>
                                        <li>${jobDetails.experience}</li>

                                    </ul>
                                </div>
                            </div>

                        </div>
                        <!-- Right Content -->
                        <div class="col-xl-4 col-lg-4">
                            <div class="post-details3  mb-50">
                                <!-- Small Section Tittle -->
                                <div class="small-section-tittle">
                                    <h4>Job Overview</h4>
                                </div>
                                <ul>
                                    <li>Posted on : <span>${jobDetails.postingDate}</span></li>
                                    <li>Location : <span>${jobDetails.location}</span></li>

                                    <li>Job nature : <span>${jobDetails.jobType}</span></li>
                                    <li>Salary :  <span>${jobDetails.salary}</span></li>
                                    <li>Closes on : <span>${jobDetails.closingDate}</span></li>
                                </ul>
                                <div class="apply-btn2">
                                    <a href="allappliedjobs.jsp" class="hover-link primary-button">Apply Now</a>
                                </div>
                            </div>
                            <div class="post-details4  mb-50">
                                <!-- Small Section Tittle -->
                                <div class="small-section-tittle">
                                    <h4>Company Information</h4>
                                </div>
                                <ul>
                                    <li>Name: <span>${jobDetails.companyName}</span></li>
                                    <li>Web : <span>${jobDetails.companyWebsite}</span></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- job post company End -->

        </main>
        <hr>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>