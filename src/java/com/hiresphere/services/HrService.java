/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.services;


import com.hiresphere.models.HR;
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
        } catch (SQLException ex) {
            //    logger.error(ex.getMessage() + LocalDateTime.now());
        }
        return hr;
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

    public int getHrId(int hrId) {
        HR hr=new HR();
        String sql="Select hrId from hr where userId=?";
        Connection con = JDBCConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, hrId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                hr.setHrId(rs.getInt("hrId"));
            }
            

        } catch (SQLException ex) {

        }
        int id=hr.getHrId();
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
//Logger log =  Logger.getLogger(HRService.class.getName());
//            log.error("ERROR:" +ex.getMessage()+"@"+LocalDateTime.now());
            System.out.println("Failure From Service Class Update Method");
        }
        return result;
    }
 

}
