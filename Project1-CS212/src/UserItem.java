//UserItem.java

/**
 * Stores the code and weight of the Transaction items;
 * Stores and returns through get and set methods
 * Overrides Object.toString() and Object.equals()
 * @author Muhammad Islam
 *
 */
public class UserItem {
	// Code of a transaction item
	private String code;
	// Weight of a transaction item
	private String weight;
	
	/**
	 * Class constructor, sets code and weight
	 * @param in_code the code of a produce item
	 * @param in_weight the weight of a produce item
	 */
	public UserItem(String in_code, String in_weight){
		code = in_code;
		weight = in_weight;
	} // end of constructor
	
	/**
	 * Returns code of item
	 * @return String the code of a item
	 */
	public String getCode(){
		return code;
	}
	/**
	 * Returns the weight of an item
	 * @return float the weight of an item
	 */
	public float getWeight(){
		return Float.parseFloat(weight);
	}
	/**
	 * sets the code to the argument
	 * @param in_code the code of an item
	 */
	public void setCode(String in_code){
		code = in_code;  // set the code
	}
	/**
	 * set the weight to the argument
	 * @param in_weight the weight of an item
	 */
	public void setWeight(String in_weight){
		weight = in_weight;  // set the weight
	}
	/**
	 * Overrides Object.toString()
	 * @return String representation of the object
	 */
	public String toString(){
		return code + " " + weight + " ";
	}
	/**
	 * checks if two objects are equal
	 * @return boolean true if both are equal; otherwise false
	 */
	public boolean equals(Object other){
		return (other !=null && getClass() ==other.getClass()  			// check for null and same class 
							 && code.equals(((UserItem)other).code) 	// check for equal code
							 && weight == (((UserItem)other).weight));  // check for equal weight
							
	}
}
