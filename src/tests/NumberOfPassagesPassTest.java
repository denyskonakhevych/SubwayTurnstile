package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pass.NumberOfPassagesPass;
import pass.PassType;

public class NumberOfPassagesPassTest {

	private NumberOfPassagesPass pass;
	
	@Before
	public void setUp() throws Exception {
		pass = new NumberOfPassagesPass(0, PassType.PASSAGES_20);
	}

	@Test
	public void testValidateOk() throws IllegalAccessException {
		pass.validate();
	}
	
	@Test
	public void testDecreaseNumberOfPassagesAfterValidation() throws IllegalAccessException {
		pass.validate();
		assertEquals(pass.getNumberOfPasseges(), 19);
	}
	
	@Test
	public void testSpendAllPassages() throws IllegalAccessException {
		for(int i = 0; i < 20; i++) {
			pass.validate();
		}
		assertEquals(pass.getNumberOfPasseges(), 0);
	}
	
	@Test(expected = IllegalAccessException.class)
	public void testSpendAllPassagesAndTryValidate() throws IllegalAccessException {
		for(int i = 0; i < 21; i++) {
			pass.validate();
		}
	}
}