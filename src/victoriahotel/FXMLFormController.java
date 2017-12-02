/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victoriahotel;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class FXMLFormController implements Initializable {

    @FXML
    private JFXTextField Username;
    @FXML
    private JFXTextField Password;
    @FXML
    private JFXTextField Email;
    @FXML
    private JFXButton Daftar;
    @FXML
    private JFXTextField Surename;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SignUp(ActionEvent event) throws IOException {
        Connection con = new koneksi().getConnection();
        Connection connection;
        PreparedStatement ps;
        
        try {
            if(Username.getText().length() !=0 && Password.getText().length() !=0 && Surename.getText().length() !=0 && Email.getText().length() !=0){
            connection = DriverManager.getConnection("jdbc:mysql://localhost/victoria_hotel?zeroDate TimeBehavior=convertToNull", "root", "");
            ps = connection.prepareStatement("insert into akun (username,password,surename,email) values (?,?,?,?)");
            ps.setString(1, Username.getText());
            ps.setString(2, Password.getText());
            ps.setString(3, Surename.getText());
            ps.setString(4, Email.getText());
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Selamat anda berhasil mendaftar"); 
            ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLLogin.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Homepage");
            stage.show();
            }
            else if(Username.getText().length() ==0 || Password.getText().length() ==0 || Surename.getText().length() ==0 || Email.getText().length()==0){
                JOptionPane.showMessageDialog(null, "Mohon isi data dengan lengkap");
                Username.requestFocus();
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal");
        }
    
    }
}