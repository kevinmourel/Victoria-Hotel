/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victoriahotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ARIFIN
 */
public class koneksi {
    Connection koneksi;
    public Connection getConnection(){
        try{
            koneksi=DriverManager.getConnection("jdbc:mysql://localhost/victoria_hotel","root","");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Koneksi ke Database Gagal","Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        return koneksi;
    }
}
