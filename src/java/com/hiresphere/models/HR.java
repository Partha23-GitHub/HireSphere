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
import java.time.LocalDateTime;
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
public class HR extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    private int hrId, userId, companyId, value;

    /**
     *
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     *
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }
    private String contactNumber, companyName, hrName, gender;

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

    /**
     *
     * @return
     * @throws Exception 
     * This Method is mainly responsible for load the
     * HR menu and the corresponding pages dynamically through Ajax.
     */
    public String loadMenuContent() throws Exception {
        String result = "FAILURE";
        switch (this.getWork()) {
            case "jobpost":
                result = "POSTJOB";
                break;
            case "allpostedjobs":
                System.out.println(this.value);
                ArrayList jobList = HrService.getInstance().getAllJobPostedByHr(this.value);
                sessionMap.put("JobPostedByHr", jobList);
                result = "ALLPOSTEDJOB";
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * @return the hrId
     */
    public int getHrId() {
        return hrId;
    }

    /**
     * @param hrId the hrId to set
     */
    public void setHrId(int hrId) {
        this.hrId = hrId;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
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
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the companyId
     */
    public int getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId the companyId to set
     */
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    /**
     * @return the contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * @param contactNumber the contactNumber to set
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
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
     * @return the hrName
     */
    public String getHrName() {
        return hrName;
    }

    /**
     * @param hrName the hrName to set
     */
    public void setHrName(String hrName) {
        this.hrName = hrName;
    }

    /**
     *
     * @return
     * This method will be called when HR clicks on their profile. it
     * will take the user id from session the get all the necessary data from
     * database and send to view through session
     */
    public String visitHRProfile() {
        String result = "FAILURE";

        HR hr = HrService.getHrByUserId(this.userId);

        if (hr != null) {
            sessionMap.put("HR", hr);
            result = "SUCCESS";
        } else {
            String hrProfileVisitErrorMsg = "Either Email or Password is Wrong!";
            sessionMap.put("HRProfileVisitErrorMsg", hrProfileVisitErrorMsg);
            System.out.println("returning Failure from hrvisitProfile method");
            // logger.error("No Claim Found" + LocalDateTime.now());
        }
        return result;
    }

    /**
     *
     * @return 
     * This method is called when HR try to update their profile. It
     * gathered all the data then called the updateHRProfile and insert fields
     * into HR database.
     */
    public String updateHRProfile() {
        String result = "FAILURE";
        System.out.println("HR Update Start");
        boolean success = HrService.updateHRProfile(this, this.hrId);

        if (success) {
            //  HR hr= HRService.getAllEmployees();
            //sessionMap.put("hr", this);
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
