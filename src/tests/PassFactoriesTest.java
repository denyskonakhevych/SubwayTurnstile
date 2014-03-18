package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import pass.AccumulativePass;
import pass.DatePass;
import pass.NumberOfPassagesPass;
import pass.Pass;
import pass.PassType;
import pass.date.strategies.DateStrategy;
import pass.date.strategies.MonthStrategy;
import pass.date.strategies.NDaysStrategy;
import pass.passfactories.AbstractPassFactory;
import pass.passfactories.AccumulativePassFactory;
import pass.passfactories.DatePassFactory;
import pass.passfactories.NumberOfPassagesPassFactory;

public class PassFactoriesTest {

	/*
	@Before
	public void setUp() throws Exception {
		
	}*/

	@Test
	public void testDatePassFactoryStudentOk() {
		Calendar currentDate = Calendar.getInstance();
		DateStrategy dateStrategy = new MonthStrategy(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), PassType.MONTH_STUDENT);
		AbstractPassFactory apf = new DatePassFactory(dateStrategy);
		Pass pass = apf.getPass();
		assertTrue(pass instanceof DatePass);
	}
	
	@Test
	public void testDatePassFactoryPupilOk() {
		Calendar currentDate = Calendar.getInstance();
		DateStrategy dateStrategy = new MonthStrategy(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), PassType.MONTH_PUPIL);
		AbstractPassFactory apf = new DatePassFactory(dateStrategy);
		Pass pass = apf.getPass();
		assertTrue(pass instanceof DatePass);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDatePassFactoryMonthStrategyWrongPassType() {
		Calendar currentDate = Calendar.getInstance();
		DateStrategy dateStrategy = new MonthStrategy(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), PassType.PASSAGES_20);
		AbstractPassFactory apf = new DatePassFactory(dateStrategy);
		Pass pass = apf.getPass();
		assertTrue(pass instanceof DatePass);
	}
	
	@Test(expected = IllegalArgumentException.class)
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
		DateStrategy dateStrategy = new NDaysStrategy(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE), PassType.DAYS_10);
		AbstractPassFactory apf = new DatePassFactory(dateStrategy);
		Pass pass = apf.getPass();
		assertTrue(pass instanceof DatePass);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDatePassFactoryNDaysStrategyWrongPassType() {
		Calendar currentDate = Calendar.getInstance();
		DateStrategy dateStrategy = new NDaysStrategy(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE), PassType.ACCUMULATIVE);
		AbstractPassFactory apf = new DatePassFactory(dateStrategy);
		Pass pass = apf.getPass();
		assertTrue(pass instanceof DatePass);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDatePassFactoryNDaysStrategyNullPassType() {
		Calendar currentDate = Calendar.getInstance();
		DateStrategy dateStrategy = new NDaysStrategy(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE), null);
		AbstractPassFactory apf = new DatePassFactory(dateStrategy);
		Pass pass = apf.getPass();
		assertTrue(pass instanceof DatePass);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDatePassFactoryNull() {
		//AbstractPassFactory apf = new DatePassFactory(null);
		new DatePassFactory(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNumberOfPassagesFactoryWrongArgument() {
		AbstractPassFactory apf = new NumberOfPassagesPassFactory(PassType.DAYS_10);
		Pass pass = apf.getPass();
		assertTrue(pass instanceof NumberOfPassagesPass);
	}
	
	@Test
	public void testNumberOfPassagesFactoryOk() {
		AbstractPassFactory apf = new NumberOfPassagesPassFactory(PassType.PASSAGES_20);
		Pass pass = apf.getPass();
		assertTrue(pass instanceof NumberOfPassagesPass);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNumberOfPassagesFactoryNull() {
		//AbstractPassFactory apf = new NumberOfPassagesPassFactory(null);
		new NumberOfPassagesPassFactory(null);
	}
	
	@Test
	public void testAccumulativePassFactoryNull() {
		
		AbstractPassFactory apf = new AccumulativePassFactory();
		Pass pass = apf.getPass();
		assertTrue(pass instanceof AccumulativePass);
	}
}
