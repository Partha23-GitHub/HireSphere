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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    private String contactNumber, companyName, hrManagerName, gender;

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

    public int getHrManagerId() {
        return hrManagerId;
    }

    /**
     * @return the hrId
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

    public void setHrManagerName(String hrManagerName) {
        this.hrManagerName = hrManagerName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

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
            //  Logger log =  Logger.getLogger(HtmlLayoutLog.class.getName());
            System.out.println("Update is incomplete" + "@" + LocalDateTime.now());

        }
        return result;

    }

}
