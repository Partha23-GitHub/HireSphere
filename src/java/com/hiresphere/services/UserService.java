/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.services;

import com.hiresphere.utils.JDBCConnectionManager;
import com.hiresphere.models.User;
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
public class UserService {
    public static UserService userService = null;

    public static UserService getInstance() {
        if (userService == null) {
            return new UserService();
        } else {
            return userService;
        }
    }
   

    public static boolean doSignup(User user) {
        boolean result = false;
        Connection con = JDBCConnectionManager.getConnection();

        String sql = "INSERT INTO users(email,password,roleId,name)"
                + "VALUES(? ,? ,? ,?);";
        
        try {

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, 1);
            preparedStatement.setString(4, user.getName());

            int rs = preparedStatement.executeUpdate();

            if (rs != 0) {
                result = true;
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(UserService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+ex.getErrorCode()+" "+ex.getMessage());
         
        }
         catch (Exception ex) {
            Logger log = Logger.getLogger(UserService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+" "+ex.getMessage());
         
        }
        return result;
    }

    public static boolean userExist(String email) {
        String sql="SELECT * from users where email=?";
         try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1, email);

            
            System.out.println("LoginService :: "+ps);
            
            ResultSet rs = ps.executeQuery();
              if (rs.next()) {
               
                return true;
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(UserService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+ex.getErrorCode()+" "+ex.getMessage());
         
        }
         catch (Exception ex) {
            Logger log = Logger.getLogger(UserService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+" "+ex.getMessage());
         
        }

        return false;
        
        
        
    }

    public boolean doLogin(User user)
    {
        boolean success = false;
        
        String sql = "Select * from users where email=? and password=?";
        
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            
            System.out.println("LoginService :: "+ps);
            
            ResultSet rs = ps.executeQuery();
              if (rs.next()) {
               
                success = true;
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(UserService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+ex.getErrorCode()+" "+ex.getMessage());
         
        }
         catch (Exception ex) {
            Logger log = Logger.getLogger(UserService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+" "+ex.getMessage());
         
        }

        return success;
    }
    
    public static User getUser(String email) {
        User user = new User();
        Connection con = JDBCConnectionManager.getConnection();
        String sql = "Select * from users where email=?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, email);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setEmail(rs.getString("email"));
                user.setRoleId(rs.getInt("roleId"));
                user.setName(rs.getString("name"));
                user.setUserId(rs.getInt("userId"));
                // con.close();
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(UserService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+ex.getErrorCode()+" "+ex.getMessage());
         
        }
         catch (Exception ex) {
            Logger log = Logger.getLogger(UserService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+" "+ex.getMessage());
         
        }
        System.out.println("UserId: "+user.getUserId());
        return user;
    }
}
