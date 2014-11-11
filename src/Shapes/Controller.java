package Shapes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.*;

public class Controller {

	public static void main(String args[]) {
		new Controller().doMain();
	}

	private void doMain() {

		// Declare and fill hashmap to contain Shape options and parameters for
		// calculating area
		Map<String, ArrayList<String>> shapeMap = new HashMap<String, ArrayList<String>>();
		shapeMap = fillShapeMap(shapeMap);

		// IO to gather information for creating shape
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("Please Enter the Fields to Create Your Shape");

		askForShape(shapeMap);
		String shape = getShape(reader, shapeMap);

		askForColor();
		ShapeColor color = getColor(reader);

		Shape newShape = createShape(reader, shape, color, shapeMap);

		System.out.println();
	}

	/**
	 * Hard code hash map based on shape classes available. Key is the shape
	 * class name in lower case. Value is an arraylist of all the parameters
	 * needed to calculate area.
	 */
	private Map<String, ArrayList<String>> fillShapeMap(
			Map<String, ArrayList<String>> shapeMap) {

		shapeMap.put("circle", new ArrayList<String>(Arrays.asList("radius")));
		shapeMap.put("rectangle",
				new ArrayList<String>(Arrays.asList("height", "width")));
		shapeMap.put("square", new ArrayList<String>(Arrays.asList("side")));
		shapeMap.put("triangle",
				new ArrayList<String>(Arrays.asList("base", "height")));
		return shapeMap;

	}

	/**
	 * Displays shape options. Loop through ShapeMap hashmap
	 */
	private void askForShape(Map<String, ArrayList<String>> shapeMap) {

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
			ShapeColor color, Map<String, ArrayList<String>> shapeMap) {

		System.out.println("Enter the values for the following parameter(s):");

		// Shapes that require two parameters
		if (shape.equals("rectangle") || shape.equals("triangle")) {
			return null;
		}
		// Shapes that require one parameter
		else {
			return createOneParameterShape(reader, shape, color, shapeMap);
		}
	}

	/**
	 * Returns user's shape for only shapes that require one area parameter to construct
	 */
	private Shape createOneParameterShape(BufferedReader reader, String shape,
			ShapeColor color, Map<String, ArrayList<String>> shapeMap) {
		
		System.out.println(shapeMap.get(shape).get(0) + ":");
		double param = readParameter(reader);
		
		try {
			Class<?> newShape = Class.forName(shape);
			Class[] parameters = new Class[] {ShapeColor.class, int.class, double.class};
			Constructor constructor = newShape.asSubclass(Shape.class).getConstructors(parameters);
			
			//Constructor constructor = newShape.getConstructor(ShapeColor.class, double.class);
			//Object helloshape = constructor.newInstance(color, param);
			return null;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e){
			e.printStackTrace();
		} catch (IllegalAccessException e){
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Returns user choice of shape. Checks against hashmap keys whether user
	 * input is valid. If input is invalid, method calls itself.
	 */
	private String getShape(BufferedReader reader,
			Map<String, ArrayList<String>> shapeMap) {

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
	private double readParameter(BufferedReader reader) {

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

	/**
	 * Uses buffered reader to get user choice Returns
	 */
	private double getUserInput(BufferedReader reader) {

		try {
			int userOption = Integer.parseInt(reader.readLine());
			return userOption;
		} catch (NumberFormatException nfe) {
			System.out.println("Error: please re-enter a valid choice");
			return getUserInput(reader);
		} catch (IOException e) {
			System.out.println("Error occurred");
		}

		return 0;
	}
}
