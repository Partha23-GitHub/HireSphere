
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>HireSphere | Home</title>
        <link rel="stylesheet" href="./css/candidate_menu.css">
        <link rel="stylesheet" href="./css/jobdiv.css">
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
            <header>
                <div class="container header-section flex">
                    <div class="header-left">
                        <h1>Top companies hiring now</h1>
                        <p>"Your talent determines what you can do. Your motivation determines how much you are willing to do. Your attitude determines how well you do it." - Lou Holtz</p>
                        <a href="JobSearch" class="primary-button get-started-btn">Get Started</a>
                    </div>
                    <div class="header-right">
                        <img src="assets/candidatehomepic.png" alt="hero image">
                    </div>
                </div>
            </header>
            <section class="conpanies-section">
                <div class="container">
                    <div class="small-bold-text companies-header">The world's best companies rely on Hire Sphere to Hire Candidates</div>
                    <div class="logos flex">
                        <img src="assets/amazon-2.svg" class="logo" alt="">
                        <img src="assets/asus-rog-1.svg" class="logo" alt="">
                        <img src="assets/Flipkart-logo.png" class="logo" alt="">
                        <img src="assets/google-logo.jpg" class="logo" alt="">
                        <img src="assets/Exavalu Logo.png" class="logo" alt="">
                    </div>
                </div>
            </section>
            <br>
            <br>
            <div class="container"> 
                <h1 class="flex" style="justify-content: center; align-items: center;">Recent Job to Apply</h1>
                <section>
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
                                                                    <a href="#" class="text-dark">Frontend Developer</a>
                                                                </h5>
                                                                <p class="text-muted mb-0">Exavalu</p>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <div>
                                                                <p class="text-muted mb-0">
                                                                    
                                                                    Kolkata
                                                                    
                                                                </p>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div>
                                                                <p class="text-muted mb-0 mo-mb-2">
                                                                    <span class="text-primary"> &#8377; &nbsp;</span
                                                                    >Not Disclosed
                                                                </p>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div>
                                                                <p class="text-muted mb-0">&nbsp;&nbsp;&nbsp;&nbsp;Internship</p>
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
                                                                    >1 Year
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
                                                                    href="jobdetails.jsp"
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
                                                                    <a href="#" class="text-dark">Frontend Developer</a>
                                                                </h5>
                                                                <p class="text-muted mb-0">Exavalu</p>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <div>
                                                                <p class="text-muted mb-0">
                                                                    
                                                                    Kolkata
                                                                    
                                                                </p>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div>
                                                                <p class="text-muted mb-0 mo-mb-2">
                                                                    <span class="text-primary"> &#8377; &nbsp;</span
                                                                    >Not Disclosed
                                                                </p>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div>
                                                                <p class="text-muted mb-0">&nbsp;&nbsp;&nbsp;&nbsp;Internship</p>
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
                                                                    >1 Year
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
                                                                    href="jobdetails.jsp"
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
                                                                    <a href="#" class="text-dark">Frontend Developer</a>
                                                                </h5>
                                                                <p class="text-muted mb-0">Exavalu</p>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <div>
                                                                <p class="text-muted mb-0">
                                                                    
                                                                    Kolkata
                                                                    
                                                                </p>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div>
                                                                <p class="text-muted mb-0 mo-mb-2">
                                                                    <span class="text-primary"> &#8377; &nbsp;</span
                                                                    >Not Disclosed
                                                                </p>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div>
                                                                <p class="text-muted mb-0">&nbsp;&nbsp;&nbsp;&nbsp;Internship</p>
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
                                                                    >1 Year
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
                                                                    href="jobdetails.jsp"
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
                </section>
            </div>
            <hr>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
