/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.services;

import com.hiresphere.models.HR;
import com.hiresphere.models.JobApplication;
import com.hiresphere.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class JobApplicationService {

    public static ArrayList doGetJobApplicationByCandidate(int candidateId) {
        ArrayList jobApplicationList = new ArrayList();
        Connection con = JDBCConnectionManager.getConnection();
        String sql = "SELECT ja.applicationId, ja.candidateId, ja.jobId,companyName, jobTitle, jobType,ja.applicationStatus,applicationMessage\n"
                + "                 FROM hiresphere.jobapplication ja, jobdetails jd, hr h, candidates c,jobapplicationstatuses js\n"
                + "                 WHERE ja.candidateId = c.candidateId\n"
                + "                 AND ja.hrId = h.hrId\n"
                + "                 AND ja.jobId = jd.jobId\n"
                + "                 AND ja.applicationStatus=js.applicationStatus\n"
                + "                 AND c.candidateId = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, candidateId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                JobApplication jobApplication = new JobApplication();
                jobApplication.setApplicationId(rs.getInt("applicationId"));
                jobApplication.setCandidateId(rs.getInt("candidateId"));
                jobApplication.setJobId(rs.getInt("jobId"));
                jobApplication.setCompanyName(rs.getString("companyName"));
                jobApplication.setJobTitle(rs.getString("jobTitle"));
                jobApplication.setJobType(rs.getString("jobType"));

                jobApplication.setAppicationStatus(rs.getInt("applicationStatus"));
                jobApplication.setApplicationMessage(rs.getString("applicationMessage"));
                jobApplicationList.add(jobApplication);

            }
        } catch (SQLException ex) {

        }

        return jobApplicationList;
    }

    public static ArrayList doGetApplicationByHrId(HR hr) {
        ArrayList applicantList = new ArrayList();
        String sql = "SELECT ca.candidateId,ca.name,ca.gender,ca.phoneNumber,ja.jobId\n"
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
                applicantList.add(applicant);
                System.out.println("this is comment:" + applicant.getCandidateName());
            }

        } catch (SQLException ex) {

        }

        return applicantList;

    }

    public static ArrayList getAllApplicant(JobApplication aThis) {
        ArrayList applicantList = new ArrayList();
        String sql = "SELECT ca.candidateId,ca.name,ca.gender,ca.phoneNumber\n"
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
                applicantList.add(applicant);
                System.out.println("this is comment:" + applicant.getCandidateName());
            }

        } catch (SQLException ex) {

        }

        return applicantList;
    }

}
