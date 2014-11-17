package Shapes;

public class Square extends Rectangle {

	
	//private final double sideLength;
	//no need for this? not used.
	
	public Square(ShapeColor color, double sideLength) {
		super(color, sideLength, sideLength);
	}
	
	@Override
	public boolean isRegular() {
		return true;
	}

}
