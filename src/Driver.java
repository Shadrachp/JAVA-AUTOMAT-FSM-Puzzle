import Model.FSM;
import Model.PathFinder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.application.Application.launch;

public class Driver extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        PathFinder a = new PathFinder(new FSM().getFsm());

        StatesController statesController;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Crossing Planets");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("States.fxml"));
        Parent root1 = fxmlLoader.load();

        statesController = fxmlLoader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();


        loader.<Controller>getController().injectController(statesController);
        loader.<Controller>getController().setPathFinder(a);
    }

    public static void main(String[] args) {
        launch(args);
    }


}
