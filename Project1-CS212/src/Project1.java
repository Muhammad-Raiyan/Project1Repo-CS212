//Project1.java

import java.text.DecimalFormat;
/**
 * Holds the main method, creates objects of database
 * transaction and passes the data to ReceiptGUI to display
 * them with JFrame.
 * 
 * @author Muhammad Islam
 */
public class Project1 {
	
	
	public static void main(String[] args) {
		/**
		 * Initialize Database and Transaction objects
		 * which tokenize and store the data from database.txt
		 * and shopping.txt
		 */
		Database DB = new Database();
		Transaction T = new Transaction();
		
		// Initialize DecimalFormat object which controls number of decimal places
		DecimalFormat df = new DecimalFormat();
		// Set decimal places to 2
		df.setMaximumFractionDigits(2);
		
		// initialize String array to hold data
		String trans_name[] = new String[T.getLength()];
		String trans_price[] = new String[T.getLength()];
		String trans_cost[] = new String[T.getLength()];
		
		// sum holds total sum of cost
		// temp temporarily holds sum after each iteration
		float temp, sum = 0;
		
		for(int i=0; i<T.getLength(); i++){
			// get name, price and weight of all transaction item
			trans_name[i] = DB.getName(T.getCode(i));
			// as getPrice returns float, it has to be converted to String
			trans_price[i] = Float.toString(DB.getPrice(T.getCode(i)));
			// multiply weight and price to get cost which is stored in temp
			temp = T.getWeight(i) * DB.getPrice(T.getCode(i));
			// add temp to sum
			sum+=temp;
			// format temp and store to trans_cost as string
			trans_cost[i] = df.format(temp);
		}
		// formal the sum to 2 decimal places
		String total = df.format(sum);
		
		/**
		 *  Initialize ReceiptGUI object with constructor
		 *  passes all data there to be displayed in JFrame
		 */
		ReceiptGUI r_ob = new ReceiptGUI(trans_name, trans_price, trans_cost, total);
	}	// End of main method
}	// End of class Project1


