package pass.date.strategies;

import java.util.Calendar;

import pass.type.Pass;

public abstract class DateStrategy {

	protected Calendar startDate;
	protected Calendar endDate;
	
	public abstract Pass makePass(int id);
}
