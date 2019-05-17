/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forzaapp.quiz;
import forzaapp.FXML_HomeController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author alex
 */
public class FXML_QuizController implements Initializable {

    @FXML private Button ok;
    @FXML private Button quit;
    @FXML private Text question;
    @FXML private Text question_nb;
    @FXML private RadioButton choice_0;
    @FXML private RadioButton choice_1;
    @FXML private RadioButton choice_2;
    @FXML private RadioButton choice_3;
    
    private int count; //count for question number
    private int score; //final score
    private int nbQuestions = 3;
    private boolean mandatory; //to verify there is at least one answer from usr
    private List<RadioButton> list;
    private QuizModel model;

    public FXML_QuizController() throws Exception {
        model = new QuizModel();
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        count = 1;
        score = 0;
        loadQuestion(1);
        quit.setVisible(false);
        
        list = new ArrayList<>(4);
        list.add(choice_0);
        list.add(choice_1);
        list.add(choice_2);
        list.add(choice_3);
    }
    
    private void verify(int usrAnswer) {
        if (model.getAllAnswers(count-1)[usrAnswer].equals(model.getCorrect(count-1)))
            score++;
    }
    
    private void displayScore() {
        question_nb.setText("Results");
        question.setText("your score is : "+score+"/"+nbQuestions);
        for (RadioButton rb : list)
            rb.setVisible(false);
        ok.setVisible(false);
        quit.setVisible(true);
    }
    
    @FXML
    private void loadQuestion(int i) {
        question_nb.setText("Question "+i);
        question.setText(model.getQuestion(i-1));
        
        /*for (int j = 0; j < nbQuestions; j++) {
            list.get(j).setText(model.getAllAnswers(i-1)[j]);
        }*/
        choice_0.setText(model.getAllAnswers(i-1)[0]);
        choice_1.setText(model.getAllAnswers(i-1)[1]);
        choice_2.setText(model.getAllAnswers(i-1)[2]);
        choice_3.setText(model.getAllAnswers(i-1)[3]);
    }
    
    @FXML
    private void okButton(ActionEvent event) throws IOException {
        if (mandatory) {
            
            int usrAnswer = 0; //temp var to get user answer
            
            for (RadioButton rb : list) {
                if (rb.isSelected()) {
                    rb.setSelected(false); //reset RadioButton
                    verify(usrAnswer);
                }
                usrAnswer++;
            }
            count++;
            if (count <= nbQuestions)
                loadQuestion(count);
            else
                displayScore();
            
            mandatory = false;
        }
    }
    
    @FXML
    private void loadHome(ActionEvent event) throws IOException {
        FXML_HomeController c = new FXML_HomeController();
        c.loadHome(event);
        //Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //stage.close();
    }
    
    /* ====================================================================== */
    
    @FXML
    private void handle0(ActionEvent event) {
        mandatory = true;
        if (choice_1.isSelected()) choice_1.setSelected(false);
        if (choice_2.isSelected()) choice_2.setSelected(false);
        if (choice_3.isSelected()) choice_3.setSelected(false);
    }
    
    @FXML
    private void handle1(ActionEvent event) {
        mandatory = true;
        if (choice_0.isSelected()) choice_0.setSelected(false);
        if (choice_2.isSelected()) choice_2.setSelected(false);
        if (choice_3.isSelected()) choice_3.setSelected(false);
    }
    
    @FXML
    private void handle2(ActionEvent event) {
        mandatory = true;
        if (choice_0.isSelected()) choice_0.setSelected(false);
        if (choice_1.isSelected()) choice_1.setSelected(false);
        if (choice_3.isSelected()) choice_2.setSelected(false);
    }
    
    @FXML
    private void handle3(ActionEvent event) {
        mandatory = true;
        if (choice_0.isSelected()) choice_0.setSelected(false);
        if (choice_1.isSelected()) choice_1.setSelected(false);
        if (choice_2.isSelected()) choice_2.setSelected(false);
    }
}
