import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class StatesController {

    @FXML
    private Label label0, label1;

    private Controller controller;

    public void injectMainController(Controller controller){
        this.controller = controller;
    }
    @FXML
    void initialize() {


    }

    public void updateStates(String string, boolean isValid) {
        switch(string) {
            case "00000": setColor(label0, isValid); break;
            case "00110": setColor(label1, isValid); break;

        }
    }

    public void setColor(Label label, boolean isValid) {
        if(isValid)
            label.setStyle("-fx-background-color: yellow");
        else
            label.setStyle("-fx-background-color: red");

    }

}
