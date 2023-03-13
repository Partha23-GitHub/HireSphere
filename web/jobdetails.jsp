<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html class="no-js" lang="zxx">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Job Details</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="manifest" href="site.webmanifest">
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

        <!-- CSS here -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/jobdetail.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
                                            <div class="mo-mb-2" style="margin-right: 15px;">
                                                <img
                                                    src="data:image/jpg/jpeg/png;base64,${jobDetails.imageData}"
                                                alt=""
                                                class="img-fluid mx-auto d-block" style="width:25rem;height: 5rem;"
                                                />
                                        </div>
                                    </div>
                                    <div class="job-tittle">
                                        <a>
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
                                        <h4>Education & Experience</h4>
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

                                    <button type="button" class=" btn-primary" style="width: 120px; border-radius: 6px;height: 40px; box-shadow:0;" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                        Apply Job
                                    </button>
                                </div>
                            </div>
                            <div class="post-details4  mb-50">
                                <!-- Small Section Tittle -->
                                <div class="small-section-tittle">
                                    <h4>Company Information</h4>
                                </div>
                                <ul>
                                    <li>Name: <span>${jobDetails.companyName}</span></li>
                                    <li>Website : <span>${jobDetails.companyWebsite}</span></li>
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
        <!--this is code for modal popup for job apply-->
            <div class="modal fade " id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">

                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            Are you sure, want to apply for this job ?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn-secondary" data-bs-dismiss="modal" style="width: 100px; border-radius: 6px;height: 40px; box-shadow:0;">Close</button>
                            <a href="ApplyJobByCandidate?candidateId=${Candidate.getCandidateId()}&jobId=${jobDetails.jobId}&hrId=${jobDetails.userId} & email=${User.email}">
                                 <button type="button" class="btn-primary" style="width: 100px; border-radius: 6px;height: 40px; box-shadow:0;">
                                     Yes
                                 </button>
                            </a>
                    </div>
                </div>
            </div>
        </div>
        <!--modal end here-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
</html>