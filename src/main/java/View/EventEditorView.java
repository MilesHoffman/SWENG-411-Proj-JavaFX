package View;

import Controller.EventEditorLogic;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class EventEditorView extends ViewClass {

    EventEditorLogic logic = new EventEditorLogic( this );

    private TextField nameBox, descBox, locationBox, addressBox, clubBox;
    private ComboBox<String> categoryCombo;
    private DatePicker datePicker;


    public EventEditorView() {
        super();

        setVars();
        setScene("EventEditorStyle.css");
    }

    private void setVars(){

        nameBox = new TextField("Hello");

        VBox vbox = new VBox(nameBox);

        root.getChildren().add(vbox);
    }
}
