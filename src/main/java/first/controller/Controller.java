package first.controller;

import first.Data;
import first.SumData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Set;

/**
 * Created by konstantin on 29.05.15.
 */
public class Controller {

    @FXML
    BorderPane bp = new BorderPane();
    @FXML
    AnchorPane anchorPane = new AnchorPane();

    @FXML
    TableView<Data> mainTable;
    @FXML
    TableView<SumData> sumTable;
    @FXML
    ScrollBar mainTableHorizontalScrollBar;
    @FXML
    ScrollBar sumTableHorizontalScrollBar;

    @FXML
    TableColumn<Date, LocalDate> dateCol;

    @FXML
    TableColumn<Data, Double> value1Col;

    @FXML
    TableColumn<Data, Double> value2Col;

    @FXML
    TableColumn<Data, Double> value3Col;

    @FXML
    TableColumn<SumData, String> textCol;

    @FXML
    TableColumn<SumData, Double> value10Col;

    @FXML
    TableColumn<SumData, Double> value20Col;

    @FXML
    TableColumn<SumData, Double> value30Col;

    ObservableList<Data> data =
            FXCollections.observableArrayList();

    // TODO: calculate values
    ObservableList<SumData> sumData =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        // setup table columns
        setupMainTableColumns();
        setupSumTableColumns();

        initData();
        // fill tables with data
        mainTable.setItems(data);
        sumTable.setItems(sumData);

        // bind/sync tables
        for (int i = 0; i < mainTable.getColumns().size(); i++) {

            TableColumn<Data, ?> mainColumn = mainTable.getColumns().get(i);
            TableColumn<SumData, ?> sumColumn = sumTable.getColumns().get(i);

            // sync column widths
            sumColumn.prefWidthProperty().bind(mainColumn.widthProperty());

            // sync visibility
            sumColumn.visibleProperty().bind(mainColumn.visibleProperty());

        }

        // fit content
        bp.prefWidthProperty().bind(anchorPane.widthProperty());
        bp.prefHeightProperty().bind(anchorPane.heightProperty());

        // synchronize scrollbars (must happen after table was made visible)
        ScrollBar mainTableHorizontalScrollBar = findScrollBar( mainTable, Orientation.HORIZONTAL);
        ScrollBar sumTableHorizontalScrollBar = findScrollBar( sumTable, Orientation.HORIZONTAL);
        mainTableHorizontalScrollBar.valueProperty().bindBidirectional( sumTableHorizontalScrollBar.valueProperty());

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

    /**
     * Summary table column mapping.
     */
    private void setupSumTableColumns() {
        textCol.setCellValueFactory(new PropertyValueFactory<>("text"));
        value10Col.setCellValueFactory(new PropertyValueFactory<>("value1"));
        value20Col.setCellValueFactory(new PropertyValueFactory<>("value2"));
        value30Col.setCellValueFactory(new PropertyValueFactory<>("value3"));
    }

    /**
     * Primary table column mapping.
     */
    private void setupMainTableColumns() {
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        value1Col.setCellValueFactory(new PropertyValueFactory<>("value1"));
        value2Col.setCellValueFactory(new PropertyValueFactory<>("value2"));
        value3Col.setCellValueFactory(new PropertyValueFactory<>("value3"));
    }

    public void initData() {

        data.addAll(
                new Data(LocalDate.of(2015, Month.JANUARY, 10), 10.0, 20.0, 30.0),
                new Data(LocalDate.of(2015, Month.JANUARY, 11), 40.0, 50.0, 60.0),
                new Data(LocalDate.of(2015, Month.JANUARY, 12), 10.0, 20.0, 30.0),
                new Data(LocalDate.of(2015, Month.JANUARY, 13), 40.0, 50.0, 60.0),
                new Data(LocalDate.of(2015, Month.JANUARY, 14), 10.0, 20.0, 30.0),
                new Data(LocalDate.of(2015, Month.JANUARY, 15), 40.0, 50.0, 60.0),
                new Data(LocalDate.of(2015, Month.JANUARY, 16), 10.0, 20.0, 30.0),
                new Data(LocalDate.of(2015, Month.JANUARY, 17), 40.0, 50.0, 60.0),
                new Data(LocalDate.of(2015, Month.JANUARY, 18), 10.0, 20.0, 30.0),
                new Data(LocalDate.of(2015, Month.JANUARY, 19), 40.0, 50.0, 60.0),
                new Data(LocalDate.of(2015, Month.JANUARY, 20), 10.0, 20.0, 30.0),
                new Data(LocalDate.of(2015, Month.JANUARY, 21), 40.0, 50.0, 60.0),
                new Data(LocalDate.of(2015, Month.JANUARY, 22), 10.0, 20.0, 30.0),
                new Data(LocalDate.of(2015, Month.JANUARY, 23), 40.0, 50.0, 60.0),
                new Data(LocalDate.of(2015, Month.JANUARY, 24), 10.0, 20.0, 30.0),
                new Data(LocalDate.of(2015, Month.JANUARY, 25), 40.0, 50.0, 60.0),
                new Data(LocalDate.of(2015, Month.JANUARY, 26), 10.0, 20.0, 30.0),
                new Data(LocalDate.of(2015, Month.JANUARY, 27), 40.0, 50.0, 60.0),
                new Data(LocalDate.of(2015, Month.JANUARY, 28), 10.0, 20.0, 30.0),
                new Data(LocalDate.of(2015, Month.JANUARY, 29), 40.0, 50.0, 60.0),
                new Data(LocalDate.of(2015, Month.JANUARY, 30), 10.0, 20.0, 30.0));

        sumData.addAll(
                new SumData("Sum", 1.0, 2.0, 3.0),
                new SumData("Min", 1.0, 2.0, 3.0),
                new SumData("Max", 1.0, 2.0, 3.0));
    }
}
