/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forzaapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author alex
 */
public class FXML_IntroController implements Initializable {
    
    private String dorsetLog;
    private String dorsetPass;
    
    @FXML private TextField loginField;
    @FXML private PasswordField passwordField;
    @FXML private Button welcomeBtn;
    @FXML private Pane loginPane;
    @FXML private Label label;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loginPane.setVisible(false);
        dorsetLog = "dorset";
        dorsetPass = "1234";
    }

    @FXML
    private void loadMenu(ActionEvent event) throws IOException {        
        Parent parent = FXMLLoader.load(getClass().getResource("FXML_Home.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide(); //optional
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void login(ActionEvent event) throws IOException {
        if (dorsetLog.equals(loginField.getText()) && dorsetPass.equals(passwordField.getText()))
            loadMenu(event);
        
        else {
            label.setText("log in error");
            passwordField.clear();
        }
    }
    
    @FXML
    private void welcome(ActionEvent event) throws IOException {
        welcomeBtn.setVisible(false);
        loginPane.setVisible(true);
    }
    
}
