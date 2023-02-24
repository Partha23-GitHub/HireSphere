/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.models;

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

        boolean success = UserService.doSignup(this);

        if (success) {
            System.out.println("returning Success from doSignup method");
            result = "SUCCESS";

        } else {
            System.out.println("returning Failure from doSignup method");
        }

        return result;
    }

//    public String doLogin() throws Exception {
//        String result = "FAILURE";
//
//        boolean success = LoginService.getInstance().doLogin(this);
//
//        if (success) {
//            System.out.println("returning Success from doLogin method");
//            result = "SUCCESS";
//            sessionMap.put("Loggedin", this);
//            ArrayList empList = EmployeeService.getInstance().getAllEmployees();
//            
//
//        } else {
//            System.out.println("returning Failure from doLogin method");
//        }
//
//        return result;
//    }
}
