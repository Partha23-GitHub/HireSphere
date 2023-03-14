/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.services;

import com.hiresphere.models.Candidate;
import com.hiresphere.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class CandidateService {

    /**
     *
     * @param userId
     * @return 
     * it take the request and by the userId it fetch the details of
     * that particular candidate and return the candidate details to the calling
     * method
     */
    public static Candidate getCandidateByUserId(int userId) {
        Candidate candidate = new Candidate();
        String sql = "SELECT * FROM candidates where userId=?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                candidate.setCandidateId(rs.getInt("candidateId"));
                candidate.setUserId(rs.getInt("userId"));
                candidate.setGender(rs.getString("gender"));
                candidate.setPhoneNumber(rs.getString("phoneNumber"));
                candidate.setCity(rs.getString("city"));
                candidate.setState(rs.getString("state"));
                candidate.setCountry(rs.getString("country"));
                candidate.setResumePath(rs.getString("resume"));
            }
        } catch (SQLException ex) {
            Logger log = Logger.getLogger(CandidateService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getErrorCode() + " " + ex.getMessage());

        } catch (Exception ex) {
            Logger log = Logger.getLogger(CandidateService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());

        }
        return candidate;
    }

    /**
     *
     * @param candidateId
     * @return 
     * This method is also responsible for fetching a particular
     * candidate details from database by the given candidatId and return the
     * details to the calling method.
     */
    public static Candidate getCandidateByCandidateId(int candidateId) {
        Candidate candidate = new Candidate();
        String sql = "SELECT resume FROM candidates where candidateId=?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, candidateId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                candidate.setResumePath(rs.getString("resume"));
            }
        } catch (SQLException ex) {
            Logger log = Logger.getLogger(CandidateService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getErrorCode() + " " + ex.getMessage());

        } catch (Exception ex) {
            Logger log = Logger.getLogger(CandidateService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());

        }
        return candidate;
    }

    /**
     *
     * @param candidate
     * @param candidateId
     * @param uploadPath
     * @return 
     * This method is mainly responsible for updating the profile of
     * candidate. It takes parameters from the calling methods and store it on
     * the database
     */
    public static boolean updateCandidateProfile(Candidate candidate, int candidateId, String uploadPath) {
        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();

            String sql = "UPDATE hiresphere.candidates\n"
                    + "SET \n"
                    + "gender = ? , phoneNumber = ? , city = ?,state = ?, country=?,resume=?\n"
                    + "WHERE candidateId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            //setting up the file input strea
            preparedStatement.setString(1, candidate.getGender());
            preparedStatement.setString(2, candidate.getPhoneNumber());
            preparedStatement.setString(3, candidate.getCity());
            preparedStatement.setString(4, candidate.getState());
            preparedStatement.setString(5, candidate.getCountry());
            preparedStatement.setString(6, uploadPath);
            preparedStatement.setInt(7, candidateId);
            System.out.println("sql=" + preparedStatement);
            System.out.println("Success From Update");

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(CandidateService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getErrorCode() + " " + ex.getMessage());

        } catch (Exception ex) {
            Logger log = Logger.getLogger(CandidateService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());

        }
        return result;
    }

    /**
     *
     * @param userId
     * @return
     * When a candidate SignUp this method will called. It just inserted
     * the userId to the candidate table in db. Others details will be filled
     * later by the candidate at the time of update profile
     */
    public static boolean doRegisterCandidate(int userId) {
        boolean result = false;
        Connection con = JDBCConnectionManager.getConnection();

        String sql = "INSERT INTO candidates(userId) VALUES(?)";

        try {

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            int rs = preparedStatement.executeUpdate();

            if (rs != 0) {
                result = true;
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(CandidateService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getErrorCode() + " " + ex.getMessage());

        } catch (Exception ex) {
            Logger log = Logger.getLogger(CandidateService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());

        }

        return result;
    }

}
