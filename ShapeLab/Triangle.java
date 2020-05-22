
/**
 * Triangle is a subclass of Shape that implements Displayable interface
 * declares double attributes sideA, sideB, and sideC that represent the lengths of the 3 sides of the triangle Shape objects
 * @author Olivia Nye
 */

public class Triangle extends Shape implements Displayable{
	public double sideA;
	public double sideB;
	public double sideC;
	
	/**
	 *Triangle constructor allows for the construction of a new Triangle object with a name of String shapeName and side lengths of a, b, and c. Also increments shapeCount
	 *when each new Triangle object is constructed, 1 is added to the value of shapeCount to keep track of the number of Shape objects created for all of the Shape class
	 * sets value of sideA to double value a
	 * sets value of sideB to double value b
	 * sets value of sideC to double value c
	 * sets String text name to the value of string shapeName attribute
	 * @param a  represents length of side a of the triangle
	 * @param b represents length of side b of the triangle
	 * @param c represents length of side c of the triangle
	 * @param name is the string value representing the name of the Triangle
	 */
	
	public Triangle(double a , double b , double c, String name) {
		sideA = a;
		sideB = b;
		sideC = c;
		shapeName = name;
		
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
	 * @return string of text "Triangle", which expresses that this shape is a Triangle type
	 */
	
	public String getShape() {
		return "Triangle";
	}
	

	/**
	 * method computes and returns the area of the Triangle given the values of all 3 sides
	 * declares double attribute p and calculates it to contain the value of half of the circle's perimeter
	 * area is calculated by implementing the java.lang.math class by using the sqrt function to find the square root of p multiplied by the values of each side separately subtracted from p
	 * @return area, a double value that expresses the amount of space inside the boundaries of the 2D Triangle object
	 */
	
	public double area() {
		double p;
		p = (sideA + sideB + sideC)/ 2.0;
		
		area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
		return area;
	}

	/**
	* method computes and returns the perimeter of the Triangle
	* perimeter is calculated by finding the sum of the 3 side lengths, sideA, sideB, and sideC
	* @return perimeter, a double value that expresses the distance from any point on the edge of the triangle back to itself when traveling along the triangle's boundary
	*/	
	
	public double perimeter() {
		perimeter = sideA + sideB + sideC;
		return perimeter;
	}
	

	@Override
	public void display() {
		System.out.println("Name of Shape: " + getShapeName() + "\nShape type: " + getShape() + "\nArea: " + area + "\nPerimeter: " + perimeter + "\n");
	}
	
}
