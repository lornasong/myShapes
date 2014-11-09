package Shapes;

public class Rectangle extends Shape {
	
	private final double height;
	private final double width;
	
	public Rectangle(ShapeColor color, double height, double width) {
		super(color, 4);
		this.height = height;
		this.width = width;
	}

	@Override
	public double calculateArea() {
		return height * width;
	}
	
	@Override
	public boolean isRegular() {
		return (height == width);
	}

	
}
