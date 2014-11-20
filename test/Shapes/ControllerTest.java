package Shapes;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ControllerTest {

	private Controller controller;
	private BufferedReader reader;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void initClass() {
		controller = new Controller();
		reader = new BufferedReader(new InputStreamReader(System.in));

	}

	// Methods must be public in order to test?
	//Method is recursive...
	@Test
	public void testRequireDoubleUserInput() {
		exception.expect(IOException.class);

		controller.readParameter(reader);

	}

}
