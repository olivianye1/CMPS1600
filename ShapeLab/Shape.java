/**
 * Creates abstract Shape class that implements the Displayable and Comparable interfaces
 * @author Olivia Nye
 */

public abstract class Shape implements Displayable, Comparable<Shape>{
	/**
	 * creates abstract area method for use in sub-classes
	 * creates abstract perimeter method for use in sub-classes
	 * creates abstract method getShape -- will return name of shape as a string
	 */
	
	public abstract double area();
	public abstract double perimeter();
	public abstract String getShape();
	public abstract String getShapeName();
	
	/**declares static attribute that counts number of Shape Objects created, sets initial value to 0
	*/
	
	protected static int shapeCount = 0;
	
	//return number of shapes created
	/**
	 * returns the number of Shape objects constructed
	 * @return an integer value of shapeCount, which represents the number of Shape objects constructed
	 */
	protected static int getShapeCount() {
		return shapeCount;
	}
	
	
	/**
	 * declares area as a double attribute for use in subclasses
	 * declares perimeter as a double attribute for use in subclasses
	 * declares shapeName as a string attribute for use in subclasses
	 */
	
	public double area;
	public double perimeter;
	public String shapeName;
	
	/**
	 * creates abstract display method that implements display from Displayable interface
	 */
	
	public abstract void display();
	
	
		
	/**
	 * compares current Shape object to parameter Shape Object s by area 
	 * @return int value representing difference in area size between current Shape object and parameter Shape Object s
	 * @param s of Shape object type is the other Shape object that is being compared to this Shape object
	 */
	
	public int compareTo(Shape s) {
		return (int) (this.area - s.area);
		}
}
