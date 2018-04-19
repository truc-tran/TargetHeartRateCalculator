package target_heartRate_calculator;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * <code>TargetHeartRate<code> calculate maximum heart rate and target 
 * heart rate ( beats per minute) based on the age input.
 * @author ttran1214
 *
 */
public class TargetHeartRate extends Application{
	private TextField ageTF = new TextField();
	private TextField maxRateTF = new TextField();
	private TextField targetRateTF = new TextField();
	
	Button clear = new Button("Clear");
	Button calculate = new Button("Calculate");	
	
	/**
	 * set up elements in stage, layout, scene and
	 * calculate maximum heart rate and target 
	 * heart rate ( beats per minute) 
	 */
	@Override
	public void start(Stage stage) throws Exception {
		//NOt edible
		maxRateTF.setEditable(false);
		targetRateTF.setEditable(false);
		//GridPane-layout
		GridPane pane = new GridPane();
		pane.add(new Label("Your Age"), 0, 0);
		pane.add(new Label("Maximum Heart Rate"), 0, 1);
		pane.add(new Label("Target Heart Rate"), 0, 2);
		pane.add(ageTF, 1, 0);
		pane.add(maxRateTF, 1, 1);
		pane.add(targetRateTF, 1, 2);
		pane.setHgap(5);
		pane.setVgap(5);
		pane.setAlignment(Pos.CENTER);
				
		//Hbox-button and show
		HBox box = new HBox();
		box.setSpacing(10);
		box.setAlignment(Pos.CENTER_RIGHT);
		box.getChildren().add(clear);
		box.getChildren().add(calculate);
		pane.add(box, 1, 3);
		
		//Handling event, Lambda
		clear.setOnAction(c -> clear());
		calculate.setOnAction(c -> calculate());
		
		//Scene and show
		Scene scene = new Scene(pane, 300, 200);
		stage.setScene(scene);
		
		//Tittle
		stage.setTitle("Target Heart Rate");
		//Show
		stage.show();
		
		
	}
	
	/**
	 * Calculate the maximum heart rate and target heart rate
	 */
	// exception<Handler> or Lambda
	private void calculate() {
		int age = Integer.parseInt(ageTF.getText());
		int maxRate = 220 - age;
		int targetFrom = (50 * maxRate) / 100;
		int targetTo = (85 * maxRate) / 100;
		maxRateTF.setText(String.valueOf(maxRate) + " beats per minute");
		targetRateTF.setText(String.valueOf(targetFrom) + "-" + String.valueOf(targetTo) + " beats per minute" );
	}
	/**
	 * Reset all the text fields to empty(clear )
	 */
	private void clear() {
		ageTF.setText("");
		maxRateTF.setText("");
		targetRateTF.setText("");
	}
	public static void main(String[] args){
		Application.launch(args);
	}
	
	

}
