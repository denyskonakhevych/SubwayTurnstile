package tests.factories;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;

import pass.date.strategies.DateStrategy;
import pass.date.strategies.MonthStrategy;
import pass.date.strategies.NDaysStrategy;
import pass.passfactories.AbstractPassFactory;
import pass.passfactories.AccumulativePassFactory;
import pass.passfactories.DatePassFactory;
import pass.passfactories.NumberOfPassagesPassFactory;
import pass.passtype.NumberOfPassagesPassType;
import pass.passtype.TermPassType;
import pass.type.AccumulativePass;
import pass.type.DatePass;
import pass.type.NumberOfPassagesPass;
import pass.type.Pass;

public class PassFactoriesTest {

	@Test
	public void testDatePassFactoryMonthOk() {
		Calendar currentDate = Calendar.getInstance();
		DateStrategy dateStrategy = new MonthStrategy(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), TermPassType.MONTH);
		AbstractPassFactory apf = new DatePassFactory(dateStrategy);
		Pass pass = apf.getPass();
		assertTrue(pass instanceof DatePass);
	}
	
	@Test
	public void testDatePassFactoryStudentOk() {
		Calendar currentDate = Calendar.getInstance();
		DateStrategy dateStrategy = new MonthStrategy(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), TermPassType.MONTH_STUDENT);
		AbstractPassFactory apf = new DatePassFactory(dateStrategy);
		Pass pass = apf.getPass();
		assertTrue(pass instanceof DatePass);
	}
	
	@Test
	public void testDatePassFactoryPupilOk() {
		Calendar currentDate = Calendar.getInstance();
		DateStrategy dateStrategy = new MonthStrategy(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), TermPassType.MONTH_PUPIL);
		AbstractPassFactory apf = new DatePassFactory(dateStrategy);
		Pass pass = apf.getPass();
		assertTrue(pass instanceof DatePass);
	}
	
	@Test(expected = NullPointerException.class)
	public void testDatePassFactoryMonthStrategyNullPassType() {
		Calendar currentDate = Calendar.getInstance();
		DateStrategy dateStrategy = new MonthStrategy(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), null);
		AbstractPassFactory apf = new DatePassFactory(dateStrategy);
		Pass pass = apf.getPass();
		assertTrue(pass instanceof DatePass);
	}
	
	@Test
	public void testDatePassFactoryNDaysStrategy() {
		Calendar currentDate = Calendar.getInstance();
		DateStrategy dateStrategy = new NDaysStrategy(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE), TermPassType.DAYS_10);
		AbstractPassFactory apf = new DatePassFactory(dateStrategy);
		Pass pass = apf.getPass();
		assertTrue(pass instanceof DatePass);
	}
	
	@Test(expected = NullPointerException.class)
	public void testDatePassFactoryNDaysStrategyNullPassType() {
		Calendar currentDate = Calendar.getInstance();
		DateStrategy dateStrategy = new NDaysStrategy(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE), null);
		AbstractPassFactory apf = new DatePassFactory(dateStrategy);
		Pass pass = apf.getPass();
		assertTrue(pass instanceof DatePass);
	}
	
	@Test(expected = NullPointerException.class)
	public void testDatePassFactoryNull() {
		new DatePassFactory(null);
	}
	
	@Test
	public void testNumberOfPassagesFactoryOk() {
		AbstractPassFactory apf = new NumberOfPassagesPassFactory(NumberOfPassagesPassType.PASSAGES_20);
		Pass pass = apf.getPass();
		assertTrue(pass instanceof NumberOfPassagesPass);
	}
	
	@Test(expected = NullPointerException.class)
	public void testNumberOfPassagesFactoryNull() {
		new NumberOfPassagesPassFactory(null);
	}
	
	@Test
	public void testAccumulativePassFactoryNull() {
		
		AbstractPassFactory apf = new AccumulativePassFactory();
		Pass pass = apf.getPass();
		assertTrue(pass instanceof AccumulativePass);
	}
}
