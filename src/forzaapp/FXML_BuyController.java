/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forzaapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.awt.Desktop;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alex
 */
public class FXML_BuyController implements Initializable {
    
    @FXML
    private WebView webView;
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*WebEngine engine = webView.getEngine();
        engine.load("https://www.google.fr");*/
    }    
    
    @FXML
    private void loadMenu(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("FXML_Home.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void buy1(ActionEvent event) throws IOException, URISyntaxException {
        String url = "http://www.google.com";

        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
