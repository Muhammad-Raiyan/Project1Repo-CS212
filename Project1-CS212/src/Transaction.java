//Transaction.java
import java.util.StringTokenizer;

/**
 * Reads in the transaction.txt file; creates a database for 
 * all the transaction files
 * 
 * @author Muhammad Islam
 */
public class Transaction {
	
	// all transaction items are stored here
	private UserItem bought[] = new UserItem[12];
	// number of items on the transaction.txt
	private int length;
	
	/**
	 * constructor of the class, initializes length to 0
	 * and calls initialize() method.
	 */
	public Transaction(){
		length = 0;
		initialize();
	} // end of constructor
	
	void initialize(){
		/*
		 * temp[0] -> code
		 * temp[1] -> weight
		 */
		String temp[] = new String[2];
		// Initialize TextFileInpout object
		TextFileInput fileIn = new TextFileInput("transactions.txt");
		// Declare tokenizer object
		StringTokenizer myToken;
		// to hold string from the .txt file
		String line;
		
		
		for(int len=0; len<11; len++){
			// reads a line and stores it to String line
			line = fileIn.readLine();
			// runs till end of file
			if(line==null) break;
			
			// initialize StringTokenizer object
			myToken = new StringTokenizer(line, ",");
			
			int i=0; // loop iterator
			while(myToken.hasMoreTokens()){
				 temp[i]=myToken.nextToken();
		         i++;  // increment with each iteration 
			}
			//creating new instances of bought[] and initializing it calling UserItem constructor
			bought[len] = new UserItem(temp[0], temp[1]);
			length++; // tracking iteration to get length of transaction file
		}

	}	// end of initialize()
	
	/**
	 * Dummy Method to check all elements on bought. Used
	 * during project development.
	 */
	public void display(){
		for(int i=0; i<length; i++){
			System.out.println(bought[i].toString());
		}
	}
	
	/**
	 * to get the code at a particular index
	 * @param i index of a transaction item
	 * @return String the code of that Item
	 */
	public String getCode(int i){
		return bought[i].getCode();
	}
	
	/**
	 * to get the weight of a item at a particular index
	 * @param i index of an item
	 * @return float the weight of that item
	 */
	public float getWeight(int i){
		return bought[i].getWeight();
	}
	/**
	 * @return int length of the bought[] array.
	 */
	public int getLength(){
		return length;
	}
}
