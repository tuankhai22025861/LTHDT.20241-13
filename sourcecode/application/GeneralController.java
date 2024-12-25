package application;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GeneralController {
	
	@FXML
	protected AnchorPane scenePane;
	
	protected Stage stage;
	protected Scene scene;
	protected Parent root;
	
	
	public void returnToMenu(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Cảnh báo");
		alert.setContentText("Bạn có chắc muốn return về menu không?");
		
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
            root = loader.load();
            
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
	
	public void help(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HelpScene.fxml"));
        root = loader.load();
        
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	
}
