/**
 * Rectangle is a subclass of Shape that implements Displayable interface
 * declares double attributes Length and Height that represent the dimensions of the Rectangle Shape objects
 * @author Olivia Nye
 */

public class Rectangle extends Shape implements Displayable{
	public double Length;
	public double Height;
	
	/**
	 *Rectangle constructor allows for the construction of a new Rectangle object with a name of String shapeName, a length of l, and a height of h. Also increments shapeCount
	 *when each new Rectangle object is constructed, 1 is added to the value of shapeCount to keep track of the number of Shape objects created for all of the Shape class
	 * sets value of Length to double value l
	 * sets value of Height to double value h
	 * sets String text name to the value of string shapeName attribute
	 * @param l  represents length of the rectangle
	 * @param h represents height of the triangle
	 * @param name is the string value representing the name of the Rectangle
	 */
	
	public Rectangle(double l, double h, String name) {
		Length = l;
		Height = h;
		shapeName = name;
		
		shapeCount = shapeCount + 1;
	}
	
	

	/**
	 * method returns the type of shape constructed
	 * @return string of text "Rectangle", which expresses that this shape is a Rectangle type
	 */
	
	public String getShape() {
		return "Rectangle";
	}
	
	/**
	 * method returns the name of the Shape object
	 * @return string shapeName representing the name of this shape
	 */
	
	public String getShapeName() {
		return shapeName;
	}
	
	

	/**method sets the value of the attribute Length
	* sets the value of length to the value of parameter l
	* @param double l representing the length of 2 sides of the rectangle
	*/
	
	public void setLength(double l) {
		Length = l;
	}
	
	/**method sets the value of the attribute Height
	* sets the value of Height to the value of parameter h
	* @param double h representing the length of the other 2 sides of the rectangle
	*/
	
	public void setHeight(double h) {
		Height = h;
	}

	/**
	 * method outputs the length of the Rectangle
	 * @return Length, a double representing the length of 2 sides of the rectangle
	 */
	
	public double getLength() {
		return Length;
	}

	/**
	 * method outputs the height of the Rectangle
	 * @return Height, a double representing the length of the other 2 sides of the rectangle
	 */
	
	public double getHeight() {
		return Height;
	}
	

	/**
	 * method computes and returns the area of the rectangle
	 * area is calculated by multiplying the Length of the Rectangle by the Height of the Rectangle
	 * @return area, a double value that expresses the amount of space inside the boundaries of the 2D Rectangle object
	 */
	
	public double area() {
		return area = Length * Height;
	}


	/**
	* method computes and returns the perimeter of the Rectangle
	* perimeter is calculated by finding the sum of twice the Length and twice the Height
	* @return perimeter, a double value that expresses the distance from any point on the edge of the Rectangle back to itself when traveling along the rectangle's boundary
	*/	
	
	public double perimeter() {
		return perimeter = (2 * Length) + (2 * Height);
	}
	
	@Override
	public void display() {
		System.out.println("Name of Shape: " + getShapeName() + "\nShape type: " + getShape() + "\nArea: " + area + "\nPerimeter: " + perimeter + "\n");
	}
	
	
}
