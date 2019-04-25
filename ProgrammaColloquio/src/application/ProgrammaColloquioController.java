package application;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import programmaColloquio.model.Model;
import programmaColloquio.model.Temperatura;

public class ProgrammaColloquioController {
	private Model modello = new Model();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cmbScegli;

    @FXML
    private TextField txtResult;

    @FXML
    private Button btnClear;

    @FXML
    void doClear(ActionEvent event) {
    	txtResult.clear();
    }

    @FXML
    void doResult(ActionEvent event) {
    	
    }

    @FXML
    void doScegli(ActionEvent event) {
    	modello.loadFile(cmbScegli.getValue());
    	String tempResult = modello.getResult(cmbScegli.getValue());
    	txtResult.setText(tempResult);
    }

    @FXML
    void initialize() {
        assert cmbScegli != null : "fx:id=\"cmbScegli\" was not injected: check your FXML file 'Programma.fxml'.";
        cmbScegli.getItems().addAll("weather","football");
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Programma.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Programma.fxml'.";

    }
}


