package tests.pass;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pass.type.AccumulativePass;

public class AccumulativePassTest {

	private AccumulativePass pass;
	
	private final float PRICE_PER_PASSAGE = 2.5f;
	
	private final float DELTA = 0.0001f;
	
	@Before
	public void setUp() throws Exception {
		pass = new AccumulativePass(0, 0, PRICE_PER_PASSAGE);
	}

	@Test
	public void testIncreaseBalanceOk() {
		pass.increaseBalance(50.f);
		assertEquals(pass.getBalance(), 50.f, DELTA);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIncreaseBalanceFail() {
		pass.increaseBalance(-0.1f);
	}
	
	@Test
	public void testSetPriceOk() {
		final float NEW_PRICE = 1.5f;
		pass.setPrice(NEW_PRICE);
		assertEquals(pass.getPrice(), NEW_PRICE, DELTA);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetPriceFail() {
		pass.setPrice(-0.1f);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testValidateFails() {
		pass.validate();
	}
	
	@Test
	public void testValidateOk() {
		pass.increaseBalance(2.5f);
		pass.validate();
	}
	
	@Test(expected = IllegalStateException.class)
	public void testValidateFailsNotEnoughMoney() {
		pass.increaseBalance(2.4f);
		pass.validate();
	}

	@Test
	public void testToString() {
		String desired = "ID: 0 TYPE: ACCUMULATIVE PASSAGES DONE: 0 BALANCE LEFT: 0.0";
		assertEquals(pass.toString(), desired);
	}
}
