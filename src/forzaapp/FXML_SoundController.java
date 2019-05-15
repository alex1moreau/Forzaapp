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
import javafx.scene.media.MediaPlayer;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alex
 */
public class FXML_SoundController implements Initializable {
    
    private MediaPlayer mediaPlayer;
    @FXML private WebView video;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        video.getEngine().load("https://www.youtube.com/embed/BxCQ3q_3pPo?autoplay=1&controls=0");
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
