package pass.date.strategies;

import java.util.Calendar;

import pass.DatePass;
import pass.Pass;
import pass.PassType;

public class MonthStrategy extends DateStrategy {

	private PassType type;
	
	public MonthStrategy(int year, int month, PassType type) {
		if (type == null || !type.toString().toLowerCase().contains("MONTH".toLowerCase())) {
			throw new IllegalArgumentException("Wrong pass type: " + type);
		}
		this.type = type;
		startDate = Calendar.getInstance();
		startDate.set(year, month, 1, 0, 0, 0);
		endDate = Calendar.getInstance();
		endDate.set(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH), startDate.getMaximum(Calendar.DATE), 23, 59, 59);
	}

	@Override
	public Pass makePass(int id) {
		return new DatePass(id, type, startDate, endDate);
	}
}
