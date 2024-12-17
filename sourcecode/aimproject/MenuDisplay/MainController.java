package application;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController implements Initializable {
	
    @FXML
    private ComboBox<String> myComboBox;
	
	@FXML 
	private Label myLabel;
	
	@FXML
	private AnchorPane scenePane;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	String[] algorithms = {"Selection Sort", "Merge Sort", "Shell Sort"};
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		myComboBox.getItems().addAll(algorithms);
	}
	
	public void selectAction(ActionEvent event) throws IOException {
		String currentAlgorithm = myComboBox.getValue();
		if (currentAlgorithm == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!");
			alert.setContentText("Error! You should select one agorithm");
			alert.show();
		} else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AgorithmScene.fxml"));
            root = loader.load();

            AgorithmScreenController agorithmScreenController = loader.getController();
            agorithmScreenController.setUserOption(currentAlgorithm);
            
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();			
		}
	}
	
	public void quit(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Cảnh báo");
		alert.setContentText("Bạn có chắc muốn out không?");
		
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Stage stage = (Stage) scenePane.getScene().getWindow();
            stage.close();
        }
	}
}
	
