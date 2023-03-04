<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <meta name="author" content="Themesdesign" />
        <title>Details</title>
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            crossorigin="anonymous"
            />

        <!--Material Icon -->
        <link rel="stylesheet" type="text/css" href="./css/materialdesignicons.min.css"/>
    </head>

    <body>
        <section>
            <jsp:include page="menu.jsp"></jsp:include>
                <div class="top-banner">
                    <div class="container">
                        <div class="small-bold-text banner-text">Find your dream job now</div>
                    </div>
                </div>
            </section>
            <!-- JOB DETAILS START -->
        <c:set var="jobDetails" value="${JobDetails}"></c:set>
            <section class="section">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <h4 class="text-dark mb-3" style="font-size: xx-large"></h4>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-8 col-md-7">
                            <div class="job-detail border rounded p-4">
                                <div class="job-detail-content">
                                    <img
                                        src="data:image/jpg/jpeg/png;base64,${jobDetails.imageData}"
                                    alt=""
                                    class="img-fluid mx-auto d-block" style="width:25rem;height: 5rem;"
                                    />
                                <div class="job-detail-com-desc overflow-hidden d-block">
                                    <h4 class="mb-2">
                                        <a href="#" class="text-dark">${jobDetails.getJobTitle()}</a>
                                    </h4>
                                    <p class="text-muted mb-0">
                                        <i class="mdi mdi-bank mr-2"></i>${jobDetails.companyName}
                                    </p>
                                    <p class="text-muted mb-0">
                                        <i class="mdi mdi-map-marker mr-2"></i>${jobDetails.location}
                                    </p>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <h5 class="text-dark mt-4">Job Description :</h5>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="job-detail border rounded mt-2 p-4">
                                    <div class="job-detail-desc">
                                        <p class="text-muted mb-3">
                                            ${jobDetails.description}
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <h5 class="text-dark mt-4">Responsibilities :</h5>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="job-detail border rounded mt-2 p-4">
                                    <div class="job-detail-desc">
                                        <p class="text-muted mb-0">
                                            ${jobDetails.responsibilities}
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <h5 class="text-dark mt-4">Requirements :</h5>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="job-detail border rounded mt-2 p-4">
                                    <div class="job-detail-desc">
                                        <p class="text-muted mb-0">
                                            ${jobDetails.requirements}
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <h5 class="text-dark mt-4">Education Qualification :</h5>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="job-detail border rounded mt-2 p-4">
                                    <div class="job-detail-desc">
                                        <div class="job-details-desc-item">
                                            <div class="float-left mr-3">
                                                <i class="mdi mdi-send text-primary"></i>
                                            </div>
                                            <p class="text-muted mb-2">
                                                ${jobDetails.educationQualification}
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-5 mt-4 mt-sm-0">
                        <div class="job-detail border rounded p-4">
                            <h5 class="text-muted text-center pb-2"><i></i>Summary</h5>

                            <div class="job-detail-location pt-4 border-top">
                                <div class="job-details-desc-item">
                                    <div class="float-left mr-2">
                                        <i class="mdi mdi-bank text-muted"></i>
                                    </div>
                                    <p class="text-muted mb-2">${jobDetails.companyName}</p>
                                </div>

                                <div class="job-details-desc-item">
                                    <div class="float-left mr-2">
                                        <i class="mdi mdi-email text-muted"></i>
                                    </div>
                                    <p class="text-muted mb-2">${jobDetails.postingDate}</p>
                                </div>

                                <div class="job-details-desc-item">
                                    <div class="float-left mr-2">
                                        <i class="mdi mdi-web text-muted"></i>
                                    </div>
                                    <p class="text-muted mb-2">${jobDetails.companyWebsite}</p>
                                </div>

                                <div class="job-details-desc-item">
                                    <div class="float-left mr-2">
                                        <i class="mdi mdi-currency-usd text-muted"></i>
                                    </div>
                                    <p class="text-muted mb-2">${jobDetails.salary}</p>
                                </div>

                                <div class="job-details-desc-item">
                                    <div class="float-left mr-2">
                                        <i class="mdi mdi-security text-muted"></i>
                                    </div>
                                    <p class="text-muted mb-2">${jobDetails.experience}</p>
                                </div>

                                <div class="job-details-desc-item">
                                    <div class="float-left mr-2">
                                        <i class="mdi mdi-clock-outline text-muted"></i>
                                    </div>
                                    <p class="text-muted mb-2">${jobDetails.postingDate}</p>
                                </div>
                                <p style="color: rgb(222, 74, 74)">
                                    <strong
                                        >Make sure you update your Profile & Resume brefore applying
                                        in any openings.
                                    </strong>
                                </p>
                            </div>
                        </div>

                        <div class="job-detail border rounded mt-4">
                            <a href="ApplyJobByCandidate?candidateId=${Candidate.getCandidateId()}&jobId=${jobDetails.jobId}&hrId=${jobDetails.userId}" class="hover-link primary-button">Apply Now</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- JOB DETAILS END -->
        <hr />
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
