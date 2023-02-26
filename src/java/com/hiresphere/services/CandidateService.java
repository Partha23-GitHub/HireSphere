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

/**
 *
 * @author user
 */
public class CandidateService {

    public static Candidate getCandidateById(int candidateId) {
        Candidate candidate = new Candidate();
        String sql = "SELECT * FROM candidates where candidateId=1";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            // ps.setInt(1, candidateId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                candidate.setCandidateId(rs.getInt("candidateId"));
                candidate.setUserId(rs.getInt("userId"));
                candidate.setName(rs.getString("name"));
                candidate.setGender(rs.getString("gender"));
                candidate.setPhoneNumber(rs.getString("phoneNumber"));
                candidate.setCity(rs.getString("city"));
                candidate.setState(rs.getString("state"));
                candidate.setCountry(rs.getString("country"));

            }
        } catch (SQLException ex) {
            //    logger.error(ex.getMessage() + LocalDateTime.now());
        }
        return candidate;
    }

    public static boolean updateCandidateProfile(Candidate candidate, int candidateId) {

        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();

            String sql = "UPDATE hiresphere.candidates\n"
                    + "SET \n"
                    + "gender = ? , phoneNumber = ? , city = ?,state = ?, country=? \n"
                    + "WHERE candidateId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            //preparedStatement.setString(1, candidate.getName());
            preparedStatement.setString(1, candidate.getGender());
            preparedStatement.setString(2, candidate.getPhoneNumber());
            preparedStatement.setString(3, candidate.getCity());
            preparedStatement.setString(4, candidate.getState());
            preparedStatement.setString(5, candidate.getCountry());

            preparedStatement.setInt(6, candidateId);
            System.out.println("sql=" + preparedStatement);
            System.out.println("Success From Update");

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
//Logger log =  Logger.getLogger(CandidateService.class.getName());
//            log.error("ERROR:" +ex.getMessage()+"@"+LocalDateTime.now());
            System.out.println("Failure From Service Class Update Method");
        }
        return result;
    }

}
