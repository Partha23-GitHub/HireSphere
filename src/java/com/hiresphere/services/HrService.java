/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.services;

import com.hiresphere.models.HR;
import com.hiresphere.models.JobApplication;
import com.hiresphere.models.JobDetails;
import com.hiresphere.models.User;
import com.hiresphere.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class HrService {

    /**
     *
     */
    public static HrService hrService = null;

    /**
     *
     * @param userId
     * @return
     *  This method will make query on the database and get the details of the particular hr  by taking the userId from session
     */
    public static HR getHrByUserId(int userId) {
        HR hr = new HR();
        String sql = "SELECT * from hr h, companies c  where h.companyId=c.companyId having userId=?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hr.setHrId(rs.getInt("hrId"));
                hr.setUserId(rs.getInt("userId"));
                hr.setGender(rs.getString("gender"));

                hr.setContactNumber(rs.getString("contactNumber"));
                hr.setCompanyName(rs.getString("companyName"));

            }
        }catch (SQLException ex) {
            Logger log = Logger.getLogger(HrService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+ex.getErrorCode()+" "+ex.getMessage());
         
        }
         catch (Exception ex) {
            Logger log = Logger.getLogger(HrService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+" "+ex.getMessage());
         
        }
        return hr;
    }

    /**
     *
     * @param userId
     * @return
     * This method is responsible for inserting the registered data into database while Hr is Signing Up.
     */
    public static boolean doRegisterHr(int userId) {

        boolean result = false;
        Connection con = JDBCConnectionManager.getConnection();

        String sql = "INSERT INTO hr(userId) VALUES(?)";

        try {

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            int rs = preparedStatement.executeUpdate();

            if (rs != 0) {
                result = true;
            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        return result;

    }

    private HrService() {
    }

    /**
     *
     * @return
     */
    public static HrService getInstance() {
        if (hrService == null) {
            return new HrService();
        } else {
            return hrService;
        }
    }

    /**
     *
     * @param userId
     * @return
     * This method is mainly search in the database about all the job that are posted by the particular Hr and return the all the job result.
     */
    public ArrayList getAllJobPostedByHr(int userId) {
        ArrayList jobList = new ArrayList();
        String sql = "Select * from jobdetails where userId=?";
        Connection con = JDBCConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                JobDetails jobdetails = new JobDetails();
                jobdetails.setJobTitle(rs.getString("jobTitle"));
                jobdetails.setLocation(rs.getString("location"));
                jobdetails.setSalary(rs.getString("salary"));
                jobdetails.setClosingDate(rs.getString("closingDate"));
                jobdetails.setJobType(rs.getString("jobType"));
                jobdetails.setJobId(rs.getInt("jobId"));
                jobList.add(jobdetails);
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(HrService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+ex.getErrorCode()+" "+ex.getMessage());
         
        }
         catch (Exception ex) {
            Logger log = Logger.getLogger(HrService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+" "+ex.getMessage());
         
        }
        System.out.println(jobList.size());
        return jobList;
    }

    /**
     *
     * @param userId
     * @return
     * This method takes userId as parameter and search in the hr table then return the hrId corresponding to the userId.
     */
    public int getHrId(int userId) {
        HR hr = new HR();
        String sql = "Select hrId from hr where userId=?";
        Connection con = JDBCConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                hr.setHrId(rs.getInt("hrId"));
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(HrService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+ex.getErrorCode()+" "+ex.getMessage());
         
        }
         catch (Exception ex) {
            Logger log = Logger.getLogger(HrService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+" "+ex.getMessage());
         
        }
        int id = hr.getHrId();
        return id;
    }

    /**
     *
     * @param hr
     * @param hrId
     * @return
     * This method is taking t parameter Hr and hrId and putting all the hr data data are need to update and update all data corresponding to the HrIds
     */
    public static boolean updateHRProfile(HR hr, int hrId) {

        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();

            String sql = "UPDATE hiresphere.hr\n"
                    + "SET \n"
                    + "gender = ? , contactNumber = ?  \n"
                    + "WHERE hrId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            //preparedStatement.setString(1, hr.getName());
            preparedStatement.setString(1, hr.getGender());
            preparedStatement.setString(2, hr.getContactNumber());
            //   preparedStatement.setString(3, hr.getCompanyName());

            preparedStatement.setInt(3, hrId);
            System.out.println("sql=" + preparedStatement);
            System.out.println("Success From Update");

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(HrService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+ex.getErrorCode()+" "+ex.getMessage());
         
        }
         catch (Exception ex) {
            Logger log = Logger.getLogger(HrService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+" "+ex.getMessage());
         
        }
        return result;
    }

    /**
     *
     * @param userId
     * @return
     * this method is only count the number of job that are posted by the particular Hr.
     */
    public int countNumberOfPostedJobs(int userId) {
        int postedJobs = 0;
        try {
            Connection con = JDBCConnectionManager.getConnection();

            String sql = "select count(jobTitle) from jobdetails where userId=?;";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            //preparedStatement.setString(1, hr.getName());
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                postedJobs = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(HrService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+ex.getErrorCode()+" "+ex.getMessage());
         
        }
         catch (Exception ex) {
            Logger log = Logger.getLogger(HrService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+" "+ex.getMessage());

            //Logger log =  Logger.getLogger(HRService.class.getName());
            //log.error("ERROR:" +ex.getMessage()+"@"+LocalDateTime.now());
            ex.printStackTrace();
            System.out.println("Failure From Service Class Update Method");
        }
        System.out.println("Posted Jobs :" + postedJobs);
        return postedJobs;
    }

    /**
     *
     * @param hrId
     * @return
     * This method is counting the number of application are has been done for all the jobs that has been posted by the particular Hr
     */
    public int getTotalApplication(int hrId) {
        int totalApplication = 0;
        try {
            Connection con = JDBCConnectionManager.getConnection();

            String sql = "SELECT count(applicationId) FROM hiresphere.jobapplication where hrId=?;";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            //preparedStatement.setString(1, hr.getName());
            preparedStatement.setInt(1, hrId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                totalApplication = rs.getInt(1);
            }
        }catch (SQLException ex) {
            Logger log = Logger.getLogger(HrService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+ex.getErrorCode()+" "+ex.getMessage());
         
        }
         catch (Exception ex) {
            Logger log = Logger.getLogger(HrService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+" "+ex.getMessage());
       }
        return totalApplication;
    }

    /**
     * @param hrId
     * @return
     * This method counts total candidate that has been shortlisted by the Hr
     */
    public int getTotalShortlisted(int hrId) {
        int totalShortlisted = 0;
        try {
            Connection con = JDBCConnectionManager.getConnection();

            String sql = "SELECT count(applicationStatus) FROM hiresphere.jobapplication where hrId=? and applicationStatus=1;";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            //preparedStatement.setString(1, hr.getName());
            preparedStatement.setInt(1, hrId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                totalShortlisted = rs.getInt(1);
            }

        }catch (SQLException ex) {
            Logger log = Logger.getLogger(HrService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+ex.getErrorCode()+" "+ex.getMessage());
         
        }
         catch (Exception ex) {
            Logger log = Logger.getLogger(HrService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+" "+ex.getMessage());
         
        }
        return totalShortlisted;
    }

    /**
     *
     * @param userId
     * @return
     * This method count the total number od jobs that are not approved by HrManager to be published in candidate side
     */
    public int getTotalPending(int userId) {
        int totalPending = 0;
        try {
            Connection con = JDBCConnectionManager.getConnection();

            String sql = "select count(hrManagerVerificationStatus) from jobdetails where userId=? and hrManagerVerificationStatus=0;";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            //preparedStatement.setString(1, hr.getName());
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                totalPending = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(HrService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+ex.getErrorCode()+" "+ex.getMessage());
         
        }
         catch (Exception ex) {
            Logger log = Logger.getLogger(HrService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+" "+ex.getMessage());
         
            //Logger log =  Logger.getLogger(HRService.class.getName());
            //log.error("ERROR:" +ex.getMessage()+"@"+LocalDateTime.now());
            ex.printStackTrace();
            System.out.println("Failure From Service Class Update Method");
        }
        return totalPending;
    }

    /**
     *
     * @param userId
     * @return
     * This method counts total number of job that are verified by the HrManager till date
     */
    public int getTotalVerified(int userId) {
        int totalPending = 0;
        try {
            Connection con = JDBCConnectionManager.getConnection();

            String sql = "select count(hrManagerVerificationStatus) from jobdetails where userId=? and hrManagerVerificationStatus=1;";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            //preparedStatement.setString(1, hr.getName());
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                totalPending = rs.getInt(1);
            }

        }  catch (SQLException ex) {
            Logger log = Logger.getLogger(HrService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+ex.getErrorCode()+" "+ex.getMessage());
         
        }
         catch (Exception ex) {
            Logger log = Logger.getLogger(HrService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+" "+ex.getMessage());

        }
        return totalPending;
    }

}
