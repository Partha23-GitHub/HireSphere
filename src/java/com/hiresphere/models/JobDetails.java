/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.models;

import com.hiresphere.services.HrService;
import com.hiresphere.services.JobDetailsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author user
 */
public class JobDetails extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    private int jobId, userId;
    private String companyName, companyWebsite, jobTitle, jobType, description;
    private String educationQualification, requirements, responsibilities, location;
    private String experience, closingDate, salary, postingDate;
    private int hrManagerVerificationStatus, jobStatus;
    private String jobStatusMessage, imageData;
    private File companyLogo;

    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        setMap((ApplicationMap) application);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        setSessionMap((SessionMap<String, Object>) (SessionMap) session);
    }

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public ApplicationMap getMap() {
        return map;
    }

    public void setMap(ApplicationMap map) {
        this.map = map;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEducationQualification() {
        return educationQualification;
    }

    public void setEducationQualification(String educationQualification) {
        this.educationQualification = educationQualification;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }

    public int getHrManagerVerificationStatus() {
        return hrManagerVerificationStatus;
    }

    public void setHrManagerVerificationStatus(int hrManagerVerificationStatus) {
        this.hrManagerVerificationStatus = hrManagerVerificationStatus;
    }

    public int getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(int jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobStatusMessage() {
        return jobStatusMessage;
    }

    public void setJobStatusMessage(String jobStatusMessage) {
        this.jobStatusMessage = jobStatusMessage;
    }

    public File getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(File companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public String postAJob() throws FileNotFoundException, IOException {
        String result = "FAILURE";
        boolean success = JobDetailsService.getInstance().postAjob(this);
        if (success) {
            System.out.println("returning Success from postAJob method");
            sessionMap.put("NumberOfPostedJobs",HrService.getInstance().countNumberOfPostedJobs(this.userId));
            result = "SUCCESS";
        } else {
            System.out.println("returning Failure from postAJob method");
        }
        return result;

    }
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    // for searching a perticular job
    public String jobSearch() {
        String result = "FAILURE";
        ArrayList jobDetailsList = JobDetailsService.doJobSearch(this);

        if (jobDetailsList != null) {
            sessionMap.put("JobDetailsList", jobDetailsList);
            result = "SUCCESS";
        }

        return result;

    }

    public String jobSearchByKeyword() {
        String result = "FAILURE";
        ArrayList jobDetailsList = JobDetailsService.doJobSearchByKeyword(this);
        System.out.println("userId from view job details" + this.userId);

        if (jobDetailsList != null) {
            sessionMap.put("JobDetailsList", jobDetailsList);

            result = "SUCCESS";
        }

        return result;

    }

    public String viewJobDetails() {
        String result = "FAILURE";
        System.out.println("userId from view job details" + this.userId);
        JobDetails jobDetails = JobDetailsService.viewJobDetailsById(this.jobId);

        if (jobDetails != null) {
            sessionMap.put("JobDetails", jobDetails);
            result = "SUCCESS";
        } else {
            String viewJobDetailsErrorMsg = "Either Email or Password is Wrong!";
            sessionMap.put("ViewJobDetailsErrorMsg", viewJobDetailsErrorMsg);
            System.out.println("returning Failure from viewJobDetailsErrorMsg method");
            //  logger.error("No Claim Found" + LocalDateTime.now());
        }
        return result;
    }

    public String updateJob() throws FileNotFoundException {
        String result = "FAILURE";
        try {
            boolean success = JobDetailsService.updateJobDetails(this);
            JobDetails jobDetails = JobDetailsService.viewJobDetailsById(this.jobId);
            System.out.println("in update job userId: " + jobDetails.userId);
            if (success) {
                ArrayList jobList = HrService.getInstance().getAllJobPostedByHr(this.userId);
                System.out.println("List Size:" + jobList.size());
                sessionMap.put("JobPostedByHr", jobList);
                result = "SUCCESS";
            } else {
                String viewJobDetailsErrorMsg = "Either Email or Password is Wrong!";
                sessionMap.put("ViewJobDetailsErrorMsg", viewJobDetailsErrorMsg);
                System.out.println("returning Failure from viewJobDetailsErrorMsg method");
                //  logger.error("No Claim Found" + LocalDateTime.now());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String viewJobDetailsByHrManager() {
        String result = "FAILURE";

        JobDetails jobDetails = JobDetailsService.viewJobDetailsById(this.jobId);

        if (jobDetails != null) {
            sessionMap.put("JobDetails", jobDetails);
            result = "SUCCESS";
        } else {
            String viewJobDetailsErrorMsg = "Either Email or Password is Wrong!";
            sessionMap.put("ViewJobDetailsErrorMsg", viewJobDetailsErrorMsg);
            System.out.println("returning Failure from viewJobDetailsErrorMsg method");
            //  logger.error("No Claim Found" + LocalDateTime.now());
        }
        return result;
    }

    public String acceptByHrManager() {
        String result = "FAILURE";
        boolean success = JobDetailsService.doAcceptByHrManager(this.jobId);
        if (success == true) {
            result = "SUCCESS";
        }
        return result;
    }

    public String rejectByHrManager() {
        String result = "FAILURE";
        boolean success = JobDetailsService.doRejectByHrManager(this.jobId);
        if (success == true) {
            result = "SUCCESS";
        }
        return result;
    }

}
