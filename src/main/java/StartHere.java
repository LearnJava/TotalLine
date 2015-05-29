import first.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by konstantin on 29.05.15.
 */
public class StartHere extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Scene scene = null;

        FXMLLoader loader = new FXMLLoader(StartHere.class.getResource("/fxml/mainFile.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene = new Scene(root);
        // load css
        scene.getStylesheets().addAll(getClass().getResource("/style/application.css").toExternalForm());

        // Give the programEditDialogController access to the main app
        Controller controllerFirst = loader.getController();

        stage.setTitle("Table View Sample");
        stage.setWidth(400);
        stage.setHeight(550);

        stage.setScene(scene);
        stage.show();
    }
}
