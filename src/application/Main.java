package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.lang.Math;


public class Main extends Application {
	int sidesCount =  1;
	int sidesMax = 7;
	int sidesMin = 3;
	Group group;
	@Override
	public void start(Stage primaryStage) {
		try { 
			Main parent = new Main();
			
			// BorderPane root = new BorderPane();
			// create and configure a VBox to hold our components
			VBox root = new VBox();
			root.setSpacing(10);
			root.setAlignment(Pos.CENTER);

			// Change initial circles properties
			Circle shape = new Circle(125, 125, 80);
			shape.setFill(Color.YELLOW);
			shape.setStroke(Color.RED);

			// create a group that holds all the features
			Group group = new Group(shape);
			parent.group = group;

			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			TextField sidesTextField = new TextField();
			sidesTextField.setMaxWidth(250);

			Button button = new Button();
			button.setText("Generate Shape");

			Button buttonAdd = new Button();
			buttonAdd.setText("Add");

			Button buttonMinus = new Button();
			buttonMinus.setText("minus");

	  // Component 1 if statement restricting max and minimum side input.
      EventHandler<ActionEvent> textInputEvent = new EventHandler<ActionEvent>() {
          public void handle(ActionEvent e)
          {
        	  int sides = parent.sidesCount;
              if (sides >= 3 && sides <= 7) {
              	Double[] points = new Double[sides * 2];
                  for(int i = 0; i < sides; ++i)
                  {
                  	parent.drawShape(sides, group);
                  }
              } else {
            	  System.out.println("Invalid");
              }
          };
      };

      // Add button functionality
      EventHandler<ActionEvent> buttonAddEvent = new EventHandler<ActionEvent>() {
          public void handle(ActionEvent e)
          {
          	System.out.println("add click");
          	parent.sidesCount++;
          	sidesTextField.setText(String.valueOf(parent.sidesCount));
          	parent.drawShape(parent.sidesCount, parent.group);
          }
      };
      
      // Minus button functionality
      EventHandler<ActionEvent> buttonMinusEvent = new EventHandler<ActionEvent>() {
          public void handle(ActionEvent e)
          {
          	System.out.println("minus click");
          	parent.sidesCount--;
          	sidesTextField.setText(String.valueOf(parent.sidesCount));
          	parent.drawShape(parent.sidesCount, parent.group);
          }
      };

      // when button is pressed / number is changed
      sidesTextField.textProperty().addListener((obs, oldText, newText) -> {
    	    System.out.println("Text changed from "+ oldText +" to "+ newText);
    	    parent.sidesCount = Integer.parseInt(sidesTextField.getText());
    	});
      button.setOnAction(textInputEvent);
      buttonAdd.setOnAction(buttonAddEvent);
      buttonMinus.setOnAction(buttonMinusEvent);


			//add the components to the VBox
			root.getChildren().addAll(group, sidesTextField, button, buttonAdd, buttonMinus);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {
		launch(args);
	}

	// Functionalities
	public static void drawShape(int sides, Group group) {
		Main parent = new Main();
		drawShape(sides, parent.sidesMin, parent.sidesMax, group);
	}
	
	// Function to draw shape
	public static void drawShape(int sides, int minVal, int maxVal, Group group) {
		if (sides >= minVal && sides <= maxVal) {
			Double[] points = new Double[sides * 2];
		    for(int i = 0; i < sides; ++i)
		    {
		    	double angle = ((Math.PI * 2) / sides) * i;
		    	points[i * 2] = Math.cos(angle) * 100;
		    	points[(i * 2) + 1] = Math.sin(angle) * 100;
		    }
		    Polygon polygon = new Polygon();
		    polygon.getPoints().addAll(points);
		    if (sides % 2 == 0)
		    	polygon.setFill(Color.BLUE);
		    else
		    	polygon.setFill(Color.RED);
		    group.getChildren().clear();
		    group.getChildren().add(polygon);
		} else {
			System.out.println("Invalid");
		}
	}
}