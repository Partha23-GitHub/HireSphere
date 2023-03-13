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

    /**
     *
     * @param application
     */
    @Override
    public void setApplication(Map<String, Object> application) {
        setMap((ApplicationMap) application);
    }

    /**
     *
     * @param session
     */
    @Override
    public void setSession(Map<String, Object> session) {
        setSessionMap((SessionMap<String, Object>) (SessionMap) session);
    }

    /**
     *
     * @return
     */
    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    /**
     *
     * @param sessionMap
     */
    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    /**
     *
     * @return
     */
    public ApplicationMap getMap() {
        return map;
    }

    /**
     *
     * @param map
     */
    public void setMap(ApplicationMap map) {
        this.map = map;
    }

    /**
     *
     * @return
     */
    public int getJobId() {
        return jobId;
    }

    /**
     *
     * @param jobId
     */
    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    /**
     *
     * @return
     */
    public int getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     *
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     *
     * @return
     */
    public String getCompanyWebsite() {
        return companyWebsite;
    }

    /**
     *
     * @param companyWebsite
     */
    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    /**
     *
     * @return
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     *
     * @param jobTitle
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     *
     * @return
     */
    public String getJobType() {
        return jobType;
    }

    /**
     *
     * @param jobType
     */
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public String getEducationQualification() {
        return educationQualification;
    }

    /**
     *
     * @param educationQualification
     */
    public void setEducationQualification(String educationQualification) {
        this.educationQualification = educationQualification;
    }

    /**
     *
     * @return
     */
    public String getRequirements() {
        return requirements;
    }

    /**
     *
     * @param requirements
     */
    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    /**
     *
     * @return
     */
    public String getResponsibilities() {
        return responsibilities;
    }

    /**
     *
     * @param responsibilities
     */
    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    /**
     *
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return
     */
    public String getExperience() {
        return experience;
    }

    /**
     *
     * @param experience
     */
    public void setExperience(String experience) {
        this.experience = experience;
    }

    /**
     *
     * @return
     */
    public String getClosingDate() {
        return closingDate;
    }

    /**
     *
     * @param closingDate
     */
    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    /**
     *
     * @return
     */
    public String getSalary() {
        return salary;
    }

    /**
     *
     * @param salary
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     *
     * @return
     */
    public String getPostingDate() {
        return postingDate;
    }

    /**
     *
     * @param postingDate
     */
    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }

    /**
     *
     * @return
     */
    public int getHrManagerVerificationStatus() {
        return hrManagerVerificationStatus;
    }

    /**
     *
     * @param hrManagerVerificationStatus
     */
    public void setHrManagerVerificationStatus(int hrManagerVerificationStatus) {
        this.hrManagerVerificationStatus = hrManagerVerificationStatus;
    }

    /**
     *
     * @return
     */
    public int getJobStatus() {
        return jobStatus;
    }

    /**
     *
     * @param jobStatus
     */
    public void setJobStatus(int jobStatus) {
        this.jobStatus = jobStatus;
    }

    /**
     *
     * @return
     */
    public String getJobStatusMessage() {
        return jobStatusMessage;
    }

    /**
     *
     * @param jobStatusMessage
     */
    public void setJobStatusMessage(String jobStatusMessage) {
        this.jobStatusMessage = jobStatusMessage;
    }

    /**
     *
     * @return
     */
    public File getCompanyLogo() {
        return companyLogo;
    }

    /**
     *
     * @param companyLogo
     */
    public void setCompanyLogo(File companyLogo) {
        this.companyLogo = companyLogo;
    }

    /**
     *
     * @return
     */
    public String getImageData() {
        return imageData;
    }

    /**
     *
     * @param imageData
     */
    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
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

    /**
     *
     * @return
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     *
     * @param keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    // for searching a perticular job

    /**
     *
     * @return
     * When Candidate try to view all the jobs this method will be called. And get all the job from db that are verified by the HRManager.
     * Then it send to the view through the session.
     */
    public String jobSearch() {
        String result = "FAILURE";
        ArrayList jobDetailsList = JobDetailsService.doJobSearch(this);

        if (jobDetailsList != null) {
            sessionMap.put("JobDetailsList", jobDetailsList);
            result = "SUCCESS";
        }

        return result;

    }

    /**
     * @return
     * When the user try to search job according to search keyword. this method take the keyword and called the related services method
     * and return all the matching jobs
     */
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

    /**
     * @return
     * When a user click on the view details to view all the job details this method will be called with the job id. 
     * Then it called the viewJobDetailsById from services and return the job details to the view through session
     */
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

    /**
     *
     * @return
     * @throws FileNotFoundException
     * After posting a job by Hr then if hr wants to update the job details then this method will called and takes all the fields from form and update the jobDetails database
     */
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

    /**
     * @return
     * After posting the job by Hr. The job has to verify by the HrManager. if HR manager try to view the job details that hr has posted , this method will called 
     */
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

    /**
     * @return
     * This method is mainly responsible for change the job application status i.e accept by the Hr manager.
     */
    public String acceptByHrManager() {
        String result = "FAILURE";
        boolean success = JobDetailsService.doAcceptByHrManager(this.jobId);
        if (success == true) {
            result = "SUCCESS";
        }
        return result;
    }

    /**
     * @return
     * This method is mainly responsible for change the job application status i.e reject by the Hr manager.
     */
    public String rejectByHrManager() {
        String result = "FAILURE";
        boolean success = JobDetailsService.doRejectByHrManager(this.jobId);
        if (success == true) {
            result = "SUCCESS";
        }
        return result;
    }

}
