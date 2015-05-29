package first;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * first.Data for summary table rows.
 */
public class SumData {

    private final SimpleStringProperty text;
    private final SimpleDoubleProperty value1;
    private final SimpleDoubleProperty value2;
    private final SimpleDoubleProperty value3;

    public SumData( String text, double value1, double value2, double value3) {

        this.text = new SimpleStringProperty( text);

        this.value1 = new SimpleDoubleProperty( value1);
        this.value2 = new SimpleDoubleProperty( value2);
        this.value3 = new SimpleDoubleProperty( value3);
    }

    public final SimpleStringProperty textProperty() {
        return this.text;
    }

    public final String getText() {
        return this.textProperty().get();
    }

    public final void setText(final String text) {
        this.textProperty().set(text);
    }

    public final SimpleDoubleProperty value1Property() {
        return this.value1;
    }

    public final double getValue1() {
        return this.value1Property().get();
    }

    public final void setValue1(final double value1) {
        this.value1Property().set(value1);
    }

    public final SimpleDoubleProperty value2Property() {
        return this.value2;
    }

    public final double getValue2() {
        return this.value2Property().get();
    }

    public final void setValue2(final double value2) {
        this.value2Property().set(value2);
    }

    public final SimpleDoubleProperty value3Property() {
        return this.value3;
    }

    public final double getValue3() {
        return this.value3Property().get();
    }

    public final void setValue3(final double value3) {
        this.value3Property().set(value3);
    }
}