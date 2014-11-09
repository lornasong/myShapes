package Shapes;
import java.awt.Color;


/**
 * Enum to generate a collection of possible colors for shapes.
 * Translates a lower case strings of the color
 * @author lsong
 */
public enum ShapeColor {
	  
	  RED(Color.RED, "red"),
	  ORANGE(Color.ORANGE, "orange"),
	  YELLOW(Color.YELLOW, "yellow"),
	  GREEN(Color.GREEN, "green"),
	  BLUE(Color.BLUE, "blue"),
	  GRAY(Color.GRAY, "gray"),
	  PINK(Color.PINK, "pink"),
	  BLACK(Color.BLACK, "black"),
	  WHITE(Color.WHITE, "white"),
	  //end
	  ;
	  
	  private final Color awtColor;
	  private final String colorName;

	  private ShapeColor(Color awtColor, String name) {
	    this.awtColor = awtColor;
	    this.colorName = name;
	  }

	  /**
	   * Returns the awt of the color
	   * Looks like [r, b, y]
	   */
	  public Color getAwtColor() {
	    return awtColor;
	  }

	  /**
	   * Returns the string of the color name
	   */
	  public String getColorName() {
	    return colorName;
	  }
}
