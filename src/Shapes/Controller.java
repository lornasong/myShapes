package Shapes;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//TODO Comment
public class Controller {

	public static void main(String args[]) {
		new Controller().doMain();
	}
	
	private void doMain(){
		
		System.out.println("Please enter the fields to create your shape: ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		
		askForColor();
		
		String shape = getString(reader);
		System.out.println("What color is your shape?");
		String color = getString(reader);
		System.out.println();
	}
	
	private void askForShape(){
		System.out.println("Please choose a shape: ");
		System.out.println("Circle");
		System.out.println("Rectangle");
		System.out.println("Square");
		System.out.println("Triangle");
	}
	
	private void askForColor(){
		
	}
	
	/**
	 * Uses buffered reader to get next line of user input
	 * Returns string input
	 */
	private String getString(BufferedReader reader){

		try {
			String input = reader.readLine();
			return input;
		} catch (IOException e) {
			System.out.println("Error occurred");
		}	
		return null;
	}	

	/**
	 * Uses buffered reader to get parameters for calculating area
	 * Returns double
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
	 * Uses buffered reader to get user choice
	 * Returns 
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
