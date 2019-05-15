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
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alex
 */
public class FXML_911Controller implements Initializable {

    @FXML private WebView video;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        video.getEngine().load("https://www.youtube.com/embed/EqP6HaEiDus?autoplay=1&controls=0");
        video.setPrefSize(1600, 900);
    }
    
    @FXML
    private void loadMenu(ActionEvent event) throws IOException {
        video.getEngine().load(null);
        Parent parent = FXMLLoader.load(getClass().getResource("FXML_Home.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
