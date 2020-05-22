/**
 * import ArrayList java package allows the creation and modification of arrayLists
 * import Collections java package that allows the sorting of arrays with the Collections.sort method  
 */

import java.util.ArrayList;
import java.util.Collections;

/** 
 * creates tester class shapeTester that is used to test the functioning of the Shape class and all of its subclasses
 * @author Olivia Nye
 */

public class ShapeTester {
	
	/**
	 * creates the main method with the default parameters, executes to the console
	 * @param args -- the default parameter for main methods
	 */
	public static void main(String[] args) {
				
		/** 
		 * constructs ArrayList Shapes with Shape object element types
		 */
		
		ArrayList<Shape> Shapes = new ArrayList<Shape>();
		
		/**
		 * constructs new Shape object rectangle1 of type Rectangle with Length 1 and Height 2 and shapeName rectangle1
		 */
		
		Rectangle rectangle1 =  new Rectangle(1,2, "rectangle1");
		
		/**
		 * constructs new Shape object circle1 of type Circle with radius 1 and shapeName circle1
		 */
	
		Circle circle1 = new Circle (1, "circle1");
		
		/**
		 * constructs new Shape object triangle1 of type Triangle with side lengths of 8, 2, and 7 and shapeName triangle1
		 */

		Triangle triangle1 = new Triangle(8, 2, 7, "triangle1");
		
		/**
		 * constructs new Shape object square1 of type Square with side lengths of 8, 2, and 7 and shapeName triangle1
		 */
		
		Square square1 = new Square(2 , "square1");
		
		/**
		 * calls area method on object rectangle1 to compute and return the shape's area
		 */
		rectangle1.area();
		
		/**
		 * calls perimeter method on object rectangle1 to compute and return the shape's perimeter
		 */
		rectangle1.perimeter();
		
		/**
		 * calls area method on object circle1 to compute and return the shape's area
		 */

		circle1.area();
		
		/**
		 * calls perimeter method on object circle1 to compute and return the shape's perimeter
		 */
		
		circle1.perimeter();
		
		/**
		 * calls area method on object triangle1 to compute and return the shape's area
		 */
		
		triangle1.area();

		/**
		 * calls perimeter method on object triangle1 to compute and return the shape's perimeter
		 */
		
		triangle1.perimeter();
		
		/**
		 * calls area method on object square1 to compute and return the shape's area
		 */
		
		square1.area();
		
		/**
		 * calls perimeter method on object square1 to compute and return the shape's perimeter
		 */
		
		square1.perimeter();
		
		/**
		 * calls add method from ArrayList java Package to add Shape rectangle1 to the first position of ArrayList Shapes
		 */
		
		Shapes.add(rectangle1);
		
		/**
		 * calls add method from ArrayList java Package to add Shape circle1 to the next position of ArrayList Shapes
		 */
		Shapes.add(circle1);
		
		/**
		 * calls add method from ArrayList java Package to add Shape triangle1 to the next position of ArrayList Shapes
		 */
		
		Shapes.add(triangle1);
		
		/**
		 * calls add method from ArrayList java Package to add Shape square1 to the next position of ArrayList Shapes
		 */
		
		Shapes.add(square1);
		
		/**
		 * prints shape type of all elements in Shapes
		 * for loop iterates through each element in ArrayList Shapes by position number i, starting at i = 0 and continuing until reaching the end of the ArrayList
		 * employs get method from ArrayList java package and getShape method from Shape class 
		 * prints the shape type of the object in each position of the ArrayList Shapes, printing each on its own line
		 */

		for (int i = 0; i < Shapes.size(); i = i + 1) {
			//prints type of shape in each position of ArrayList Shapes
			System.out.println(Shapes.get(i).getShape());
		}
		
		/**
		 * print a line of white space for readability 
		 * Prints string label for readability, labeling the next output as referencing the circles present in the ArrrayList
		 */
		
		System.out.println("");
		System.out.println("Circles in Shapes ArrayList: ");
		/**
		 * prints name and 
		 * for loop iterates through each element in ArrayList Shapes by position number i, starting at i = 0 and continuing until reaching the end of the ArrayList
		 * employs if-statement that only continues if the Shape in element i of Shapes is of Circle type, by calling the getShape() method on the returned value of the get(i) method, and comparin that content to the text "Circle" with the contentEquals built in function
		 * prints the names of the Circle shapes in Array list using getShapeName method,  and their positions in the array by calling i
		 * prints white space and punctuation in appropriate locations to make this information more understandable/readable to users
		 */
		
		for (int i = 0; i < Shapes.size(); i = i + 1) {
			if (Shapes.get(i).getShape().contentEquals("Circle")){
				System.out.print(Shapes.get(i).getShapeName());
				System.out.print(", ");
				System.out.println("Position " + i);
			}
		}
		
		/**
		 * prints, on a new line, the number of shapes created, which is accessed by calling the getShapeCount method from the shape class
		 * This data point is printed along with a text string that gives this valu meaning to the readers
		 * this line is printed on a new line and followed by a line of white space
		 */
		
		System.out.println("\nNumber of Shape Objects created: " + Shape.getShapeCount());
		
		//prints out the type, area, and perimeter of each shape in ArrayList Shape
		
		/**
		 * calls displayArray method on ArrayList Shapes
		 * returns display method output, which provides toString formatting of each shape in Shapes' shapeName, shape type, area, and perimeter in the order they were added to the ArrayList initially
		 *implements Displayable interface
		 */
		displayArray(Shapes);
		
		/**
		 * implements Collections interface by calling the sort method on arrayList Shape 
		 * relies on the compareTo method from Shape class to compare the objects in the list by their area size 
		 * re-orders objects in ArrayList Shapes such that elements are ordered by area size in increasing order
		 * 
		 */

		Collections.sort(Shapes);
		
		
		/**
		 * calls displayArray method on ArrayList Shapes
		 * returns display method output, which provides toString formatting of each shape in Shapes' shapeName, shape type, area, and perimeter in the order they were added to the ArrayList initially
		 *implements Displayable interface
		 *same content returned as in previous call of the displayArea method on Shapes, but order has now changed because 
		 */
		displayArray(Shapes);
	}
	
	/**
	 * declares static void method displayArray whose parameter is an ArrayList of Shape element type
	 * for loop iterates through the ArrayList by position number i, starting at i = 0 and continuing until reaching the end of the ArrayList
	 *calls display method from Displayable interface for the contents of each position of the ArrayList
	 *display method call outputs toString formatting of each shape in Shapes' shapeName, shape type, area, and perimeter of object in i position of the ArrayList
	 * @param L represents an ArrayList with elements of type Shape objects
	 */
	
	protected static void displayArray(ArrayList<Shape> L) {
		for (int i = 0; i < L.size(); i = i + 1) {
			L.get(i).display(); 
		}
		
	
	
	
	}

}
