/**
 * Square is a subclass of Rectangle, which is a subclass of Shape, that implements Displayable interface
 * @author Olivia Nye
 */

public class Square extends Rectangle implements Displayable{
	
	/**
	 *Square constructor allows for the construction of a new Square object with a name of String shapeName, and all sides with a double length value s. Also increments shapeCount
	 *when each new Square object is constructed, 1 is added to the value of shapeCount to keep track of the number of Shape objects created for all of the Shape class
	 * calls super constructor from rectangle class, with s as the argument to both the l parameter and the h parameter, and name as the argument to the name parameter
	 * sets String text name to the value of string shapeName attribute
	 * @param s represents length of each side of the square
	 * @param name is the string value representing the name of the Rectangle
	 */
	
		public Square(double s, String name) {
			super(s, s, name);
		}
		

	/**
	* method returns the type of shape constructed
	* @return string of text "Square", which expresses that this shape is a Square type
	*/
	public String getShape() {
		return "Square";
	}
	
	/**
	 * method returns the name of the Shape object
	 * @return string shapeName representing the name of this shape
	 */
	
	public String getShapeName() {
		return shapeName;
	}
	
	@Override
	public double area() {
		super.area();
		return area;
	}

	@Override
	public double perimeter() {
		super.perimeter();
		return perimeter;
	}
	
	@Override
	public void display() {
		System.out.println("Name of Shape: " + getShapeName() + "\nShape type: " + getShape() + "\nArea: " + area + "\nPerimeter: " + perimeter + "\n");
	}

}

	