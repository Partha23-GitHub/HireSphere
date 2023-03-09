/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.services;

import com.hiresphere.models.Candidate;
import com.hiresphere.models.HR;
import com.hiresphere.models.JobApplication;
import com.hiresphere.utils.JDBCConnectionManager;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class JobApplicationService {

    public static ArrayList doGetJobApplicationByCandidate(int candidateId) throws IOException {
        ArrayList jobApplicationList = new ArrayList();
        Connection con = JDBCConnectionManager.getConnection();
        String sql = " SELECT applicationId, candidates.candidateId,candidates.resume, jobdetails.jobId,companyName, jobTitle, jobType,applicationMessage\n"
                + "                 FROM jobapplication inner join candidates on jobapplication.candidateId=candidates.candidateId inner join jobdetails on \n"
                + "                 jobapplication.jobId=jobdetails.jobId inner join jobapplicationstatuses on jobapplication.applicationStatus=jobapplicationstatuses.applicationStatus where candidates.candidateId=?;";
//"SELECT ja.applicationId, ja.candidateId, ja.jobId,companyName, jobTitle, jobType,ja.applicationStatus,applicationMessage\n"
//                + "                 FROM hiresphere.jobapplication ja, jobdetails jd, hr h, candidates c,jobapplicationstatuses js\n"
//                + "                 WHERE ja.candidateId = c.candidateId\n"
//                + "                 AND ja.hrId = h.hrId\n"
//                + "                 AND ja.jobId = jd.jobId\n"
//                + "                 AND ja.applicationStatus=js.applicationStatus\n"
//                + "                 AND c.candidateId = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, candidateId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                JobApplication jobApplication = new JobApplication();
                //jobApplication.setApplicationId(rs.getInt("applicationId"));
                jobApplication.setCandidateId(rs.getInt("candidateId"));
                jobApplication.setJobId(rs.getInt("jobId"));
                jobApplication.setCompanyName(rs.getString("companyName"));
                jobApplication.setJobTitle(rs.getString("jobTitle"));
                jobApplication.setJobType(rs.getString("jobType"));
//              jobApplication.setAppicationStatus(rs.getInt("applicationStatus"));
                jobApplication.setResumePath(rs.getString("resume"));
                jobApplication.setApplicationMessage(rs.getString("applicationMessage"));
                        
//              
                jobApplicationList.add(jobApplication);

            }
        } catch (SQLException ex) {

        }

        return jobApplicationList;
    }

    public static ArrayList doGetApplicationByHrId(HR hr) {
        ArrayList applicantList = new ArrayList();
        String sql = "SELECT ca.candidateId,ca.name,ca.gender,ca.phoneNumber,ca.resume,ja.jobId\n"
                + "from candidates ca,jobapplication ja\n"
                + "where ja.candidateId=ca.candidateId\n"
                + "and hrId=?";
        Connection con = JDBCConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                JobApplication applicant = new JobApplication();
                applicant.setCandidateId(rs.getInt("candidateId"));
                applicant.setCandidateName(rs.getString("name"));
                applicant.setCandidateGender(rs.getString("gender"));
                applicant.setCandidatePhoneNumber(rs.getString("phoneNumber"));
                applicant.setJobId(rs.getInt("jobId"));
                applicant.setResumePath(rs.getString("resume"));
                applicantList.add(applicant);
                System.out.println("this is comment:" + applicant.getCandidateName());
            }

        } catch (SQLException ex) {

        }

        return applicantList;

    }

    public static ArrayList getAllApplicant(JobApplication aThis) {
        ArrayList applicantList = new ArrayList();
        String sql = "SELECT ca.candidateId,ca.name,ca.gender,ca.phoneNumber,ca.resume\n"
                + "from candidates ca,jobapplication ja\n"
                + "where ja.candidateId=ca.candidateId\n"
                + "and jobId=?";
        Connection con = JDBCConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                JobApplication applicant = new JobApplication();
                applicant.setCandidateId(rs.getInt("candidateId"));
                applicant.setCandidateName(rs.getString("name"));
                applicant.setCandidateGender(rs.getString("gender"));
                applicant.setCandidatePhoneNumber(rs.getString("phoneNumber"));
                applicant.setJobId(rs.getInt("jobId"));
                applicant.setResumePath(rs.getString("resume"));
                applicantList.add(applicant);
                System.out.println("this is comment:" + applicant.getCandidateName());
            }

        } catch (SQLException ex) {

        }

        return applicantList;
    }

    public static ArrayList getApplicantByJobId(int jobId) {
        ArrayList applicantList = new ArrayList();
        String sql = "SELECT ca.candidateId,u.name,u.email,ca.gender,ca.phoneNumber,ca.resume,ja.applicationId ,ja.applicationStatus,ja.jobId\n"
                + "                 from candidates ca,jobapplication ja,users u where \n"
                + "                   ja.candidateId = ca.candidateId and ca.userId=u.userId\n"
                + "                 and jobId=?;";
        Connection con = JDBCConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, jobId);
            System.out.println("Prepared Statement is :: " + preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Candidate applicant = new Candidate();
                applicant.setCandidateId(rs.getInt("candidateId"));
                applicant.setName(rs.getString("name"));
                applicant.setEmail(rs.getString("email"));
                applicant.setGender(rs.getString("gender"));
                applicant.setPhoneNumber(rs.getString("phoneNumber"));
                applicant.setApplicationId(rs.getInt("applicationId"));
                applicant.setApplicationStatus(rs.getInt("applicationStatus"));
                applicant.setJobId(rs.getInt("jobId"));
                applicant.setResumePath(rs.getString("resume"));
                applicantList.add(applicant);
                System.out.println("this is comment:" + applicant.getName());
            }

        } catch (SQLException ex) {

        }

        return applicantList;
    }

    public static boolean updateApplicationStatus(int applicationId) {
        boolean success = false;
        String sql = "UPDATE hiresphere.jobapplication\n"
                + "SET\n"
                + "applicationStatus = ?\n"
                + "WHERE applicationId = ?;";
        Connection con = JDBCConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, applicationId);
            System.out.println(preparedStatement);

            int execute = preparedStatement.executeUpdate();
            System.out.println("execute :: " + execute);
            if (execute != 0) {
                success = true;
            }
        } catch (SQLException ex) {

        }
        return success;
    }

    public static boolean doApplyJob(JobApplication jobApplication) {
        boolean result = false;

        Connection con = JDBCConnectionManager.getConnection();

        String sql = "INSERT INTO hiresphere.jobapplication (candidateId, hrId, jobId) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setInt(1, jobApplication.getCandidateId());
            preparedStatement.setInt(2, jobApplication.getHrId());
            preparedStatement.setInt(3, jobApplication.getJobId());

            System.out.println("preparedstatement :" + preparedStatement);
            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                result = true;

            }
        } catch (SQLException ex) {

        }

        return result;
    }

    public static boolean rejectApplication(int applicationId) {
        boolean success = false;
        String sql = "UPDATE hiresphere.jobapplication\n"
                + "SET\n"
                + "applicationStatus = ?\n"
                + "WHERE applicationId = ?;";
        Connection con = JDBCConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, 2);
            preparedStatement.setInt(2, applicationId);
            System.out.println(preparedStatement);

            int execute = preparedStatement.executeUpdate();
            System.out.println("execute :: " + execute);
            if (execute != 0) {
                success = true;
            }
        } catch (SQLException ex) {

        }
        return success;
    }

}
