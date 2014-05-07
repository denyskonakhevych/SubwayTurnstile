package tests.pass;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pass.passtype.NumberOfPassagesPassType;
import pass.type.NumberOfPassagesPass;

public class NumberOfPassagesPassTest {

	private NumberOfPassagesPass pass;
	
	@Before
	public void setUp() throws Exception {
		pass = new NumberOfPassagesPass(0, NumberOfPassagesPassType.PASSAGES_20);
	}

	@Test
	public void testValidateOk() throws IllegalAccessException {
		pass.validate();
	}
	
	@Test
	public void testDecreaseNumberOfPassagesAfterValidation() {
		pass.validate();
		assertEquals(pass.getNumberOfPasseges(), 19);
	}
	
	@Test
	public void testSpendAllPassages() {
		for(int i = 0; i < 20; i++) {
			pass.validate();
		}
		assertEquals(pass.getNumberOfPasseges(), 0);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testSpendAllPassagesAndTryValidate()  {
		for(int i = 0; i < 21; i++) {
			pass.validate();
		}
	}
}