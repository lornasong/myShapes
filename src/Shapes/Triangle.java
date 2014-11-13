package Shapes;

public class Triangle extends Shape {

	private final double base;
	private final double height;
	
	public Triangle(ShapeColor color, double base, double height) {
		super(color, 3);
		this.base = base;
		this.height = height;
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
