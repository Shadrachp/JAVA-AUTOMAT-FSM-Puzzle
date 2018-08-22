import Model.Makina;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Driver extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("States.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public static void main(String[] args) {
    //test
//       ArrayList<Node> b = new FSM().getFsm(); //initializes fsm
//        for (int i = 0; i < b.size(); i++) {
//            System.out.println(b.get(i).getsType() + " State: " + b.get(i).getState() + "\n");
//            System.out.println("Links: ");
//            for (int j = 0; j < b.get(i).getpLinks().size(); j++)
//                System.out.println(b.get(i).getpLinks().get(j).getState());
//            System.out.println("-------------------");
//        }
    new Makina(0, 21);
        launch(args);
    }


}
