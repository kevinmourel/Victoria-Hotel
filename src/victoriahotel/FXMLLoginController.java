/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victoriahotel;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class FXMLLoginController implements Initializable {

    @FXML
    private JFXButton Login;
    @FXML
    private JFXButton Daftar;
    @FXML
    private JFXTextField Username;
    @FXML
    private JFXPasswordField Password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SignIn(ActionEvent event) throws IOException, SQLException {
        Connection connection;
        PreparedStatement ps;
        String user;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/victoria_hotel", "root", "");
            ps = connection.prepareStatement("SELECT * FROM `akun` WHERE `username` = ? AND `password` = ?");
            ps.setString(1, Username.getText());
            ps.setString(2, Password.getText());
            ResultSet result = ps.executeQuery();
            if (result.next()) { 
            ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLHome.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Homepage");
            stage.show();
                
            } else {
                Component rootPane = null;
                JOptionPane.showMessageDialog(null, "Salah");
                Password.setText("");
                Username.requestFocus();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal");
        }
    }  
    

    @FXML
    private void SignUp(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Form");
            stage.show();
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
        

    }
}