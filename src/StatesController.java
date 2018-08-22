import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class StatesController {

    @FXML
    private Label label0, label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11,
                  label12, label13, label14, label15, label16, label17, label18, label19, label20, label21, dead;
    private Label labels[];

    @FXML
    void initialize() {
        labels = new Label[]{label0, label1, label2, label3, label4, label5, label6, label7,
                             label8, label9, label10, label11, label12, label13, label14, label15,
                             label16, label17, label18, label19, label20, label21, dead};

    }

    public void updateStates(String string, boolean isValid) {
        switch(string) {
            case "00000": setColor(label0, isValid); break;
            case "00110": setColor(label1, isValid); break;
            case "00010": setColor(label2, isValid); break;
            case "10110": setColor(label3, isValid); break;
            case "00100": setColor(label4, isValid); break;
            case "01110": setColor(label5, isValid); break;
            case "00111": setColor(label6, isValid); break;
            case "00001": setColor(label7, isValid); break;
            case "01000": setColor(label8, isValid); break;
            case "111010": setColor(label9, isValid); break;
            case "01111": setColor(label10, isValid); break;
            case "11110": setColor(label11, isValid); break;
            case "11000": setColor(label12, isValid); break;
            case "10111": setColor(label13, isValid); break;
            case "00101": setColor(label14, isValid); break;
            case "10000": setColor(label15, isValid); break;
            case "11011": setColor(label16, isValid); break;
            case "10001": setColor(label17, isValid); break;
            case "11001": setColor(label18, isValid); break;
            case "11101": setColor(label19, isValid); break;
            case "01001": setColor(label20, isValid); break;

            case "11111": setColor(label21, isValid); break;
            default: setColor(dead, isValid);
        }
    }

    public void setColor(Label label, boolean isValid) {
        reset();
        if(isValid)
            label.setStyle("-fx-background-color: yellow; -fx-background-radius: 50%");
        else
            label.setStyle("-fx-background-color: red; -fx-background-radius: 50%");

    }

    public void resetStates() {
        reset();
        label0.setStyle("-fx-background-color: yellow; -fx-background-radius: 50%");
        label21.setStyle("-fx-background-color: green; -fx-background-radius: 50%");
    }

    public void reset() {
        for(int i = 0; i < labels.length; i++) {
            labels[i].setStyle("-fx-background-color: skyblue; -fx-background-radius: 50%");
        }
    }



}
