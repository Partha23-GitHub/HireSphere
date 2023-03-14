/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.services;

import com.hiresphere.models.HrManager;
import com.hiresphere.models.JobDetails;
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
public class HrManagerService {

    /**
     *
     * @param value
     * @return
     * This method will run the below query on the database and fetch all the posted job with all the details and show on the Hr Manager view.
     */
    public static ArrayList getAlljobsByHrManager(int value) {

        ArrayList jobList = new ArrayList();
        String sql = "SELECT jd.jobTitle ,jd.jobtype ,hrManagerVerificationStatus ,jobStatusMessage,jd.jobId FROM hr h inner join hrmanager hm on h.companyId=hm.companyId inner join jobdetails jd on h.userId=jd.userId inner join jobstatuses js on js.jobStatus=jd.jobStatus where hm.userId=?";
        Connection con = JDBCConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, value);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                JobDetails jobdetails = new JobDetails();
                jobdetails.setJobId(rs.getInt("jobId"));
                jobdetails.setJobTitle(rs.getString("jobTitle"));
                jobdetails.setJobStatusMessage(rs.getString("jobStatusMessage"));
                jobdetails.setJobType(rs.getString("jobType"));
                jobdetails.setHrManagerVerificationStatus(rs.getInt("hrManagerVerificationStatus"));
                jobList.add(jobdetails);
            }

        }  catch (SQLException ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+ex.getErrorCode()+" "+ex.getMessage());
         
        }
         catch (Exception ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+" "+ex.getMessage());
         
        }
        System.out.println(jobList.size());
        return jobList;

    }

    /**
     *
     * @param userId
     * @return
     * This method will make query on the database and get the details of the particular hr manager by taking the userId from session 
     */
    public static HrManager getHrManagerByUserId(int userId) {
        HrManager hrManager = new HrManager();
        String sql = "SELECT * from hrmanager h, companies c  where h.companyId=c.companyId having userId=?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            while (rs.next()) {
                hrManager.setHrManagerId(rs.getInt("hrManagerId"));
                hrManager.setUserId(rs.getInt("userId"));
                hrManager.setGender(rs.getString("gender"));

                hrManager.setContactNumber(rs.getString("contactNumber"));
                hrManager.setCompanyName(rs.getString("companyName"));

            }
        } catch (SQLException ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+ex.getErrorCode()+" "+ex.getMessage());
         
        }
         catch (Exception ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+" "+ex.getMessage());
         
        }
        return hrManager;
    }

    /**
     *
     * @param hrManager
     * @param hrManagerId
     * @return
     * This Method is mainly updating the profile of HrManager.
     */
    public static boolean updateHRManagerProfile(HrManager hrManager, int hrManagerId) {
        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();

            String sql = "UPDATE hiresphere.hrmanager\n"
                    + "SET \n"
                    + "gender = ? , contactNumber = ?  \n"
                    + "WHERE hrManagerId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            //preparedStatement.setString(1, hr.getName());
            preparedStatement.setString(1, hrManager.getGender());
            preparedStatement.setString(2, hrManager.getContactNumber());
            //   preparedStatement.setString(3, hr.getCompanyName());

            preparedStatement.setInt(3, hrManagerId);
            System.out.println("sql=" + preparedStatement);
            System.out.println("Success From Update");

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

        }  catch (SQLException ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+ex.getErrorCode()+" "+ex.getMessage());
         
        }
         catch (Exception ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+" "+ex.getMessage());
         
        }
        return result;
    }

    /**
     *
     * @param userId
     * @return
     * This method is responsible for inserting the registered data into database while HrManager is Signing Up.
     */
    public static boolean doRegisterHrManager(int userId) {
        boolean result = false;
        Connection con = JDBCConnectionManager.getConnection();

        String sql = "INSERT INTO hrmanager(userId) VALUES(?)";

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

}
