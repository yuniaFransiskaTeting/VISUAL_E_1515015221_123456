/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas7;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Yunia Fransiska
 */
public class koneksi {
      private static Connection con;
        
       public static Connection getConnection(){
           try{
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/praktikum_visual","root", "");
               JOptionPane.showMessageDialog(null, "koneksi berhasil");
           } catch(SQLException e){
               JOptionPane.showMessageDialog(null, "koneksi gagal :" +e.getMessage());
           }
           return con;
       } 
}
