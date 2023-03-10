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
    <header>Post Your Job</header>

    <form action="postForm" method="post" enctype="multipart/form-data">
        <div class="form first">
            <span class="title">Put All Job Details Below</span>
            <hr>
            <div class="fields">
                <div class="input-field">
                    <label>Company Name</label>
                    <input
                        type="text"
                        placeholder="Enter your company name"
                        name="companyName"
                        required
                        />
                </div>


                <div class="input-field">
                    <label>Company Website</label>
                    <input
                        type="text"
                        placeholder="Enter Company Website"
                        name="companyWebsite"
                        required
                        />
                </div>

                                <div class="input-field">
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
                        name="jobTitle"
                        required
                        />
                </div>

                <div class="input-field">
                    <label>Job Type</label>
                    <input
                        type="text"
                        placeholder="i.e: Fulltime or Intern"
                        name="jobType"
                        required
                        />
                </div>

                <div class="input-field">
                    <label>Job Descriptions</label>
                    <textarea type="text" placeholder="Job Descriptions" name="description" required ></textarea>
                </div>
                <div class="input-field">
                    <label>Education Qualifications</label>
                    <input type="text" placeholder="Enter Education Qualifications" name="educationQualification" required />
                </div>

                <div class="input-field">
                    <label>Roles & responsibilities</label>
                    <textarea type="text" placeholder="Job Responsibilities" name="responsibilities" required ></textarea>
                </div>

                <div class="input-field">
                    <label>Requirments</label>
                    <textarea type="text" placeholder="Job Requirments" name="requirements" required ></textarea>
                </div>

                <div class="input-field">
                    <label>Location</label>
                    <input type="text" placeholder="Job Location" name="location" required />
                </div>

                <div class="input-field">
                    <label>Experience</label>
                    <input
                        type="text"
                        placeholder="Work Experience"
                        name="experience"
                        required
                        />
                </div>

                <div class="input-field">
                    <label>Closed On</label>
                    <input type="date" placeholder="Application Last Date" name="closingDate" required />
                </div>
                <div class="input-field">
                    <label>Salary</label>
                    <input type="text" placeholder="CTC" name="salary" required />
                </div>
                
                <input
                    type="hidden"
                    name="userId" value="${User.getUserId()}"
                    />
                <div class="input-field">
                    <br>
                    <button type="submit" class="nextBtn btnText">Post</button>
                </div>
            </div>

        </div>
    </form>
</div>