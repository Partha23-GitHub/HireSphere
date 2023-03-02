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
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class HrManagerService {

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

        }
        System.out.println(jobList.size());
        return jobList;

    }

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
            //    logger.error(ex.getMessage() + LocalDateTime.now());
        }
        return hrManager;
    }

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
//Logger log =  Logger.getLogger(HRService.class.getName());
//            log.error("ERROR:" +ex.getMessage()+"@"+LocalDateTime.now());
            System.out.println("Failure From Service Class Update Method");
        }
        return result;
    }

}
