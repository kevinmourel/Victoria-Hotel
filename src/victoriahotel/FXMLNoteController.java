/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victoriahotel;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class FXMLNoteController implements Initializable {

    @FXML
    private Label dataContact;
    @FXML
    private Label dataEmail;
    @FXML
    private Label dataSurename;
    @FXML
    private Label dataStay;
    @FXML
    private Label dataRoom;
    @FXML
    private Label dataDate;
    @FXML
    private Label dataPayment;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    void setdata(String kontak, String mail, String nama, String stay, String room, String date, String payment){
        dataContact.setText(kontak);
        dataEmail.setText(mail);
        dataSurename.setText(nama);
        dataStay.setText(stay);
        dataRoom.setText(room);
        dataDate.setText(date);
        dataPayment.setText(payment);
    }
}

