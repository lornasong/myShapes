package Shapes;

//Note: package names typically: com.lorna.shapes (become more defined)

/**
 * Abstract Shape class Extended classes are specific shapes 10/24
 * @author lsong
 * Note: typically name abstract class as AbstractShape
 */
public abstract class Shape {

	private ShapeColor color;//private ShapeColor rather than color
	private final int numberOfSides; // doesn't change. doesn't need a setter

	public Shape(ShapeColor color, int numberOfSides) {
		this.color = color;
		this.numberOfSides = numberOfSides;
	}
	
	/**
	 * Abstract method. Each shape will need its own parameters to calculate area
	 * Note: keep abstract method at the top of class
	 */
	public abstract double calculateArea();
	
	/**
	 * Returns True if shape is a regular polygon
	 */
	public abstract boolean isRegular();

	/**
	 * Returns true if the shape can easily roll down a hill.
	 */
	public boolean isRollable() {
		return false;
	}

	public ShapeColor getColor() {
		return color;
	}

	public int getNumberOfSides() {
		return numberOfSides;
	}
	
	public void setColor(ShapeColor color) {
		this.color = color;
	}

	/**
	 * Returns color name as a string. Pulls from ShapeColor Enum
	 */
	public String getColorString(ShapeColor color) {
		return color.getColorName();
	}

	/**
	 * Returns the name of the shape by looking at the extended class name
	 */
	public String getShapeName() {
		String name = getClass().getSimpleName().toLowerCase();
		return name;
	}
	
	@Override
	public String toString() {
		return "The " + getColorString(color) + " " + getShapeName() + " has "
				+ getNumberOfSides() + " sides and an area of " + calculateArea()
				+ " units squared.";
	}
}
