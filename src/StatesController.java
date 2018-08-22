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
        labels[0].setStyle("-fx-background-color: yellow; -fx-background-radius: 50%");
    }

    public void reset() {
        for(int i = 0; i < labels.length; i++) {
            labels[i].setStyle("-fx-background-color: skyblue; -fx-background-radius: 50%");
        }
    }



}
