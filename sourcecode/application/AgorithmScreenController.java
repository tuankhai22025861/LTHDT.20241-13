package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert.AlertType;

public class AgorithmScreenController extends GeneralController {
	String userOption;
	
	@FXML
	private Label labelArray;
	
	@FXML
	private Label labelTotalTime;
	
	@FXML 
	private Label header;
	
	@FXML
	private TextField textField;
	
	@FXML
	private ScrollPane scrollPaneResult;
	
	private List<Integer> intList = new ArrayList<>();
	
	SortAlgorithm sortAgorithm = null;
	
	
	public void setUserOption(String userOption) {
		this.userOption = userOption;
		header.setText("Choosen Agorithm: " + userOption);
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
		
		List<int[]> steps = sortAgorithm.getSteps();
	    VBox stepVBox = new VBox(5);  
		
		// Clear scrollPane content
		scrollPaneResult.setContent(null);
		
		for (int i = 0; i < steps.size(); i++) {
		    int[] step = steps.get(i);
		    String stepText = "STEP " + (i + 1) + ": "; 
		    
		    for (int num : step) {
		        stepText += num + " ,";
		    }
		    
		    Label stepLabel = new Label(stepText);
		    stepVBox.getChildren().add(stepLabel);
		}
		
	    scrollPaneResult.setContent(stepVBox);
		labelTotalTime.setText("Total time: " + duration + " millisecond");
	}

}
