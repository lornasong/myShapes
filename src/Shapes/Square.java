package Shapes;

public class Square extends Rectangle {

	public Square(ShapeColor color, double sideLength) {
		super(color, sideLength, sideLength);
	}
	
	@Override
	public boolean isRegular() {
		return true;
	}

}
