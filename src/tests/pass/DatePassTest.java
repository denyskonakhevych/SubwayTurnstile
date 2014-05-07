package tests.pass;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import pass.passtype.TermPassType;
import pass.type.DatePass;

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
		pass = new DatePass(0, TermPassType.MONTH_STUDENT, startDate, endDate);
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
	public void testValidateOk() {
		pass.validate();
	}
	
	@Test(expected = IllegalStateException.class)
	public void testValidateFalse() {	
		startDate = Calendar.getInstance();
		startDate.set(1980, Calendar.MARCH, 1, 0, 0, 0);
		endDate = Calendar.getInstance();
		endDate.set(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH), startDate.getMaximum(Calendar.DATE), 23, 59, 59);
		pass = new DatePass(0, TermPassType.MONTH_STUDENT, startDate, endDate);
		pass.validate();
	}
}
