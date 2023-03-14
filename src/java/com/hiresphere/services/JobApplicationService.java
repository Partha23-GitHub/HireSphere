/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.services;

import com.hiresphere.models.Candidate;
import com.hiresphere.models.HR;
import com.hiresphere.models.JobApplication;
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
public class JobApplicationService {

    /**
     *
     * @param candidateId
     * @return This method take candateId as parameter and search all the
     * application that has been applied by the candidate.
     */
    public static ArrayList doGetJobApplicationByCandidate(int candidateId) {
        ArrayList jobApplicationList = new ArrayList();
        Connection con = JDBCConnectionManager.getConnection();
        String sql = " SELECT applicationId, candidates.candidateId,candidates.resume, jobdetails.jobId,companyName, jobTitle, jobType,applicationMessage\n"
                + "                 FROM jobapplication inner join candidates on jobapplication.candidateId=candidates.candidateId inner join jobdetails on \n"
                + "                 jobapplication.jobId=jobdetails.jobId inner join jobapplicationstatuses on jobapplication.applicationStatus=jobapplicationstatuses.applicationStatus where candidates.candidateId=?;";
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
            Logger log = Logger.getLogger(JobApplicationService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getErrorCode() + " " + ex.getMessage());

        } catch (Exception ex) {
            Logger log = Logger.getLogger(JobApplicationService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());

        }

        return jobApplicationList;
    }

    /**
     * @param hr
     * @return This method is mainly responsible for getting all the applied
     * candidate's details that are posted by the Hr.
     */
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
            Logger log = Logger.getLogger(JobApplicationService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getErrorCode() + " " + ex.getMessage());

        } catch (Exception ex) {
            Logger log = Logger.getLogger(JobApplicationService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());

        }

        return applicantList;

    }

    /**
     * @param jobId
     * @return This method find all the candidate that are applied by the
     * candidate. It search of the database corresponding tho the database and
     * return all the applied candidate.
     */
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
            Logger log = Logger.getLogger(JobApplicationService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getErrorCode() + " " + ex.getMessage());

        } catch (Exception ex) {
            Logger log = Logger.getLogger(JobApplicationService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());

        }

        return applicantList;
    }

    /**
     * @param applicationId
     * @return When a Hr try to change the status of the candidate like
     * reject,Shortlisted then this method take the applicationId and change the
     * status in jobApplication table
     */
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
            Logger log = Logger.getLogger(JobApplicationService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getErrorCode() + " " + ex.getMessage());

        } catch (Exception ex) {
            Logger log = Logger.getLogger(JobApplicationService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());

        }
        return success;
    }

    /**
     * @param jobApplication
     * @return This method is inserting data to the jobApplication table
     * whenever candidate apply for a job.
     *
     */
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
            Logger log = Logger.getLogger(JobApplicationService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getErrorCode() + " " + ex.getMessage());

        } catch (Exception ex) {
            Logger log = Logger.getLogger(JobApplicationService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());

        }

        return result;
    }

    /**
     *
     * @param applicationId
     * @return When a Hr try to change the status of the candidate like
     * reject,Shortlisted then this method take the applicationId and change the
     * status in jobApplication table
     */
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
            Logger log = Logger.getLogger(JobApplicationService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getErrorCode() + " " + ex.getMessage());

        } catch (Exception ex) {
            Logger log = Logger.getLogger(JobApplicationService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());

        }
        return success;
    }

}
