//necessary libraries
import java.awt.*;
import java.awt.event.*;
import javax.lang.model.util.ElementScanner6;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.io.IOException;

//main class for the project using JFrame for GUI
public class GUI_Calculator_Assignment extends JFrame
{
	//declare buttons for GUI 
	private JButton oneButton = new JButton("1");
	private JButton twoButton = new JButton("2");
	private JButton threeButton = new JButton("3");
	private JButton fourButton = new JButton("4");
	private JButton fiveButton = new JButton("5");
	private JButton sixButton = new JButton("6");
	private JButton sevenButton = new JButton("7");
	private JButton eightButton = new JButton("8");
	private JButton nineButton = new JButton("9");
	private JButton zeroButton = new JButton("0");
	private JButton decButton = new JButton(".");
	private JButton addButton = new JButton("+");
	private JButton subButton = new JButton("-");
	private JButton mulButton = new JButton("*");
	private JButton divButton = new JButton("/");
	private JButton equalButton = new JButton("=");
	private JButton resetButton = new JButton("Reset");
	//declare a text field for displaying the result
	private JTextField result_field = new JTextField("");

	//global varibles
	String display = "";
	int counter = 0;
	double total,temp = 0.0;
	String last_operator = "";

	//an instance of the GUI_Calculator_Assignment class
	public GUI_Calculator_Assignment () {
		//declare a panel to display GUI
		JPanel p1 = new JPanel(new GridLayout(5,2));

		//add all buttens and text fields into GUI
		p1.add(sevenButton);
		p1.add(eightButton);
		p1.add(nineButton);
		p1.add(divButton);
		p1.add(fourButton);
		p1.add(fiveButton);
		p1.add(sixButton);
		p1.add(mulButton);

		p1.add(oneButton);
		p1.add(twoButton);
		p1.add(threeButton);
		p1.add(subButton);

		p1.add(zeroButton);
		p1.add(decButton);
		p1.add(addButton);
		p1.add(equalButton);
		p1.add(result_field);
		//declare a seperate panel for displaying the result and a reset button
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		//add these into the second penal
		p2.add(result_field);
		p2.add(resetButton);

        //if wish to set button size, do:
		//zeroButton.setSize(50,30);

		//set up GUI
		p1.setBorder(new TitledBorder("Thu's Calculator"));
		add(p1, BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);

		//connect buttons to a GUI listener 
		oneButton.addActionListener(new ButtonListener());
		twoButton.addActionListener(new ButtonListener());
		threeButton.addActionListener(new ButtonListener());
		fourButton.addActionListener(new ButtonListener());
		fiveButton.addActionListener(new ButtonListener());
		sixButton.addActionListener(new ButtonListener());
		sevenButton.addActionListener(new ButtonListener());
		eightButton.addActionListener(new ButtonListener());
		nineButton.addActionListener(new ButtonListener());
		zeroButton.addActionListener(new ButtonListener());
		decButton.addActionListener(new ButtonListener());
		addButton.addActionListener(new ButtonListener());
		subButton.addActionListener(new ButtonListener());
		mulButton.addActionListener(new ButtonListener());
		divButton.addActionListener(new ButtonListener());
		equalButton.addActionListener(new ButtonListener());
		resetButton.addActionListener(new ButtonListener());
	}

	//this class will assist interaction/connection between mouse and GUI
	private class ButtonListener implements ActionListener {
	
		//this function handles the necessary calculations
		public void get_result(String num_string, String last_operator) {
			double num = Integer.parseInt(num_string);
			switch (last_operator){
				case "+":
					total += num;
					break;
	
				case "-":
					if (total == 0) 
						total = num;
					else
						total -= num;
					break;
	
				case "*":
				if (total == 0) 
					total = num;
				else
					total *= num;
				break;
	
				case "/":
					if (total == 0) 
						total = num;
					else {
						total /= num;
						
					}	
					break;
				default:
					break;
			}
			
	
		}

		//This overriden function using Actionlistener to obtain information from the mouse
		@Override
		public void actionPerformed(ActionEvent e) {
			//a complex if-else if statement that identifies which action event had just occurred from the mouse
			if (e.getSource() == oneButton) {
				display += "1";
				result_field.setText(display);
			}
			else if (e.getSource() == twoButton) {
				display += "2";
				result_field.setText(display);
			}
			else if (e.getSource() == threeButton) {
				display += "3";
				result_field.setText(display);
			}
			else if (e.getSource() == fourButton) {
				display += "4";
				result_field.setText(display);

			}
			else if (e.getSource() == fiveButton) {
				display += "5";
				result_field.setText(display);

			}
			else if (e.getSource() == sixButton) {
				display += "6";
				result_field.setText(display);

			}
			else if (e.getSource() == sevenButton) {
				display += "7";
				result_field.setText(display);

			}
			else if (e.getSource() == eightButton) {
				display += "8";
				result_field.setText(display);

			}
			else if (e.getSource() == nineButton) {
				display += "9";
				result_field.setText(display);

			}
			else if (e.getSource() == zeroButton) {
				display += "0";
				result_field.setText(display);
			}
			//if not numbers entered, call get_result function to perform calculations
			//display total in result field  
			else if (e.getSource() == equalButton) {	
				result_field.setText(display);				
				get_result(display, last_operator);				
				result_field.setText(Double.toString(total));
				display="";
			}
			else if (e.getSource() == addButton)	{
				last_operator = "+";
				get_result(display, last_operator);
				display="";
				result_field.setText(Double.toString(total));
			}
			else if (e.getSource() == subButton)	{
				last_operator = "-";
				get_result(display, last_operator);
				display="";
				result_field.setText(Double.toString(total));
			}
			else if (e.getSource() == mulButton)	{
				last_operator = "*";
				get_result(display, last_operator);
				display="";
				result_field.setText(Double.toString(total));
			}
			else if (e.getSource() == divButton)	{
				last_operator = "/";
				if (display == "0") {
					result_field.setText("Invalid");
				}
				else {
					get_result(display, last_operator);
					display="";
					result_field.setText(Double.toString(total)); 
				}
			}
			//additional option for resetting the calculator
			else if (e.getSource() == resetButton){
				last_operator = "";
				total = 0;
				temp = 0;
				display = "";
				result_field.setText(Double.toString(total));
			}
		}
	}

	//main function: create an instance of this project and set up a GUI
	public static void main(String[] args){
		GUI_Calculator_Assignment frame = new GUI_Calculator_Assignment();
		frame.pack();
		frame.setTitle("Calculator");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
