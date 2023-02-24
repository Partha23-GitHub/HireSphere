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

/**
 *
 * @author user
 */
public class HrService {

    public static HrService hrService = null;

    private HrService() {
    }

    public static HrService getInstance() {
        if (hrService == null) {
            return new HrService();
        } else {
            return hrService;
        }
    }

    public boolean postAjob(JobDetails job) {
        boolean result = false;
        Connection con = JDBCConnectionManager.getConnection();
        String sql = "INSERT INTO hiresphere.jobdetails\n"
                + "(jobId,\n"
                + "userId,\n"
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
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            //System.out.println("entering try block");
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, job.getJobId());
            preparedStatement.setInt(2, job.getUserId());
            preparedStatement.setString(3, job.getCompanyName());
            preparedStatement.setString(4, job.getCompanyWebsite());
            preparedStatement.setString(5, job.getJobTitle());
            preparedStatement.setString(6, job.getJobType());
            preparedStatement.setString(7, job.getDescription());
            preparedStatement.setString(8, job.getEducationQualification());
            preparedStatement.setString(9, job.getResponsibilities());
            preparedStatement.setString(10, job.getRequirements());
            preparedStatement.setString(11, job.getLocation());
            preparedStatement.setString(12, job.getExperience());
            preparedStatement.setString(13, job.getClosingDate());
            preparedStatement.setString(14, job.getSalary());
            preparedStatement.setInt(15,0 );
            preparedStatement.setInt(16,1 );
            preparedStatement.setString(17, job.getPostingDate());
            int rows = preparedStatement.executeUpdate();

            if (rows==1) {
                
                result = true;
            }
             con.close();
             System.out.println("LoginService :: "+preparedStatement);


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;

    }

}
