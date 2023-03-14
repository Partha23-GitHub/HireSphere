/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hiresphere.models;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Meghna
 */
public class MD5Encryption {
    
    public static String encryptPassword(String password) {
        BigInteger bigInt = new BigInteger("0");
        try{
        MessageDigest md= MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(password.getBytes());
        bigInt=new BigInteger(1,messageDigest);
        }
        
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
        
        return bigInt.toString(16);
    }
    
    
   

    
            
}
