<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="./css/post-a-job.css" />
<link
    rel="stylesheet"
    href="https://unicons.iconscout.com/release/v4.0.0/css/line.css"
    />
<style>
    .container{
        margin-left:12rem;
    }
    .form first{
        height: 30rem;
    }
</style>

<div class="container">
    <header>${JobDetails.getJobTitle()}</header>

    <form action="UpdateJob" method="post" enctype="multipart/form-data">
        <div class="form first">
            <span class="title">Job details</span>
            <hr>
            <div class="fields">
                <div class="input-field">
                    <label>Company Name</label>
                    <input
                        type="text"
                        placeholder="Enter your company name"
                        name="companyName" value="${JobDetails.getCompanyName()}"
                        readonly required
                        />
                </div>


                <div class="input-field">
                    <label>Company Website</label>
                    <input
                        type="text"
                        placeholder="Enter Company Website"
                        name="companyWebsite" value="${JobDetails.getCompanyWebsite()}"
                        required
                        />
                </div>

                <!--                <div class="input-field">
                                    <label>Company Logo</label>
                                    <input
                                        type="file"
                                        placeholder="Choose logo"
                                        name="companyLogo"
                                        required
                                        />
                                </div>-->

                <div class="input-field">
                    <label>Job Title</label>
                    <input
                        type="text"
                        placeholder="i.e: Java or Android"
                        name="jobTitle" value="${JobDetails.getJobTitle()}"
                        required
                        />
                </div>

                <div class="input-field">
                    <label>Job Type</label>
                    <input
                        type="text"
                        placeholder="i.e: Fulltime or Intern"
                        name="jobType" value="${JobDetails.getJobType()}"
                        required
                        />
                </div>

                <div class="input-field">
                    <label>Job Descriptions</label>
                    <textarea type="text" placeholder="Job Descriptions" name="description" required >${JobDetails.getDescription()}</textarea>
                </div>
                <div class="input-field">
                    <label>Education Qualifications</label>
                    <input type="text" placeholder="Enter Education Qualifications" name="educationQualification" value="${JobDetails.getEducationQualification()}" required />
                </div>

                <div class="input-field">
                    <label>Roles & responsibilities</label>
                    <textarea type="text" placeholder="Job Responsibilities" name="responsibilities" required >${JobDetails.getResponsibilities()}</textarea>
                </div>

                <div class="input-field">
                    <label>Requirments</label>
                    <textarea type="text" placeholder="Job Requirments" name="requirements" required >${JobDetails.getRequirements()}</textarea>
                </div>

                <div class="input-field">
                    <label>Location</label>
                    <input type="text" placeholder="Job Location" name="location" value="${JobDetails.getLocation()}" required />
                </div>

                <div class="input-field">
                    <label>Experience</label>
                    <input
                        type="text"
                        placeholder="Work Experience"
                        name="experience" value="${JobDetails.getExperience()}"
                        required
                        />
                </div>

                <div class="input-field">
                    <label>Closed On</label>
                    <input type="date" placeholder="Application Last Date" name="closingDate" value="${JobDetails.getClosingDate()}" required />
                </div>
                <div class="input-field">
                    <label>Salary</label>
                    <input type="text" placeholder="CTC" name="salary" value="${JobDetails.getSalary()}" required />
                </div>
                <input
                    type="hidden"
                    name="jobId" value="${JobDetails.getJobId()}"
                    />
                <input
                    type="hidden"
                    name="userId" value="${JobDetails.getUserId()}"
                    />
                <div class="input-field">
                    <br>
                    <button type="submit" class="nextBtn btnText">Update</button>
                </div
            </div>

        </div>
    </form>
</div>

<!--                    
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
Custom fonts for this template
<link href="./css/all.min.css" rel="stylesheet" type="text/css" />
Custom styles for this template
<link href="./css/sb-admin-2.min.css" rel="stylesheet" />
<link rel="stylesheet" href="./css/post-a-job.css" />
<link
rel="stylesheet"
href="https://unicons.iconscout.com/release/v4.0.0/css/line.css"
/>

<style>
.container{
margin-left:12rem;
}
.form first{
height: 30rem;
}
</style>
</head>

<body id="page-top">
Page Wrapper 
<div id="wrapper">
Sidebar 
<ul
class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
id="accordionSidebar"
>
Sidebar - Brand 
<a
class="sidebar-brand d-flex align-items-center justify-content-center"
href="companyindex.html"
>
<img src="" alt="Company Logo" />
</a>

Divider 
<hr class="sidebar-divider my-0" />

Nav Item - Dashboard 
<li class="nav-item active">
<a class="nav-link" href="hrmenupage.jsp">
    <span style="margin-left: 2rem">&#9751;&nbsp;Home</span></a
>
</li>

Divider 
<hr class="sidebar-divider" />

Nav Item - Pages Collapse Menu 
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

