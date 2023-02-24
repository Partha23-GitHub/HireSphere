/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.models;

import com.hiresphere.services.JobDetailsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author user
 */
public class JobDetails extends ActionSupport implements ApplicationAware, SessionAware, Serializable {
    private int jobId,userId;
    private String companyName,companyWebsite,jobTitle,jobType,description;
    private String educationQualification,requirements,responsibilities,location;
    private String experience,closingDate,salary,postingDate;
    private int hrManagerVerificationStatus,jobStatus;
    
    
    
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

    /**
     * @return the jobId
     */
    public int getJobId() {
        return jobId;
    }

    /**
     * @param jobId the jobId to set
     */
    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the companyWebsite
     */
    public String getCompanyWebsite() {
        return companyWebsite;
    }

    /**
     * @param companyWebsite the companyWebsite to set
     */
    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    /**
     * @return the jobTitle
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * @param jobTitle the jobTitle to set
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * @return the jobType
     */
    public String getJobType() {
        return jobType;
    }

    /**
     * @param jobType the jobType to set
     */
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    /**
     * @return the description
     */


    /**
     * @return the educationQualification
     */
    public String getEducationQualification() {
        return educationQualification;
    }

    /**
     * @param educationQualification the educationQualification to set
     */
    public void setEducationQualification(String educationQualification) {
        this.educationQualification = educationQualification;
    }

    /**
     * @return the requirements
     */
    public String getRequirements() {
        return requirements;
    }

    /**
     * @param requirements the requirements to set
     */
    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    /**
     * @return the responsibilities
     */
    public String getResponsibilities() {
        return responsibilities;
    }

    /**
     * @param responsibilities the responsibilities to set
     */
    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the experience
     */
    public String getExperience() {
        return experience;
    }

    /**
     * @param experience the experience to set
     */
    public void setExperience(String experience) {
        this.experience = experience;
    }

    /**
     * @return the closingDate
     */
    public String getClosingDate() {
        return closingDate;
    }

    /**
     * @param closingDate the closingDate to set
     */
    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    /**
     * @return the salary
     */
    public String getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * @return the postingDate
     */
    public String getPostingDate() {
        return postingDate;
    }

    /**
     * @param postingDate the postingDate to set
     */
    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }

    /**
     * @return the hrManagerVerificationStatus
     */
    public int getHrManagerVerificationStatus() {
        return hrManagerVerificationStatus;
    }

    /**
     * @param hrManagerVerificationStatus the hrManagerVerificationStatus to set
     */
    public void setHrManagerVerificationStatus(int hrManagerVerificationStatus) {
        this.hrManagerVerificationStatus = hrManagerVerificationStatus;
    }

    /**
     * @return the jobStatus
     */
    public int getJobStatus() {
        return jobStatus;
    }
     public String getDescription() {
        return description;
    }

    /**
     * @param jobdescription the jobdescription to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param jobStatus the jobStatus to set
     */
    public void setJobStatus(int jobStatus) {
        this.jobStatus = jobStatus;
    }
     public String postAJob()
    {
        String result="FAILURE";
        
        boolean success=JobDetailsService.getInstance().postAjob(this);
        if(success)
        {
            System.out.println("returning Success from postAJob method");
            result = "SUCCESS";
        }
        else
        {
             System.out.println("returning Failure from postAJob method");
        }
        return result;
        
    }

    /**
     * @return the jobdescription
     */
   
    
    
}
