package Shapes;

public class Triangle extends Shape {

	private double base;
	private double height;
	
	public Triangle(ShapeColor color, double base, double height) {
		super(color, 3);
	}

	@Override
	public double calculateArea() {
		return 0.5 * base * height;
	}
	
	@Override
	public boolean isRegular() {
		return (height == (base / 2) * Math.sqrt(3.0));
	}

}
