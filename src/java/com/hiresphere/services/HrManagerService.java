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

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getErrorCode() + " " + ex.getMessage());

        } catch (Exception ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());

        }
        System.out.println(jobList.size());
        return jobList;

    }

    /**
     *
     * @param userId
     * @return
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
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getErrorCode() + " " + ex.getMessage());

        } catch (Exception ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());

        }
        return hrManager;
    }

    /**
     *
     * @param hrManager
     * @param hrManagerId
     * @return
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

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getErrorCode() + " " + ex.getMessage());

        } catch (Exception ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());

        }
        return result;
    }

    /**
     *
     * @param userId
     * @return
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

    public static int getHrManagerId(int userId) {
        HrManager hrManager = new HrManager();
        String sql = "Select hrManagerId from hrmanager where userId=?";
        Connection con = JDBCConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                hrManager.setHrManagerId(rs.getInt("hrManagerId"));
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getErrorCode() + " " + ex.getMessage());

        } catch (Exception ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());

        }
        int id = hrManager.getHrManagerId();
        return id;
    }

    public static int getComapnyId(int hrManagerId) {
        HrManager hrManager = new HrManager();
        String sql = "Select companyId from hrmanager where hrManagerId=?";
        Connection con = JDBCConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, hrManagerId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                hrManager.setCompanyId(rs.getInt("companyId"));
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getErrorCode() + " " + ex.getMessage());

        } catch (Exception ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());

        }
        int id = hrManager.getCompanyId();
        return id;
    }

    public static int getTotalApplication(int companyId) {

        int totalApplication = 0;
        try {
            Connection con = JDBCConnectionManager.getConnection();

            String sql = "SELECT count(applicationId) FROM hiresphere.jobapplication ja,hr h where ja.hrId=h.hrId and h.companyId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            //preparedStatement.setString(1, hr.getName());
            preparedStatement.setInt(1, companyId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                totalApplication = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getErrorCode() + " " + ex.getMessage());

        } catch (Exception ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());
        }
        return totalApplication;

    }

    public static int countNumberOfPostedJobs(int companyId) {
        int postedJobs = 0;
        try {
            Connection con = JDBCConnectionManager.getConnection();

            String sql = "select count(jobId)from jobdetails jd,users u,hr h where jd.userId=u.userId and u.userId=h.userId and h.companyId=? and hrManagerVerificationStatus=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            //preparedStatement.setString(1, hr.getName());
            preparedStatement.setInt(1, companyId);
            preparedStatement.setInt(2, 1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                postedJobs = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getErrorCode() + " " + ex.getMessage());

        } catch (Exception ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());

            //Logger log =  Logger.getLogger(HRService.class.getName());
            //log.error("ERROR:" +ex.getMessage()+"@"+LocalDateTime.now());
            ex.printStackTrace();
            System.out.println("Failure From Service Class Update Method");
        }
        System.out.println("Posted Jobs :" + postedJobs);
        return postedJobs;
    }

    public static Object getTotalShortlisted(int companyId) {
        int totalShortlisted = 0;
        try {
            Connection con = JDBCConnectionManager.getConnection();

            String sql = "select count(applicationId) from jobapplication ja, hr h where applicationStatus=? and ja.hrId=h.hrId and h.companyId=?;";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            //preparedStatement.setString(1, hr.getName());
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, companyId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                totalShortlisted = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getErrorCode() + " " + ex.getMessage());

        } catch (Exception ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());

        }
        return totalShortlisted;
    }

    public static Object getTotalPending(int companyId) {
        int pendingJobs = 0;
        try {
            Connection con = JDBCConnectionManager.getConnection();

            String sql = "select count(jobId)from jobdetails jd,users u,hr h where jd.userId=u.userId and u.userId=h.userId and h.companyId=? and hrManagerVerificationStatus=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            //preparedStatement.setString(1, hr.getName());
            preparedStatement.setInt(1, companyId);
            preparedStatement.setInt(2, 0);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                pendingJobs = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getErrorCode() + " " + ex.getMessage());

        } catch (Exception ex) {
            Logger log = Logger.getLogger(HrManagerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());

            //Logger log =  Logger.getLogger(HRService.class.getName());
            //log.error("ERROR:" +ex.getMessage()+"@"+LocalDateTime.now());
            ex.printStackTrace();
            System.out.println("Failure From Service Class Update Method");
        }
        System.out.println("Pending Jobs :" + pendingJobs);
        return pendingJobs;
    }

}
