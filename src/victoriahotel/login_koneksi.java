/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victoriahotel; 
 
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ARIFIN
 */
public class login_koneksi {
    private static Connection koneksi;

    public static Connection GetConnection() throws SQLException {
        if (koneksi == null) {
            Driver driver = new Driver();
            koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/victoria_hotel", "root", "");
        }
        return koneksi;
    }

    static int execute(String SQL) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
