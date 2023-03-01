/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.models;

import com.hiresphere.services.HrService;
import com.hiresphere.services.JobApplicationService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author user
 */
public class JobApplication extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

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
    private String work;

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
    private int applicationId;
    private int candidateId;
    private int hrId;
    private int jobId;
    private int applicationStatus;
    private String companyName;
    private String jobTitle;
    private String jobType;
    private String applicationMessage;
    private String candidateName;
    private String candidatePhoneNumber;
    private String candidateGender;

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidatePhoneNumber() {
        return candidatePhoneNumber;
    }

    public void setCandidatePhoneNumber(String candidatePhoneNumber) {
        this.candidatePhoneNumber = candidatePhoneNumber;
    }

    public String getCandidateGender() {
        return candidateGender;
    }

    public void setCandidateGender(String candidateGender) {
        this.candidateGender = candidateGender;
    }

    public String getApplicationMessage() {
        return applicationMessage;
    }

    public void setApplicationMessage(String applicationMessage) {
        this.applicationMessage = applicationMessage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public int getHrId() {
        return hrId;
    }

    public void setHrId(int hrId) {
        this.hrId = hrId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(int applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

//    public String getAllApplicant(){
//        String result = "FAILURE";
//        ArrayList jobApplicant = JobApplicationService.getAllApplicant(this);
//
//        return result;
//    }
    public String viewAllApplicantByJobId() {
        String result = "FAILURE";

        ArrayList applicantList = JobApplicationService.getApplicantByJobId(this.jobId);
        if (applicantList != null) {
            System.out.println("Returning Success from View All Applicant from Id ");
            sessionMap.put("ApplicantList", applicantList);
            System.out.println("Applicant List Size ::" + applicantList.size());
            result = "SUCCESS";
        } else {
            System.out.println("Returning Failure from View All Applicant from Id ");
        }
        return result;
    }

    public String doApproveApplication() {
        String result = "FAILURE";
        boolean update = JobApplicationService.updateApplicationStatus(this.applicationId);
        System.out.println("update ::" + update);
        if (update == true) {
            ArrayList applicantList = JobApplicationService.getApplicantByJobId(this.jobId);
            sessionMap.put("ApplicantList", applicantList);

            result = "SUCCESS";
        }
        return result;
    }

    public String doRejectApplication() {
        String result = "FAILURE";
        boolean update = JobApplicationService.rejectApplication(this.applicationId);
        System.out.println("update ::" + update);
        if (update == true) {

            ArrayList applicantList = JobApplicationService.getApplicantByJobId(this.jobId);
            sessionMap.put("ApplicantList", applicantList);

            result = "SUCCESS";
        }
        return result;
    }

    public String applyJob() {
        String result = "FAILURE";

        int Id = HrService.getInstance().getHrId(this.hrId);
        JobApplication jobApplication = new JobApplication();
        jobApplication.setJobId(this.jobId);
        jobApplication.setCandidateId(this.candidateId);
        jobApplication.setHrId(Id);

        boolean success = JobApplicationService.doApplyJob(jobApplication);

        if (success) {
            ArrayList jobList = JobApplicationService.doGetJobApplicationByCandidate(this.candidateId);
            System.out.println("applied job list" + jobList.size());
            sessionMap.put("JobApplicationList", jobList);
            result = "SUCCESS";
        } else {

            System.out.println("Returning failure from job application");

        }
        return result;
    }
}
