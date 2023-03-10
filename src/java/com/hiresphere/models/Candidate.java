/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.models;

import com.hiresphere.services.CandidateService;
import com.hiresphere.services.JobApplicationService;
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
public class Candidate extends ActionSupport implements ApplicationAware, SessionAware, Serializable{

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

    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        map = (ApplicationMap) application;
    }

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

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }
    
    
    public String getResumeFileName() {
        return resumeFileName;
    }

    public void setResumeFileName(String resumeFileName) {
        this.resumeFileName = resumeFileName;
    }

    public String getResumeContentType() {
        return resumeContentType;
    }

    public void setResumeContentType(String resumeContentType) {
        this.resumeContentType = resumeContentType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public File getResume() {
        return resume;
    }

    public void setResume(File resume) {
        this.resume = resume;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

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

    public String updateProfile() throws FileNotFoundException, IOException, FileUploadException, Exception {
        String result = "FAILURE";
        // checking if any resume is there of candidate., if there then delete it
        String oldPath=CandidateService.getCandidateByCandidateId(candidateId).getResumePath();
        System.out.println("oldpath: "+oldPath);
        if(oldPath!=null){
            File file=new File("C:\\Users\\itssh\\Downloads\\HireSphere\\HireSphere\\web\\Resume/"+oldPath);
            file.delete();
        }
        // store the new resume
        String relativePath=System.currentTimeMillis()+ resumeFileName; // for creating unique file name
        String filePath = "C:\\Users\\itssh\\Downloads\\HireSphere\\HireSphere\\web\\Resume/" +relativePath; 
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
