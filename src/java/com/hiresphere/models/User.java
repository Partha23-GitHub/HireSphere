/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.models;

import com.hiresphere.services.CandidateService;
import com.hiresphere.services.HrService;
import com.hiresphere.services.JobDetailsService;
import com.hiresphere.services.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
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
public class User extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    private String name;
    private String email;
    private String password;
    private Integer roleId;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String doCandidateSignUp() {
        String result = "FAILURE";
        try {
            boolean success = UserService.doSignup(this);
            User user = UserService.getUser(this.getEmail());
            boolean succes1 = CandidateService.doRegisterCandidate(user.userId);
            if (success && succes1) {
                //creating MailSender object and setting up all parameters
                String toEmail = this.email;
                String subject = "Thank you for registering with HireSphere";
                String message = "You are succesfully registered with HireSphere with your email " + this.getEmail()
                        + " and password " + this.getPassword() + ". You are just few step away to get hired. Best wishes from us for your future career.";

                MailSender.sendEmailToRegisterUser(toEmail, subject, message);
                result = "SUCCESS";
            } else {
                System.out.println("returning Failure from doSignup method");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public String doLogin() throws Exception {
        String result = "FAILURE";

        boolean success = UserService.getInstance().doLogin(this);

        if (success) {
            System.out.println("Returning Success from doLogin method");
            User user = UserService.getUser(this.getEmail());
            System.out.println("user id from do log in" + user.getUserId());

            switch (user.getRoleId()) {
                case 1:
                    Candidate candidate = CandidateService.getCandidateByUserId(user.getUserId());
                    System.out.println("candifate id from log in" + candidate.getCandidateId());
                    sessionMap.put("Candidate", candidate);
                    ArrayList jobList = JobDetailsService.doGetRecentJobs();
                    sessionMap.put("JobList", jobList);
                    result = "CANDIDATE";
                    break;
                case 2:
                    sessionMap.put("NumberOfPostedJobs",HrService.getInstance().countNumberOfPostedJobs(user.getUserId()));
                    int hrId=HrService.getInstance().getHrId(user.userId);
                    sessionMap.put("TotalApplication",HrService.getInstance().getTotalApplication(hrId));
                    sessionMap.put("TotalShortlisted",HrService.getInstance().getTotalShortlisted(hrId));
                    sessionMap.put("TotalPending",HrService.getInstance().getTotalPending(user.getUserId()));
                    sessionMap.put("TotalVerified",HrService.getInstance().getTotalVerified(user.getUserId()));
                    result = "HR";
                    break;
                case 3:
                    result = "HR MANAGER";
                    break;
                default:
                    result = "FAILURE";
            }

            sessionMap.put("User", user);
        } else {
            System.out.println("Returning Failure from doLogin method");
        }

        return result;
    }
    public String fbLogin() {
        String result = "FAILURE";
        try {
            if(UserService.userExist(this.email))
            {
                User user = UserService.getUser(this.getEmail());
                Candidate candidate = CandidateService.getCandidateByUserId(user.getUserId());
                System.out.println("candifate id from log in" + candidate.getCandidateId());
                sessionMap.put("Candidate", candidate);
                 sessionMap.put("User", user);
                result="SUCCESS";
                
                
                
            } else {
            
            boolean success = UserService.doSignup(this);
            User user = UserService.getUser(this.getEmail());
            boolean succes1 = CandidateService.doRegisterCandidate(user.userId);
              Candidate candidate = CandidateService.getCandidateByUserId(user.getUserId());
                System.out.println("candifate id from log in" + candidate.getCandidateId());
                sessionMap.put("Candidate", candidate);
                 sessionMap.put("User", user);
            if (success && succes1) {
                //creating MailSender object and setting up all parameters
                String toEmail = this.email;
                String subject = "Thank you for registering with HireSphere";
                String message = "You are succesfully registered with HireSphere with your email " + this.getEmail()
                        + " and password " + this.getPassword() + ". You are just few step away to get hired. Best wishes from us for your future career.";

                MailSender.sendEmailToRegisterUser(toEmail, subject, message);
                result = "SUCCESS";
            } else {
                System.out.println("returning Failure from doSignup method");
            }
        } 
        }catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    
}
