/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

/**
 *
 * @author user
 */
public class HR {
     String work;

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
    public String loadMenuContent() throws Exception {
        String result = "FAILURE";
        switch (this.work) {
            case "jobpost":
                result = "POSTJOB";
                break;
            case "allapplicant":
                result = "ALLALLAPPLICANT";
                break;
            case "allpostedjobs":
                result = "ALLPOSTEDJOB";
                break;
            default:
                break;
        }
        return result;
    }
}
