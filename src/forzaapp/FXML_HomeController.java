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
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author alex
 */
public class FXML_HomeController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("clicked");
    }
    
    @FXML
    private void loadAbout(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("FXML_About.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void loadCollection(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("FXML_Collection.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void load911(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("FXML_911.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void loadGraph(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("FXML_Graph.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void loadBuy(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("FXML_Buy.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void loadSound(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("FXML_Sound.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void loadQuiz(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("quiz/FXML_Quiz.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void loadCredits(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("FXML_Credits.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void loadHome(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("FXML_Home.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void quitApp(ActionEvent event) throws IOException {        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
