/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victoriahotel;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class FXMLInformationController implements Initializable {

    ObservableList<String> list1 = FXCollections.observableArrayList("1 Night","2 Night","3 Night","4 Night","5 Night","6 Night","1 Weeks");
    ObservableList<String> list2 = FXCollections.observableArrayList("Standart","Deluxe","Executive");
    ObservableList<String> list3 = FXCollections.observableArrayList("Cash","Credit Card","Pre-pay");
    
    @FXML
    private JFXButton Book;
    @FXML
    private JFXTextField Contact;
    @FXML
    private JFXTextField Email;
    @FXML
    private JFXTextField Surename;
     
    @FXML
    private JFXComboBox<String> Room;
    @FXML
    private JFXDatePicker Date;
    @FXML
    private JFXComboBox<String> Payment;
    @FXML
    private JFXComboBox<String> Stay;
    
    String kontak, mail, nama, stay, room, date, payment;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Stay.setValue("1 Night");
        Stay.setItems(list1);
       
        Room.setValue("Standart");
        Room.setItems(list2);
        
        Payment.setValue("Cash");
        Payment.setItems(list3);
         
    }
    void Kirim(){
        //untuk validasi isian
         if(Contact.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Contact belum terisi");
        }else if (Email.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Email belum terisi");
        }else if(Surename.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nama belum terisi");
        }else if(Stay.getValue().equals("")){
            JOptionPane.showMessageDialog(null, "Nama belum terisi");
        }else if(Room.getValue().equals("")){
            JOptionPane.showMessageDialog(null, "Nama belum terisi");
        }else if(Date.getValue().equals("")){
            JOptionPane.showMessageDialog(null, "Nama belum terisi");
        }else if(Payment.getValue().equals("")){
            JOptionPane.showMessageDialog(null, "Nama belum terisi");
        }
        //untuk pengambilan nilai isian
        kontak = Contact.getText();
        mail = Email.getText();
        nama = Surename.getText();
        stay = Stay.getValue();
        room = Room.getValue();
        date = Date.getValue().toString();
        payment = Payment.getValue();
    }

    @FXML
    private void Booking(ActionEvent event) {
        Kirim();
        try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLNote.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Receipt");
            stage.show();
            
            FXMLNoteController Data = new FXMLNoteController();
            Data = fxmlLoader.getController();
            
            Data.setdata(kontak, mail, nama, stay, room, date, payment);
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
    }
    
}
