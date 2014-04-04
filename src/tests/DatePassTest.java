package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import pass.DatePass;
import pass.PassType;

public class DatePassTest {

	private Calendar startDate;
	private Calendar endDate;
	private DatePass pass;
	
	@Before
	public void setUp() throws Exception {
		Calendar currentDate = Calendar.getInstance();
		startDate = Calendar.getInstance();
		startDate.set(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), 1, 0, 0, 0);
		endDate = Calendar.getInstance();
		endDate.set(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH), startDate.getMaximum(Calendar.DATE), 23, 59, 59);
		pass = new DatePass(0, PassType.MONTH_STUDENT, startDate, endDate);
	}

	@Test
	public void testStartDate() {
		assertEquals(pass.getStartDate(), startDate);
	}
	
	@Test
	public void testEndDate() {
		assertEquals(pass.getEndDate(), endDate);
	}
	
	@Test
	public void testValidateOk() throws IllegalAccessException {
		pass.validate();
	}
	
	@Test(expected = IllegalAccessException.class)
	public void testValidateFalse() throws IllegalAccessException {	
		startDate = Calendar.getInstance();
		startDate.set(1980, Calendar.MARCH, 1, 0, 0, 0);
		endDate = Calendar.getInstance();
		endDate.set(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH), startDate.getMaximum(Calendar.DATE), 23, 59, 59);
		pass = new DatePass(0, PassType.MONTH_STUDENT, startDate, endDate);
		pass.validate();
	}
}
