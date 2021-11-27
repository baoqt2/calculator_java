//Ann Trac
// package myJavaFXpkg;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
/*import javafx.scene.text.TextAlignment;*/
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI_Calculator_Assignment extends Application 
{
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) throws Exception
	{
		double sum = 0.0;
	// Create a scene and place a button in the scene.
	Pane pane = new Pane();
	final JFrame frame = new JFrame();
	JPanel panel = new JPanel();
		
		Label myLabel = new Label("123456");
		myLabel.setFont(Font.font("Courier",FontWeight.BOLD,FontPosture.REGULAR,20));
		myLabel.setStyle("-fx-border-color: blue;");
		myLabel.setAlignment(Pos.BASELINE_RIGHT); // align text to the right side of the label.
		myLabel.setLayoutX(10);       // set the x location of the label
		myLabel.setLayoutY(10);       // set the y location of the label
		myLabel.setPrefSize(250, 20); // set the width and height of the label
		myLabel.setText("123456789"); // put some numbers into the label
		pane.getChildren().add(myLabel);
		myLabel.setText(Double.toString(sum));
		
		//creating a GridPane for buttons
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPrefSize(250,100);
		gridPane.setLayoutX(10);
		gridPane.setLayoutY(80);
		
		//creating buttons in Calculator
		//First row
		Button sevenButton = new Button("7");
		gridPane.add(sevenButton, 0, 0);
		Button eightButton = new Button("8");
		gridPane.add(eightButton, 1, 0);
		Button nineButton = new Button("9");
		gridPane.add(nineButton, 2, 0);
		Button divideButton = new Button("/");
		gridPane.add(divideButton,3, 0);
		//Second Row
		Button fourButton = new Button("4");
		gridPane.add(fourButton, 0, 1);
		Button fiveButton = new Button("5");
		gridPane.add(fiveButton, 1, 1);
		Button sixButton = new Button("6");
		gridPane.add(sixButton, 2, 1);
		Button multiplyButton = new Button("x");
		gridPane.add(multiplyButton, 3, 1);
		//Third Row
		Button oneButton = new Button("1");
		gridPane.add(oneButton, 0, 2);
		Button twoButton = new Button("2");
		gridPane.add(twoButton, 1, 2);
		Button threeButton = new Button("3");
		gridPane.add(threeButton, 2, 2);
		Button subtractButton = new Button("-");
		gridPane.add(subtractButton, 3, 2);
		//Fourth Row
		Button zeroButton = new Button("0");
		gridPane.add(zeroButton, 0, 3);
		Button decimalButton = new Button(".");
		gridPane.add(decimalButton, 1, 3);
		Button additionButton = new Button("+");
		gridPane.add(additionButton, 2, 3);
		Button equalButton = new Button("=");
		gridPane.add(equalButton, 3, 3);
		//Button sizes
		additionButton.setPrefSize(50, 30);
        subtractButton.setPrefSize(50, 30);
        multiplyButton.setPrefSize(50, 30);
        divideButton.setPrefSize(50, 30);
        zeroButton.setPrefSize(50, 30);
        oneButton.setPrefSize(50, 30);
        twoButton.setPrefSize(50, 30);
        threeButton.setPrefSize(50, 30);
        fourButton.setPrefSize(50, 30);
        fiveButton.setPrefSize(50, 30);
        sixButton.setPrefSize(50, 30);
        sevenButton.setPrefSize(50, 30);
        eightButton.setPrefSize(50, 30);
        nineButton.setPrefSize(50, 30);
        equalButton.setPrefSize(50, 30);
		decimalButton.setPrefSize(50, 30);
		//Font style
		additionButton.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR,14));
        subtractButton.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR,14));
        multiplyButton.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR,14));
        divideButton.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR,14));
        zeroButton.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR,14));
        oneButton.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR,14));
        twoButton.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR,14));
        threeButton.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR,14));
        fourButton.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR,14));
        fiveButton.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR,14));
        sixButton.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR,14));
        sevenButton.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR,14));
        eightButton.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR,14));
        nineButton.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR,14));
        equalButton.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR,14));
		pane.getChildren().add(gridPane);


	//	Button addButton = new Button();

		
		Scene scene = new Scene(pane,280,300);
		primaryStage.setTitle("MyJavaFX"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	public void calculation(int number1, int number2, string operator)
	{
		float result = 0;

		switch (operator){
			case "+":
				result = number1 + number2;
				break;

			case "-":
				result = number1 - number2;
				break;

			case "x":
				result = number1 * number2;
				break;

			case "/":
				try{
					if (number2 != 0)
						result = number1 / number2;	
				} catch (IOException e){
					JOptionPane.showMessageDialog (null, "Something went Wrong", "Title", JOptionPane.ERROR_MESSAGE);
                //LOGGER.error("Error message: " + e.getMessage());
				}
			default:
				break;
		}

	}

	public static void main(String[] args){

		Application.launch(args);
	}
}
