package Testing;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import controller.Main;

// Dummy JUnit code, testing to make sure imports work.
public class MainGUITest {
	Main myGUI;
	
	@Before
	public void setUp() throws Exception {
		myGUI = new Main();
	}

	@Test
	public void test() {
		//assertTrue(myGUI.isActive());
	}

}