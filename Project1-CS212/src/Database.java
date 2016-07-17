//Database.java

import java.util.StringTokenizer;

/**
 * Reads the database.txt; stores all the items and creates the database.
 * @author Muhammad Islam
 *
 */
public class Database {
	
	// All items are stored here.
	private ProduceItem data[] = new ProduceItem[16];
	// Tracks the length of the array
	private int length;
	
	/**
	 * Class constructor. No arguments.
	 * initializes length to zero and 
	 * calls initialize()
	 */
	public Database(){
		length = 0;		// so data[0] stores first value 
		initialize();	// Calls to initialize method
	} // end of constructor
	/**
	 * Reads database.txt, tokenizes each line and stores
	 * them to data[]; increments the length in each iteration
	 * thus giving the number of produce items
	 */
	private void initialize(){
		/*
		 * produce[0] -> Code
		 * produce[1] -> Name
		 * produce[2] -> Price
		 */
		String produce[] = new String[3];
		//Initialize TextFileInput object
		TextFileInput fileIn = new TextFileInput("database.txt");
		//Declare StringTokenizer Object
		StringTokenizer myToken;
		//to store each line from text file.
		String line;
		//Iterates 16 times; each time read a new line and tokenize
		for(int len=0; len<16; len++){
			//read a new line
			line = fileIn.readLine();
			//break at end of file
			if(line==null) break;
			
			//initialize StringTokenizer object with line as string and ',' as token
			myToken = new StringTokenizer(line, ",");
			
			
			int i=0; // loop iterator 
			while(myToken.hasMoreTokens()){
				//tokenize line and store to produce[]
				 produce[i]=myToken.nextToken();
		         i++; 
			}
			//creates a new data after each iteration and calls constructor
			data[len] = new ProduceItem(produce[0], produce[1], produce[2]);
			//increment length
			length++;
		}
	} // end of initialize()
	
	/**
	 * Dummy Method to check all elements on data. Used
	 * during project development.
	 */
	public void display(){
		for(int i=0; i<length; i++){
			System.out.println(data[i].toString());
		}
	}
	/**
	 * @return int length of the data[] array.
	 */
	public int getLength(){
		return length;
	}
	
	/**
	 * Takes the code of a produce item; uses search method
	 * to get the index of that item. Then returns the name
	 * stored in that produce item object
	 * 
	 * @param code the code of any produce item
	 * @return String the name of the produce item whose code was passed
	 */
	public String getName(String code){
		// calls search method and passes the code
		int i = search(code);
		return data[i].getName();
	}
	
	/**
	 * Finds the price of the produce item whose code
	 * was passed as argument. Uses search method to get the index
	 * of that produce item. 
	 * 
	 * @param code the code of any produce item
	 * @return float the price of the produce item whose code was passed
	 */
	public float getPrice(String code){
		// calls the search method with the code, uses the index to get the price as string
		String temp = data[search(code)].getPrice();
		// converts the String to a float
		return Float.parseFloat(temp);  
	}
	
	/**
	 * finds the index of produce item of same code and returns the index
	 * 
	 * @param code the code of a produce item 
	 * @return int index of the produce item
	 */
	private int search(String code){
		// iterates through the entire data[] 
		for(int idx = 0; idx<length; idx++){
			if( (data[idx].getCode() ).equals(code)) //check for equal code 
				return idx; // index of the item if matched
		}
		return -5;	// if none matches then shows error
	}
} // end of class Database.java
