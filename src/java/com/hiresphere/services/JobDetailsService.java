/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.services;

import com.hiresphere.models.JobDetails;
import com.hiresphere.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar; 

/**
 *
 * @author user
 */
public class JobDetailsService {
     public static JobDetailsService jobDetailsService = null;

    private JobDetailsService() {
    }

    public static JobDetailsService getInstance() {
        if (jobDetailsService == null) {
            return new JobDetailsService();
        } else {
            return jobDetailsService;
        }
    }

    public boolean postAjob(JobDetails job) {
        Date d = Calendar.getInstance().getTime();  
      DateFormat df = new SimpleDateFormat("dd-mm-yyy");  
      String postingDate = df.format(d);  
        boolean result = false;
        Connection con = JDBCConnectionManager.getConnection();
        String sql = "INSERT INTO hiresphere.jobdetails\n"
                + "(userId,\n"
                + "companyName,\n"
                + "companyWebsite,\n"
                + "jobTitle,\n"
                + "jobType,\n"
                + "description,\n"
                + "educationQualification,\n"
                + "responsibilities,\n"
                + "requirements,\n"
                + "location,\n"
                + "experience,\n"
                + "closingDate,\n"
                + "salary,\n"
                + "hrManagerVerificationStatus,\n"
                + "jobStatus,\n"
                + "postingDate)\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            //System.out.println("entering try block");
            PreparedStatement preparedStatement = con.prepareStatement(sql);
   
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, job.getCompanyName());
            preparedStatement.setString(3, job.getCompanyWebsite());
            preparedStatement.setString(4, job.getJobTitle());
            preparedStatement.setString(5, job.getJobType());
            preparedStatement.setString(6, job.getDescription());
            preparedStatement.setString(7, job.getEducationQualification());
            preparedStatement.setString(8, job.getResponsibilities());
            preparedStatement.setString(9, job.getRequirements());
            preparedStatement.setString(10, job.getLocation());
            preparedStatement.setString(11, job.getExperience());
            preparedStatement.setString(12, job.getClosingDate());
            preparedStatement.setString(13, job.getSalary());
            preparedStatement.setInt(14,0 );
            preparedStatement.setInt(15,1 );
            preparedStatement.setString(16, postingDate);
             System.out.println("LoginService :: "+preparedStatement);
            int rows = preparedStatement.executeUpdate();
        
            if (rows==1) {
                
                result = true;
            }
            
            


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;

    }

    
}
