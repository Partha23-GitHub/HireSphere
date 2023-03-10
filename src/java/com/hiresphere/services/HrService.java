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

    public static HrService hrService = null;

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

    public static HrService getInstance() {
        if (hrService == null) {
            return new HrService();
        } else {
            return hrService;
        }
    }

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

    public int getHrId(int Id) {
        HR hr = new HR();
        String sql = "Select hrId from hr where userId=?";
        Connection con = JDBCConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, Id);
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
       
       } catch (SQLException ex) {
            //Logger log =  Logger.getLogger(HRService.class.getName());
            //log.error("ERROR:" +ex.getMessage()+"@"+LocalDateTime.now());
            ex.printStackTrace();
            System.out.println("Failure From Service Class Update Method");
        }
        return totalApplication;
    }

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
         
        } catch (SQLException ex) {
            //Logger log =  Logger.getLogger(HRService.class.getName());
            //log.error("ERROR:" +ex.getMessage()+"@"+LocalDateTime.now());
            ex.printStackTrace();
            System.out.println("Failure From Service Class Update Method");
        }
        return totalShortlisted;
    }

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

        } catch (SQLException ex) {
            //Logger log =  Logger.getLogger(HRService.class.getName());
            //log.error("ERROR:" +ex.getMessage()+"@"+LocalDateTime.now());
            ex.printStackTrace();
            System.out.println("Failure From Service Class Update Method");
        }
        return totalPending;
    }

}
