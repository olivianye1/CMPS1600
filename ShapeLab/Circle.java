/**
 * Circle is a subclass of Shape that implements Displayable interface
 * declares double attribute radius that represents the radius of the circle, which is the straightline distance from the center of the circle to any point on the edge of the circle
 * declares final double attribute PI_VALUE and sets value to the value of Pi rounded to 5 decimal points
 * @author Olivia Nye
 *
 */

public class Circle extends Shape implements Displayable{
	private double radius;
	protected final double PI_VALUE = 3.14159;
	
	/**
	 * Circle constructor allows for the construction of a new circle object with a name of String shapeName and a radius of double radius, also increments shapeCount
	 *when each new Circle object is constructed, 1 is added to the value of shapeCount to keep track of the number of Shape objects created for all of the Shape class
	 * @param r double value representing the straight-line distance from the center of the circle to any point on the circle's edge
	 * @param name is the string value representing the name of the Circle 
	 */
	
	public Circle (double r, String name) {
		shapeName = name;
		radius = r;
		
		//increment shapeCount as a new shape is created
		shapeCount = shapeCount + 1;
	}
	
	/**
	 * method returns the name of the Shape object
	 * @return string shapeName representing the name of this shape
	 */
	
	public String getShapeName() {
		return shapeName;
	}
	
	/**
	 * method returns the type of shape constructed
	 * @return string of text "Circle", which expresses that this shape is a circle type
	 */

	public String getShape() {
		return "Circle";
	}
	
	/**method sets the value of the attribute radius 
	* sets the value of radius to the value of parameter r
	* @param double r representing the straight-line distance from the center of the circle to any point on the circle's edge
	*/
	
	public void setRadius(double r) {
		radius = r;
	}
	
	/**
	 * method outputs the value of the circle's radius
	 * @return a double representing the straight-line distance from the center of the circle to any point on the circle's edge
	 */
	
	public double getRadius() {
		return radius;
	}

	
	/**
	 * method computes and returns the area of the circle
	 * area is calculated by multiplying the final double value of PI_VALUE by the value of the squared value of radius
	 * @return area, a double value that expresses the amount of space inside the boundaries of the 2D circle object
	 */
	
	public double area() {
		area = (radius * radius) * PI_VALUE;
		return area;
	}
	

	/**
	 * method computes and returns the perimeter of the circle, which is more accurately known as the circumference of the circle
	 * perimeter is calculated by multiplying the circle's radius by the final double value of PI_VALUE and then doubling that product
	 * @return perimeter, a double value that expresses the distance from any point on the edge of the circle back to itself when traveling along the circle's boundary
	 */
	public double perimeter() {
		perimeter = 2 * PI_VALUE * radius;
		return perimeter;
	}

	@Override
	public void display() {
		System.out.println("Name of Shape: " + getShapeName() + "\nShape type: " + getShape() + "\nArea: " + area + "\nPerimeter: " + perimeter + "\n");
	}
	
		
}
