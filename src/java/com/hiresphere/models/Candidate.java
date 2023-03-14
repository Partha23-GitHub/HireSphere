/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.models;

import com.hiresphere.services.CandidateService;
import com.hiresphere.services.JobApplicationService;
import com.hiresphere.utils.JDBCUtility;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Jayita
 */
public class Candidate extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

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

    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    /**
     *
     * @param application
     */
    @Override
    public void setApplication(Map<String, Object> application) {
        map = (ApplicationMap) application;
    }

    /**
     *
     * @param session
     */
    @Override
    public void setSession(Map<String, Object> session) {
        sessionMap = (SessionMap) session;
    }
    private int candidateId;
    private int userId;
    private String name;
    private String email;
    private String gender;
    private String phoneNumber;
    private String city;
    private String state;
    private String country;
    private int applicationId;
    private int applicationStatus;
    private int jobId;
    private File resume;
    private String resumePath;
    private String resumeFileName;
    private String resumeContentType;

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
    public String getResumeFileName() {
        return resumeFileName;
    }

    /**
     *
     * @param resumeFileName
     */
    public void setResumeFileName(String resumeFileName) {
        this.resumeFileName = resumeFileName;
    }

    /**
     *
     * @return
     */
    public String getResumeContentType() {
        return resumeContentType;
    }

    /**
     *
     * @param resumeContentType
     */
    public void setResumeContentType(String resumeContentType) {
        this.resumeContentType = resumeContentType;
    }

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
    public File getResume() {
        return resume;
    }

    /**
     *
     * @param resume
     */
    public void setResume(File resume) {
        this.resume = resume;
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
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return 
     * This method will called when a candidate click on my profile. It
     * take the userId from session and called the getCandidateByUserId method
     * of UserService and take all the candidate data then put in the session
     * map.
     */
    public String visitCandidateProfile() {
        String result = "FAILURE";

        Candidate candidate = CandidateService.getCandidateByUserId(this.userId);

        if (candidate != null) {
            sessionMap.put("Candidate", candidate);
            result = "SUCCESS";
        } else {
            String candidateProfileVisitErrorMsg = "Either Email or Password is Wrong!";
            sessionMap.put("CandidateProfileVisitErrorMsg", candidateProfileVisitErrorMsg);
            System.out.println("returning Failure from visitProfile method");
            // logger.error("No Claim Found" + LocalDateTime.now());
        }
        return result;
    }

    /**
     *
     * @return 
     * @throws IOException 
     * This method is basically taking candidateId
     * from view and called the doGetJobApplicationByCandidate method of
     * JobApplicationService to process all the jobs that are applied by the
     * candidate.
     */
    public String viewJobApplication() throws IOException {
        String result = "FAILURE";
        ArrayList jobApplicationList = JobApplicationService.doGetJobApplicationByCandidate(this.getCandidateId());
        if (jobApplicationList != null) {
            sessionMap.put("JobApplicationList", jobApplicationList);

            result = "SUCCESS";
        }
        result = "SUCCESS";
        return result;

    }

    /**
     *
     * @return 
     * @throws FileNotFoundException
     * @throws IOException
     * @throws FileUploadException
     * @throws Exception
     * When User update their profile this method will called
     * with the resume file and all the necessary data for profile update. First
     * it will check if any od resume is present or not. if present then find
     * out the resume then delete it, after that new resume will store on the
     * resume folder(Append the system current currentTimeMillis for generating
     * unique file name) and store the path into candidate table's resume
     * column.
     */
    public String updateProfile() throws FileNotFoundException, IOException, FileUploadException, Exception {
        String result = "FAILURE";
        JDBCUtility jdbcUtility = JDBCUtility.getInstanceOfJDBCUtility();
        // checking if any resume is there of candidate., if there then delete it
        String oldPath = CandidateService.getCandidateByCandidateId(candidateId).getResumePath();
        
        if (oldPath != null) {
            File file = new File(jdbcUtility.getPropertyValue("resumeStoringPath") + oldPath);
            file.delete();
        }
        // store the new resume
        String relativePath = System.currentTimeMillis() + resumeFileName; // for creating unique file name
        String filePath = jdbcUtility.getPropertyValue("resumeStoringPath") + relativePath;
        File destFile = new File(filePath);
        FileUtils.copyFile(resume, destFile);
        System.out.println(relativePath);
        System.out.println(candidateId);
        boolean success = CandidateService.updateCandidateProfile(this, candidateId, relativePath);

        if (success) {
            //  Candidate candidate= CandidateService.getAllEmployees();
            //sessionMap.put("candidate", this);
            result = "SUCCESS";
            String successMsg = "Profile is Successfully Updated!";
            sessionMap.put("SuccessMsg", successMsg);

        } else {
            //  Logger log =  Logger.getLogger(HtmlLayoutLog.class.getName());
            System.out.println("Update is incomplete" + "@" + LocalDateTime.now());

        }
        return result;

    }
}
