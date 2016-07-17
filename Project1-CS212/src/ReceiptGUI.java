//ReceiptGUI.java
import java.awt.*;
import javax.swing.*;

/**
 * Displays the result i.e the name, price, cost and 
 * total cost of the transaction. USes JFrame to create the GUI.
 * Uses BorderLayout manager to display the strings in different
 * places of the JFrame
 * @author Muhammad Islam
 */
public class ReceiptGUI extends JFrame{
	private static JFrame myFrame;
	private static JLabel label;
	private static Container myContentPane;
	//TextArea for all name price and cost of produce item
	private static TextArea allName, allPrice, allCost;
	//temporarily holds name, price and cost
	private static String[] name, price, cost;
	// holds the total expenses
	private static String total; 
	/**
	 * Class constructor, initializes all variables
	 * calls initialize to initialize JFrame,
	 * calls go() to display all the content
	 * 
	 * @param in_name array containing all names
	 * @param in_price array containing all price
	 * @param in_cost array containing all cost
	 * @param in_total array containing total amount
	 */
	public ReceiptGUI(String[] in_name, String[] in_price, String[] in_cost, String in_total){
		// initialize name, price, cost and total
		name = in_name;
		price = in_price;
		cost = in_cost;
		total = in_total;
		// Call to initialize and go
		initialize();
		go();
		// So that none of the textArea are editable from GUI
		allCost.setEditable(false);
		allName.setEditable(false);
		allPrice.setEditable(false);
	}
	/**
	 * Initialize the JFrame, sets size, location, title
	 * and visibility
	 */
	private void initialize(){
		myFrame=new JFrame();
	    myFrame.setSize(300,900);
	    myFrame.setLocation(100, 100);
	    myFrame.setTitle("Customeer Receipt");
	    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    myFrame.pack();
	    myFrame.setVisible(true);
	}	// End of initialize()
	
	/**
	 * Initializes all the text area, sets all their location
	 * on JFrame and displays all the data
	 */
	private void go(){
		// Initialize contentPane
		myContentPane = myFrame.getContentPane();
		// Initialize TextArea for data
		allName = new TextArea();
		allPrice = new TextArea();
		allCost = new TextArea();
		// Initialize label to display the sum
		label = new JLabel();
		label.setText("Total: " + total);
		
		/** 
		 * Set location of textAreas
		 * Name(WEST) 	Price(Center)	Cost(EAST) 
		 * label(South)								
		 */
		myContentPane.add(allName, BorderLayout.WEST);
		myContentPane.add(allPrice, BorderLayout.CENTER);
		myContentPane.add(allCost, BorderLayout.EAST);
		myContentPane.add(label, BorderLayout.SOUTH);
		
		// To give title of all textAreas
		allName.append("Produce Items\n");
		allPrice.append("Price per lbs\n");
		allCost.append("Cost per Item\n");
		
		// Iterates through the Data to append them to textAreas
		for(int i=0; i<name.length; i++){
			allName.append( "Item #  " + Integer.toString(i+1) + "  " + name[i] + "\n");
			allPrice.append(price[i] + "\n");
			allCost.append(cost[i] + "\n");
		}
		
		myFrame.pack();
		myFrame.setVisible(true);
	}	// End of go()
	
}// End of class ReceiptGUI
