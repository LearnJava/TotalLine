import first.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Set;

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
        Controller controller = loader.getController();

        stage.setTitle("Table View Sample");
        stage.setWidth(400);
        stage.setHeight(550);

        stage.setScene(scene);
        stage.show();

        ScrollBar mainTableHorizontalScrollBar = findScrollBar(controller.getMainTable(), Orientation.HORIZONTAL);
        ScrollBar sumTableHorizontalScrollBar = findScrollBar(controller.getSumTable(), Orientation.HORIZONTAL);
        mainTableHorizontalScrollBar.valueProperty().bindBidirectional(sumTableHorizontalScrollBar.valueProperty());
    }

        /**
         * Find the horizontal scrollbar of the given table.
         *
         * @param table
         * @return
         */
    private ScrollBar findScrollBar(TableView<?> table, Orientation orientation) {

        // this would be the preferred solution, but it doesn't work. it always gives back the vertical scrollbar
        //		return (ScrollBar) table.lookup(".scroll-bar:horizontal");
        //
        // => we have to search all scrollbars and return the one with the proper orientation

        Set<Node> set = table.lookupAll(".scroll-bar");
        for (Node node : set) {
            ScrollBar bar = (ScrollBar) node;
            if (bar.getOrientation() == orientation) {
                return bar;
            }
        }

        return null;
    }
    }

