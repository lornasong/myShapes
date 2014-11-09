package Shapes;

public class Circle extends Shape {

	//Keeping notation as so for future reference
	private static final int NUM_SIDES = 1;
	private double radius;

	public Circle(ShapeColor color, double radius) {
		super(color, NUM_SIDES);
		this.radius = radius;
	}

	@Override
	public double calculateArea() {
		return Math.PI * radius * radius;
	}
	
	//cntrl space for shortcut
	@Override
	public boolean isRegular() {
		return true;
	}
	
	@Override
	public boolean isRollable() {
		return true;
	}
}
