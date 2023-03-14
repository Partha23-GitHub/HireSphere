/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.utils;

import com.hiresphere.services.JobDetailsService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class JDBCUtility {

    /**
     *
     */
    public static JDBCUtility jdbcUtility = null;

    // in this class we will have static methods to get the connection params
    /**
     * @param param
     * @return This method is mainly responsible for analyzing the key values of
     * setting.properties file and return the corresponding value of that key
     * that is asking the by program
     */
    public String getPropertyValue(String param) {

        String value = null;

        //input = getClass().getResourceAsStream("settings.properties"); // Property file path in classpath
        try {

            String path = JDBCUtility.class.getClassLoader().getResource("settings.properties").getPath();

            BufferedReader input = new BufferedReader(new FileReader(path));

            Properties prop = new Properties();

            prop.load(input);

            value = prop.getProperty(param);

        } catch (IOException ex) {
            // TODO Auto-generated catch block
            Logger log = Logger.getLogger(JobDetailsService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());
        } catch (Exception ex) {
            Logger log = Logger.getLogger(JobDetailsService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + " " + ex.getMessage());

        }

        return value;
    }

    private JDBCUtility() {
        // Private constructor
    }

    /**
     *
     * @return
     */
    public static JDBCUtility getInstanceOfJDBCUtility() {
        if (jdbcUtility == null) {
            jdbcUtility = new JDBCUtility();
        }
        return jdbcUtility;
    }

}
