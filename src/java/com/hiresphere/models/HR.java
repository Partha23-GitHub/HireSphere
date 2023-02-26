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
public class HR extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    private int hrId, userId, companyId;
    private String contactNumber, companyName, hrName;

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
            case "jobpost":
                result = "POSTJOB";
                break;
            case "allpostedjobs":
                System.out.println(this.userId);
                ArrayList jobList = HrService.getInstance().getAllJobPostedByHr(2);
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

}
