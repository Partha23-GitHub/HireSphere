/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.models;

import com.hiresphere.services.HrManagerService;
import com.hiresphere.services.HrService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author user
 */
public class HrManager extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    private int hrManagerId, userId, companyId, value;

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
    private String contactNumber, companyName, hrManagerName, gender;

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
     * This method will be called when HRManager
     * clicks on their profile. it will take the user id from session the get
     * all the necessary data from database and send to view through session
     */
    public String loadMenuContent() throws Exception {
        String result = "FAILURE";
        switch (this.getWork()) {
            case "allpostedjobs":
                System.out.println(this.value);
                ArrayList jobList = HrManagerService.getAlljobsByHrManager(this.value);
                sessionMap.put("JobList", jobList);
                result = "ALLPOSTEDJOB";
                break;
            default:
                break;
        }
        return result;
    }

    /**
     *
     * @return
     */
    public int getHrManagerId() {
        return hrManagerId;
    }

    /**
     * @param hrManagerId
     */
    public void setHrManagerId(int hrManagerId) {
        this.hrManagerId = hrManagerId;
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
    public String getHrManagerName() {
        return hrManagerName;
    }

    /**
     *
     * @param hrManagerName
     */
    public void setHrManagerName(String hrManagerName) {
        this.hrManagerName = hrManagerName;
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
     * This method will be called when HR clicks on their profile. it
     * will take the user id from session the get all the necessary data from
     * database and send to view through session
     */
    public String visitHRManagerProfile() {
        String result = "FAILURE";
        System.out.println(this.userId);
        HrManager hrmanager = HrManagerService.getHrManagerByUserId(this.userId);

        if (hrmanager != null) {
            sessionMap.put("HRManager", hrmanager);
            System.out.println(hrmanager.getGender());
            result = "SUCCESS";
        } else {
            String hrmanagerProfileVisitErrorMsg = "Either Email or Password is Wrong!";
            sessionMap.put("HRProfileVisitErrorMsg", hrmanagerProfileVisitErrorMsg);
            System.out.println("returning Failure from HRManagervisitProfile method");
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
    public String updateHRManagerProfile() {
        String result = "FAILURE";
        System.out.println("HR Manager Update Start");
        boolean success = HrManagerService.updateHRManagerProfile(this, this.hrManagerId);

        if (success) {
            //  HR hr= HRService.getAllEmployees();
            //sessionMap.put("hr", this);
            result = "SUCCESS";
            String successMsg = "Profile is Successfully Updated!";
            sessionMap.put("SuccessMsg", successMsg);

        } else {
//              Logger log =  Logger.getLogger(HtmlLayoutLog.class.getName());
            System.out.println("Update is incomplete" + "@" + LocalDateTime.now());

        }
        return result;

    }

}
