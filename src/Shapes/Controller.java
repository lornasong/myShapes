package Shapes;

//hashmap use pretty common. arraylist also.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.*;
import org.apache.commons.lang3.StringUtils;

public class Controller {

	public static void main(String args[]) {
		new Controller().doMain();
	}

	private void doMain() {

		// Declare and fill hashmap to contain Shape options and parameters for
		// calculating area
		Map<String, String[]> shapeMap = new HashMap<String, String[]>();
		// shapeMap = fillShapeMap(shapeMap); NOTE: no need to return shapeMap.
		// Heap
		// is modified and shapeMap still references that Heap
		fillShapeMap(shapeMap);

		// IO to gather information for creating shape
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("Please Enter the Fields to Create Your Shape");

		askForShape(shapeMap);
		String shape = getShape(reader, shapeMap);

		askForColor();
		ShapeColor color = getColor(reader);

		Shape newShape = createShape(reader, shape, color, shapeMap);
		System.out.println(newShape.toString());
		System.out.println();
	}

	/**
	 * Hard code hash map based on shape classes available. Key is the shape
	 * class name in lower case. Value is an arraylist of all the parameters
	 * needed to calculate area.
	 * 
	 * @return
	 */
	// TODO can be an array not an arraylist
	private void fillShapeMap(Map<String, String[]> shapeMap) {

		shapeMap.put("circle", new String[] { "radius" });
		shapeMap.put("rectangle", new String[] { "length", "width" });
		shapeMap.put("square", new String[] { "side" });
		shapeMap.put("triangle", new String[] { "base", "height" });
		// return shapeMap; // don't need to return. shapemap points to
		// reference
		// in object in heap. heap is changing. make void
		// ints (e.g.) are immutable. int is in stack. integer is in heap
		// Integer foo = 1. Integer boo = 1. then foo == bar. (Integers built at
		// beginning of JVM running)
		// Integer foo = new Integer (1) and Integer bar = new Integer (1), then
		// foo != bar
		// runtime vs. compiler time
		// auto-boxing (int, Integer, float, Float, etc)
		// Integer foo = 1; int bar = 1 then foo == bar. foo get's un auto boxes
		// Void and void can autobox
		// two pointers to the same heap when you have

	}

	/**
	 * Displays shape options. Loop through ShapeMap hashmap
	 */
	private void askForShape(Map<String, String[]> shapeMap) {

		System.out.println("Choose a shape:");
		for (String key : shapeMap.keySet()) {
			System.out.println(" - " + key);
		}
	}

	/**
	 * Displays color options. Loop through ShapeColor enum
	 */
	private void askForColor() {
		System.out.println("Select a color:");
		for (ShapeColor c : ShapeColor.values()) {
			System.out.println(" - " + c.getColorName());
		}
	}

	/**
	 * Asks for parameters for particular shapes. Distinguishes between shapes
	 * that require two parameters (e.g. triangle and rectangle) or shapes that
	 * require only one parameter to create instance. Returns user's shape.
	 */
	private Shape createShape(BufferedReader reader, String shape,
			ShapeColor color, Map<String, String[]> shapeMap) {

		System.out.println("Enter the values for the following parameter(s):");

		// Shapes that require two parameters
		if (shape.equals("rectangle") || shape.equals("triangle")) {
			return createShapeWithTwoParameters(reader, shape, color, shapeMap);
		}
		// Shapes that require one parameter
		else {
			return createShapeWithOneParameter(reader, shape, color, shapeMap);
		}
	}

	// TODO: make a kernel method.to pass the parameters
	// Normally don't use reflection. use it in special cases.
	// Use switch statement
	/**
	 * Returns user's shape for only shapes that require one area parameter to
	 * construct
	 */
	private Shape createShapeWithOneParameter(BufferedReader reader,
			String shape, ShapeColor color, Map<String, String[]> shapeMap) {

		// Ask for one parameter
		System.out.println(shapeMap.get(shape)[0] + ":");
		double param = readParameter(reader);

		// Create class
		try {
			shape = "Shapes." + StringUtils.capitalize(shape);
			Class<?> newShape = Class.forName(shape);
			Class[] parameters = new Class[] { ShapeColor.class, double.class };
			Constructor<?> constructor = newShape.asSubclass(Shape.class)
					.getConstructor(parameters);
			Object objShape = constructor.newInstance(color, param);
			return (Shape) objShape;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * Returns user's shape for only shapes that require TWO area parameters to
	 * construct
	 */
	private Shape createShapeWithTwoParameters(BufferedReader reader,
			String shape, ShapeColor color, Map<String, String[]> shapeMap) {

		// Ask for 2 parameters
		System.out.println(shapeMap.get(shape)[0] + ":");
		double param1 = readParameter(reader);
		System.out.println(shapeMap.get(shape)[1] + ":");
		double param2 = readParameter(reader);

		// Create class
		try {
			shape = "Shapes." + StringUtils.capitalize(shape);
			Class<?> newShape = Class.forName(shape);
			Class[] parameters = new Class[] { ShapeColor.class, double.class,
					double.class };
			Constructor<?> constructor = newShape.asSubclass(Shape.class)
					.getConstructor(parameters);
			Object objShape = constructor.newInstance(color, param1, param2);
			return (Shape) objShape;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Returns user choice of shape. Checks against hashmap keys whether user
	 * input is valid. If input is invalid, method calls itself.
	 */
	private String getShape(BufferedReader reader,
			Map<String, String[]> shapeMap) {

		String userInput = readString(reader);

		// Check if userInput is valid by checking keys in shapeMap
		if (shapeMap.containsKey(userInput)) {
			return userInput;
		} else {
			System.out
					.println("Error: invalid shape choice. Choose a shape from the list above:");
			return getShape(reader, shapeMap);
		}
	}

	/**
	 * Returns user choice of color. Checks again ShapeColor enum to see if
	 * user's color is valid. If user color is invalid, method calls itself.
	 */
	private ShapeColor getColor(BufferedReader reader) {

		String userInput = readString(reader);
		// TODO move into color enum. LS. how? how to access that method?
		// Check if userInput is valid color selection in ShapeColor
		for (ShapeColor shape : ShapeColor.values()) {
			if (userInput.equals(shape.getColorName())) {
				return shape;
			}
		}

		// userInput is invalid
		System.out
				.println("Error: invalid color choice. Select a color from the list above:");
		return getColor(reader);

	}

	/**
	 * Uses buffered reader to get next line of user input. Returns trimmed
	 * lower-case string input
	 */
	private String readString(BufferedReader reader) {

		try {
			String input = reader.readLine();
			input = input.trim();
			input = input.toLowerCase();
			return input;
		} catch (IOException e) {
			System.out.println("Error occurred");
		}
		return null;
	}

	/**
	 * Uses buffered reader to get parameters for calculating area Returns
	 * double
	 */
	public double readParameter(BufferedReader reader) {

		try {
			double parameter = Double.parseDouble(reader.readLine());
			return parameter;
		} catch (NumberFormatException nfe) {
			System.out.println("Error: please re-enter a valid parameter");
			return readParameter(reader);
		} catch (IOException e) {
			System.out.println("Error occurred");
		}

		return 0;
	}

}
