/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.models;

import com.hiresphere.services.HrService;
import com.hiresphere.services.JobApplicationService;
import com.hiresphere.services.JobDetailsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
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
    private String work;

    /**
     *
     * @return
     */
    public String getWork() {
        return work;
    }

    /**
     *
     * @param work
     */
    public void setWork(String work) {
        this.work = work;
    }
    private int applicationId;
    private int candidateId;
    private int hrId;
    private int jobId;

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    private int applicationStatus;
    private String companyName;
    private String jobTitle;
    private String jobType;
    private String applicationMessage;
    private String candidateName;
    private String candidatePhoneNumber;
    private String candidateGender;
    private String email;
    private String password;
    private String resumePath;

    /**
     *
     * @return
     */
    public String getResumePath() {
        return resumePath;
    }

    /**
     *
     * @param resumePath
     */
    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }
    
    /**
     *
     * @return
     */
    public String getCandidateName() {
        return candidateName;
    }

    /**
     *
     * @param candidateName
     */
    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    /**
     *
     * @return
     */
    public String getCandidatePhoneNumber() {
        return candidatePhoneNumber;
    }

    /**
     *
     * @param candidatePhoneNumber
     */
    public void setCandidatePhoneNumber(String candidatePhoneNumber) {
        this.candidatePhoneNumber = candidatePhoneNumber;
    }

    /**
     *
     * @return
     */
    public String getCandidateGender() {
        return candidateGender;
    }

    /**
     *
     * @param candidateGender
     */
    public void setCandidateGender(String candidateGender) {
        this.candidateGender = candidateGender;
    }

    /**
     *
     * @return
     */
    public String getApplicationMessage() {
        return applicationMessage;
    }

    /**
     *
     * @param applicationMessage
     */
    public void setApplicationMessage(String applicationMessage) {
        this.applicationMessage = applicationMessage;
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
    public int getApplicationId() {
        return applicationId;
    }

    /**
     *
     * @param applicationId
     */
    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    /**
     *
     * @return
     */
    public int getCandidateId() {
        return candidateId;
    }

    /**
     *
     * @param candidateId
     */
    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    /**
     *
     * @return
     */
    public int getHrId() {
        return hrId;
    }

    /**
     *
     * @param hrId
     */
    public void setHrId(int hrId) {
        this.hrId = hrId;
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
    public int getApplicationStatus() {
        return applicationStatus;
    }

    /**
     *
     * @param applicationStatus
     */
    public void setApplicationStatus(int applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

//    public String getAllApplicant(){
//        String result = "FAILURE";
//        ArrayList jobApplicant = JobApplicationService.getAllApplicant(this);
//
//        return result;
//    }

    /**
     *@return
     * This method is responsible for getting all the applicant for a particular job. it receive the job id from URL ans called the responsible 
     * service method to find all the applicant from jobApplication table
     */
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

    /**
     *@return 
     * This is mainly responsible for Shortlisted the candidate. When Hr click on the Shortlist button this method is called and update the application status
     */
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

    /**
     *@return
     * This is mainly responsible for Reject the candidate. When Hr click on the Reject button this method is called and update the application status
     */
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

    /**
     *
     * @return
     * @throws IOException
     * This applyJob is called when a candidate apply for a job . It takes necessary data from URL and insert candidate data into jobApplication table.
     * after successfully applied it call the MailSender and send the mail to candidate this few job details
     */
    public String applyJob() throws IOException {
        String result = "FAILURE";

        int Id = HrService.getInstance().getHrId(this.hrId);
        JobDetails jobDetails = JobDetailsService.viewJobDetailsById(this.jobId);
        JobApplication jobApplication = new JobApplication();
        jobApplication.setJobId(this.jobId);
        jobApplication.setCandidateId(this.candidateId);
        jobApplication.setHrId(Id);

      boolean success = JobApplicationService.doApplyJob(jobApplication);

        if (success) {
            ArrayList jobList = JobApplicationService.doGetJobApplicationByCandidate(this.candidateId);
            System.out.println("applied job list" + jobList.size());
            sessionMap.put("JobApplicationList", jobList);
            String toEmail = this.email;
            String subject = "Successfully Applied";
            String message = "You are succesfully applied in  " + jobDetails.getJobTitle()
                    + " in company " + jobDetails.getCompanyName()+ ". You are just few step away to get hired. Best wishes from us for your future career.";

                MailSender.sendEmailToRegisterUser(toEmail, subject, message);
            result = "SUCCESS";
        } else {

            System.out.println("Returning failure from job application");

        }
        return result;
    }
}
