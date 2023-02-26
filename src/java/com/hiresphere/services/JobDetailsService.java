/*
 * Click nbfs://nbhost/SystemFileSystem/Tjobdetailslates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Tjobdetailslates/Classes/Class.java to edit this tjobdetailslate
 */
package com.hiresphere.services;

import com.hiresphere.models.JobDetails;
import com.hiresphere.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.apache.log4j.Logger;

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


    public static ArrayList doJobSearch(JobDetails jobdetails) {
        ArrayList jobdetailsList = new ArrayList();

        try {
            Connection con = JDBCConnectionManager.getConnection();

            String sql = "SELECT * FROM hiresphere.jobdetails where hrManagerVerificationStatus=1";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("Sql=" + preparedStatement);
            while (rs.next()) {
                JobDetails job = new JobDetails();
                job.setJobId(rs.getInt("jobId"));
                job.setJobTitle(rs.getString("jobTitle"));
                job.setCompanyName(rs.getString("companyName"));
                job.setJobType(rs.getString("jobType"));
                job.setSalary(rs.getString("salary"));
                job.setLocation(rs.getString("location"));
                job.setExperience(rs.getString("experience"));
                System.out.println("result" + job.getJobTitle() + job.getExperience() + job.getJobType() + job.getLocation() + job.getSalary() + job.getCompanyName());
                jobdetailsList.add(job);
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(JobDetailsService.class.getName());
            log.error("ERROR:" + ex.getMessage() + "@" + LocalDateTime.now());
        }

        return jobdetailsList;
    }

    public static ArrayList doJobSearchByKeyword(JobDetails jobdetails) {
        ArrayList jobdetailsList = new ArrayList();

        try {
            Connection con = JDBCConnectionManager.getConnection();

            String sql = "SELECT * FROM hiresphere.jobdetails where hrManagerVerificationStatus=1 and (jobTitle like ? or companyName like ? or jobType like ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, "%" + jobdetails.getKeyword() + "%");
            preparedStatement.setString(2, "%" + jobdetails.getKeyword() + "%");
            preparedStatement.setString(3, "%" + jobdetails.getKeyword() + "%");

            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("Sql=" + preparedStatement);
            while (rs.next()) {
                JobDetails job = new JobDetails();
                job.setJobId(rs.getInt("jobId"));

                job.setJobTitle(rs.getString("jobTitle"));
                job.setCompanyName(rs.getString("companyName"));
                job.setJobType(rs.getString("jobType"));
                job.setSalary(rs.getString("salary"));
                job.setLocation(rs.getString("location"));
                job.setExperience(rs.getString("experience"));
                System.out.println("result" + job.getJobTitle() + job.getExperience() + job.getJobType() + job.getLocation() + job.getSalary() + job.getCompanyName());
                jobdetailsList.add(job);
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(JobDetailsService.class.getName());
            log.error("ERROR:" + ex.getMessage() + "@" + LocalDateTime.now());
        }

        return jobdetailsList;
    }

    public static JobDetails viewJobDetailsById(int jobId) {
        JobDetails jobdetails = new JobDetails();
        System.out.println(jobId);
        String sql = "SELECT * FROM jobdetails where jobId=?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, jobId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                jobdetails.setJobId(rs.getInt("jobId"));
                jobdetails.setJobTitle(rs.getString("jobTitle"));
                jobdetails.setCompanyWebsite(rs.getString("companyWebsite"));
                jobdetails.setCompanyName(rs.getString("companyName"));
                jobdetails.setJobType(rs.getString("jobType"));
                jobdetails.setLocation(rs.getString("location"));
                jobdetails.setEducationQualification(rs.getString("educationQualification"));
                jobdetails.setDescription(rs.getString("description"));
                jobdetails.setResponsibilities(rs.getString("responsibilities"));
                jobdetails.setRequirements(rs.getString("requirements"));
                jobdetails.setClosingDate(rs.getString("closingDate"));
                jobdetails.setSalary(rs.getString("salary"));
                jobdetails.setPostingDate(rs.getString("postingDate"));
                jobdetails.setExperience(rs.getString("experience"));
                System.out.println("jobDetails:" + jobdetails.getJobTitle());

            }
        } catch (SQLException ex) {
            //  logger.error(ex.getMessage() + LocalDateTime.now());
        }
        return jobdetails;
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
