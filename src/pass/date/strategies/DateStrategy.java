package pass.date.strategies;

import java.util.Calendar;

import pass.Pass;

public abstract class DateStrategy {

	protected Calendar startDate;
	protected Calendar endDate;
	
	public abstract Pass makePass(int id);
}
