/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.services;


import com.hiresphere.models.JobApplication;
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

    public ArrayList getAllJobPostedByHr(int userId){
        ArrayList jobList= new ArrayList();
        String sql ="Select * from jobdetails where userId=?";
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

        }
        System.out.println(jobList.size());
        return jobList;
    }

}
