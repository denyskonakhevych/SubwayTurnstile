package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import pass.AccumulativePass;
import pass.Pass;
import pass.PassType;
import pass.date.strategies.DateStrategy;
import pass.date.strategies.MonthStrategy;
import pass.passfactories.AbstractPassFactory;
import pass.passfactories.AccumulativePassFactory;
import pass.passfactories.DatePassFactory;
import pass.passfactories.NumberOfPassagesPassFactory;
import server.Server;
import tourniquet.Tourniquet;

public class TourniquetTest {

	private Tourniquet tourniquet;
	
	@Before
	public void setUp() throws Exception {
		tourniquet = new Tourniquet();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckPassNull() {
		Tourniquet tourniquet = new Tourniquet();
		tourniquet.checkPass(null);
	}
	
	@Test
	public void testCheckDatePass() {
		Calendar currentDate = Calendar.getInstance();
		DateStrategy dateStrategy = new MonthStrategy(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), PassType.MONTH_STUDENT);
		AbstractPassFactory apf = new DatePassFactory(dateStrategy);
		Pass pass = apf.getPass();
		Tourniquet tourniquet = new Tourniquet();
		assertTrue(tourniquet.checkPass(pass));
	}
	
	@Test
	public void testCheckNumberOfPassagesPass() {
		AbstractPassFactory apf = new NumberOfPassagesPassFactory(PassType.PASSAGES_20);
		Pass pass = apf.getPass();
		Tourniquet tourniquet = new Tourniquet();
		assertTrue(tourniquet.checkPass(pass));
	}
	
	@Test
	public void testCheckAccumulativePassOk() {
		final float RAISE = 50.0f;
		
		AbstractPassFactory apf = new AccumulativePassFactory();
		AccumulativePass pass = (AccumulativePass) apf.getPass();
		pass.increaseBalance(RAISE);
		Tourniquet tourniquet = new Tourniquet();
		assertTrue(tourniquet.checkPass(pass));
	}
	
	@Test
	public void testCheckDatePassExpiredFailsValidation() {
		DateStrategy dateStrategy = new MonthStrategy(2000, 1, PassType.MONTH_STUDENT);
		AbstractPassFactory apf = new DatePassFactory(dateStrategy);
		Pass pass = apf.getPass();
		Tourniquet tourniquet = new Tourniquet();
		assertFalse(tourniquet.checkPass(pass));
	}
	
	@Test
	public void testCheckNumberOfPassagesPassFailsValidation() {
		AbstractPassFactory apf = new NumberOfPassagesPassFactory(PassType.PASSAGES_20);
		Pass pass = apf.getPass();
		Tourniquet tourniquet = new Tourniquet();
		for(int i = 0; i < 20; i++) {
			tourniquet.checkPass(pass);
		}
		assertFalse(tourniquet.checkPass(pass));
	}
	
	@Test
	public void testCheckAccumulativePassWithNotEnoughBalanceFailsValidation() {
		AbstractPassFactory apf = new AccumulativePassFactory();
		Pass pass = apf.getPass();
		Tourniquet tourniquet = new Tourniquet();
		assertFalse(tourniquet.checkPass(pass));
	}
	
	@Test
	public void testTotalNumberOfPassages() {
		AbstractPassFactory apf = new AccumulativePassFactory();
		Pass pass = apf.getPass();
		Tourniquet tourniquet = new Tourniquet();
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		assertEquals(4, tourniquet.getPassagesNumber());
	}
	
	@Test
	public void testNumberOfPassagesByPassageSuccession() {
		AbstractPassFactory apf = new AccumulativePassFactory();
		Pass pass = apf.getPass();
		Tourniquet tourniquet = new Tourniquet();
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		
		final float RAISE = 50.0f;
		AccumulativePass accPass = (AccumulativePass) apf.getPass();
		accPass.increaseBalance(RAISE);
		tourniquet.checkPass(accPass);
		tourniquet.checkPass(accPass);
		
		assertEquals(6, tourniquet.getPassagesNumber());
		assertEquals(4, tourniquet.getPassagesNumber(false));
		assertEquals(2, tourniquet.getPassagesNumber(true));
	}
	
	@Test
	public void testNumberOfPassagesByPassageSuccessionAndPassType() {
		AbstractPassFactory apf = new AccumulativePassFactory();
		Pass pass = apf.getPass();
		Tourniquet tourniquet = new Tourniquet();
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		
		final float RAISE = 50.0f;
		AccumulativePass accPass = (AccumulativePass) apf.getPass();
		accPass.increaseBalance(RAISE);
		tourniquet.checkPass(accPass);
		tourniquet.checkPass(accPass);
		
		apf = new NumberOfPassagesPassFactory(PassType.PASSAGES_20);
		pass = apf.getPass();
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		
		assertEquals(9, tourniquet.getPassagesNumber());
		assertEquals(0, tourniquet.getPassagesNumber(false, PassType.PASSAGES_20));
		assertEquals(3, tourniquet.getPassagesNumber(true, PassType.PASSAGES_20));
	}
}
