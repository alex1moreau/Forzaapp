package forzaapp.quiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/*
 * @author alex
 */
public final class FileImport
{
    // Simple debug method, just flip: LOG = true
    private static final boolean LOG = false;
    private static void log(String s){ if (LOG) System.out.println(s); };

    /**
     * Method to display an open dialog window and select a file
     * @param quiz is the QuizModel to send file data into
     */
    public static void importQuiz(QuizModel quiz) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Import Quiz");
        fileChooser.setInitialFileName("QuizFile.txt");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            try {
                readFileToQuiz(selectedFile, quiz);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Parser to read a file and compose each row with content into a list.
     * Each list is sent back to the {@code QuizModel} to compose {@code AQuiz}
     * @param f is the file to read
     * @param quiz is the QuizModel to parse data into
     * @throws IOException file not found
     */
    private static void readFileToQuiz(File f, QuizModel quiz) throws IOException{

        if (f.exists()) {
            log("Trying to read:\n" + f.getAbsolutePath());

            FileInputStream file = new FileInputStream(f);
            Scanner read = new Scanner(file);

            String string;
            List<String> list = new LinkedList<String>();

            while (read.hasNext()) {
                string = read.nextLine();						
                log("String: " + string);
                if ((string.isEmpty()) && (!list.isEmpty())) {
                    quiz.addAQuiz(list);						
                    log("List:" + list.toString());
                    list.clear();
                } else if ((!string.isEmpty()) && (!string.substring(0, 1).equals("/"))) {
                    list.add(string);
                }
            }
            quiz.addAQuiz(list);
            read.close();
            log(quiz.toString());

        } else {
                throw new IOException("File not found, aborting!");
        }
    }
}