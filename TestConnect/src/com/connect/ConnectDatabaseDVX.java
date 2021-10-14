/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Quan Dau
 */
public class ConnectDatabaseDVX {
     Connection con;
     Statement stmt;
     String url;
     String name;
     
     public ConnectDatabaseDVX(String url, String name){
         this.url = url;
         this.name = name;
     }
     
     public Statement getConnection() {
        try {
            Class.forName(name);
           
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();
            return stmt;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
     
      public int Update(String str) {
        try {
            
            stmt = getConnection();
            int i = stmt.executeUpdate(str);
            
            return i;
        } catch (Exception e) {
            return -1;
        }
    }

    public String Query(String str) {
        try {
             stmt = getConnection();
            ResultSet rs = stmt.executeQuery(str);
            String listGhe = "";
             while (rs.next()) {

//                      Ghe ghe = new Ghe(rs.getInt(1),rs.getInt(2),rs.getInt(2));
                        String id = String.valueOf(rs.getInt(1));
                        String sold = String.valueOf(rs.getInt(2));
                        String block = String.valueOf(rs.getInt(3));
                        String u = id + " " + sold + " " + block;
                        listGhe = u + " " + listGhe;
                    }
            return listGhe;
        } catch (Exception e) {
            return null;
        }
    }
    
    
}
