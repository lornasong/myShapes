package Shapes;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//TODO Comment
public class Controller {

	public static void main(String args[]) {
		new Controller().doMain();
	}

	private void doMain(){
		
		//Declare a Hashmap to contain Shape options
		Map <String, ArrayList<String>> shapeMap = new HashMap<String, ArrayList<String>>();
		shapeMap = fillShapeMap(shapeMap);
		System.out.println("Please enter the fields to create your shape: ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		
		askForShape();
		String shape = getShape(reader);
		
		askForColor();
		String color = getString(reader);
		
		System.out.println();
	}
	
	private Map <String, ArrayList<String>> fillShapeMap(Map shapeMap){
		return shapeMap;
		
	}

	/**
	 * Displays shape options
	 */
	private void askForShape() {
		System.out.println("Please choose a shape: ");
		System.out.println(" - circle");
		System.out.println(" - rectangle");
		System.out.println(" - square");
		System.out.println(" - triangle");
	}

	/**
	 * Displays color options
	 */
	private void askForColor() {
		System.out.println("Please select a color: ");
		for (ShapeColor c : ShapeColor.values()) {
			System.out.println(" - " + c.getColorName());
		}
	}

	private void askForParameters() {

	}

	private String getShape(BufferedReader reader){
		
		String userInput = getString(reader);
		
		if (userInput.equalsIgnoreCase("circle") || userInput.equalsIgnoreCase("rectangle") || userInput.equalsIgnoreCase("square") || userInput.equalsIgnoreCase("circle") || )
		return null;
	}

	/**
	 * Uses buffered reader to get next line of user input Returns string input
	 */
	private String getString(BufferedReader reader) {

		try {
			String input = reader.readLine();
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
	private double getParameter(BufferedReader reader) {

		try {
			double parameter = Double.parseDouble(reader.readLine());
			return parameter;
		} catch (NumberFormatException nfe) {
			System.out.println("Error: please re-enter a valid parameter");
			return getParameter(reader);
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