Nav Item - Utilities Collapse Menu 
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

Divider 
<hr class="sidebar-divider" />

Heading 
<div class="sidebar-heading">Get Your Job Done By</div>

Nav Item - Pages Collapse Menu 
<li class="nav-item">
<a class="nav-link collapsed" onclick="fetchContent('jobpost','hr-home-content','0')">
    <span style="margin-left: 0.8rem; font-weight: 700;cursor: pointer";
          >&#9755; &nbsp; Post Jobs</span
    >
</a>
</li>

Nav Item - Charts 


Nav Item - Tables 
<li class="nav-item">
<a class="nav-link collapsed" onclick="fetchContent('allpostedjobs', 'hr-home-content',${User.getUserId()})">
    <span style="margin-left: 0.8rem; font-weight: 700;cursor: pointer"
          >&#9755;&nbsp;View All Posted Jobs</span
    >
</a>
</li>

Divider 
<hr class="sidebar-divider d-none d-md-block" />
</ul>
End of Sidebar 

Content Wrapper 
<div id="content-wrapper" class="d-flex flex-column">
Main Content 
<div id="content">
 Topbar 
<nav
    class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow"
    >
     Sidebar Toggle (Topbar) 
    <button
        id="sidebarToggleTop"
        class="btn btn-link d-md-none rounded-circle mr-3"
        >
        <i class="fa fa-bars"></i>
    </button>

     Topbar Navbar 
    <ul class="navbar-nav ml-auto">
        <div class="topbar-divider d-none d-sm-block"></div>

         Nav Item - User Information 
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
             Dropdown - User Information 
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
 End of Topbar 

 Begin Page Content 
<div class="container">
<header>${JobDetails.getJobTitle()}</header>

<form action="UpdateJob" method="post" enctype="multipart/form-data">
<div class="form first">
<span class="title">Job details</span>
<hr>
<div class="fields">
<div class="input-field">
<label>Company Name</label>
<input
    type="text"
    placeholder="Enter your company name"
    name="companyName" value="${JobDetails.getCompanyName()}"
    readonly required
    />
</div>


<div class="input-field">
<label>Company Website</label>
<input
    type="text"
    placeholder="Enter Company Website"
    name="companyWebsite" value="${JobDetails.getCompanyWebsite()}"
    required
    />
</div>

<!--                <div class="input-field">
                    <label>Company Logo</label>
                    <input
                        type="file"
                        placeholder="Choose logo"
                        name="companyLogo"
                        required
                        />
                </div>

<div class="input-field">
    <label>Job Title</label>
    <input
        type="text"
        placeholder="i.e: Java or Android"
        name="jobTitle" value="${JobDetails.getJobTitle()}"
        required
        />
</div>

<div class="input-field">
    <label>Job Type</label>
    <input
        type="text"
        placeholder="i.e: Fulltime or Intern"
        name="jobType" value="${JobDetails.getJobType()}"
        required
        />
</div>

<div class="input-field">
    <label>Job Descriptions</label>
    <textarea type="text" placeholder="Job Descriptions" name="description" required >${JobDetails.getDescription()}</textarea>
</div>
<div class="input-field">
    <label>Education Qualifications</label>
    <input type="text" placeholder="Enter Education Qualifications" name="educationQualification" value="${JobDetails.getEducationQualification()}" required />
</div>

<div class="input-field">
    <label>Roles & responsibilities</label>
    <textarea type="text" placeholder="Job Responsibilities" name="responsibilities" required >${JobDetails.getResponsibilities()}</textarea>
</div>

<div class="input-field">
    <label>Requirments</label>
    <textarea type="text" placeholder="Job Requirments" name="requirements" required >${JobDetails.getRequirements()}</textarea>
</div>

<div class="input-field">
    <label>Location</label>
    <input type="text" placeholder="Job Location" name="location" value="${JobDetails.getLocation()}" required />
</div>

<div class="input-field">
    <label>Experience</label>
    <input
        type="text"
        placeholder="Work Experience"
        name="experience" value="${JobDetails.getExperience()}"
        required
        />
</div>

<div class="input-field">
    <label>Closed On</label>
    <input type="date" placeholder="Application Last Date" name="closingDate" value="${JobDetails.getClosingDate()}" required />
</div>
<div class="input-field">
    <label>Salary</label>
    <input type="text" placeholder="CTC" name="salary" value="${JobDetails.getSalary()}" required />
</div>
<input
    type="hidden"
    name="jobId" value="${JobDetails.getJobId()}"
    />
<input
    type="hidden"
    name="userId" value="${JobDetails.getUserId()}"
    />
<div class="input-field">
    <br>
    <button type="submit" class="nextBtn btnText">Update</button>
</div
</div>

</div>
</form>
</div>                     /.container-fluid 
</div>
End of Main Content 

</div>
End of Content Wrapper 

</div>
</body>
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<script type="text/javascript">
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
-->
