package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AgorithmScreenController{
	String userOption;
	
	@FXML
	private AnchorPane scenePane;
	
	@FXML
	private Label labelArray;
	
	@FXML
	private Label labelSortedArray;
	
	@FXML
	private Label labelTotalTime;
	
	@FXML 
	private Label header;
	
	@FXML
	private TextField textField;
	
	private List<Integer> intList = new ArrayList<>();
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	SortAlgorithm sortAgorithm = null;
	
	
	public void setUserOption(String userOption) {
		this.userOption = userOption;
		header.setText("Choosen Agorithm: " + userOption);
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
	
	public void uploadButton(ActionEvent event) {
		String textFieldContent = textField.getText();
		String[] stringNumbers = textFieldContent.split(", ");
		
		intList.clear();
		
        for (String numStr : stringNumbers) {
            try {
            	intList.add(Integer.parseInt(numStr)); 
            } catch (NumberFormatException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Invalid array input!");
                alert.show();
                labelArray.setText("Your array is: ");
                return; 
            }
        }
        
        String noti = "Your array is: ";
        for (int num : intList) {
        	noti += " " + num + ",";
        }
        
        labelArray.setText(noti);
	}
	
	
	public void generateButton(ActionEvent event) {
		intList.clear();
		
		int size = 100;
        Random random = new Random();

        for (int i = 0; i < size; i++) {
        	int randomInt = random.nextInt(101); 
            intList.add(randomInt);
        }
        
        String noti = "Your array is: ";
        for (int num : intList) {
        	noti += " " + num + ",";
        }
        labelArray.setText(noti);
	}
	
	public void sortButton(ActionEvent event) {
		if (sortAgorithm == null) {
			if (userOption.equals("Merge Sort")) {
				sortAgorithm = new MergeSort();
			}  else if (userOption.equals("Selection Sort")) {
				sortAgorithm = new SelectionSort();
			} else if (userOption.equals("Shell Sort")) {
				sortAgorithm = new ShellSort();
			}			
		}
		int[] intArray = intList.stream().mapToInt(Integer::intValue).toArray();
		System.out.println("worked!");
		sortAgorithm.setArray(intArray);
		long startTime = System.nanoTime();
		sortAgorithm.sort();
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1_000_000;
		
		String noti = "Your sorted array is: ";
		for (int num: intArray) {
			noti += " " + num + ",";
		}
		labelSortedArray.setText(noti);
		
		labelTotalTime.setText("Total time: " + duration + " millisecond");
	}

}
