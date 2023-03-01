/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.services;

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

}
