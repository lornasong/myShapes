package Shapes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShapeTest {
	
	public ShapeColor orange = ShapeColor.ORANGE;

	//Do you make one test to do all classes?
	//Or do you make a test method for each class?
	//Or do you make a test class for each class?
	@Test
	public void testGetShapeNameFromClass() {
		
		Square square = new Square(orange, 6);
		assertEquals("Shapes name should be the name of it's class", square.getShapeName(), "square");
	}

}
