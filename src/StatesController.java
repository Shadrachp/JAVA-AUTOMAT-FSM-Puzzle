import javafx.fxml.FXML;
import javafx.scene.control.Label;

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

    public void updateSolution(String string, boolean isValid, boolean isSolution) {
        reset();
        String[] states = string.split("<-");
        for(int i = 0; i < states.length; i++) {
            String str = states[i].substring(1);
            System.out.println(str);
            updateStates(str, isValid, isSolution);
        }

    }

    public void updateStates(String string, boolean isValid, boolean isSolution) {
        switch(string) {
            case "00000": setColor(label0, isValid, isSolution); break;
            case "00110": setColor(label1, isValid, isSolution); break;
            case "00010": setColor(label2, isValid, isSolution); break;
            case "10110": setColor(label3, isValid, isSolution); break;
            case "00100": setColor(label4, isValid, isSolution); break;
            case "01110": setColor(label5, isValid, isSolution); break;
            case "00111": setColor(label6, isValid, isSolution); break;
            case "00001": setColor(label7, isValid, isSolution); break;
            case "01000": setColor(label8, isValid, isSolution); break;
            case "11010": setColor(label9, isValid, isSolution); break;
            case "01111": setColor(label10, isValid, isSolution); break;
            case "11110": setColor(label11, isValid, isSolution); break;
            case "11000": setColor(label12, isValid, isSolution); break;
            case "10111": setColor(label13, isValid, isSolution); break;
            case "00101": setColor(label14, isValid, isSolution); break;
            case "10000": setColor(label15, isValid, isSolution); break;
            case "11011": setColor(label16, isValid, isSolution); break;
            case "10001": setColor(label17, isValid, isSolution); break;
            case "11001": setColor(label18, isValid, isSolution); break;
            case "11101": setColor(label19, isValid, isSolution); break;
            case "01001": setColor(label20, isValid, isSolution); break;

            case "11111": setColor(label21, isValid, isSolution); break;
            default: setColor(dead, isValid, isSolution);
        }
    }

    public void setColor(Label label, boolean isValid, boolean isSolution) {
//        reset();

        if(isValid) {
            if(isSolution) {
                label.setStyle("-fx-background-color: green; -fx-background-radius: 50%");
                System.out.println("isSolution");
                System.out.println("label: "+label.getText());
            }
            else {
                System.out.println("notsol");
                label.setStyle("-fx-background-color: yellow; -fx-background-radius: 50%");
            }

        }

        else {
            label.setStyle("-fx-background-color: red; -fx-background-radius: 50%");
        }


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
